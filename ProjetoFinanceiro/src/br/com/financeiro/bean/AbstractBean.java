package br.com.financeiro.bean;

import java.io.Serializable;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public abstract class AbstractBean implements Serializable {
	
	private static final long serialVersionUID = 1L;	
	
	@Inject protected LoginBean loginBean;
	
}
