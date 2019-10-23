package ma.jit.entities;

import javax.persistence.Entity;

/**
 * @author AMERMOUCH Hind
 *   ELHARIRI Yassine
 *   ELKACHAF Mustapha
 *
 */
/**
 * Declaration de classe CompteCourant comme un Entity Bean Declaration de
 * classe CompteCourant comme classe fille de la classe Compte
 *
 */
@Entity
public class CompteCourant extends Compte {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructeur sans parametres
	 */
	public CompteCourant() {
		super();
		// TODO Auto-generated constructor stub
	}

}
