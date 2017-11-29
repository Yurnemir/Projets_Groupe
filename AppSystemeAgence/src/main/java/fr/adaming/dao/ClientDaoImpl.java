package fr.adaming.dao;

import java.util.List;

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
		String req = "FROM Client";
		
		return sf.getCurrentSession().createQuery(req).list();
	}

	@Override
	public List<Client> getAllClientsByAgent(Agent agent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Client getClientById(Client client) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Client addClient(Client client) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Client updateClient(Client client) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteClient(Client client) {
		// TODO Auto-generated method stub
		
	}

}
