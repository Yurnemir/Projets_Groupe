package fr.adaming.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import fr.adaming.enums.EtatBienAchat;
import fr.adaming.enums.TypeBien;

@Entity
@DiscriminatorValue("ACHAT")
public class BienAchat extends BienImmobilier {
	private static final long serialVersionUID = 1L;
	
	//====================== Attributs ======================
	@Column(name="prixVente_b")
	private double prixVente;
	@Column(name="etatBien_b")
	private EtatBienAchat etatBien;
	
	//====================== Constructeurs ======================
	public BienAchat() {
		super();
	}
	public BienAchat(boolean disponible, Date dateSoumission, Date dateDispo,
			TypeBien typeBien, byte[] image, String description,
			double superficie, double longitude, double latitude,
			double prixVente, EtatBienAchat etatBien) {
		super(disponible, dateSoumission, dateDispo, typeBien, image,
				description, superficie, longitude, latitude);
		this.prixVente = prixVente;
		this.etatBien = etatBien;
	}
	public BienAchat(int id, boolean disponible, Date dateSoumission,
			Date dateDispo, TypeBien typeBien, byte[] image,
			String description, double superficie, double longitude,
			double latitude, double prixVente, EtatBienAchat etatBien) {
		super(id, disponible, dateSoumission, dateDispo, typeBien, image,
				description, superficie, longitude, latitude);
		this.prixVente = prixVente;
		this.etatBien = etatBien;
	}

	//====================== Getters / Setters ======================
	public double getPrixVente() {
		return prixVente;
	}
	public void setPrixVente(double prixVente) {
		this.prixVente = prixVente;
	}
	public EtatBienAchat getEtatBien() {
		return etatBien;
	}
	public void setEtatBien(EtatBienAchat etatBien) {
		this.etatBien = etatBien;
	}

	//====================== Methodes ======================
	@Override
	public String toString() {
		return "BienAchat [prixVente=" + prixVente + ", etatBien=" + etatBien
				+ ", id=" + id + ", disponible=" + disponible
				+ ", dateSoumission=" + dateSoumission + ", dateDispo="
				+ dateDispo + ", typeBien=" + typeBien + "]";
	}
}
