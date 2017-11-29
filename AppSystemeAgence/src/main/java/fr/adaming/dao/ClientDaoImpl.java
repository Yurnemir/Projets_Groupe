package fr.adaming.dao;

import java.util.List;

import org.hibernate.NonUniqueResultException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Agent;
import fr.adaming.model.Client;

@Repository
public class ClientDaoImpl implements IClientDao{

	@Autowired
	private SessionFactory sf;
	
	@Override
	
	public List<Client> getAllClients() {
		String req = "FROM Client u";
		
		return sf.getCurrentSession().createQuery(req).list();
	}

	@Override
	public List<Client> getAllClientsByAgent(Agent agent) {
		String req = "FROM Client u WHERE u.agent.id=:aId";
		Query query = sf.getCurrentSession().createQuery(req);
		query.setParameter("aId", agent.getId());
		
		return query.list();
	}

	@Override
	public Client getClientById(Client client) {
		return (Client) sf.getCurrentSession().get(Client.class, client.getId());
	}

	@Override
	public Client addClient(Client client) {
		sf.getCurrentSession().persist(client);
		return client;
	}

	@Override
	public Client updateClient(Client client) {
		sf.getCurrentSession().saveOrUpdate(client);
		return client;
	}

	@Override
	public void deleteClient(Client client) {
		sf.getCurrentSession().delete(client);	
	}

}
