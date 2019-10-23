package ma.jit.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

/**
 * 
 * @author AMERMOUCH Hind
 *   ELHARIRI Yassine
 *   ELKACHAF Mustapha
 *
 */

/**
 * Declaration de la classe Conseiller comme un Entity Bean Declaration de
 * classe Conseiller comme classe fille de la classe Users
 *
 */
@Entity

public class Conseiller extends Users {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Declaration de la relation entre Entity Conseiller et Entity Client
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Client> listeClient = new ArrayList<Client>();

	/**
	 * Getters Setters
	 */
	public List<Client> getListeClient() {
		return listeClient;
	}

	public void setListeClient(List<Client> listeClient) {
		this.listeClient = listeClient;
	}

	/**
	 * Constructeur sans parametres
	 */
	public Conseiller() {
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
	public Conseiller(String nom, String prenom, String login, String password, String adresse, String email) {
		super(nom, prenom, login, password, adresse, email);
		// TODO Auto-generated constructor stub
	}

}
