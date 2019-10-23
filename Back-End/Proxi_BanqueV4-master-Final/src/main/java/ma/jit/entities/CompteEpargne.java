package ma.jit.entities;

import javax.persistence.Entity;

/**
 * @author AMERMOUCH Hind
 *   ELHARIRI Yassine
 *   ELKACHAF Mustapha
 *
 */

/**
 * Declaration de classe CompteEpargne comme un Entity Bean Declaration de
 * classe CompteEpargne comme classe fille de la classe Compte
 *
 */

@Entity
public class CompteEpargne extends Compte {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructeur sans parametres
	 */
	public CompteEpargne() {
		super();
		// TODO Auto-generated constructor stub
	}

}
