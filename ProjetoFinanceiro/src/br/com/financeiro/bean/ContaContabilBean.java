package br.com.financeiro.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.financeiro.pojo.ContaContabil;
import br.com.financeiro.pojo.PlanoDeContas;

@Named
@ViewScoped
public class ContaContabilBean extends AbstractBean {

	private static final long serialVersionUID = 1L;
	
	private ContaContabil contaContabil;
	private List<ContaContabil> listaContaContabil;
	private List<PlanoDeContas> listaPlanoDeContas;
	
	@PostConstruct
	public void init() {
				
	}

	public ContaContabil getContaContabil() {
		return contaContabil;
	}

	public void setContaContabil(ContaContabil contaContabil) {
		this.contaContabil = contaContabil;
	}

	public List<ContaContabil> getListaContaContabil() {
		return listaContaContabil;
	}

	public void setListaContaContabil(List<ContaContabil> listaContaContabil) {
		this.listaContaContabil = listaContaContabil;
	}

	public List<PlanoDeContas> getListaPlanoDeContas() {
		return listaPlanoDeContas;
	}

	public void setListaPlanoDeContas(List<PlanoDeContas> listaPlanoDeContas) {
		this.listaPlanoDeContas = listaPlanoDeContas;
	}
	
	
	
}
