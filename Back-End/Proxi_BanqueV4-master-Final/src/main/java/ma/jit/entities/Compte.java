package ma.jit.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author AMERMOUCH Hind
 *   ELHARIRI Yassine
 *   ELKACHAF Mustapha
 *
 */
/**
 * Declaration de la classe Compte comme classe mère Declaration de classe
 * Compte comme un Entity Bean
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)

public class Compte implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Declaration des attributs
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long numeroCompte;
	private double solde;
	private double decouvert;

	/**
	 * Declaration de la relation entre l'entité compte et l'entité client
	 */
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonIgnore
	private Client client;

	/**
	 * Declaration de la relation entre l'entité compte et l'entité transaction
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Transaction> listTransaction = new ArrayList<>();

	/**
	 * Getters and Setters
	 * 
	 * 
	 */
	public long getNumeroCompte() {
		return numeroCompte;
	}

	public void setNumeroCompte(int numeroCompte) {
		this.numeroCompte = numeroCompte;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<Transaction> getListTransaction() {
		return listTransaction;
	}

	public void setListTransaction(List<Transaction> listTransaction) {
		this.listTransaction = listTransaction;
	}

	public double getDecouvert() {
		return decouvert;
	}

	public void setDecouvert(double decouvert) {
		this.decouvert = decouvert;
	}

	/**
	 * Constructeur avec 4 parametres
	 * 
	 * @param numeroCompte
	 * @param solde
	 * @param decouvert
	 * @param client
	 */
	public Compte(int numeroCompte, double solde, double decouvert, Client client) {
		super();
		this.numeroCompte = numeroCompte;
		this.solde = solde;
		this.decouvert = decouvert;
		this.client = client;

	}

	/**
	 * Constructeur avec 2 parametres
	 * 
	 * @param solde
	 * @param client
	 */
	public Compte(double solde, Client client) {
		super();
		this.solde = solde;
		this.client = client;
	}

	/**
	 * Constructeur sans parametres
	 */
	public Compte() {
		super();
	}

}
