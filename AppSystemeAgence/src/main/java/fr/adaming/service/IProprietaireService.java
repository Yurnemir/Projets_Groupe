package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Proprietaire;

public interface IProprietaireService {

	public List<Proprietaire> getAllProprietaires();
	public Proprietaire getProprietaireById(Proprietaire prop);
	public Proprietaire addProprietaire(Proprietaire prop);
	public Proprietaire updateProprietaire(int id);
	public void deleteProprietaire(int id);

}
