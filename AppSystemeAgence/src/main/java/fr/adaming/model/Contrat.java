package fr.adaming.model;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="contrats")
public class Contrat {

	//====================== Attributs ======================
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_contrat")
	private int id ; 
	
	private Date dateSignature ; 
	
	@ManyToOne
	@JoinColumn(name="client_id", referencedColumnName="id_c")
	private Client client ; 
	
	@ManyToOne
	@JoinColumn(name="bien_id", referencedColumnName="id_b")
	private BienImmobilier bien ;

	
	//====================== Constructeurs ======================
	public Contrat() {
		super();
	}

	public Contrat(Date dateSignature, Client client, BienImmobilier bien) {
		super();
		this.dateSignature = dateSignature;
		this.client = client;
		this.bien = bien;
	}

	public Contrat(int id, Date dateSignature, Client client, BienImmobilier bien) {
		super();
		this.id = id;
		this.dateSignature = dateSignature;
		this.client = client;
		this.bien = bien;
	}

	//====================== Getters / Setters ======================

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateSignature() {
		return dateSignature;
	}

	public void setDateSignature(Date dateSignature) {
		this.dateSignature = dateSignature;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public BienImmobilier getBien() {
		return bien;
	}

	public void setBien(BienImmobilier bien) {
		this.bien = bien;
	}

	//====================== Methodes ======================

	@Override
	public String toString() {
		return "Contrat [id=" + id + ", dateSignature=" + dateSignature + ", bien=" + bien + "]";
	} 
	
	
	
}
