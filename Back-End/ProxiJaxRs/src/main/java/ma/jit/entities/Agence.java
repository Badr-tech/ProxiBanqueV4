package ma.jit.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Agence {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String adresse;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<CompteAgence> listCompteAgence = new ArrayList<>();
	
	
	
	public List<CompteAgence> getListCompteAgence() {
		return listCompteAgence;
	}
	public void setListCompteAgence(List<CompteAgence> listCompteAgence) {
		this.listCompteAgence = listCompteAgence;
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
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public Agence(Long id, String nom, String adresse) {
		super();
		this.id = id;
		this.nom = nom;
		this.adresse = adresse;
	}
	public Agence() {
		super();
	}

	
}
