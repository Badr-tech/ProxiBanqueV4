package ma.jit.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * 
 * @author AMERMOUCH Hind
 *   ELHARIRI Yassine
 *   ELKACHAF Mustapha
 *
 */

/**
 * Declaration de la classe Role comme un Entity Bean
 *
 *
 */
@Entity
public class Role {
	/**
	 * Declaration des attributs
	 */
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	private String role;
	/**
	 * Declaration de la relation entre Entity Role et Entity Users
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Users> listeUser = new HashSet<Users>();

	/**
	 * Getters Setters
	 */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Set<Users> getListeUser() {
		return listeUser;
	}

	public void setListeUser(Set<Users> listeUser) {
		this.listeUser = listeUser;
	}

	/**
	 * Constructeur avec 2 parametres
	 * 
	 * @param id
	 * @param role
	 */
	public Role(Long id, String role) {
		super();
		this.id = id;
		this.role = role;
	}

	/**
	 * Constructeur avec parametres
	 */
	public Role(Long id) {
		super();
		this.id = id;
	}

	/**
	 * Constructeur sans parametres
	 */
	public Role() {
		super();
	}

}
