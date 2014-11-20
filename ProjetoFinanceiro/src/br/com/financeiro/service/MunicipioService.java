package br.com.financeiro.service;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.financeiro.pojo.Municipio;
import br.com.financeiro.pojo.Uf;
import br.com.financeiro.repository.MunicipioRepository;

@Stateless
public class MunicipioService implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Inject 
	MunicipioRepository municipioRepository;
		
	public List<Municipio> listaMunicipiosPorUf(Uf uf) {
		return municipioRepository.findByUfOrderByUfAsc(uf);
	}
	
}
