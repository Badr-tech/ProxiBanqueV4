package ma.jit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ma.jit.entities.Parametrage;
import ma.jit.service.IParametrageService;

/**
 * Declaration webservice Rest pour gerer le parametrage
 *
 */
@RestController
public class ParametrageController {
	/**
	 * Injection du service parametrage
	 */
	@Autowired
	private IParametrageService iparametrage;

	/**
	 * Methode modifier parametrage
	 * 
	 * @param par
	 */
	@RequestMapping(value = "/parametrage", method = RequestMethod.PUT)
	public void parametrage(@RequestBody Parametrage par) {
		this.iparametrage.updateParametrage(par);
	}
}
