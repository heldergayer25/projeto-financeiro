package br.com.financeiro.service;

import java.io.Serializable;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.financeiro.pojo.Uf;
import br.com.financeiro.repository.UfRepository;

@Stateless
public class UfService implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject 
	UfRepository ufRepository;
	
	
	public Uf obterUfPorId(String sigla) {
		return ufRepository.findBySigla(sigla);
	}

}
