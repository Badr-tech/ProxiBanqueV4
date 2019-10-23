package ma.jit.entities;

import javax.persistence.Entity;

/**
 * 
 * @author AMERMOUCH Hind
 *   ELHARIRI Yassine
 *   ELKACHAF Mustapha
 *
 */

/**
 * Declaration de la classe Gerant comme un Entity Bean Declaration de classe
 * Gerant comme classe fille de la classe Users
 *
 */
@Entity
public class Gerant extends Users {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructeur sans parametres
	 */
	public Gerant() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructeur avec parametres
	 * 
	 * @param nom
	 * @param prenom
	 * @param login
	 * @param password
	 * @param adresse
	 * @param email
	 */
	public Gerant(String nom, String prenom, String login, String password, String adresse, String email) {
		super(nom, prenom, login, password, adresse, email);
		// TODO Auto-generated constructor stub
	}

}
