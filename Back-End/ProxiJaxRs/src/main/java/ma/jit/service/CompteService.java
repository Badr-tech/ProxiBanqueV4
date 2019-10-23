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
@Service
public class CompteService implements ICompteService {

	@Autowired
	private ICompteDao cpte;
	
	@Autowired
	private ICompteAgenceDao ca;
	
	@Autowired
	private IParametrageDao par;
	
	@Autowired
	private ITransaction transactionDao;

	@Override
	public void create(Compte compte) {
		cpte.save(compte);
	}

	@Override
	public List<Compte> getAllCompte() {

		return (List<Compte>) cpte.findAll();
	}

	@Override
	public void deleteCompte(Long numeroCompte) {
		cpte.deleteById(numeroCompte);
	}

	@Override
	public void updateCompte(Compte compte) {
		cpte.save(compte);

	}

	@Override
	public Compte getCompteById(Long numeroCompte) {
		
	 return cpte.findById(numeroCompte).get();
	}

	@Override
	public void verser(long code, double montant){
		Compte compteRecepteur = cpte.findById(code).get();
		compteRecepteur.setSolde(compteRecepteur.getSolde()+montant);
		cpte.save(compteRecepteur);
		Transaction transaction = new Transaction(new Date(),"versement",montant);
		transaction.setCompte(compteRecepteur);
		transactionDao.save(transaction);
	}
	
	@Transactional
	@Override
	public void virement(Long code1, Long code2, double montant) {
		
		Compte compteEmetteur = cpte.findById(code1).get();
		double soldeEmetter = compteEmetteur.getSolde();
		if(soldeEmetter-montant>compteEmetteur.getDecouvert()) {
			double commission = par.findById(1L).get().getCom();
			double agenceCommission = montant*commission;
			
			compteEmetteur.setSolde(soldeEmetter-montant-agenceCommission);
			
			CompteAgence compteAgence = ca.findById(1L).get();
			compteAgence.setMontant(compteAgence.getMontant()+agenceCommission);
			
			verser(code2,montant);
			
			cpte.save(compteEmetteur);
			ca.save(compteAgence);
			
			Transaction transaction = new Transaction(new Date(),"retrait",montant);
			transaction.setCompte(compteEmetteur);
			transactionDao.save(transaction);
		}
}


}
