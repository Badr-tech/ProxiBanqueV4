package ma.jit.entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author AMERMOUCH Hind
 *   ELHARIRI Yassine
 *   ELKACHAF Mustapha
 *
 */
/**
 * Declaration de classe CompteAgence comme un Entity Bean
 *
 */
@Entity
public class CompteAgence {

	/**
	 * Declaration des attributs
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDate DateOuverture;
	private double solde;
	/**
	 * Declaration de la relation entre l'entité compteAgence et agence
	 */
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonIgnore
	private Agence agence;

	/**
	 * Getters Setters
	 */
	public Agence getAgence() {
		return agence;
	}

	public void setAgence(Agence agence) {
		this.agence = agence;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDateOuverture() {
		return DateOuverture;
	}

	public void setDateOuverture(LocalDate dateOuverture) {
		DateOuverture = dateOuverture;
	}

	public double getMontant() {
		return solde;
	}

	public void setMontant(double montant) {
		this.solde = montant;
	}

	public CompteAgence() {
		super();
	}

}
