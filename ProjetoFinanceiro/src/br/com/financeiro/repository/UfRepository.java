package br.com.financeiro.repository;

import java.io.Serializable;
import java.util.List;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Query;
import org.apache.deltaspike.data.api.Repository;

import br.com.financeiro.pojo.Uf;

@Repository
public interface UfRepository extends EntityRepository<Uf, Serializable> {

	@Query("SELECT uf FROM Uf uf ORDER BY uf.sigla ASC")
	List<Uf> listarEstados();

	Uf findBySigla(String sigla);	
	
}
