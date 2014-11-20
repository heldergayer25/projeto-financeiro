package br.com.financeiro.bean;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.com.financeiro.pojo.Acesso;
import br.com.financeiro.pojo.Usuario;
import br.com.financeiro.service.AcessoService;
import br.com.financeiro.service.UsuarioService;
import br.com.financeiro.util.Criptografia;
import br.com.financeiro.util.Mensagens;

@Named
@SessionScoped
public class LoginBean implements Serializable  {

	private static final long serialVersionUID = 1L;
	
	@EJB UsuarioService usuarioService;
	@EJB AcessoService acessoService;
	
	private String login;
	private String senha;
	private Acesso acesso;
	private Usuario usuarioLogado;
	
	@PostConstruct
	public void init() {
		
	}

	public void logarNoSistema() throws IOException {
		
		if(validarLoginSenha()) {
			usuarioLogado = new Usuario();
			usuarioLogado = usuarioService.obterUsuarioPorAcesso(acesso);
			Mensagens.info("Logado!");
			FacesContext.getCurrentInstance().getExternalContext().redirect("sistema/home.xhtml"); 
		} else {
			Mensagens.warn("Login ou senha inválidos!");
		}
		
	}
	
	public boolean validarLoginSenha() {
		
		acesso = new Acesso();	
		Criptografia md5 = new Criptografia();
		
		String senhaCriptografada = md5.md5(senha);		
		acesso = acessoService.validaLoginSenha(login, senhaCriptografada);
		
		if(acesso != null) {
			return true;
		}		
		return false;
	}
	
	

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}	
	
	public Acesso getAcesso() {
		return acesso;
	}

	public void setAcesso(Acesso acesso) {
		this.acesso = acesso;
	}

	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}
	
}
