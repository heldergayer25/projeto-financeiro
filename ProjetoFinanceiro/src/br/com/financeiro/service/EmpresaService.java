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
import br.com.financeiro.util.Mensagens;

@Stateless
public class EmpresaService implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Inject EmpresaRepository empresaRepository;
	@Inject ContatoRepository contatoRepository;
	@Inject EnderecoRepository enderecoRepository;
	
	@Transactional
	public void salvar(Empresa empresa) throws Exception {
		if(empresa != null) {
			if((empresaRepository.findOptionalByCpfCnpj(empresa.getCpfCnpj()) != null) && empresa.getId() == null) {
				Mensagens.error("CPF/CNPJ já cadastrado!");
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

	public List<Empresa> listarEmpresas() {
		return empresaRepository.findAll();
	}

	public Empresa obterEmpresaPorId(Integer id) {
		return empresaRepository.findBy(id);
	}
}
