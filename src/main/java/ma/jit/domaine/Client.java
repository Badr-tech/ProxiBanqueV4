package ma.jit.domaine;

import javax.persistence.Entity;

@Entity
public class Client extends Personne {

	private String email;
	private String adresse;
	

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the adresse
	 */
	public String getAdresse() {
		return adresse;
	}

	/**
	 * @param adresse the adresse to set
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	/**
	 * 
	 */
	public Client() {
		super();
	}

	/**
	 * @param id
	 * @param nom
	 * @param prenom
	 * @param email
	 * @param adresse
	 */
	public Client(Long id, String nom, String prenom, String email, String adresse) {
		super(id, nom, prenom);
		this.email = email;
		this.adresse = adresse;
	}

}
