package fr.adaming.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.model.Visite;
import fr.adaming.service.IVisiteService;

@RestController
public class VisiteRest {

	@Autowired
	private IVisiteService visiteService;
	
	public void setVisiteService(IVisiteService visiteService) {
		this.visiteService = visiteService;
	}

	@RequestMapping(value="/listeVisites", method=RequestMethod.GET, produces="application/json")
	public List<Visite> getAllVisite(){
		return visiteService.getAllVisite();
	}
	
	@RequestMapping(value="/visite", method=RequestMethod.GET, produces="application/json")
	public Visite getVisiteById(@RequestParam("pId") int id){
		return visiteService.getVisiteById(id);
	}
	
	@RequestMapping(value="/visite", method=RequestMethod.POST, produces="application/json", consumes="application/json")
	public Visite addVisite(@RequestBody Visite visite){
		return visiteService.addVisite(visite);
	}
	
	@RequestMapping(value="/visite", method=RequestMethod.PUT, produces="application/json", consumes="application/json")
	public Visite visiteUpdate(@RequestBody Visite visite){
		return visiteService.updateVisite(visite);
	}
	
	@RequestMapping(value="/visite", method=RequestMethod.DELETE, produces="application/json", consumes="application/json")
	public void deleteVisite(@RequestParam("pId") int id){
		visiteService.deleteVisite(id);
	}
}
