package ma.jit.service;

import java.util.List;

import ma.jit.entities.Compte;

/**
 * Declaration de l'interface CompteService
 *
 */
public interface ICompteService {
	/**
	 * Declaration des methodes metier
	 */
	public void createCompte(Compte compte);

	public List<Compte> getAllCompte();

	public void deleteCompte(Long numeroCompte);

	public void updateCompte(Compte compte);

	public Compte getCompteById(Long numeroCompte);

	public void virement(Long compteEmetteur, Long compteRecepteur, double montant);

	public void versement(long numeroCompte, double montant);

}
