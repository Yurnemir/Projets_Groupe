package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.adaming.dao.IClientDao;
import fr.adaming.model.Agent;
import fr.adaming.model.Client;

@Service
public class ClientServiceImpl implements IClientService {

	@Autowired
	private IClientDao clientDao;
	
	@Override
	public List<Client> getAllClients() {
		return clientDao.getAllClients();
	}

	@Override
	public List<Client> getAllClientsByAgent(Agent agent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Client getClientById(Client client, Agent agent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Client addClient(Client client, Agent agent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Client updateClient(Client client, Agent agent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteClient(Client client, Agent agent) {
		// TODO Auto-generated method stub
		
	}

}
