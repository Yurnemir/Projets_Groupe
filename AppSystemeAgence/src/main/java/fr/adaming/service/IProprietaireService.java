package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Proprietaire;

public interface IProprietaireService {

	public List<Proprietaire> getAllProprietaires();
	public Proprietaire getProprietaireById(int id);
	public Proprietaire addProprietaire(Proprietaire prop);
	public Proprietaire updateProprietaire(Proprietaire prop);
	public void deleteProprietaire(int id);

}
