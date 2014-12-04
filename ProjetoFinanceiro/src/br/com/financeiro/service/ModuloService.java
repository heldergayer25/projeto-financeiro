package br.com.financeiro.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.financeiro.pojo.Modulo;
import br.com.financeiro.repository.ModuloRepository;

@Stateless
public class ModuloService extends AbstractService {

	private static final long serialVersionUID = 1L;
	
	@Inject ModuloRepository moduloRepository;

	public List<Modulo> listarTodos() {
		return moduloRepository.findAll();
	}

}
