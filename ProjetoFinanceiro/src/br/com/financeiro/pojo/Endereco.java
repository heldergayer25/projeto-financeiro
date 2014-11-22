package br.com.financeiro.pojo;

// default package
// Generated 10/11/2014 22:21:36 by Hibernate Tools 4.0.0

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Endereco generated by hbm2java
 */
@Entity
@Table(name = "endereco")
public class Endereco implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;

	private Integer id;
	private Usuario usuario;
	private Empresa empresa;
	private ClienteFornecedor clienteFornecedor;
	private Municipio municipio;
	private String rua;
	private int numero;
	private int cep;
	private String bairro;
	private String pais;
	private String outro;	
	private boolean ativo;
	private boolean principal;

	public Endereco() {
	}

	public Endereco(Municipio municipio, String rua, int numero, int cep,
			String bairro, String pais, boolean ativo) {
		this.municipio = municipio;
		this.rua = rua;
		this.numero = numero;
		this.cep = cep;
		this.bairro = bairro;
		this.pais = pais;
		this.ativo = ativo;
	}

	public Endereco(Usuario usuario, Empresa empresa,
			ClienteFornecedor clienteFornecedor, Municipio municipio,
			String rua, int numero, int cep, String bairro, String pais,
			String outro, Integer funcionarioId, boolean ativo,
			boolean principal) {
		this.usuario = usuario;
		this.empresa = empresa;
		this.clienteFornecedor = clienteFornecedor;
		this.municipio = municipio;
		this.rua = rua;
		this.numero = numero;
		this.cep = cep;
		this.bairro = bairro;
		this.pais = pais;
		this.outro = outro;		
		this.ativo = ativo;
		this.principal = principal;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario_id")	
	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "empresa_id")
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cliente_fornecedor_id")
	public ClienteFornecedor getClienteFornecedor() {
		return this.clienteFornecedor;
	}

	public void setClienteFornecedor(ClienteFornecedor clienteFornecedor) {
		this.clienteFornecedor = clienteFornecedor;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "municipio_id", nullable = false)
	@NotNull
	public Municipio getMunicipio() {
		return this.municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	@Column(name = "rua", nullable = false, length = 200)
	@NotNull
	@NotEmpty(message = "Uma rua deve ser infomada!")
	@Length(max = 200)	
	public String getRua() {
		return this.rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	@Column(name = "numero", nullable = false)
	@NotNull
	public int getNumero() {
		return this.numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	@Column(name = "cep", nullable = false)
	@NotNull
	public int getCep() {
		return this.cep;
	}

	public void setCep(int cep) {
		this.cep = cep;
	}

	@Column(name = "bairro", nullable = false, length = 100)
	@NotNull
	public String getBairro() {
		return this.bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	@Column(name = "pais", nullable = false, length = 20)
	@NotNull
	public String getPais() {
		return this.pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	@Column(name = "outro", length = 50)
	public String getOutro() {
		return this.outro;
	}

	public void setOutro(String outro) {
		this.outro = outro;
	}	

	@Column(name = "ativo", nullable = false)
	@NotNull
	public boolean isAtivo() {
		return this.ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	@Column(name = "principal")
	public boolean getPrincipal() {
		return this.principal;
	}

	public void setPrincipal(boolean principal) {
		this.principal = principal;
	}

}