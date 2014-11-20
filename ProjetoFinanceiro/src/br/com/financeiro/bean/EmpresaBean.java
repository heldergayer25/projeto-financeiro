package br.com.financeiro.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.financeiro.pojo.Contato;
import br.com.financeiro.pojo.Empresa;
import br.com.financeiro.pojo.Endereco;
import br.com.financeiro.pojo.Municipio;
import br.com.financeiro.pojo.Uf;
import br.com.financeiro.service.EmpresaService;
import br.com.financeiro.service.MunicipioService;
import br.com.financeiro.service.UfService;
import br.com.financeiro.util.Mensagens;

@Named
@ViewScoped
public class EmpresaBean extends LoginBean {
	
	private static final long serialVersionUID = 1L;

	@EJB private MunicipioService municipioService;
	@EJB private UfService ufService;
	@EJB private EmpresaService empresaService;
	
	@Inject	private List<Uf> listaEstados;	
	
	private Empresa empresa;
	private Endereco endereco;
	private Contato contato;
	
	private Municipio municipioSelecionado;
	private List<Municipio> municipios;
	private Uf uf;
		
	
	@PostConstruct
	public void init() {
		empresa = new Empresa();
		contato = new Contato();
		endereco = new Endereco();
		uf = new Uf();
		uf = ufService.obterUfPorId("AC");
		municipiosPorUf();
	}

	
	public void salvar() throws Exception {
		contato.setAtivo(true);
		contato.setPrincipal(true);
		contato.setEmpresa(empresa);
		endereco.setAtivo(true);
		endereco.setPais("BR");
		endereco.setPrincipal(true);
		endereco.setMunicipio(municipioSelecionado);
		endereco.setEmpresa(empresa);
		empresa.setAtivo(true);		
		empresa.getContatos().add(contato);
		empresa.getEnderecos().add(endereco);	
		
		empresaService.salvar(empresa);
		
		Mensagens.info("Empresa salva com sucesso!");
	}
	
	
	public void municipiosPorUf() {
		municipios = new ArrayList<Municipio>(municipioService.listaMunicipiosPorUf(uf));
	}	
	
	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
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
	
}
