package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Proprietaire;

@Repository
public class ProprietaireDaoImpl implements IProprietaireDao {

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
	public Proprietaire getProprietaireById(int id) {

		Session s = sf.getCurrentSession();

		return (Proprietaire) s.get(Proprietaire.class, id);
	}

	@Override
	public Proprietaire addProprietaire(Proprietaire prop) {

		Session s = sf.getCurrentSession();
		
		s.save(prop);
		
		return prop;
	}

	@Override
	public Proprietaire updateProprietaire(Proprietaire prop) {
		
		Session s = sf.getCurrentSession();
		
		Proprietaire propUpdate = (Proprietaire) s.get(Proprietaire.class, prop.getId());
		
		propUpdate.setNom(prop.getNom());
		propUpdate.setTelPrive(prop.getTelPrive());
		propUpdate.setTelTravail(prop.getTelTravail());
		propUpdate.setAdresseProprietaire(prop.getAdresseProprietaire());
		propUpdate.setListeBiens(prop.getListeBiens());
		
		s.saveOrUpdate(propUpdate);
		
		return propUpdate;
	}

	@Override
	public void deleteProprietaire(int id) {
		Session s = sf.getCurrentSession();
		
		Proprietaire propDelete = (Proprietaire) s.get(Proprietaire.class, id);
		
		s.delete(propDelete);
	}
}
