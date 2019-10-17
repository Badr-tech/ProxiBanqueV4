package ma.jit.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.jit.dao.IClientDao;
import ma.jit.entities.Client;
import ma.jit.entities.Compte;
import ma.jit.entities.CompteCourant;


@Service
public class ClientService implements IClientService {
	@Autowired
	IClientDao clt;

	@Override
	public void create(Client client) {
		CompteCourant compte = new CompteCourant();
		compte.setSolde(20.00);
		compte.setClient(client);
		client.getListeCompte().add(compte);
		clt.save(client);

	}

	@Override
	public List<Client> getAllClient() {
		return (List<Client>) clt.findAll();
	}

	@Override
	public void deleteClient(Long id) {
		clt.deleteById(id);

	}

	@Override
	public void updateClient(Client client) {
		clt.save(client);

	}

	@Override
	public Client getClientById(Long id) {

		return clt.findById(id).get();
	}

}
