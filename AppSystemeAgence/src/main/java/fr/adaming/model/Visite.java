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
@Table(name="visites")
public class Visite implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_v")
	private int id;
	
	private Date date;
	
	private Date heure;
	
	@ManyToOne
	@JoinColumn(name="bien_id", referencedColumnName="id_b")
	private BienImmobilier bien;
	
	@ManyToOne
	@JoinColumn(name="client_id", referencedColumnName="id_cl")
	private Client client;

	public Visite() {
		super();
	}

	public Visite(Date date, Date heure) {
		super();
		this.date = date;
		this.heure = heure;
	}

	public Visite(int id, Date date, Date heure) {
		super();
		this.id = id;
		this.date = date;
		this.heure = heure;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getHeure() {
		return heure;
	}

	public void setHeure(Date heure) {
		this.heure = heure;
	}

	public BienImmobilier getBien() {
		return bien;
	}

	public void setBien(BienImmobilier bien) {
		this.bien = bien;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public String toString() {
		return "Visite [id=" + id + ", date=" + date + ", heure=" + heure + "]";
	}
	
	
}
