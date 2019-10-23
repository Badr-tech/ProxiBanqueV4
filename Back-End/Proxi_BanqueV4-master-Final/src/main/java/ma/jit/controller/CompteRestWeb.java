package ma.jit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ma.jit.entities.Compte;
import ma.jit.service.ICompteService;

/**
 * Declaration webservice Rest pour gerer un compte
 *
 */
@RestController
public class CompteRestWeb {
	/**
	 * Injection du service compte
	 */
	@Autowired
	private ICompteService cpte;

	/**
	 * Methode retourner liste des comptes
	 * 
	 * @return
	 */
	@RequestMapping(value = "/comptes", method = RequestMethod.GET)
	public List<Compte> getAllCompte() {
		return cpte.getAllCompte();
	}

	/**
	 * Methode retourner un compte par son id
	 * 
	 * @param numeroCompte
	 * @return
	 */
	@RequestMapping(value = "/comptes/{numeroCompte}", method = RequestMethod.GET)
	public Compte getCompteById(@PathVariable Long numeroCompte) {
		return cpte.getCompteById(numeroCompte);

	}

	/**
	 * Methode supprimer un compte
	 * 
	 * @param numeroCompte
	 * @return
	 */
	@RequestMapping(value = "/comptes/{numeroCompte}", method = RequestMethod.DELETE)
	public boolean supprimer(@PathVariable Long numeroCompte) {
		cpte.deleteCompte(numeroCompte);
		;
		return true;
	}

	/**
	 * Methode modifier un compte
	 * 
	 * @param compte
	 */
	@RequestMapping(value = "/comptes", method = RequestMethod.PUT)
	public void save(@RequestBody Compte compte) {
		cpte.updateCompte(compte);

	}

}
