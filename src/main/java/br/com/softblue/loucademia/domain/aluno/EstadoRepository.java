package br.com.softblue.loucademia.domain.aluno;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class EstadoRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	public List<Estado> listEstados(){
		return em.createQuery("SELECT e FROM  Estado e ORDER BY e.nome",Estado.class).getResultList();
		
	}

}
