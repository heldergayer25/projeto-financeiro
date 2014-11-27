package br.com.financeiro.bean;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.com.financeiro.pojo.Acesso;
import br.com.financeiro.pojo.Empresa;
import br.com.financeiro.pojo.Usuario;
import br.com.financeiro.service.AcessoService;
import br.com.financeiro.service.EmpresaService;
import br.com.financeiro.service.UsuarioService;
import br.com.financeiro.util.Criptografia;
import br.com.financeiro.util.Mensagens;

@Named
@SessionScoped
public class LoginBean implements Serializable  {

	private static final long serialVersionUID = 1L;
	
	@EJB UsuarioService usuarioService;
	@EJB AcessoService acessoService;
	@EJB EmpresaService empresaService;
	
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

	public String logarNoSistema() throws Exception {
		
		logado = validarLoginSenha();
		
		if(logado) {
			
			usuarioLogado = null;
			usuarioLogado = usuarioService.obterUsuarioPorAcesso(acesso);
			
//			HttpSession session = Util.getSession();
//            session.setAttribute("usuario", usuarioLogado);			
			
			Mensagens.info("Logado!");
			//FacesContext.getCurrentInstance().getExternalContext().redirect("sistema/home.xhtml");
			//return "/sistema/home.xhtml";
			return "/selecao_empresa.xhtml";
		} else {
			Mensagens.warn("Login ou senha inválidos!");
			return "/login.xhtml";
		}
		
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
		FacesContext.getCurrentInstance().getExternalContext().redirect("sistema/home.xhtml");		
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
