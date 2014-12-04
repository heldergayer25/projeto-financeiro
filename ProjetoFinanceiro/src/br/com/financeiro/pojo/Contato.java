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

/**
 * Contato generated by hbm2java
 */
@Entity
@Table(name = "contato")
public class Contato implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;

	private Integer id;
	private Usuario usuario;
	private Empresa empresa;
	private ClienteFornecedor clienteFornecedor;
	private String telefone;
	private String celular;
	private String email;
	private boolean ativo;
	private boolean principal;

	public Contato() {
	}

	public Contato(String telefone, String celular, String email, boolean ativo) {
		this.telefone = telefone;
		this.celular = celular;
		this.email = email;
		this.ativo = ativo;
	}

	public Contato(Usuario usuario, Empresa empresa,
			ClienteFornecedor clienteFornecedor, String telefone,
			String celular, String email, boolean ativo, boolean principal) {
		this.usuario = usuario;
		this.empresa = empresa;
		this.clienteFornecedor = clienteFornecedor;
		this.telefone = telefone;
		this.celular = celular;
		this.email = email;
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

	@Column(name = "telefone", nullable = false, length = 20)
	@NotNull	
	@Length(max = 20, message = "Telefone deve ter no m�ximo 20 n�meros!")
	public String getTelefone() {
		return this.telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Column(name = "celular", nullable = false, length = 20)
	@NotNull
	@Length(max = 20, message = "Celular deve ter no m�ximo 20 n�meros!")
	public String getCelular() {
		return this.celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	@Column(name = "email", nullable = false, length = 50)
	@NotNull
	@Length(max = 50, message = "E-mail deve ter no m�ximo 50 caract�ries!")
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
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
	public boolean isPrincipal() {
		return this.principal;
	}

	public void setPrincipal(boolean principal) {
		this.principal = principal;
	}

}
