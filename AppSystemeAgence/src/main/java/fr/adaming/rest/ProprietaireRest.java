package fr.adaming.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
}
