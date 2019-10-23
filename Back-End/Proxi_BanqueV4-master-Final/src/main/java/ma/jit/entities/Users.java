package ma.jit.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

/**
 * @author AMERMOUCH Hind
 *   ELHARIRI Yassine
 *   ELKACHAF Mustapha
 *
 */
/**
 * Declaration de la classe Users comme classe mère Declaration de classe Users
 * comme un Entity Bean
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)

public class Users implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Declaration des attributs
	 */
	/**
	 * Declaration des attributs
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String prenom;
	private String login;
	private String password;
	private String adresse;
	private String email;
	/**
	 * Declaration de la relation entre Entity Role et Entity Users
	 */
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	Role role;

	/**
	 * Getters Setters
	 * 
	 */
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Constructeur avec 6 parametres
	 * 
	 * @param nom
	 * @param prenom
	 * @param login
	 * @param password
	 * @param adresse
	 * @param email
	 */
	public Users(String nom, String prenom, String login, String password, String adresse, String email) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.password = password;
		this.adresse = adresse;
		this.email = email;
	}

	/**
	 * Constructeur avec parametres
	 * 
	 * @param nom
	 * @param prenom
	 * @param login
	 * @param adresse
	 * @param email
	 * @param role
	 */
	public Users(String nom, String prenom, String login, String adresse, String email, Role role) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.adresse = adresse;
		this.email = email;
		this.role = role;
	}

	/**
	 * Constructeur sans parametres
	 * 
	 */
	public Users() {
		super();
	}

}
