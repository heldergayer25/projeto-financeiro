package br.com.financeiro.repository;

import java.io.Serializable;
import java.util.List;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

import br.com.financeiro.pojo.Municipio;
import br.com.financeiro.pojo.Uf;

@Repository
public interface MunicipioRepository extends EntityRepository<Municipio, Serializable> {

	List<Municipio> findByUfOrderByUfAsc(Uf uf);
	
}
