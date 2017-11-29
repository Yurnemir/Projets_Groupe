package fr.adaming.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "proprietaires")
public class Proprietaire implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_p")
	private int id;
	private String nom;
	private String telPrive;
	private String telTravail;
//	@OneToOne(mappedBy="adresseProp")
//	private Adresse adresseProprietaire;
//	@OneToMany(mappedBy="", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
//	private List<BienImmobilier> listeBiens;

	public Proprietaire() {
		super();
	}
	public Proprietaire(String nom, String telPrive, String telTravail) {
		super();
		this.nom = nom;
		this.telPrive = telPrive;
		this.telTravail = telTravail;
	}
	public Proprietaire(int id, String nom, String telPrive, String telTravail) {
		super();
		this.id = id;
		this.nom = nom;
		this.telPrive = telPrive;
		this.telTravail = telTravail;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getTelPrive() {
		return telPrive;
	}
	public void setTelPrive(String telPrive) {
		this.telPrive = telPrive;
	}
	public String getTelTravail() {
		return telTravail;
	}
	public void setTelTravail(String telTravail) {
		this.telTravail = telTravail;
	}
//	public Adresse getAdresseProprietaire() {
//		return adresseProprietaire;
//	}
//	public void setAdresseProprietaire(Adresse adresseProprietaire) {
//		this.adresseProprietaire = adresseProprietaire;
//	}
//	public List<BienImmobilier> getListeBiens() {
//		return listeBiens;
//	}
//	public void setListeBiens(List<BienImmobilier> listeBiens) {
//		this.listeBiens = listeBiens;
//	}

	@Override
	public String toString() {
		return "Proprietaire [id=" + id + ", nom=" + nom + ", telPrive=" + telPrive + ", telTravail=" + telTravail
				+ "]";
	}
}
