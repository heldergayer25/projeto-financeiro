package br.com.financeiro.repository;

import java.io.Serializable;
import java.util.List;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Query;
import org.apache.deltaspike.data.api.Repository;

import br.com.financeiro.pojo.Acesso;
import br.com.financeiro.pojo.Usuario;

@Repository
public interface UsuarioRepository extends EntityRepository<Usuario, Serializable> {

	Usuario findOptionalBy(int id);

	Usuario findByAcesso(Acesso acesso);	
	
	@Query("SELECT u FROM Usuario u "
			+ "LEFT JOIN FETCH u.contatos "
			+ "LEFT JOIN FETCH u.enderecos "			
         + "WHERE u.id = ?1")
	Usuario obterUsuarioCompleto(int id);
	
	@Query("SELECT u FROM Usuario u WHERE u.ativo = true ORDER BY u.nome ASC")
	List<Usuario> listarUsuariosAtivos();
	
}
