package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import fr.adaming.dao.IProprietaireDao;
import fr.adaming.model.Proprietaire;

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
	public Proprietaire getProprietaireById(Proprietaire prop) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Proprietaire addProprietaire(Proprietaire prop) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Proprietaire updateProprietaire(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteProprietaire(int id) {
		// TODO Auto-generated method stub
		
	}

	
}
