package ma.jit.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ma.jit.dao.IConseillerDao;
import ma.jit.entities.Conseiller;

@RestController
public class ConseillerRestWeb {

	@Autowired
	private IConseillerDao conseil;

//listeclients
	@RequestMapping(value = "/conseillers", method = RequestMethod.GET)
	public List<Conseiller> getAllConseiller() {
		return conseil.findAll();
	}

//getclienybyid
	@RequestMapping(value = "/conseillers/{id}", method = RequestMethod.GET)
	public Conseiller getConseillerById(@PathVariable Long id) {
		return conseil.findById(id).get();

	}

	// ajouter client
	@RequestMapping(value = "/conseillers", method = RequestMethod.POST)
	public Conseiller saveClient(@RequestBody Conseiller conseiller) {
		return conseil.save(conseiller);
	}

	// deletebyid
	@RequestMapping(value = "/conseillers/{id}", method = RequestMethod.DELETE)
	public boolean supprimer(@PathVariable Long id) {
		conseil.deleteById(id);
		return true;
	}

	// updateclient
	@RequestMapping(value = "/conseillers/{id}", method = RequestMethod.PUT)
	public Conseiller save(@PathVariable Long id, @RequestBody Conseiller conseiller) {
		conseiller.setId(id);
		return conseil.save(conseiller);

	}

}
