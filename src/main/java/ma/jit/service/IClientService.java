package ma.jit.service;

import java.util.List;

import ma.jit.entities.Client;



public interface IClientService {
	
		
		public void create(Client client);
		public List<Client> getAllClient();
		public void deleteClient(Long id);
		public void updateClient(Client client);
		public Client  getClientById(Long id);


	}
