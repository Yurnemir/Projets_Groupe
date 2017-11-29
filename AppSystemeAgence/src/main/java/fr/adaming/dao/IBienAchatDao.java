package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.BienAchat;

public interface IBienAchatDao {
	public List<BienAchat> getAllBiensAchat();
	public BienAchat getBienAchatById(int id);
	public BienAchat addBienAchat(BienAchat bienAchat);
	public BienAchat updateBienAchat(BienAchat bienAchat);
	public void deleteBienAchat(int id);
}
