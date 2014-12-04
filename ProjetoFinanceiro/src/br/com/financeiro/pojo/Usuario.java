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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;


/**
 * Usuario generated by hbm2java
 */
@Entity
@Table(name = "usuario")
public class Usuario implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Acesso acesso;
	private String nome;
	private String cpf;
	private Set<Modulo> modulos = new HashSet<>(0);
	private Set<Contato> contatos = new HashSet<>(0);
	private Set<Empresa> empresas = new HashSet<>(0);
	private Set<Endereco> enderecos = new HashSet<>(0);

	public Usuario() {
	}

	public Usuario(Acesso acesso, String nome, String cpf) {
		this.acesso = acesso;
		this.nome = nome;
		this.cpf = cpf;
	}

	public Usuario(Acesso acesso, String nome, String cpf, Set<Modulo> modulos,
			Set<Contato> contatos, Set<Empresa> empresas, Set<Endereco> enderecos) {
		this.acesso = acesso;
		this.nome = nome;
		this.cpf = cpf;
		this.modulos = modulos;
		this.contatos = contatos;
		this.empresas = empresas;
		this.enderecos = enderecos;
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
	@JoinColumn(name = "acesso_id", nullable = false)
	public Acesso getAcesso() {
		return this.acesso;
	}

	public void setAcesso(Acesso acesso) {
		this.acesso = acesso;
	}

	@Column(name = "nome", nullable = false, length = 100)
	@NotNull
	@Length(max = 100, message = "O Nome deve ter no m�ximo 100 caract�ries!")
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(name = "cpf", nullable = false, length = 11)	
	@NotNull
	@Length(max = 11, min = 11, message = "CPF deve ter 11 n�meros!")
	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "modulo_has_usuario", joinColumns = { @JoinColumn(name = "usuario_id", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "modulo_id", nullable = false, updatable = false) })
	public Set<Modulo> getModulos() {
		return this.modulos;
	}

	public void setModulos(Set<Modulo> modulos) {
		this.modulos = modulos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
	public Set<Contato> getContatos() {
		return this.contatos;
	}

	public void setContatos(Set<Contato> contatos) {
		this.contatos = contatos;
	}

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "usuario_has_empresa", joinColumns = { @JoinColumn(name = "usuario_id", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "empresa_id", nullable = false, updatable = false) })
	public Set<Empresa> getEmpresas() {
		return this.empresas;
	}

	public void setEmpresas(Set<Empresa> empresas) {
		this.empresas = empresas;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
	public Set<Endereco> getEnderecos() {
		return this.enderecos;
	}

	public void setEnderecos(Set<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

}
