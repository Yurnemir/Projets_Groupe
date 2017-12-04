package fr.adaming.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import fr.adaming.enums.TypeBien;

@Entity
@Table(name="biens")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="typeAction_b")
public abstract class BienImmobilier implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//====================== Attributs ======================
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_b")
	protected int id;
	@Column(name="disponible_b")
	protected boolean disponible;
	@Column(name="date_soumission_b")
	@Temporal(TemporalType.DATE)
	protected Date dateSoumission;
	@Column(name="date_dispo_b")
	@Temporal(TemporalType.DATE)
	protected Date dateDispo;
	@Column(name="typeBien_b")
	protected TypeBien typeBien;
	@Column(name="image_b")
	protected byte[] image;
	@Column(name="description_b")
	protected String description;
	@Column(name="superficie_b")
	protected double superficie;
	@Column(name="longitude_b")
	protected double longitude;
	@Column(name="latitude_b")
	protected double latitude;
	@Embedded
	protected Adresse adresse;
	@ManyToOne
	@JoinColumn(name="proprietaire_id", referencedColumnName="id_p")
	protected Proprietaire proprietaire;
	@JsonIgnore
	@OneToMany(mappedBy="bien")
	protected List<Visite> listeVisites;
	@JsonIgnore
	@OneToMany(mappedBy="bien")
	protected List<Contrat> listeContrats;
	
	//====================== Constructeurs ======================
	public BienImmobilier() {
		super();
	}
	public BienImmobilier(boolean disponible, Date dateSoumission,
			Date dateDispo, TypeBien typeBien, byte[] image,
			String description, double superficie, double longitude,
			double latitude) {
		super();
		this.disponible = disponible;
		this.dateSoumission = dateSoumission;
		this.dateDispo = dateDispo;
		this.typeBien = typeBien;
		this.image = image;
		this.description = description;
		this.superficie = superficie;
		this.longitude = longitude;
		this.latitude = latitude;
	}
	public BienImmobilier(int id, boolean disponible, Date dateSoumission,
			Date dateDispo, TypeBien typeBien, byte[] image,
			String description, double superficie, double longitude,
			double latitude) {
		super();
		this.id = id;
		this.disponible = disponible;
		this.dateSoumission = dateSoumission;
		this.dateDispo = dateDispo;
		this.typeBien = typeBien;
		this.image = image;
		this.description = description;
		this.superficie = superficie;
		this.longitude = longitude;
		this.latitude = latitude;
	}

	//====================== Getters / Setters ======================
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isDisponible() {
		return disponible;
	}
	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
	public Date getDateSoumission() {
		return dateSoumission;
	}
	public void setDateSoumission(Date dateSoumission) {
		this.dateSoumission = dateSoumission;
	}
	public Date getDateDispo() {
		return dateDispo;
	}
	public void setDateDispo(Date dateDispo) {
		this.dateDispo = dateDispo;
	}
	public TypeBien getTypeBien() {
		return typeBien;
	}
	public void setTypeBien(TypeBien typeBien) {
		this.typeBien = typeBien;
	}

	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getSuperficie() {
		return superficie;
	}
	public void setSuperficie(double superficie) {
		this.superficie = superficie;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public Adresse getAdresse() {
		return adresse;
	}
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	public Proprietaire getProprietaire() {
		return proprietaire;
	}
	public void setProprietaire(Proprietaire proprietaire) {
		this.proprietaire = proprietaire;
	}
	public List<Visite> getListeVisites() {
		return listeVisites;
	}
	public void setListeVisites(List<Visite> listeVisites) {
		this.listeVisites = listeVisites;
	}
	public List<Contrat> getListeContrats() {
		return listeContrats;
	}
	public void setListeContrats(List<Contrat> listeContrats) {
		this.listeContrats = listeContrats;
	}
	
	//====================== Methodes ======================
	@Override
	public String toString() {
		return "BienImmobilier [id=" + id + ", disponible=" + disponible
				+ ", dateSoumission=" + dateSoumission + ", dateDispo="
				+ dateDispo + ", typeBien=" + typeBien + "]";
	}
}
