package br.com.financeiro.bean;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.DualListModel;

import br.com.financeiro.pojo.Acesso;
import br.com.financeiro.pojo.Contato;
import br.com.financeiro.pojo.Endereco;
import br.com.financeiro.pojo.Modulo;
import br.com.financeiro.pojo.Municipio;
import br.com.financeiro.pojo.Uf;
import br.com.financeiro.pojo.Usuario;
import br.com.financeiro.service.EmpresaService;
import br.com.financeiro.service.ModuloService;
import br.com.financeiro.service.MunicipioService;
import br.com.financeiro.service.UfService;
import br.com.financeiro.service.UsuarioService;
import br.com.financeiro.util.FinanceiroException;
import br.com.financeiro.util.Mensagens;

@Named
@ViewScoped
public class UsuarioBean extends AbstractBean {
	
	private static final long serialVersionUID = 1L;
	
	@EJB UsuarioService usuarioService;
	@EJB EmpresaService empresaService;
	@EJB ModuloService moduloService;
	@EJB MunicipioService municipioService;
	@EJB UfService ufService;
	
	@Inject	private List<Uf> listaEstados;
	
	private Municipio municipioSelecionado;
	private List<Municipio> municipios;
	private Uf uf;	
	private Usuario usuario;
	private DualListModel<Modulo> modulosPickList;
	private List<Modulo> modulosSource;
	private List<Modulo> modulosTarget;
	private String repetirSenha;
	private Contato contato;
	private Endereco endereco;
	private Acesso acesso;
	private List<Usuario> usuarios;
	private Usuario usuarioSelecionado;
	
	@PostConstruct
	public void init() {
		repetirSenha = new String();
		usuario = new Usuario();
		usuario.setAcesso(new Acesso());
		endereco = new Endereco();
		contato = new Contato();
		acesso = new Acesso();
		usuarioSelecionado = new Usuario();
		
		uf = new Uf();
		uf = ufService.obterUfPorId("AC");
		usuarios = new ArrayList<Usuario>(usuarioService.listarUsuariosAtivos());
		municipiosPorUf();
		carregarPickListModulos();
	}
	
	public void salvar() throws FinanceiroException {		
		contato.setUsuario(usuario);
		usuario.getContatos().add(contato);
		municipioSelecionado.setUf(uf);
		endereco.setMunicipio(municipioSelecionado);
		endereco.setPais("BR");
		endereco.setUsuario(usuario);
		usuario.getEnderecos().add(endereco);
		acesso.getUsuarios().add(usuario);
		usuario.setAcesso(acesso);
		usuario.setAtivo(true);
		usuario.setModulos(new HashSet<Modulo>(modulosPickList.getTarget()));
		
		usuarioService.salvar(usuario);
		
		Mensagens.info("Usuário salvo com sucesso!");
		usuarios = new ArrayList<Usuario>(usuarioService.listarUsuariosAtivos());
	}

	public void excluir() {
		usuarioService.excluir(usuarios);
		Mensagens.info("Usuário exluído com sucesso!");
		usuarios = new ArrayList<Usuario>(usuarioService.listarUsuariosAtivos());
	}
	
	public void municipiosPorUf() {
		municipios = new ArrayList<Municipio>(municipioService.listaMunicipiosPorUf(uf));
	}	
	
	public void carregarPickListModulos() {
		modulosSource = new ArrayList<Modulo>(moduloService.listarTodos());
		modulosTarget = new ArrayList<Modulo>();
		
		modulosPickList = new DualListModel<Modulo>(modulosSource, modulosTarget);
	}
	
	public void modalEditUsuario() {
		usuario = usuarioService.obterUsuarioCompleto(usuarioSelecionado.getId());
		
		for(Contato contatoEdit : usuario.getContatos()) {
			if(contatoEdit.isPrincipal()) {
				contato = contatoEdit;
			}
		}
		
		for(Endereco enderecoEdit : usuario.getEnderecos()) {
			if(enderecoEdit.isPrincipal()) {
				endereco = enderecoEdit;
			}
		}
		
	}
	
	public int renderedBotaoExcluir() {
		int contador = 0;
		for(Usuario usuario : usuarios) {
			if(usuario.isSelecionado()) {
				contador++;
			}
		}
		
		return contador;
	}
	
	/*
	 * Getters and Setters
	 */
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public DualListModel<Modulo> getModulosPickList() {
		return modulosPickList;
	}
	
	public void setModulosPickList(DualListModel<Modulo> modulosPickList) {
		this.modulosPickList = modulosPickList;
	}

	public List<Modulo> getModulosSource() {
		return modulosSource;
	}

	public void setModulosSource(List<Modulo> modulosSource) {
		this.modulosSource = modulosSource;
	}

	public List<Modulo> getModulosTarget() {
		return modulosTarget;
	}

	public void setModulosTarget(List<Modulo> modulosTarget) {
		this.modulosTarget = modulosTarget;
	}

	public String getRepetirSenha() {
		return repetirSenha;
	}

	public void setRepetirSenha(String repetirSenha) {
		this.repetirSenha = repetirSenha;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}


	public List<Uf> getListaEstados() {
		return listaEstados;
	}


	public void setListaEstados(List<Uf> listaEstados) {
		this.listaEstados = listaEstados;
	}


	public Municipio getMunicipioSelecionado() {
		return municipioSelecionado;
	}


	public void setMunicipioSelecionado(Municipio municipioSelecionado) {
		this.municipioSelecionado = municipioSelecionado;
	}


	public List<Municipio> getMunicipios() {
		return municipios;
	}


	public void setMunicipios(List<Municipio> municipios) {
		this.municipios = municipios;
	}


	public Uf getUf() {
		return uf;
	}


	public void setUf(Uf uf) {
		this.uf = uf;
	}

	public Acesso getAcesso() {
		return acesso;
	}

	public void setAcesso(Acesso acesso) {
		this.acesso = acesso;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario getUsuarioSelecionado() {
		return usuarioSelecionado;
	}

	public void setUsuarioSelecionado(Usuario usuarioSelecionado) {
		this.usuarioSelecionado = usuarioSelecionado;
	}

}
