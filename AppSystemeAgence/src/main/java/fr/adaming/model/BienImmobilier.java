package fr.adaming.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import fr.adaming.enums.TypeBien;

@Entity
@Table(name="biens")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
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
	
	//====================== Constructeurs ======================
	public BienImmobilier() {
		super();
	}
	public BienImmobilier(boolean disponible, Date dateSoumission, Date dateDispo, TypeBien typeBien) {
		super();
		this.disponible = disponible;
		this.dateSoumission = dateSoumission;
		this.dateDispo = dateDispo;
		this.typeBien = typeBien;
	}
	public BienImmobilier(int id, boolean disponible, Date dateSoumission, Date dateDispo, TypeBien typeBien) {
		super();
		this.id = id;
		this.disponible = disponible;
		this.dateSoumission = dateSoumission;
		this.dateDispo = dateDispo;
		this.typeBien = typeBien;
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
	public void setTypeBien(TypeBien type) {
		this.typeBien = type;
	}
	
	//====================== Methodes ======================
	@Override
	public String toString() {
		return "BienImmobilier [id=" + id + ", disponible=" + disponible
				+ ", dateSoumission=" + dateSoumission + ", dateDispo="
				+ dateDispo + ", type=" + type + "]";
	}
}
