package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.BienAchat;

@Repository
public class BienAchatDaoImpl implements IBienAchatDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<BienAchat> getAllBiensAchat() {
		Session session = this.sessionFactory.getCurrentSession();
		String request = "FROM BienAchat b";
		Query query = session.createQuery(request);
		return query.list();
	}
	
	@Override
	public BienAchat getBienAchatById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		String request = "FROM BienAchat b WHERE b.id=:pId";
		Query query = session.createQuery(request);
		query.setParameter("pId", id);
		return (BienAchat) query.uniqueResult();
	}
	
	@Override
	public BienAchat addBienAchat(BienAchat bienAchat) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(bienAchat);
		return bienAchat;
	}
	
	@Override
	public BienAchat updateBienAchat(BienAchat bienAchat) {
		Session session = this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(bienAchat);
		return bienAchat;
	}
	
	@Override
	public void deleteBienAchat(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(this.getBienAchatById(id));
	}
}
