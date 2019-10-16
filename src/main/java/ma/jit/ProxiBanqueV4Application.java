package ma.jit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import ma.jit.dao.IClientDao;
import ma.jit.domaine.Client;
import ma.jit.domaine.Personne;

@SpringBootApplication
public class ProxiBanqueV4Application implements CommandLineRunner {
	@Autowired
	IClientDao clientDao;

	@Autowired
	private RepositoryRestConfiguration restConfiguration;

	public static void main(String[] args) {
		SpringApplication.run(ProxiBanqueV4Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		restConfiguration.exposeIdsFor(Client.class);

		clientDao.save(new Client(null, "badr", "badr", "badr@gmail.com", "sidi maarouf casablanca"));
		clientDao.save(new Client(null, "issam", "issam", "issam@gmail.com", "sidi maarouf casablanca"));
		clientDao.save(new Client(null, "hind", "hind", "badr@gmail.com", "sidi maarouf casablanca"));
		clientDao.save(new Client(null, "yassin", "yassine", "badr@gmail.com", "sidi maarouf casablanca"));

	}

}
