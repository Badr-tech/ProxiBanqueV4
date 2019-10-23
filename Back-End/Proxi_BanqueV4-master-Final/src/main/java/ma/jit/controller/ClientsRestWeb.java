package ma.jit.controller;

import java.util.List;

import javax.ws.rs.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ma.jit.entities.Client;
import ma.jit.entities.Conseiller;
import ma.jit.service.IClientService;

/**
 * Declaration webservice Rest pour gerer un client
 *
 */
@RestController
public class ClientsRestWeb {

	/**
	 * Injection du service client
	 */
	@Autowired
	private IClientService clt;

	/**
	 * Methode retourner une liste des clients
	 * 
	 * @return
	 */
	@RequestMapping(value = "/clients", method = RequestMethod.GET)
	public List<Client> getAllClient() {
		return clt.getAllClient();
	}

	/**
	 * Methode retourner un client par son id
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/clients/{id}", method = RequestMethod.GET)
	public Client getClientById(@PathVariable Long id) {
		return clt.getClientById(id);

	}

	/**
	 * Methode ajouter un client
	 * 
	 * @param client
	 * @param conseiller
	 * @throws Exception
	 */
	@RequestMapping(value = "/clients", method = RequestMethod.POST)
	public void saveClient(@RequestBody Client client, Conseiller conseiller) throws Exception {
		clt.createClient(client, conseiller);
	}

	/**
	 * Methode supprimer un client
	 * 
	 * @param id
	 */
	@RequestMapping(value = "/clients/{id}", method = RequestMethod.DELETE)
	public void supprimer(@PathVariable Long id) {
		clt.deleteClient(id);
	}

	/**
	 * Methode modifier un client
	 * 
	 * @param client
	 */
	@RequestMapping(value = "/clients/{id}", method = RequestMethod.PUT)
	public void updateClient(@RequestBody Client client, @PathVariable Long id) {
		clt.updateClient(client, id);

	}

}
