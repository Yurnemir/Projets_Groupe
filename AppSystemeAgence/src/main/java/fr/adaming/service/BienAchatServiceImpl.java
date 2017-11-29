package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IBienAchatDao;
import fr.adaming.model.BienAchat;

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
}
