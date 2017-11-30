package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Agent;
import fr.adaming.model.Client;

public interface IClientDao {

	public List<Client> getAllClients();
	
	public List<Client> getAllClientsByAgent(Agent agent);
	
	public Client getClientById(Client client);
	
	public Client getClientByName(Client client);
	
	public Client addClient(Client client);
	
	public Client updateClient(Client client);
	
	public void deleteClient(Client client);
	
}
