package fr.adaming.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="agents")
public class Agent implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//====================== Attributs ======================
	@Id
	@Column(name="id_ag")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="identifiant_ag")
	private String identifiant;
	@Column(name="mdp_ag")
	private String mdp;
	@JsonIgnore
	@OneToMany(mappedBy="agent")
	private List<Client> listeClients;

	//====================== Constructeurs ======================
	public Agent() {
		super();
	}
	public Agent(String identifiant, String mdp) {
		super();
		this.identifiant = identifiant;
		this.mdp = mdp;
	}
	public Agent(int id, String identifiant, String mdp) {
		super();
		this.id = id;
		this.identifiant = identifiant;
		this.mdp = mdp;
	}

	//====================== Getters / Setters ======================
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIdentifiant() {
		return identifiant;
	}
	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	public List<Client> getListeClients() {
		return listeClients;
	}
	public void setListeClients(List<Client> listeClients) {
		this.listeClients = listeClients;
	}
	
	//====================== Methodes ======================
	@Override
	public String toString() {
		return "Agent [id=" + id + ", identifiant=" + identifiant + ", mdp="
				+ mdp + "]";
	}
}
