package br.com.financeiro.repository;

import java.io.Serializable;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

import br.com.financeiro.pojo.Endereco;

@Repository
public interface EnderecoRepository extends EntityRepository<Endereco, Serializable> {

	
	
}
