package br.com.financeiro.repository;

import java.io.Serializable;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Query;
import org.apache.deltaspike.data.api.Repository;

import br.com.financeiro.pojo.Empresa;

@Repository
public interface EmpresaRepository extends EntityRepository<Empresa, Serializable> {

	Empresa findOptionalByCpfCnpj(String cpfCnpj);	
	
	@Query("SELECT e FROM Empresa e "
			+ "LEFT JOIN FETCH e.contatos "
			+ "LEFT JOIN FETCH e.enderecos "			
         + "WHERE e.id = ?1")
	Empresa obterEmpresaCompleta(int id);
	
}
