package fr.adaming.service;

import java.util.List;

import fr.adaming.model.BienLocation;
import fr.adaming.model.Client;

public interface IBienLocationService {
	public List<BienLocation> getAllBiensLocation();
	public BienLocation getBienLocationById(int id);
	public BienLocation addBienLocation(BienLocation bienLocation);
	public BienLocation updateBienLocation(BienLocation bienLocation);
	public void deleteBienLocation(int id);
	public List<BienLocation> trierLocationParClient(Client client);
}
