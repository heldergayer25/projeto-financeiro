package br.com.financeiro.service;

import java.io.Serializable;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.financeiro.pojo.PlanoDeContas;
import br.com.financeiro.repository.PlanoDeContasRepository;
import br.com.financeiro.util.Mensagens;

@Stateless
public class PlanoDeContasService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject PlanoDeContasRepository planoDeContasRepository;
	
	
	@Transactional
	public void salvar(PlanoDeContas planoDeContas) throws Exception {
		if(planoDeContas != null) {
			if(planoDeContasRepository.findOptionalByDescricaoAndEmpresa(planoDeContas.getDescricao(), planoDeContas.getEmpresa()) != null) {				
				throw new Exception("Já existe Plano De Contas com essa descrição para essa empresa!");
			}
			
			planoDeContasRepository.save(planoDeContas);
		} else {
			Mensagens.fatal("Um Plano de Contas de ser informado!");
		}
	}


	public PlanoDeContas obterPlanoDeContasPadrao() {		
		return planoDeContasRepository.findBy(1);
	}
}
