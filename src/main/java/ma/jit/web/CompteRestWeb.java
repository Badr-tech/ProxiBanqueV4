package ma.jit.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ma.jit.dao.ICompteDao;
import ma.jit.entities.Compte;
@RestController
public class CompteRestWeb {
	@Autowired
	private ICompteDao cpte;

//listeclients
	@RequestMapping(value = "/comptes", method = RequestMethod.GET)
	public List<Compte> getAllCompte() {
		return cpte.findAll();
	}

//getclienybyid
	@RequestMapping(value = "/comptes/{numeroCompte}", method = RequestMethod.GET)
	public Compte getCompteById(@PathVariable Long numeroCompte) {
		return cpte.findById(numeroCompte).get();

	}

	// ajouter client
	@RequestMapping(value = "/comptes", method = RequestMethod.POST)
	public Compte saveCompte(@RequestBody Compte compte) {
		return cpte.save(compte);
	}

	//deletebyid
		@RequestMapping(value = "/comptes/{numeroCompte}", method = RequestMethod.DELETE)
		public boolean supprimer(@PathVariable Long numeroCompte) {
			cpte.deleteById(numeroCompte);
			return true;
		}
		
		//updateclient
				@RequestMapping(value = "/comptes/{numeroCompte}", method = RequestMethod.PUT)
				public Compte save(@PathVariable Long numeroCompte, @RequestBody Compte compte ) {
					compte.setNumeroCompte(numeroCompte);
					return cpte.save(compte);
					
				}	
	
}
