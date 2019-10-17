package ma.jit.entities;

import javax.persistence.Entity;

@Entity
public class CompteCourant extends Compte {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CompteCourant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CompteCourant(double solde, Client client) {
		super(solde, client);
		// TODO Auto-generated constructor stub
	}

}
