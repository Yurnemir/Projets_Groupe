package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IVisiteDao;
import fr.adaming.model.Visite;

@Service
@Transactional
public class VisiteServiceImpl implements IVisiteService{

	@Autowired
	private IVisiteDao visiteDao;
	
	public void setVisiteDao(IVisiteDao visiteDao) {
		this.visiteDao = visiteDao;
	}

	@Override
	public List<Visite> getAllVisite() {
		return visiteDao.getAllVisite();
	}

	@Override
	public Visite getVisiteById(int id) {
		Visite visiteGet = visiteDao.getVisiteById(id);
		
		if(visiteGet!=null){
			return visiteGet;
		}else{
			return null;
		}
	}

	@Override
	public Visite addVisite(Visite visite) {
		return visiteDao.addVisite(visite);
	}

	@Override
	public Visite updateVisite(Visite visite) {
		return visiteDao.updateVisite(visite);
	}

	@Override
	public void deleteVisite(int id) {
		visiteDao.deleteVisite(id);
	}

}
