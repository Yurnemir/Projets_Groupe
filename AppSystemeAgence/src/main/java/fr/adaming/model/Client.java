package fr.adaming.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="clients")
public class Client {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_c")
	private int id;
	private String nom;
	private String telephone;
	
	@OneToOne
	private Adresse adresse;
	
//	@OneToMany(mappedBy="client")
//	private List<Visite> listeVisites;
	
	@OneToMany(mappedBy="client")
	private List<Contrat> listeContrats;
	
	@ManyToOne
	@JoinColumn(name="agent_id",referencedColumnName="id_a")
	private Agent agent;

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

//	public List<Visite> getListeVisites() {
//		return listeVisites;
//	}
//
//	public void setListeVisites(List<Visite> listeVisites) {
//		this.listeVisites = listeVisites;
//	}
//
//	public List<Contrat> getListeContrats() {
//		return listeContrats;
//	}
//
//	public void setListeContrats(List<Contrat> listeContrats) {
//		this.listeContrats = listeContrats;
//	}

	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}
	
	
	
}
