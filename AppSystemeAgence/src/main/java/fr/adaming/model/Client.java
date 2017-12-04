package fr.adaming.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import fr.adaming.enums.TypeRecherche;

@Entity
@Table(name="clients")
public class Client implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//====================== Attributs ======================
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_cl")
	private int id;
	@Column(name="nom_cl")
	private String nom;
	@Column(name="telephone_cl")
	private String telephone;

	@Embedded
	private Adresse adresse;
	
	@Embedded
	private Criteres criteres;
	
	@JsonIgnore
	@OneToMany(mappedBy="client")
	private List<Visite> listeVisites;
	@JsonIgnore
	@OneToMany(mappedBy="client")
	private List<Contrat> listeContrats;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="agent_id",referencedColumnName="id_ag")
	private Agent agent;

	//====================== Constructeurs ======================
	public Client() {
		super();
	}
	public Client(String nom, String telephone) {
		super();
		this.nom = nom;
		this.telephone = telephone;
	}
	public Client(int id, String nom, String telephone) {
		super();
		this.id = id;
		this.nom = nom;
		this.telephone = telephone;
	}

	//====================== Constructeurs ======================
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
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Adresse getAdresse() {
		return adresse;
	}
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
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
	public Agent getAgent() {
		return agent;
	}
	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	public Criteres getCriteres() {
		return criteres;
	}
	public void setCriteres(Criteres criteres) {
		this.criteres = criteres;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", telephone=" + telephone + ", adresse=" + adresse
				+ ", agent=" + agent + "]";
	}
}
