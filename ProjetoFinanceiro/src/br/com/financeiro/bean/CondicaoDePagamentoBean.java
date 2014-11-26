package br.com.financeiro.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.financeiro.pojo.CondicaoDePagamento;

@Named
@ViewScoped
public class CondicaoDePagamentoBean extends LoginBean {
	
	private static final long serialVersionUID = 1L;
	
	private CondicaoDePagamento condicaoDePagamento;
	private List<CondicaoDePagamento> listaCondicaoDePagamento;
	
	
	@PostConstruct
	public void init() {
		
	}


	public CondicaoDePagamento getCondicaoDePagamento() {
		return condicaoDePagamento;
	}


	public void setCondicaoDePagamento(CondicaoDePagamento condicaoDePagamento) {
		this.condicaoDePagamento = condicaoDePagamento;
	}


	public List<CondicaoDePagamento> getListaCondicaoDePagamento() {
		return listaCondicaoDePagamento;
	}


	public void setListaCondicaoDePagamento(
			List<CondicaoDePagamento> listaCondicaoDePagamento) {
		this.listaCondicaoDePagamento = listaCondicaoDePagamento;
	}

	
	
	
}
