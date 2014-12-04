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
import javax.persistence.Table;

/**
 * Modulo generated by hbm2java
 */
@Entity
@Table(name = "modulo")
public class Modulo implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private int codigo;
	private Set<Usuario> usuarios = new HashSet<>(0);

	public Modulo() {
	}

	public Modulo(String nome, int codigo) {
		this.nome = nome;
		this.codigo = codigo;
	}

	public Modulo(String nome, int codigo, Set<Usuario> usuarios) {
		this.nome = nome;
		this.codigo = codigo;
		this.usuarios = usuarios;
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

	@Column(name = "nome", nullable = false, length = 45)
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(name = "codigo", nullable = false)
	public int getCodigo() {
		return this.codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "modulo_has_usuario", joinColumns = { @JoinColumn(name = "modulo_id", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "usuario_id", nullable = false, updatable = false) })
	public Set<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	@Override
	public String toString() {	
		return getNome();
	}

}
