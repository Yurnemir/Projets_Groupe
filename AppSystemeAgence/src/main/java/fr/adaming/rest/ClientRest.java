package fr.adaming.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.model.Agent;
import fr.adaming.model.Client;
import fr.adaming.service.IAgentService;
import fr.adaming.service.IClientService;

@RestController
@RequestMapping("/client")
public class ClientRest {

	@Autowired
	private IClientService clientService;
	
	@Autowired
	private IAgentService agentService;
	
	@RequestMapping(value="/all",method=RequestMethod.GET,produces="application/json")
	public List<Client> getAllClients(){
		return clientService.getAllClients();
	}
	
	@RequestMapping(value="/allFromAgent", method=RequestMethod.GET,consumes="application/json",produces="application/json")
	public List<Client> getAllClientsByAgent(@RequestBody Agent agent ){
		return clientService.getAllClientsByAgent(agent);
	}
	
	@RequestMapping(value="/getById", method=RequestMethod.GET,produces="application/json")
	public Client getClientById(@RequestParam(value="clientID") int clientID, @RequestParam(value="agentID") int agentID){
		Agent agent = new Agent();
		agent.setId(agentID);
		Client client = new Client();
		client.setId(clientID);
		
		return clientService.getClientById(client, agent);
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST,consumes="application/json",produces="application/json")
	public Client addClient(@RequestBody Client client, @RequestParam(value="agentID") int agentID){
		
		Agent agent = new Agent();
		agent.setId(agentID);
		
		client = clientService.addClient(client, agent);
		return client;
	}
	
	@RequestMapping(value="/update",method=RequestMethod.PUT,consumes="application/json",produces="application/json")
	public Client updateClient(@RequestBody Client client, @RequestParam(value="agentID") int agentID){
		Agent agent = new Agent();
		agent.setId(agentID);

		client = clientService.updateClient(client, agent);
		return client;
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.DELETE,consumes="application/json")
	public void deleteClient(@RequestBody Client client, @RequestParam(value="agentID") int agentID){
		Agent agent = new Agent();
		agent.setId(agentID);

		clientService.deleteClient(client, agent);
	}
	
}
