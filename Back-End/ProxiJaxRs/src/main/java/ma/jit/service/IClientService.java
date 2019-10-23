package ma.jit.service;

import java.util.List;

import ma.jit.entities.Client;
import ma.jit.entities.Conseiller;

public interface IClientService {
	
		
		public void createClient(Client client, Conseiller conseiller) throws Exception;
		public List<Client> getAllClient();
		public void deleteClient(Long id);
		public void updateClient(Client client);
		public Client  getClientById(Long id);
		public Client getClientByNom(String nom);
		public List<Client> getAllClientByConseiller(Conseiller conseiller);
		public void reafectClient(Long id_client, Long id_conseiller);


	}
