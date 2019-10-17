package ma.jit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.jit.dao.ICompteDao;
import ma.jit.entities.Compte;
@Service
public class CompteService implements ICompteService {

	@Autowired
	ICompteDao cpte;

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

}
