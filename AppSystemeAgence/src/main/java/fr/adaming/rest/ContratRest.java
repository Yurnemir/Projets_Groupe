package fr.adaming.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.model.BienImmobilier;
import fr.adaming.model.Client;
import fr.adaming.model.Contrat;
import fr.adaming.service.IContratService;

@RestController
//@RequestMapping("/contrats")
public class ContratRest {

	@Autowired
	private IContratService contratService ; 
	
	@RequestMapping(value="/listeContrats", method=RequestMethod.GET, produces="application/json")
	public List<Contrat> getAllContrats(){
		return contratService.getAllContrats() ; 
	}
	
	@RequestMapping(value="/addContrat/{clId}/{bId}", method=RequestMethod.POST,produces="application/json",consumes="application/json")
	public Contrat addContrat(@RequestBody Contrat c, @PathVariable("clId") int idCl, @PathVariable("bId") int idB){
		return contratService.addContrat(c,idCl,idB);
	}
	
	@RequestMapping(value="/getContrat/{pId}", method=RequestMethod.GET, produces="application/json")
	public Contrat getContratById(@PathVariable("pId") int id){
		return contratService.getContratById(id); 
	}
	
}
