package br.com.financeiro.pojo;

// default package
// Generated 10/11/2014 22:21:36 by Hibernate Tools 4.0.0

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * PlanoDeContas generated by hbm2java
 */
@Entity
@Table(name = "plano_de_contas")
public class PlanoDeContas implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Empresa empresa;
	private PlanoDeContas planoDeContas;
	private String descricao;
	private Set<PlanoDeContas> planoDeContases = new HashSet<>(0);
	private Set<ContaContabil> contaContabils = new HashSet<>(0);

	public PlanoDeContas() {
	}

	public PlanoDeContas(PlanoDeContas planoDeContas, String descricao) {
		this.planoDeContas = planoDeContas;
		this.descricao = descricao;
	}

	public PlanoDeContas(Empresa empresa, PlanoDeContas planoDeContas,
			String descricao, Set<PlanoDeContas> planoDeContases, Set<ContaContabil> contaContabils) {
		this.empresa = empresa;
		this.planoDeContas = planoDeContas;
		this.descricao = descricao;
		this.planoDeContases = planoDeContases;
		this.contaContabils = contaContabils;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "empresa_id")
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "plano_de_contas_id", nullable = false)
	public PlanoDeContas getPlanoDeContas() {
		return this.planoDeContas;
	}

	public void setPlanoDeContas(PlanoDeContas planoDeContas) {
		this.planoDeContas = planoDeContas;
	}

	@Column(name = "descricao", nullable = false, length = 100)
	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "planoDeContas")
	public Set<PlanoDeContas> getPlanoDeContases() {
		return this.planoDeContases;
	}

	public void setPlanoDeContases(Set<PlanoDeContas> planoDeContases) {
		this.planoDeContases = planoDeContases;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "planoDeContas")
	public Set<ContaContabil> getContaContabils() {
		return this.contaContabils;
	}

	public void setContaContabils(Set<ContaContabil> contaContabils) {
		this.contaContabils = contaContabils;
	}

}
