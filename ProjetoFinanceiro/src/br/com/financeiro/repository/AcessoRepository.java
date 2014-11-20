package br.com.financeiro.repository;

import java.io.Serializable;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

import br.com.financeiro.pojo.Acesso;

@Repository
public interface AcessoRepository extends EntityRepository<Acesso, Serializable> {

	Acesso findOptionalByLoginAndSenha(String login, String senha);	
	
}
