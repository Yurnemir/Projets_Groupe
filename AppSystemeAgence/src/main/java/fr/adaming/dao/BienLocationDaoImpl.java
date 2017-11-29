package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.BienLocation;

@Repository
public class BienLocationDaoImpl implements IBienLocationDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public List<BienLocation> getAllBiensLocation() {
		Session session = this.sessionFactory.getCurrentSession();
		String request = "FROM BienLocation b";
		Query query = session.createQuery(request);
		return query.list();
	}

	@Override
	public BienLocation getBienLocationById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		String request = "FROM BienLocation b WHERE b.id=:pId";
		Query query = session.createQuery(request);
		query.setParameter("pId", id);
		return (BienLocation) query.uniqueResult();
	}

	@Override
	public BienLocation addBienLocation(BienLocation bienLocation) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(bienLocation);
		return bienLocation;
	}

	@Override
	public BienLocation updateBienLocation(BienLocation bienLocation) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(bienLocation);
		return bienLocation;
	}

	@Override
	public void deleteBienLocation(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(this.getBienLocationById(id));
	}
}
