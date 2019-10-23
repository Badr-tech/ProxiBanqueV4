package ma.jit.entities;

import javax.persistence.Entity;

/**
 * @author AMERMOUCH Hind
 *   ELHARIRI Yassine
 *   ELKACHAF Mustapha
 *
 */
/**
 * Declaration de classe BackOffice comme un Entity Bean Declaration de la
 * classe BackOffice comme classe fille de la classe Users
 * 
 */
@Entity
public class BackOffice extends Users {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructeur sans parametres
	 */
	public BackOffice() {
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
	public BackOffice(String nom, String prenom, String login, String password, String adresse, String email) {
		super(nom, prenom, login, password, adresse, email);
		// TODO Auto-generated constructor stub
	}

}
