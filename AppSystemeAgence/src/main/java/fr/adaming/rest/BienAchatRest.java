package fr.adaming.rest;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import fr.adaming.enums.EtatBienAchat;
import fr.adaming.enums.TypeBien;
import fr.adaming.model.BienAchat;
import fr.adaming.service.IBienAchatService;
import fr.adaming.service.IProprietaireService;
import fr.adaming.service.ProprietaireServiceImpl;

@RestController
public class BienAchatRest {
	@Autowired
	private IBienAchatService bienAchatService;
	@Autowired
	private IProprietaireService proprietaireService;

	public void setBienAchatService(IBienAchatService bienAchatService) {
		this.bienAchatService = bienAchatService;
	}

	public void setProprietaireService(IProprietaireService proprietaireService) {
		this.proprietaireService = proprietaireService;
	}

	@RequestMapping(value = "/bien/achat/liste", method = RequestMethod.GET, produces = "application/json")
	public List<BienAchat> getAllBiensAchat() {
		return this.bienAchatService.getAllBiensAchat();
	}

	@RequestMapping(value = "/bien/achat", method = RequestMethod.GET, produces = "application/json")
	public BienAchat getBienAchatById(@RequestParam("pId") int id) {
		return this.bienAchatService.getBienAchatById(id);
	}

	@RequestMapping(value = "/bien/achat", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public BienAchat addBienAchat(@RequestBody BienAchat bienAchat, @RequestParam("pIdProp") int idProp) {
		// @RequestMapping(value="/bien/achat", method=RequestMethod.POST,
		// produces="application/json")
		// public BienAchat addBienAchat(@RequestParam("pIdProp") int idProp) {
		// BienAchat bienAchat = bienAchatService.getBienAchatById(3);
		bienAchat.setProprietaire(proprietaireService.getProprietaireById(idProp));
		return this.bienAchatService.addBienAchat(bienAchat);
	}

	// @RequestMapping(value="/bien/achat", method=RequestMethod.PUT,
	// produces="application/json", consumes="application/json")
	// public BienAchat updateBienAchat(@RequestBody BienAchat bienAchat,
	// @RequestParam("pIdProp") int idProp) {
	@RequestMapping(value = "/bien/achat", method = RequestMethod.PUT, produces = "application/json")
	public BienAchat updateBienAchat(@RequestParam("pIdProp") int idProp) {
		BienAchat bienAchat = bienAchatService.getBienAchatById(3);
		bienAchat.setProprietaire(proprietaireService.getProprietaireById(idProp));
		return this.bienAchatService.updateBienAchat(bienAchat);
	}

	@RequestMapping(value = "/bien/achat", method = RequestMethod.DELETE)
	public void deleteBienAchat(@RequestParam("pId") int id) {
		this.bienAchatService.deleteBienAchat(id);
	}

	public void addImage(@RequestParam("pImage") MultipartFile file, @RequestParam("pId") int id){
		
	}
	
//	@RequestMapping(value = "/bien/image", produces = MediaType.IMAGE_JPEG_VALUE)
//	@ResponseBody
//	public byte[] getPhoto(BienAchat bienAchat) throws IOException {
//		BienAchat bienA = bienAchatService.getBienAchatById(bienAchat.getId());
//		if (bienA.getImage() == null) {
//			return new byte[0];
//		} else {
//			return IOUtils.toByteArray(new ByteArrayInputStream(bienA.getImage()));
//		}
//	}

	
}
