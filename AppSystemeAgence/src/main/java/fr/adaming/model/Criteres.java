package fr.adaming.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import fr.adaming.enums.TypeBien;
import fr.adaming.enums.TypeRecherche;

@Embeddable
public class Criteres implements Serializable {
	
	//Creation de criteres de filtrage préenregistrés par client
	private TypeRecherche recherche;
	
	private double prixMax;
	private double loyerMax;
	private double surfaceMin;
	private double surfaceMax;

	@Column(name="bien_rech")
	private TypeBien bien;
	
	@Column(name="ville_rech")
	private String ville;
	
	public Criteres() {
		super();
	}

	public Criteres(double prixMax, double loyerMax, double surfaceMin, double surfaceMax, TypeBien bien, String ville, TypeRecherche recherche) {
		super();
		this.prixMax = prixMax;
		this.loyerMax = loyerMax;
		this.surfaceMin = surfaceMin;
		this.surfaceMax = surfaceMax;
		this.bien = bien;
		this.ville = ville;
		this.recherche = recherche;
	}

	public double getPrixMax() {
		return prixMax;
	}

	public void setPrixMax(double prixMax) {
		this.prixMax = prixMax;
	}

	public double getSurfaceMin() {
		return surfaceMin;
	}

	public void setSurfaceMin(double surfaceMin) {
		this.surfaceMin = surfaceMin;
	}

	public double getSurfaceMax() {
		return surfaceMax;
	}

	public void setSurfaceMax(double surfaceMax) {
		this.surfaceMax = surfaceMax;
	}

	public TypeBien getBien() {
		return bien;
	}

	public void setBien(TypeBien bien) {
		this.bien = bien;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public double getLoyerMax() {
		return loyerMax;
	}

	public void setLoyerMax(double loyerMax) {
		this.loyerMax = loyerMax;
	}
	public TypeRecherche getRecherche() {
		return recherche;
	}
	public void setRecherche(TypeRecherche recherche) {
		this.recherche = recherche;
	}
	@Override
	public String toString() {
		return "Criteres [prixMax=" + prixMax + ", loyerMax=" + loyerMax + ", surfaceMin=" + surfaceMin
				+ ", surfaceMax=" + surfaceMax + ", bien=" + bien + ", ville=" + ville + "]";
	}

}
