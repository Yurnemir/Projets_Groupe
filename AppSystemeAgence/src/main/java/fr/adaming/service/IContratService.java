package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Contrat;

public interface IContratService {

	public List<Contrat> getAllContrats(); 
	public Contrat addContrat(Contrat c) ; 
	public Contrat getContratById(int id) ; 
	
}
