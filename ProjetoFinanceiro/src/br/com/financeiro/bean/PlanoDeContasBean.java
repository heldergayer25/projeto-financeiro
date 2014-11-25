package br.com.financeiro.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.financeiro.pojo.PlanoDeContas;
import br.com.financeiro.service.PlanoDeContasService;
import br.com.financeiro.util.Mensagens;

@Named
@ViewScoped
public class PlanoDeContasBean extends LoginBean {

	private static final long serialVersionUID = 1L;

	@EJB private PlanoDeContasService planoDeContasService;
	
	private PlanoDeContas planoDeContas;
	private List<PlanoDeContas> listaPlanoDeContas;
	
	@PostConstruct
	public void init() {
		
	}

	public void salvar() throws Exception {
//		private Integer id;
//		private Empresa empresa;
//		private PlanoDeContas planoDeContas;
//		private String descricao;
//		private Set<PlanoDeContas> planoDeContases = new HashSet<>(0);
//		private Set<ContaContabil> contaContabils = new HashSet<>(0);
		
		planoDeContasService.salvar(planoDeContas);
		Mensagens.info("Plano de Contas salvo com sucesso!");
		
	}
	
	
	public PlanoDeContas getPlanoDeContas() {
		return planoDeContas;
	}

	public void setPlanoDeContas(PlanoDeContas planoDeContas) {
		this.planoDeContas = planoDeContas;
	}

	public List<PlanoDeContas> getListaPlanoDeContas() {
		return listaPlanoDeContas;
	}

	public void setListaPlanoDeContas(List<PlanoDeContas> listaPlanoDeContas) {
		this.listaPlanoDeContas = listaPlanoDeContas;
	}
	
}
