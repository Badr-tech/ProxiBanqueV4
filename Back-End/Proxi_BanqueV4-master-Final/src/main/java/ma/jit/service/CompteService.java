package ma.jit.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.jit.dao.ICompteAgenceDao;
import ma.jit.dao.ICompteDao;
import ma.jit.dao.IParametrageDao;
import ma.jit.dao.ITransaction;
import ma.jit.entities.Compte;
import ma.jit.entities.CompteAgence;
import ma.jit.entities.Transaction;

/**
 * @author AMERMOUCH Hind
 * ELHARIRI Yassine
 * ELKACHAF Mustapha
 *
 */
/**
 * Declaration de la classe metier qui implemente l'interface ICompteService
 *
 */
@Service
public class CompteService implements ICompteService {

	/**
	 * Injection des repositories
	 */
	@Autowired
	private ICompteDao cpte;

	@Autowired
	private ICompteAgenceDao ca;

	@Autowired
	private IParametrageDao par;

	@Autowired
	private ITransaction transactionDao;

	/**
	 * Methode creer un compte
	 */
	@Override
	public void createCompte(Compte compte) {
		cpte.save(compte);
	}

	/**
	 * Methode retourner un liste des comptes
	 */
	@Override
	public List<Compte> getAllCompte() {

		return (List<Compte>) cpte.findAll();
	}

	/**
	 * Methode supprimer un compte
	 */
	@Override
	public void deleteCompte(Long numeroCompte) {
		cpte.deleteById(numeroCompte);
	}

	/**
	 * Methode modifir un compte
	 */
	@Override
	public void updateCompte(Compte compte) {
		cpte.save(compte);

	}

	/**
	 * Methode retourner un compte par son numero
	 */
	@Override
	public Compte getCompteById(Long numeroCompte) {

		return cpte.findById(numeroCompte).get();
	}

	/**
	 * Methode versement
	 */
	@Override
	public void versement(long code, double montant) {
		Compte compteRecepteur = cpte.findById(code).get();
		compteRecepteur.setSolde(compteRecepteur.getSolde() + montant);
		cpte.save(compteRecepteur);
		Transaction transaction = new Transaction(new Date(), "versement", montant);
		transaction.setCompte(compteRecepteur);
		transactionDao.save(transaction);
	}

	/**
	 * Methode virement
	 */
	@Transactional
	@Override
	public void virement(Long code1, Long code2, double montant) {

		Compte compteEmetteur = cpte.findById(code1).get();
		double soldeEmetter = compteEmetteur.getSolde();
		if (soldeEmetter - montant > compteEmetteur.getDecouvert()) {
			double commission = par.findById(1L).get().getCom();
			double agenceCommission = montant * commission;

			compteEmetteur.setSolde(soldeEmetter - montant - agenceCommission);

			CompteAgence compteAgence = ca.findById(1L).get();
			compteAgence.setMontant(compteAgence.getMontant() + agenceCommission);

			versement(code2, montant);

			cpte.save(compteEmetteur);
			ca.save(compteAgence);

			Transaction transaction = new Transaction(new Date(), "retrait", montant);
			transaction.setCompte(compteEmetteur);
			transactionDao.save(transaction);
		}
	}

}
