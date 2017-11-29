package fr.adaming.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="adresses")
public class Adresse implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_ad")
	private int id;
	private int numero;
	private String rue;
	private String cp;
	private String ville;
//	@OneToOne()
//	@JoinColumn(name="prop_id", referencedColumnName="id_p")
//	private Proprietaire adresseProp;
//	private BienImmobilier adresseBien;

	public Adresse() {
		super();
	}
	public Adresse(int numero, String rue, String cp, String ville) {
		super();
		this.numero = numero;
		this.rue = rue;
		this.cp = cp;
		this.ville = ville;
	}
	public Adresse(int id, int numero, String rue, String cp, String ville) {
		super();
		this.id = id;
		this.numero = numero;
		this.rue = rue;
		this.cp = cp;
		this.ville = ville;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	public String getCp() {
		return cp;
	}
	public void setCp(String cp) {
		this.cp = cp;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
//	public BienImmobilier getAdresseBien() {
//		return adresseBien;
//	}
//	public void setAdresseBien(BienImmobilier adresseBien) {
//		this.adresseBien = adresseBien;
//	}

	@Override
	public String toString() {
		return "Adresse [id=" + id + ", numero=" + numero + ", rue=" + rue + ", cp=" + cp + ", ville=" + ville + "]";
	}
}
