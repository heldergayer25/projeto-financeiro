package br.com.financeiro.repository;

import java.io.Serializable;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

import br.com.financeiro.pojo.ContaContabil;

@Repository
public interface ContaContabilRepository extends EntityRepository<ContaContabil, Serializable> {

	
	
}
