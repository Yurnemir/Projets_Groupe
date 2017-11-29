package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Visite;

public interface IVisiteService {

	public List<Visite> getAllVisite();
	public Visite getVisiteById(int id);
	public Visite addVisite(Visite visite);
	public Visite updateVisite(Visite visite);
	public void deleteVisite(int id);
}
