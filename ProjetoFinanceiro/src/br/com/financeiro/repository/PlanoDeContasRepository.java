package br.com.financeiro.repository;

import java.io.Serializable;
import java.util.List;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

import br.com.financeiro.pojo.Empresa;
import br.com.financeiro.pojo.PlanoDeContas;

@Repository
public interface PlanoDeContasRepository extends EntityRepository<PlanoDeContas, Serializable> {

	PlanoDeContas findOptionalByDescricaoAndEmpresa(String descricao, Empresa empresa);

	List<PlanoDeContas> findByEmpresaOrderByDescricaoAsc(Empresa empresaSessao);	
	
}
