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

@Entity
public class Role {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	private String role;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Users> listeUser = new HashSet<Users>();
	
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
	public Role(Long id, String role) {
		super();
		this.id = id;
		this.role = role;
	}
	public Role() {
		super();
	}
	public Set<Users> getListeUser() {
		return listeUser;
	}
	public void setListeUser(Set<Users> listeUser) {
		this.listeUser = listeUser;
	}
	public Role(Long id) {
		super();
		this.id = id;
	}
	
	

}
