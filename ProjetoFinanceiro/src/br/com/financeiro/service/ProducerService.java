package br.com.financeiro.service;

import java.util.List;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import br.com.financeiro.pojo.PlanoDeContas;
import br.com.financeiro.pojo.Uf;
import br.com.financeiro.repository.PlanoDeContasRepository;
import br.com.financeiro.repository.UfRepository;

public class ProducerService extends AbstractService {
	
	private static final long serialVersionUID = 1L;
	@Inject UfRepository ufRepository;
	@Inject PlanoDeContasRepository planoDeContasRepository;
	
	@Produces
	public List<Uf> listaEstados() {
		return ufRepository.listarEstados();
	}	
	
	@Produces
	public List<PlanoDeContas> listarPlanoDeContasPorEmpresa() {
		return planoDeContasRepository.findByEmpresaOrderByDescricaoAsc(loginBean.getEmpresaSessao());
	}
	
}
