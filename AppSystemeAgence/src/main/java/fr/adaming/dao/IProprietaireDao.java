package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Proprietaire;

public interface IProprietaireDao {

	public List<Proprietaire> getAllProprietaires();
	public Proprietaire getProprietaireById(Proprietaire prop);
	public Proprietaire addProprietaire(Proprietaire prop);
	public Proprietaire updateProprietaire(int id);
	public void deleteProprietaire(int id);

}
