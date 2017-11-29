package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Proprietaire;

@Repository
public class ProprietaireDaoImpl implements IProprietaireDao{

	@Autowired
	private SessionFactory sf;

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public List<Proprietaire> getAllProprietaires() {
		
		Session s = sf.getCurrentSession();
		
		String req = "from Proprietaire p";
		
		Query query = s.createQuery(req);
		
		@SuppressWarnings("unchecked")
		List<Proprietaire> liste = query.list();
		
		return liste;
	}

	@Override
	public Proprietaire getProprietaireById(Proprietaire prop) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Proprietaire addProprietaire(Proprietaire prop) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Proprietaire updateProprietaire(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteProprietaire(int id) {
		// TODO Auto-generated method stub
		
	}
}
