package br.com.financeiro.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.financeiro.pojo.ContaContabil;
import br.com.financeiro.pojo.PlanoDeContas;

@Named
@ViewScoped
public class ContaContabilBean extends AbstractBean {

	private static final long serialVersionUID = 1L;

	@Inject private List<PlanoDeContas> listarPlanoDeContasPorEmpresa;
	
	private ContaContabil contaContabil;	
	
	@PostConstruct
	public void init() {
		contaContabil = new ContaContabil();		
	}

	public ContaContabil getContaContabil() {
		return contaContabil;
	}

	public void setContaContabil(ContaContabil contaContabil) {
		this.contaContabil = contaContabil;
	}
	
	public List<PlanoDeContas> getListarPlanoDeContasPorEmpresa() {
		return listarPlanoDeContasPorEmpresa;
	}

	public void setListarPlanoDeContasPorEmpresa(
			List<PlanoDeContas> listarPlanoDeContasPorEmpresa) {
		this.listarPlanoDeContasPorEmpresa = listarPlanoDeContasPorEmpresa;
	}	
	
}
