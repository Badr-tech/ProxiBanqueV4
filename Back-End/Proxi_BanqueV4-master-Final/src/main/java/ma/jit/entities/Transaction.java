package ma.jit.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * 
 * @author AMERMOUCH Hind
 *   ELHARIRI Yassine
 *   ELKACHAF Mustapha
 *
 */

/**
 * Declaration de la classe Transaction comme un Entity Bean
 * 
 *
 */

@Entity
public class Transaction {

	/**
	 * Declaration des attributs
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date date;
	private String operation;
	private double montant;
	/**
	 * Declaration de la relation entre Entity Compte et Entity Transaction
	 */
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Compte compte;

	/**
	 * Getters Setters
	 */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	/**
	 * Constructeur avec 4 parametres
	 * 
	 * @param id
	 * @param date
	 * @param operation
	 * @param montant
	 */
	public Transaction(Long id, Date date, String operation, double montant) {
		super();
		this.id = id;
		this.date = date;
		this.operation = operation;
		this.montant = montant;
	}

	/**
	 * Constructeur avec 3 parametres
	 * 
	 * @param date
	 * @param operation
	 * @param montant
	 */
	public Transaction(Date date, String operation, double montant) {
		super();
		this.date = date;
		this.operation = operation;
		this.montant = montant;
	}

	/**
	 * Constructeur sans parametres
	 */
	public Transaction() {
		super();
	}

}
