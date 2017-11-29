package fr.adaming.service;

import java.util.List;

import fr.adaming.model.BienAchat;

public interface IBienAchatService {
	public List<BienAchat> getAllBiensAchat();
	public BienAchat getBienAchatById(int id);
	public BienAchat addBienAchat(BienAchat bienAchat);
	public BienAchat updateBienAchat(BienAchat bienAchat);
	public void deleteBienAchat(int id);
}
