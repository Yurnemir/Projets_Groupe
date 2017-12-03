package fr.adaming.dao;

import java.util.Date;
import java.util.List;

import fr.adaming.model.Client;
import fr.adaming.model.Visite;

public interface IVisiteDao {

	public List<Visite> getAllVisite();
	public Visite getVisiteById(int id);
	public Visite addVisite(Visite visite);
	public Visite updateVisite(Visite visite);
	public void deleteVisite(int id);
	public List<Visite> getAllVisitesByClient(Client inClient);
	public List<Visite> getListNextVisites(Date today);
}
