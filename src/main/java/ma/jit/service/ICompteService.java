package ma.jit.service;

import java.util.List;

import ma.jit.entities.Compte;


public interface ICompteService {
	
	public void create(Compte compte);
	public List<Compte> getAllCompte();
	public void deleteCompte(Long numeroCompte);
	public void updateCompte(Compte compte);
	public Compte  getCompteById(Long numeroCompte);


}
