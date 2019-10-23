package ma.jit.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 
 * @author AMERMOUCH Hind
 *   ELHARIRI Yassine
 *   ELKACHAF Mustapha
 *
 */

/**
 * Declaration de la classe Parametrage comme un Entity Bean
 * 
 *
 */
@Entity
public class Parametrage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Declaration des attributs
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int maxConseillers;
	private int maxClients;
	private double commission;

	/**
	 * Getters Setters
	 */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getMaxCons() {
		return maxConseillers;
	}

	public void setMaxCons(int maxCons) {
		this.maxConseillers = maxCons;
	}

	public int getMaxClients() {
		return maxClients;
	}

	public void setMaxClients(int maxClients) {
		this.maxClients = maxClients;
	}

	public double getCom() {
		return commission;
	}

	public void setCom(int com) {
		this.commission = com;
	}

	/**
	 * Constructeur avec parametres
	 * 
	 * @param id
	 * @param maxCons
	 * @param maxClients
	 * @param com
	 */
	public Parametrage(Long id, int maxCons, int maxClients, double com) {
		super();
		this.id = id;
		this.maxConseillers = maxCons;
		this.maxClients = maxClients;
		this.commission = com;
	}

	/**
	 * Constructeur sans parametres
	 */
	public Parametrage() {
		super();
	}

}
