package fr.adaming.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.model.Proprietaire;
import fr.adaming.service.IProprietaireService;

@RestController
public class ProprietaireRest {

	@Autowired
	private IProprietaireService propService;

	public void setPropService(IProprietaireService propService) {
		this.propService = propService;
	}
	
	@RequestMapping(value="/listeProp", method=RequestMethod.GET, produces="application/json")
	public List<Proprietaire> getAllProprietaires(){
		return propService.getAllProprietaires();
	}
	
	@RequestMapping(value="/prop", method=RequestMethod.GET, produces="application/json")
	public Proprietaire getProprietaireById(@RequestParam("pId") int id){
		return propService.getProprietaireById(id);
	}
	
	@RequestMapping(value="/prop", method=RequestMethod.POST, produces="application/json", consumes="application/json")
	public Proprietaire addProprietaire(@RequestBody Proprietaire prop){
		return propService.addProprietaire(prop);
	}
	
	@RequestMapping(value="/prop", method=RequestMethod.PUT, produces="application/json", consumes="application/json")
	public Proprietaire updateProprietaire(@RequestBody Proprietaire prop){
		return propService.updateProprietaire(prop);
	}
	
	@RequestMapping(value="/prop", method=RequestMethod.DELETE)
	public void deleteProprietaire(@RequestParam("pId") int id){
		propService.deleteProprietaire(id);
	}
}
