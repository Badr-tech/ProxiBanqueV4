package ma.jit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ma.jit.entities.BackOffice;
import ma.jit.service.IBackOfficeService;

/**
 * Declaration webservice Rest pour gerer un user backOffice
 *
 */
@RestController
public class BackOfficeRestWeb {

	/**
	 * Injection du service BackOffice
	 */
	@Autowired
	private IBackOfficeService backOffice;

	/**
	 * Methode retourner liste des users backOffice
	 */
	@RequestMapping(value = "/backoffices", method = RequestMethod.GET)
	public List<BackOffice> getAllbackoffice() {
		return backOffice.getAllBackOffice();
	}

	/**
	 * Methode retourner un user backOffice par son id
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/backoffices/{id}", method = RequestMethod.GET)
	public BackOffice getbackofficeById(@PathVariable Long id) {
		return backOffice.getBackOfficeById(id);

	}

	/**
	 * Methode ajouter user backOffice
	 * 
	 * @param backoffice
	 */
	@RequestMapping(value = "/backoffices", method = RequestMethod.POST)
	public void saveBackOffice(@RequestBody BackOffice backoffice) {
		backOffice.createBackOffice(backoffice);
	}

	/**
	 * Methode supprimer un user backOffice
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/backoffices/{id}", method = RequestMethod.DELETE)
	public boolean supprimer(@PathVariable Long id) {
		backOffice.deleteBackOffice(id);
		return true;
	}

	/**
	 * Methode modifier user backOffice
	 * 
	 * @param backoffice
	 */
	@RequestMapping(value = "/backoffices/{id}", method = RequestMethod.PUT)
	public void savebackoffice(@RequestBody BackOffice backoffice) {
		backOffice.updateBackOffice(backoffice);

	}

}
