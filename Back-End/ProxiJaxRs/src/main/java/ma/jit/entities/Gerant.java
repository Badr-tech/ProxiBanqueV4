package ma.jit.entities;

import javax.persistence.Entity;


@Entity
public class Gerant extends Users {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Gerant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Gerant(String nom, String prenom, String login, String password, String adresse, String email) {
		super(nom, prenom, login, password, adresse, email);
		// TODO Auto-generated constructor stub
	}

	

}
