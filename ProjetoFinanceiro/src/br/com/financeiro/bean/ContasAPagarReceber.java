package br.com.financeiro.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.financeiro.pojo.Movimento;

@Named
@ViewScoped
public class ContasAPagarReceber extends LoginBean {
	
	private static final long serialVersionUID = 1L;

	private Movimento movimento;
	private List<Movimento> listaMovimento;
	
	@PostConstruct
	public void init() {
		
	}

	public Movimento getMovimento() {
		return movimento;
	}

	public void setMovimento(Movimento movimento) {
		this.movimento = movimento;
	}

	public List<Movimento> getListaMovimento() {
		return listaMovimento;
	}

	public void setListaMovimento(List<Movimento> listaMovimento) {
		this.listaMovimento = listaMovimento;
	}
	
}
