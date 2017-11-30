package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IBienAchatDao;
import fr.adaming.dao.IBienLocationDao;
import fr.adaming.dao.IClientDao;
import fr.adaming.dao.IContratDao;
import fr.adaming.model.BienImmobilier;
import fr.adaming.model.Client;
import fr.adaming.model.Contrat;


@Service
@Transactional
public class ContratServiceImpl implements IContratService{

	@Autowired
	private IContratDao contratDao ; 
	
	@Autowired
	private IBienAchatDao bienAchatDao ; 
	
	@Autowired
	private IBienLocationDao bienLocDao ; 
	
	@Autowired
	private IClientDao clientDao ; 
	
	public void setContratDao(IContratDao contratDao) {
		this.contratDao = contratDao;
	}

	public void setBienAchatDao(IBienAchatDao bienAchatDao) {
		this.bienAchatDao = bienAchatDao;
	}

	public void setBienLocDao(IBienLocationDao bienLocDao) {
		this.bienLocDao = bienLocDao;
	}

	
	
	public void setClientDao(IClientDao clientDao) {
		this.clientDao = clientDao;
	}

	@Override
	public List<Contrat> getAllContrats() {
		return contratDao.getAllContrats();
	}

	@Override
	public Contrat addContrat(Contrat c, int idCl, int idB) {
		BienImmobilier b = bienAchatDao.getBienAchatById(idB) ; 
		
		if (b==null){
			b = bienLocDao.getBienLocationById(idB); 
		}
		
		Client ClTemp = new Client() ; 
		ClTemp.setId(idCl);
		
		Client cl = clientDao.getClientById(ClTemp) ;
		
		c.setBien(b);
		c.setClient(cl);
		return contratDao.addContrat(c);
	}

	@Override
	public Contrat getContratById(int id) {	
		return contratDao.getContratById(id);
	}

	
	
}
