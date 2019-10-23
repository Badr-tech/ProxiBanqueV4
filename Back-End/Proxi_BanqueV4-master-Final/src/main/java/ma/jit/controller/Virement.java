package ma.jit.controller;

import java.util.HashMap;

import javax.ws.rs.core.Application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ma.jit.service.ICompteService;

/**
 * Declaration webservice Rest pour gerer virement
 *
 */
@RestController
public class Virement extends Application {
	/**
	 * Injection du service compte
	 */
	@Autowired
	ICompteService compteService;

	/**
	 * Methode versement
	 * 
	 * @param versement
	 */
	@RequestMapping(value = "/versement", method = RequestMethod.POST)
	public void verser(@RequestBody HashMap<String, Object> versement) {
		int code = (int) versement.get("code");
		Long code1 = Long.valueOf(code);
		double montant = (double) versement.get("montant");
		compteService.versement(code1, montant);
	}

	/**
	 * Methode virement
	 * 
	 * @param virement
	 */
	@RequestMapping(value = "/virement", method = RequestMethod.POST)
	public void virement(@RequestBody HashMap<String, Object> virement) {
		int code1 = (int) virement.get("code1");
		int code2 = (int) virement.get("code2");
		Long numCompte1 = Long.valueOf(code1);
		Long numCompte2 = Long.valueOf(code2);
		double montant = (double) virement.get("montant");
		compteService.virement(numCompte1, numCompte2, montant);
	}

}
