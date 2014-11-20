package br.com.financeiro.service;

import java.util.List;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import br.com.financeiro.pojo.Uf;
import br.com.financeiro.repository.UfRepository;

public class ProducerService {

	@Inject 
	UfRepository ufRepository;
	
	@Produces
	public List<Uf> listaEstados() {
		return ufRepository.listarEstados();
	}	
	
}
