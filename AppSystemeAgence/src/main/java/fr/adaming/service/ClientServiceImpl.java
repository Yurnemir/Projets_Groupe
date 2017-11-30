package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.AgentDaoImpl;
import fr.adaming.dao.IClientDao;
import fr.adaming.model.Agent;
import fr.adaming.model.Client;

@Service
@Transactional
public class ClientServiceImpl implements IClientService {

	@Autowired
	private IClientDao clientDao;
	@Autowired
	private IAgentService agentService;
	
	@Override
	public List<Client> getAllClients() {
		return clientDao.getAllClients();
	}

	@Override
	public List<Client> getAllClientsByAgent(Agent agent) {
		return clientDao.getAllClientsByAgent(agent);
	}

	@Override
	public Client getClientById(Client client) {
		return clientDao.getClientById(client);
	}

	@Override
	public Client getClientByName(Client client) {
		return clientDao.getClientByName(client);
	}

	@Override
	public Client addClient(Client client, Agent agent) {
		Client outClient = getClientByName(client);
		Agent outAgent = agentService.getAgentById(agent);
		
		if(outClient==null && outAgent !=null){
			client.setAgent(outAgent);
			return clientDao.addClient(client);
		} else {
			return getClientByName(client);
		}
	}
	@Override
	public Client updateClient(Client client, Agent agent) {
		Client outClient = getClientById(client);
		Agent outAgent = agentService.getAgentById(agent);
		
		if(outClient!=null && outAgent!=null){
			if(outClient.getAgent().getId() == outAgent.getId()){
				client.setAgent(outAgent);
				return clientDao.updateClient(client);
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	@Override
	public void deleteClient(Client client, Agent agent) {
		Client outClient = getClientById(client);
		Agent outAgent = agentService.getAgentById(agent);
		
		if(outClient!=null && outAgent!=null){
			if(outClient.getAgent().getId() == outAgent.getId()){
				clientDao.deleteClient(outClient);
			}
		}
	}

}
