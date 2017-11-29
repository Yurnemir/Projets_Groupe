package fr.adaming.model;



import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.http.client.ClientHttpRequest;

@Entity
@Table(name="contrats")
public class Contrat {

	//====================== Attributs ======================
	
	private int id ; 
	
	private Date dateSignature ; 
	
	private Client client ; 
	
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
