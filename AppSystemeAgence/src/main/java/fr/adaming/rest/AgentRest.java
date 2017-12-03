package fr.adaming.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.model.Agent;
import fr.adaming.service.IAgentService;

@RestController
public class AgentRest {
	@Autowired
	private IAgentService agentService;

	public void setAgentService(IAgentService agentService) {
		this.agentService = agentService;
	}

	@RequestMapping(value = "/agent", method = RequestMethod.GET, produces = "application/json")
	public Agent getAgent(@RequestParam("pUsername") String username, @RequestParam("pPassword") String password) {
		Agent agentIn = new Agent(username, password);
		return this.agentService.getAgent(agentIn);
	}
}
