package br.com.financeiro.util;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@SessionScoped
public class RedirecionarBean implements Serializable {

	private static final long serialVersionUID = 1L;

	
	public void toLogin() throws IOException {
		FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");		
	}
	
	public void toSelecaoEmpresa() throws IOException {
		FacesContext.getCurrentInstance().getExternalContext().redirect("sistema/selecao_empresa.xhtml");		
	}
	
	public void toHome() throws IOException {
		FacesContext.getCurrentInstance().getExternalContext().redirect("home.xhtml");
	}
	
	public String toLogout() {
		return "/login.xhtml";
	}
}
