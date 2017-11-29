package fr.adaming.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.model.Contrat;
import fr.adaming.service.IContratService;

@RestController
public class ContratRest {

	@Autowired
	private IContratService contratService ; 
	
	
	public List<Contrat> getAllContrats(){
		return contratService.getAllContrats() ; 
	}
	
}
