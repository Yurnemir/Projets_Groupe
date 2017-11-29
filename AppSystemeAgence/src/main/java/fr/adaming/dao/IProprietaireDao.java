package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Proprietaire;

public interface IProprietaireDao {

	public List<Proprietaire> getAllProprietaires();
	public Proprietaire getProprietaireById(int id);
	public Proprietaire addProprietaire(Proprietaire prop);
	public Proprietaire updateProprietaire(Proprietaire prop);
	public void deleteProprietaire(int id);

}
