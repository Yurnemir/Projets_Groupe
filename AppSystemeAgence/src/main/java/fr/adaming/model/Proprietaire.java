package fr.adaming.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "proprietaires")
public class Proprietaire implements Serializable{
	private static final long serialVersionUID = 1L;

	//====================== Attributs ======================
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_p")
	private int id;
	@Column(name="nom_p")
	private String nom;
	@Column(name="telPrive_p")
	private String telPrive;
	@Column(name="telTravail_p")
	private String telTravail;

	@Embedded
	private Adresse adresse;
	@JsonIgnore
	@OneToMany(mappedBy="proprietaire")
	private List<BienImmobilier> listeBiens;

	//====================== Constructeurs ======================
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

	//====================== Getters / Setters ======================
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
	public Adresse getAdresse() {
		return adresse;
	}
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	public List<BienImmobilier> getListeBiens() {
		return listeBiens;
	}
	public void setListeBiens(List<BienImmobilier> listeBiens) {
		this.listeBiens = listeBiens;
	}

	//====================== Methodes ======================
	@Override
	public String toString() {
		return "Proprietaire [id=" + id + ", nom=" + nom + ", telPrive=" + telPrive + ", telTravail=" + telTravail
				+ "]";
	}
}
