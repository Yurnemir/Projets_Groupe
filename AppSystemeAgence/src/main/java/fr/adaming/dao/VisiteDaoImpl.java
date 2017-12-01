package fr.adaming.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Client;
import fr.adaming.model.Visite;

@Repository
public class VisiteDaoImpl implements IVisiteDao{

	@Autowired
	private SessionFactory sf;
	
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public List<Visite> getAllVisite() {
		
		Session s = sf.getCurrentSession();
		
		String req = "from Visite v";
		
		Query query = s.createQuery(req);
		
		@SuppressWarnings("unchecked")
		List<Visite> liste = query.list();
		
		return liste;
	}

	@Override
	public Visite getVisiteById(int id) {
		
		Session s = sf.getCurrentSession();
		
		return (Visite) s.get(Visite.class, id);
	}

	@Override
	public Visite addVisite(Visite visite) {
		
		Session s = sf.getCurrentSession();		
		
		s.persist(visite);
		
		return visite;
	}

	@Override
	public Visite updateVisite(Visite visite) {

		Session s = sf.getCurrentSession();
		
		Visite vUpdate = (Visite) s.get(Visite.class, visite.getId());
		
		vUpdate.setDate(visite.getDate());
		vUpdate.setHeure(visite.getHeure());
		vUpdate.setBien(visite.getBien());
		vUpdate.setClient(visite.getClient());
		
		s.saveOrUpdate(vUpdate);
		
		return vUpdate;
	}

	@Override
	public void deleteVisite(int id) {
		Session s = sf.getCurrentSession();
		
		Visite vDelete = (Visite) s.get(Visite.class, id);
		
		s.delete(vDelete);
		
	}

	@Override
	public List<Visite> getAllVisitesByClient(Client inClient) {
		String req = "FROM Visite v WHERE v.client.id=:idClient";
		
		Query query = sf.getCurrentSession().createQuery(req);
		query.setParameter("idClient", inClient.getId());
		
		return query.list();
	}

}
