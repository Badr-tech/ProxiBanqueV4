package ma.jit.service;

import java.util.List;

import ma.jit.entities.Client;
import ma.jit.entities.Conseiller;

/**
 * Declaration de l'interface ClientService
 *
 */
public interface IClientService {

	/**
	 * Declaration des methodes metier
	 */
	public void createClient(Client client, Conseiller conseiller) throws Exception;

	public List<Client> getAllClient();

	public void deleteClient(Long id);

	public void updateClient(Client client, Long id);

	public Client getClientById(Long id);

	public Client getClientByNom(String nom);

}
