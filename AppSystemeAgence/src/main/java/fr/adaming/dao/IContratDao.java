package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Contrat;

public interface IContratDao {

	public List<Contrat> getAllContrats(); 
	public Contrat addContrat(Contrat c) ; 
	public Contrat getContratById(int id) ; 

}
