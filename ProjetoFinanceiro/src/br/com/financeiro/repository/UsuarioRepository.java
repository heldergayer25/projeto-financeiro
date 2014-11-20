package br.com.financeiro.repository;

import java.io.Serializable;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

import br.com.financeiro.pojo.Acesso;
import br.com.financeiro.pojo.Usuario;

@Repository
public interface UsuarioRepository extends EntityRepository<Usuario, Serializable> {

	Usuario findOptionalBy(int id);

	Usuario findByAcesso(Acesso acesso);	
	
}
