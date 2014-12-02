package br.com.financeiro.service;

import java.io.Serializable;

import javax.ejb.Stateful;
import javax.inject.Inject;

import br.com.financeiro.bean.LoginBean;

@Stateful
public abstract class AbstractService implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Inject protected LoginBean loginBean;
	
}
