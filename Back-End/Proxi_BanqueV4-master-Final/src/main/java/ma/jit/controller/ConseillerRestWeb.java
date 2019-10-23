package ma.jit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ma.jit.entities.Conseiller;
import ma.jit.service.IConseillerService;

/**
 * Declaration webservice Rest pour gerer un conseiller
 *
 */
@RestController
public class ConseillerRestWeb {

	/**
	 * Injection du service conseiller
	 */
	@Autowired
	private IConseillerService conseil;

	/**
	 * Methode retourner une liste des conseillers
	 * 
	 * @return
	 */
	@RequestMapping(value = "/conseillers", method = RequestMethod.GET)
	public List<Conseiller> getAllConseiller() {
		return conseil.getAllConseiller();
	}

	/**
	 * Methode retourner un conseiller par son id
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/conseillers/{id}", method = RequestMethod.GET)
	public Conseiller getConseillerById(@PathVariable Long id) {
		return conseil.getConseillerById(id);

	}

	/**
	 * Methode creer conseiller
	 * 
	 * @param conseiller
	 * @throws Exception
	 */
	@RequestMapping(value = "/conseillers", method = RequestMethod.POST)
	public void saveClient(@RequestBody Conseiller conseiller) throws Exception {
		conseil.createConseiller(conseiller);
	}

	/**
	 * Methode supprimer conseiller
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/conseillers/{id}", method = RequestMethod.DELETE)
	public boolean supprimer(@PathVariable Long id) {
		conseil.deleteConseiller(id);
		return true;
	}

	/**
	 * Methode modifier conseiller
	 * 
	 * @param conseiller
	 */
	@RequestMapping(value = "/conseillers", method = RequestMethod.PUT)
	public void saveConseiller(@RequestBody Conseiller conseiller) {
		conseil.updateConseiller(conseiller);

	}

}
