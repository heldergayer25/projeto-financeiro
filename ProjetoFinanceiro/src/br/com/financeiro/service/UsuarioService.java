package br.com.financeiro.service;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.financeiro.pojo.Acesso;
import br.com.financeiro.pojo.Contato;
import br.com.financeiro.pojo.Endereco;
import br.com.financeiro.pojo.Modulo;
import br.com.financeiro.pojo.Usuario;
import br.com.financeiro.repository.AcessoRepository;
import br.com.financeiro.repository.ContatoRepository;
import br.com.financeiro.repository.EnderecoRepository;
import br.com.financeiro.repository.ModuloRepository;
import br.com.financeiro.repository.UsuarioRepository;
import br.com.financeiro.util.FinanceiroException;

@Stateless
public class UsuarioService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject UsuarioRepository usuarioRepository;
	@Inject ContatoRepository contatoRepository;
	@Inject EnderecoRepository enderecoRepository;
	@Inject AcessoRepository acessoRepository;
	@Inject ModuloRepository moduloRepository;
	
	
	@Transactional
	public void salvar(Usuario usuario) throws FinanceiroException {
		
		acessoRepository.save(usuario.getAcesso());
		usuarioRepository.save(usuario);
		
		for(Contato contato : usuario.getContatos()) {
			contatoRepository.save(contato);
		}
		
		for(Endereco endereco : usuario.getEnderecos()) {
			enderecoRepository.save(endereco);
		}
		
		for(Modulo modulo : usuario.getModulos()) {
			moduloRepository.save(modulo);
		}
		
		
	}
	
	@Transactional
	public void excluir(List<Usuario> usuarios) {
		
		for(Usuario usuario : usuarios) {
			if(usuario.isSelecionado()) {
				usuario.setAtivo(false);
				usuarioRepository.save(usuario);
			}
		}
		
	}	
	
	public Usuario obterUsuarioCompleto(int id) {
		return usuarioRepository.obterUsuarioCompleto(id);
	}
	
	public Usuario obterUsuarioPorId(int id) {
		return usuarioRepository.findOptionalBy(id);
	}

	public Usuario obterUsuarioPorAcesso(Acesso acesso) {
		return usuarioRepository.findByAcesso(acesso);
	}

	public List<Usuario> listarUsuariosAtivos() {
		return usuarioRepository.listarUsuariosAtivos();
	}
	
}
