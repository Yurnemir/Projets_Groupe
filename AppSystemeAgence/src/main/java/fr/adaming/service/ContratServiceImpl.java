package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IContratDao;
import fr.adaming.model.Contrat;


@Service
@Transactional
public class ContratServiceImpl implements IContratService{

	@Autowired
	private IContratDao contratDao ; 
	
	@Override
	public List<Contrat> getAllContrats() {
		return contratDao.getAllContrats();
	}

	@Override
	public Contrat addContrat(Contrat c) {
		return contratDao.addContrat(c);
	}

	@Override
	public Contrat getContratById(int id) {	
		return contratDao.getContratById(id);
	}

	
	
}
