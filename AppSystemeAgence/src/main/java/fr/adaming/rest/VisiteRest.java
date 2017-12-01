package fr.adaming.rest;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.model.BienImmobilier;
import fr.adaming.model.Client;
import fr.adaming.model.Visite;
import fr.adaming.service.IBienAchatService;
import fr.adaming.service.IBienLocationService;
import fr.adaming.service.IClientService;
import fr.adaming.service.IVisiteService;

@RestController
public class VisiteRest {

	@Autowired
	private IVisiteService visiteService;
	
	@Autowired
	private IBienAchatService bienAchatService;

	@Autowired
	private IBienLocationService bienLocationService;
	
	@Autowired
	private IClientService clientService;
	
	@RequestMapping(value="/listeVisites", method=RequestMethod.GET, produces="application/json")
	public List<Visite> getAllVisite(){
		return visiteService.getAllVisite();
	}
	
	@RequestMapping(value="/listeVisitesByClient", method=RequestMethod.GET, produces="application/json")
	public List<Visite> getAllVisitesByClient( @RequestParam("idClient") int idClient){
		Client inClient = new Client();
		inClient.setId(idClient);
		inClient = clientService.getClientById(inClient);
		return visiteService.getAllVisitesByClient(inClient);
	}
	
	@RequestMapping(value="/visite", method=RequestMethod.GET, produces="application/json")
	public Visite getVisiteById(@RequestParam("pId") int id){
		return visiteService.getVisiteById(id);
	}
	
	@RequestMapping(value="/visite", method=RequestMethod.POST, produces="application/json", consumes="application/json")
	public Visite addVisite(@RequestBody Visite visite, @RequestParam("pIdcl") int idcl, @RequestParam("pIdb") int idb){
		
		BienImmobilier bienAchat = bienAchatService.getBienAchatById(idb);
		if(bienAchat.getId()!=0){
			visite.setBien(bienAchat);
		}else{
			BienImmobilier bienLocation = bienLocationService.getBienLocationById(idb);
			visite.setBien(bienLocation);
		}
		
		Client client = new Client();
		client.setId(idcl);
		
		client = clientService.getClientById(client);
		visite.setClient(client);
		
		return visiteService.addVisite(visite);
	}
	
	@RequestMapping(value="/visite", method=RequestMethod.PUT, produces="application/json", consumes="application/json")
	public Visite visiteUpdate(@RequestBody Visite visite, @RequestParam("pIdcl") int idcl, @RequestParam("pIdb") int idb){
		
		BienImmobilier bienAchat = bienAchatService.getBienAchatById(idb);
		if(bienAchat.getId()!=0){
			visite.setBien(bienAchat);
		}else{
			BienImmobilier bienLocation = bienLocationService.getBienLocationById(idb);
			visite.setBien(bienLocation);
		}
		
		Client client = new Client();
		client.setId(idcl);
		
		client = clientService.getClientById(client);
		visite.setClient(client);
		
		return visiteService.updateVisite(visite);
	}
	
	@RequestMapping(value="/visite", method=RequestMethod.DELETE)
	public void deleteVisite(@RequestParam("pId") int id){
		visiteService.deleteVisite(id);
	}
}
