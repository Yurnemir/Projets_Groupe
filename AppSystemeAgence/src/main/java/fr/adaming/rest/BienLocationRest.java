package fr.adaming.rest;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.enums.TypeBail;
import fr.adaming.enums.TypeBien;
import fr.adaming.model.BienLocation;
import fr.adaming.service.IBienLocationService;

@RestController
public class BienLocationRest {
	@Autowired
	private IBienLocationService bienLocationService;
	
	public void setBienLocationService(IBienLocationService bienLocationService) {
		this.bienLocationService = bienLocationService;
	}
	

	@RequestMapping(value="/bien/location/liste", method=RequestMethod.GET, produces="application/json")
	public List<BienLocation> getAllBiensLocation() {
		return this.bienLocationService.getAllBiensLocation();
	}
	
	@RequestMapping(value="/bien/location", method=RequestMethod.GET, produces="application/json")
	public BienLocation getBienLocationById(@RequestParam("pId") int id) {
		return this.bienLocationService.getBienLocationById(id);
	}
	
	@RequestMapping(value="/bien/location", method=RequestMethod.POST, produces="application/json", consumes="application/json")
	public BienLocation addBienLocation(@RequestBody BienLocation bienLocation) {
		return this.bienLocationService.addBienLocation(bienLocation);
	}
//	@RequestMapping(value="/bien/location", method=RequestMethod.POST, produces="application/json")
//	public BienLocation addBienLocation() {
//		return this.bienLocationService.addBienLocation(new BienLocation(false, new Date(), new Date(), TypeBien.APPARTEMENT, 400, 400, 400, false, TypeBail.PROFESSIONNEL));
//	}
	
	@RequestMapping(value="/bien/location", method=RequestMethod.PUT, produces="application/json", consumes="application/json")
	public BienLocation updateBienLocation(@RequestBody BienLocation bienLocation) {
		return this.bienLocationService.updateBienLocation(bienLocation);
	}
	
	@RequestMapping(value="/bien/location", method=RequestMethod.DELETE)
	public void deleteBienLocation(@RequestParam("pId") int id) {
		this.bienLocationService.deleteBienLocation(id);
	}
}
