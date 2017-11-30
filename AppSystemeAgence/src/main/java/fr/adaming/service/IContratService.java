package fr.adaming.service;

import java.util.List;

import fr.adaming.model.BienImmobilier;
import fr.adaming.model.Client;
import fr.adaming.model.Contrat;

public interface IContratService {

	public List<Contrat> getAllContrats(); 
	public Contrat addContrat(Contrat c, int idCl, int idB) ; 
	public Contrat getContratById(int id) ; 
	
}
