package ma.jit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.jit.dao.IClientDao;
import ma.jit.dao.IConseillerDao;
import ma.jit.dao.IParametrageDao;
import ma.jit.entities.Client;
import ma.jit.entities.CompteCourant;
import ma.jit.entities.Conseiller;
import ma.jit.entities.Parametrage;
@Service
public class ClientService implements IClientService {
	@Autowired
	IClientDao clientDao;
	@Autowired
	IParametrageDao parametrageDao;
	@Autowired
	IConseillerDao conseillerDao;

	@Override
	public void createClient(Client client, Conseiller conseiller) throws Exception {
		List<Client> listClient = conseiller.getListeClient();
		Parametrage par = parametrageDao.findById(1L).get();
		int maxCli = par.getMaxClients();
		if(listClient.size()<maxCli) {
		CompteCourant compte = new CompteCourant();
		compte.setSolde(20.00);
		compte.setDecouvert(200.00);
		compte.setClient(client);
		client.getListeCompte().add(compte);
		conseiller.getListeClient().add(client);
		client.setConseiller(conseiller);
		clientDao.save(client);}
		else {
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
		return (List<Client>) clientDao.findAll();
	}

	@Override
	public void deleteClient(Long id) {
		clientDao.deleteById(id);
	}

	@Override
	public void updateClient(Client client) {
		clientDao.save(client);
	}

	@Override
	public Client getClientById(Long id) {

		return clientDao.findById(id).get();
	}

	@Override
	public Client getClientByNom(String nom) {
		return clientDao.findByNom(nom);
	}

	@Override
	public List<Client> getAllClientByConseiller(Conseiller conseiller) {
		return conseiller.getListeClient();
	}

	@Override
	public void reafectClient(Long id_client, Long id_conseiller) {
		//clientDao.
		
	}

}
