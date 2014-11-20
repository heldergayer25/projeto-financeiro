package br.com.financeiro.service;

import java.io.Serializable;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.financeiro.pojo.Acesso;
import br.com.financeiro.repository.AcessoRepository;

@Stateless
public class AcessoService implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Inject AcessoRepository acessoRepository;
		
	
	public Acesso obterAcessoPorId(int id) {
		return acessoRepository.findBy(id);
	}

	public Acesso validaLoginSenha(String login, String senha) {
		return acessoRepository.findOptionalByLoginAndSenha(login, senha);
	}
	
}
