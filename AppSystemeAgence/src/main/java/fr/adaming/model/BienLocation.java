package fr.adaming.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

import fr.adaming.enums.TypeBail;
import fr.adaming.enums.TypeBien;

@Entity
@DiscriminatorValue("LOCATION")
public class BienLocation extends BienImmobilier {
	private static final long serialVersionUID = 1L;
	
	//====================== Attributs ======================
	@Column(name="loyer_b")
	private double loyer;
	@Column(name="caution_b")
	private double caution;
	@Column(name="charges_b")
	private double charges;
	@Column(name="meuble_b")
	private boolean meuble;
	@Column(name="typeBail_b")
	private TypeBail typeBail;
	
	//====================== Constructeurs ======================
	public BienLocation() {
		super();
	}
	public BienLocation(boolean disponible, Date dateSoumission,
			Date dateDispo, TypeBien typeBien, double loyer, double caution,
			double charges, boolean meuble, TypeBail typeBail) {
		super(disponible, dateSoumission, dateDispo, typeBien);
		this.loyer = loyer;
		this.caution = caution;
		this.charges = charges;
		this.meuble = meuble;
		this.typeBail = typeBail;
	}
	public BienLocation(int id, boolean disponible, Date dateSoumission,
			Date dateDispo, TypeBien typeBien, double loyer, double caution,
			double charges, boolean meuble, TypeBail typeBail) {
		super(id, disponible, dateSoumission, dateDispo, typeBien);
		this.loyer = loyer;
		this.caution = caution;
		this.charges = charges;
		this.meuble = meuble;
		this.typeBail = typeBail;
	}
	
	//====================== Getters / Setters ======================
	public double getLoyer() {
		return loyer;
	}
	public void setLoyer(double loyer) {
		this.loyer = loyer;
	}
	public double getCaution() {
		return caution;
	}
	public void setCaution(double caution) {
		this.caution = caution;
	}
	public double getCharges() {
		return charges;
	}
	public void setCharges(double charges) {
		this.charges = charges;
	}
	public TypeBail getTypeBail() {
		return typeBail;
	}
	public void setTypeBail(TypeBail typeBail) {
		this.typeBail = typeBail;
	}
	public boolean isMeuble() {
		return meuble;
	}
	public void setMeuble(boolean meuble) {
		this.meuble = meuble;
	}

	//====================== Methodes ======================
	@Override
	public String toString() {
		return "BienLocation [loyer=" + loyer + ", caution=" + caution
				+ ", charges=" + charges + ", meuble=" + meuble + ", typeBail="
				+ typeBail + ", id=" + id + ", disponible=" + disponible
				+ ", dateSoumission=" + dateSoumission + ", dateDispo="
				+ dateDispo + ", typeBien=" + typeBien + "]";
	}
}
