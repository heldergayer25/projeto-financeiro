package br.com.financeiro.service;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.apache.deltaspike.jpa.api.transaction.Transactional;

import br.com.financeiro.pojo.Contato;
import br.com.financeiro.pojo.Empresa;
import br.com.financeiro.pojo.Endereco;
import br.com.financeiro.repository.ContatoRepository;
import br.com.financeiro.repository.EmpresaRepository;
import br.com.financeiro.repository.EnderecoRepository;
import br.com.financeiro.util.FinanceiroException;

@Stateless
public class EmpresaService implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Inject EmpresaRepository empresaRepository;
	@Inject ContatoRepository contatoRepository;
	@Inject EnderecoRepository enderecoRepository;
	
	@Transactional
	public void salvar(Empresa empresa) throws FinanceiroException {
		if(empresa != null) {
			if((empresaRepository.countByCpfCnpj(empresa.getCpfCnpj()) > 0) && empresa.getId() == null) {
				throw new FinanceiroException("CPF/CNPJ j� cadastrado!");				
			} else {
				
				empresaRepository.save(empresa);
				
				for(Contato contato : empresa.getContatos()) {
					contatoRepository.save(contato);
				}
				
				for(Endereco endereco : empresa.getEnderecos()) {
					enderecoRepository.save(endereco);
				}
			}
			
		}
	}

	@Transactional
	public void excluir(List<Empresa> empresas) {
		
		for(Empresa empresa : empresas) {
			if(empresa.isSelecionado()) {
				empresa.setAtivo(false);
				empresaRepository.save(empresa);
			}
		}
		
	}
	
	public List<Empresa> listarEmpresasAtivas() {
		return empresaRepository.listarEmpresasAtivas();
	}

	public Empresa obterEmpresaPorId(Integer id) {
		return empresaRepository.findBy(id);
	}
	
	public Empresa obterEmpresaCompleta(int id) {
		return empresaRepository.obterEmpresaCompleta(id);
	}
}
