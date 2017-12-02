package fr.adaming.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IBienAchatDao;
import fr.adaming.model.BienAchat;
import fr.adaming.model.Client;
import fr.adaming.model.Criteres;

@Service
@Transactional
public class BienAchatServiceImpl implements IBienAchatService {
	@Autowired
	private IBienAchatDao bienAchatDao;
	
	public void setBienAchatDao(IBienAchatDao bienAchatDao) {
		this.bienAchatDao = bienAchatDao;
	}
	

	@Override
	public List<BienAchat> getAllBiensAchat() {
		return bienAchatDao.getAllBiensAchat();
	}

	@Override
	public BienAchat getBienAchatById(int id) {
		return bienAchatDao.getBienAchatById(id);
	}

	@Override
	public BienAchat addBienAchat(BienAchat bienAchat) {
		return bienAchatDao.addBienAchat(bienAchat);
	}

	@Override
	public BienAchat updateBienAchat(BienAchat bienAchat) {
		return bienAchatDao.updateBienAchat(bienAchat);
	}

	@Override
	public void deleteBienAchat(int id) {
		bienAchatDao.deleteBienAchat(id);
	}
	
	@Override
	public List<BienAchat> listeBienInteressant(Client client) {
		boolean location;
		Criteres critere = client.getCriteres();
		System.out.println(critere);
		if(critere.getPrixMax()==0){
			// Sprix max achat = 0 alors le client veut une location
			location =true;
		}else{
			location=false;
		}
		System.out.println(location);
		// On test le critere achat location
		// Si le client cherche une location alors il n'y a aucune raison de continuer. On renvoit donc null.
		if(location==true){
			return null;
		}else {
			List<BienAchat> listeBienInterressant = new ArrayList<>();
			List<BienAchat> listeBienAchat = bienAchatDao.getAllBiensAchat();
			for(BienAchat bien : listeBienAchat){
				if(bien.getPrixVente()<=critere.getPrixMax()&&bien.getSuperficie()>critere.getSurfaceMin()&&bien.getSuperficie()<=critere.getSurfaceMax()&&bien.getAdresse().getVille().equals(critere.getVille())){
					listeBienInterressant.add(bien);
				}
			}
			return listeBienInterressant;
			
		}
		
		
	}
}
