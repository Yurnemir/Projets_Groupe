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
	public Client getClientById(Client client, Agent agent) {
		Client outClient = clientDao.getClientById(client);
		if(outClient.getAgent().getId() == agent.getId()){
			return outClient;
		} else {
			return null;
		}
	}

	@Override
	public Client addClient(Client client, Agent agent) {
		if(agentService.getAgentById(agent)!=null){
			client.setAgent(agent);
			return clientDao.addClient(client);
		} else {
			return null;
		}
	}
	@Override
	public Client updateClient(Client client, Agent agent) {
		if(agentService.getAgentById(agent)!=null){
			client.setAgent(agent);
			return clientDao.updateClient(client);
		} else {
			return null;
		}
	}

	@Override
	public void deleteClient(Client client, Agent agent) {
		// TODO Auto-generated method stub
		
	}

}
