package fr.adaming.service;

import java.util.List;

import fr.adaming.model.BienAchat;
import fr.adaming.model.Client;

public interface IBienAchatService {
	public List<BienAchat> getAllBiensAchat();
	public BienAchat getBienAchatById(int id);
	public BienAchat addBienAchat(BienAchat bienAchat);
	public BienAchat updateBienAchat(BienAchat bienAchat);
	public void deleteBienAchat(int id);
	public List<BienAchat> listeBienInteressant(Client client);
}
