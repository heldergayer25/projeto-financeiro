package br.com.financeiro.bean;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.financeiro.pojo.Acesso;
import br.com.financeiro.pojo.Empresa;
import br.com.financeiro.pojo.Usuario;
import br.com.financeiro.service.AcessoService;
import br.com.financeiro.service.EmpresaService;
import br.com.financeiro.service.UsuarioService;
import br.com.financeiro.util.Criptografia;
import br.com.financeiro.util.Mensagens;
import br.com.financeiro.util.RedirecionarBean;

@Named
@SessionScoped
public class LoginBean implements Serializable  {

	private static final long serialVersionUID = 1L;
	
	@EJB UsuarioService usuarioService;
	@EJB AcessoService acessoService;
	@EJB EmpresaService empresaService;
	
	@Inject private RedirecionarBean redirecionarBean;
	
	private String login;
	private String senha;
	private Acesso acesso;
	private Usuario usuarioLogado;
	private Empresa empresaSessao;
	private boolean logado;		
	
	@PostConstruct
	public void init() {
		empresaSessao = new Empresa();
	}

	public void logon() throws Exception {
		
		logado = validarLoginSenha();		
		if(logado) {			
			usuarioLogado = null;
			usuarioLogado = usuarioService.obterUsuarioPorAcesso(acesso);					
			
			logado = true;			
			redirecionarBean.toSelecaoEmpresa();
			
		} else {
			Mensagens.warn("Login ou senha inválidos!");
			redirecionarBean.toLogin();			
		}		
	}
	
	/**
	 * Logout operation.
	 * @return
	 */
	public String logout() {
		// Set the paremeter indicating that user is logged in to false
		logado = false;		
		// Set logout message		
		return redirecionarBean.toLogout();
	}
	
	public boolean validarLoginSenha() {
		
		Criptografia md5 = new Criptografia();
		
		String senhaCriptografada = md5.md5(senha);		
		acesso = acessoService.validaLoginSenha(login, senhaCriptografada);
		
		if(acesso != null) {
			return true;
		}		
		return false;
	}
	
	public void paginaPrincipal() throws IOException {
		Mensagens.info(empresaSessao.getRazao());
		empresaSessao = empresaService.obterEmpresaPorId(empresaSessao.getId());
		
		redirecionarBean.toHome();
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

	public Empresa getEmpresaSessao() {
		return empresaSessao;
	}

	public void setEmpresaSessao(Empresa empresaSessao) {
		this.empresaSessao = empresaSessao;
	}

	public boolean isLogado() {
		return logado;
	}

	public void setLogado(boolean logado) {
		this.logado = logado;
	}	
	
}
