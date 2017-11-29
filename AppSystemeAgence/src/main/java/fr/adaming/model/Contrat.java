package fr.adaming.model;

import java.io.Serializable;
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
public class Contrat implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//====================== Attributs ======================
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_co")
	private int id;
	@Column(name="dateSignature_co")
	private Date dateSignature; 
//	@ManyToOne
//	@JoinColumn(name="id_cl", referencedColumnName="id_cl")
//	private Client client ;
//	@ManyToOne
//	@JoinColumn(name="id_b", referencedColumnName="id_b")
//	private BienImmobilier bien;
	
	//====================== Constructeurs ======================
	public Contrat() {
		super();
	}
	public Contrat(Date dateSignature) {
		super();
		this.dateSignature = dateSignature;
	}
	public Contrat(int id, Date dateSignature) {
		super();
		this.id = id;
		this.dateSignature = dateSignature;
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
//	public Client getClient() {
//		return client;
//	}
//	public void setClient(Client client) {
//		this.client = client;
//	}
//	public BienImmobilier getBien() {
//		return bien;
//	}
//	public void setBien(BienImmobilier bien) {
//		this.bien = bien;
//	}

	//====================== Methodes ======================
	@Override
	public String toString() {
		return "Contrat [id=" + id + ", dateSignature=" + dateSignature + "]";
	}
}
