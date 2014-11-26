package br.com.financeiro.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.financeiro.pojo.ContaBancaria;

@Named
@ViewScoped
public class ContaBancariaBean extends LoginBean {
	
	private static final long serialVersionUID = 1L;

	private ContaBancaria contaBancaria;
	private List<ContaBancaria> listaContaBancaria;
	
	@PostConstruct
	public void init() {
		
	}

	public ContaBancaria getContaBancaria() {
		return contaBancaria;
	}

	public void setContaBancaria(ContaBancaria contaBancaria) {
		this.contaBancaria = contaBancaria;
	}

	public List<ContaBancaria> getListaContaBancaria() {
		return listaContaBancaria;
	}

	public void setListaContaBancaria(List<ContaBancaria> listaContaBancaria) {
		this.listaContaBancaria = listaContaBancaria;
	}

	
	
}
