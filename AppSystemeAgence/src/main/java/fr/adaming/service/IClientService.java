package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Agent;
import fr.adaming.model.Client;

public interface IClientService {
	
	public List<Client> getAllClients();
	
	public List<Client> getAllClientsByAgent(Agent agent);
	
	public Client getClientById(Client client, Agent agent);
	
	public Client addClient(Client client, Agent agent);
	
	public Client updateClient(Client client, Agent agent);
	
	public void deleteClient(Client client, Agent agent);
}
