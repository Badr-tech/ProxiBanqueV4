package ma.jit.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author AMERMOUCH Hind
 *   ELHARIRI Yassine
 *   ELKACHAF Mustapha
 *
 */
/**
 * Declaration de classe Client comme un Entity Bean
 *
 */
@Entity
public class Client implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * Declaration des attributs
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String prenom;
	private String email;
	private String adresse;

	/**
	 * Declaration de la relation entre l'entité client et l'entité compte
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Compte> listeCompte = new ArrayList<Compte>();

	/**
	 * Declaration de la relation entre l'entité client et l'entité conseiller
	 */
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	private Conseiller conseiller;

	/**
	 * Constructeur avec 4 parametres
	 * 
	 * @param nom
	 * @param prenom
	 * @param email
	 * @param adresse
	 */

	public Client(String nom, String prenom, String email, String adresse) {
		super();

		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.adresse = adresse;
	}

	/**
	 * Constructeur avec 5 parametres
	 * 
	 * @param id
	 * @param nom
	 * @param prenom
	 * @param email
	 * @param adresse
	 */
	public Client(Long id, String nom, String prenom, String email, String adresse) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.adresse = adresse;
	}

	/**
	 * Constructeur sans parametres
	 * 
	 */
	public Client() {
		super();
	}

	/**
	 * Getters Setters
	 * 
	 * @return
	 */
	public Long getId() {
		return id;
	}

	public Conseiller getConseiller() {
		return conseiller;
	}

	public void setConseiller(Conseiller conseiller) {
		this.conseiller = conseiller;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public List<Compte> getListeCompte() {
		return listeCompte;
	}

	public void setListeCompte(List<Compte> listeCompte) {
		this.listeCompte = listeCompte;
	}

}
