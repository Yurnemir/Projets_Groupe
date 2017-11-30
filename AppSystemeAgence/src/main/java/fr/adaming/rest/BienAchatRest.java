package fr.adaming.rest;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.enums.EtatBienAchat;
import fr.adaming.enums.TypeBien;
import fr.adaming.model.BienAchat;
import fr.adaming.service.IBienAchatService;

@RestController
public class BienAchatRest {
	@Autowired
	private IBienAchatService bienAchatService;

	public void setBienAchatService(IBienAchatService bienAchatService) {
		this.bienAchatService = bienAchatService;
	}

	
	@RequestMapping(value="/bien/achat/liste", method=RequestMethod.GET, produces="application/json")
	public List<BienAchat> getAllBiensAchat() {
		return this.bienAchatService.getAllBiensAchat();
	}
	
	@RequestMapping(value="/bien/achat", method=RequestMethod.GET, produces="application/json")
	public BienAchat getBienAchatById(@RequestParam("pId") int id) {
		return this.bienAchatService.getBienAchatById(id);
	}
	
	@RequestMapping(value="/bien/achat", method=RequestMethod.POST, produces="application/json", consumes="application/json")
	public BienAchat addBienAchat(@RequestBody BienAchat bienAchat) {
		return this.bienAchatService.addBienAchat(bienAchat);
	}
//	@RequestMapping(value="/bien/achat", method=RequestMethod.POST, produces="application/json")
//	public BienAchat addBienAchat() {
//		return this.bienAchatService.addBienAchat(new BienAchat(false, new Date(), new Date(), TypeBien.BUREAU, 2000, EtatBienAchat.CORRECT));
//	}
	
	@RequestMapping(value="/bien/achat", method=RequestMethod.PUT, produces="application/json", consumes="application/json")
	public BienAchat updateBienAchat(@RequestBody BienAchat bienAchat) {
		return this.bienAchatService.updateBienAchat(bienAchat);
	}
	
	@RequestMapping(value="/bien/achat", method=RequestMethod.DELETE)
	public void deleteBienAchat(@RequestParam("pId") int id) {
		this.bienAchatService.deleteBienAchat(id);
	}
}
