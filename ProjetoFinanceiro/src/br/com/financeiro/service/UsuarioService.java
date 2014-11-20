package br.com.financeiro.service;

import java.io.Serializable;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.financeiro.pojo.Acesso;
import br.com.financeiro.pojo.Usuario;
import br.com.financeiro.repository.UsuarioRepository;

@Stateless
public class UsuarioService implements Serializable {

	private static final long serialVersionUID = 1L;
	@Inject UsuarioRepository usuarioRepository;
	
	
	public Usuario obterUsuarioPorId(int id) {
		return usuarioRepository.findOptionalBy(id);
	}


	public Usuario obterUsuarioPorAcesso(Acesso acesso) {
		return usuarioRepository.findByAcesso(acesso);
	}

}
