package ma.jit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.jit.dao.IClientDao;
import ma.jit.dao.IParametrageDao;
import ma.jit.entities.Client;
import ma.jit.entities.CompteCourant;
import ma.jit.entities.Conseiller;
import ma.jit.entities.Parametrage;

@Service
public class ClientService implements IClientService {
	@Autowired
	IClientDao clientdao;
	@Autowired
	IParametrageDao parametrage;

	@Override
	public void createClient(Client client, Conseiller conseiller) throws Exception {
		List<Client> listClient = conseiller.getListeClient();
		Parametrage par = parametrage.findById(1L).get();
		int maxCli = par.getMaxClients();
		if (listClient.size() < maxCli) {
			CompteCourant compte = new CompteCourant();
			compte.setSolde(20.00);
			compte.setDecouvert(200.00);
			compte.setClient(client);
			client.getListeCompte().add(compte);
			conseiller.getListeClient().add(client);
			client.setConseiller(conseiller);
			clientdao.save(client);
		} else {
			throw new Exception("nombre maximum des clients atteint");
		}
	}

	public void reafectConseiller(Client client, Conseiller conseiller) {
		client.getConseiller().getListeClient().remove(client);
		client.setConseiller(conseiller);
		conseiller.getListeClient().add(client);
	}

	@Override
	public List<Client> getAllClient() {
		return (List<Client>) clientdao.findAll();
	}

	@Override
	public void deleteClient(Long id) {
		clientdao.deleteById(id);
	}

	@Override
	public void updateClient(Client client, Long id) {
		client.setId(id);
		clientdao.save(client);
	}

	@Override
	public Client getClientById(Long id) {

		return clientdao.findById(id).get();
	}

	@Override
	public Client getClientByNom(String nom) {
		return clientdao.findByNom(nom);
	}

}
