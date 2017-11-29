package fr.adaming.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import fr.adaming.dao.IProprietaireDao;
import fr.adaming.model.Proprietaire;

@Service
@Transactional
public class ProprietaireServiceImpl implements IProprietaireService {

	@Autowired
	private IProprietaireDao propDao;
	
	public void setPropDao(IProprietaireDao propDao) {
		this.propDao = propDao;
	}

	@Override
	public List<Proprietaire> getAllProprietaires() {
		return propDao.getAllProprietaires();
	}

	@Override
	public Proprietaire getProprietaireById(int id) {
		return propDao.getProprietaireById(id);
	}

	@Override
	public Proprietaire addProprietaire(Proprietaire prop) {
		return propDao.addProprietaire(prop);
	}

	@Override
	public Proprietaire updateProprietaire(Proprietaire prop) {
		return propDao.updateProprietaire(prop);
	}

	@Override
	public void deleteProprietaire(int id) {
		propDao.deleteProprietaire(id);
	}

	
}
