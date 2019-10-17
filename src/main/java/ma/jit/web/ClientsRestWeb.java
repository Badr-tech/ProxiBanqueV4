package ma.jit.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ma.jit.dao.IClientDao;
import ma.jit.entities.Client;

@RestController
public class ClientsRestWeb {

	@Autowired
	private IClientDao clt;

//listeclients
	@RequestMapping(value = "/clients", method = RequestMethod.GET)
	public List<Client> getAllClient() {
		return clt.findAll();
	}

//getclienybyid
	@RequestMapping(value = "/clients/{id}", method = RequestMethod.GET)
	public Client getClientById(@PathVariable Long id) {
		return clt.findById(id).get();

	}

	// ajouter client
	@RequestMapping(value = "/clients", method = RequestMethod.POST)
	public Client saveClient(@RequestBody Client client) {
		return clt.save(client);
	}

	// deletebyid
	@RequestMapping(value = "/clients/{id}", method = RequestMethod.DELETE)
	public boolean supprimer(@PathVariable Long id) {
		clt.deleteById(id);
		return true;
	}

	// updateclient
	@RequestMapping(value = "/clients/{id}", method = RequestMethod.PUT)
	public Client save(@PathVariable Long id, @RequestBody Client client) {
		client.setId(id);
		return clt.save(client);

	}

}
