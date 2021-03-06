package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Contrat;

@Repository
public class ContratDaoImpl implements IContratDao {

	
	@Autowired
	private SessionFactory sf;
	

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Contrat> getAllContrats() {
		Session s = sf.getCurrentSession(); 
		Query query = s.createQuery("FROM Contrat");
		return query.list();
	}

	@Override
	public Contrat addContrat(Contrat c) {
		Session s = sf.getCurrentSession(); 
		s.save(c) ; 
		return c;
	}

	@Override
	public Contrat getContratById(int id) {
		Session s = sf.getCurrentSession(); 
		Query query = s.createQuery("FROM Contrat c WHERE c.id=:pId");	
		query.setParameter("pId", id);
		return (Contrat) query.uniqueResult() ;
	}




	

}
