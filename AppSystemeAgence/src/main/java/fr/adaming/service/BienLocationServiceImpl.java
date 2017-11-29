package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IBienLocationDao;
import fr.adaming.model.BienLocation;

@Service
@Transactional
public class BienLocationServiceImpl implements IBienLocationService {
	@Autowired
	private IBienLocationDao bienLocationDao;

	public void setBienLocationDao(IBienLocationDao bienLocationDao) {
		this.bienLocationDao = bienLocationDao;
	}
	

	@Override
	public List<BienLocation> getAllBiensLocation() {
		return bienLocationDao.getAllBiensLocation();
	}

	@Override
	public BienLocation getBienLocationById(int id) {
		return bienLocationDao.getBienLocationById(id);
	}

	@Override
	public BienLocation addBienLocation(BienLocation bienLocation) {
		return bienLocationDao.addBienLocation(bienLocation);
	}

	@Override
	public BienLocation updateBienLocation(BienLocation bienLocation) {
		return bienLocationDao.updateBienLocation(bienLocation);
	}

	@Override
	public void deleteBienLocation(int id) {
		bienLocationDao.getBienLocationById(id);
	}
}
