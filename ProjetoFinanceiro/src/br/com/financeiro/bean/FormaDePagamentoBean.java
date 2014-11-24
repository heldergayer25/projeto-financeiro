package br.com.financeiro.bean;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class FormaDePagamentoBean extends LoginBean {

	private static final long serialVersionUID = 1L;

	@PostConstruct
	public void init() {
		
	}
}
