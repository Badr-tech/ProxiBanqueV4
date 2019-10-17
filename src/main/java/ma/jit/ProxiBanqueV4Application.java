package ma.jit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ma.jit.dao.IClientDao;
import ma.jit.entities.Client;
import ma.jit.service.IClientService;

@SpringBootApplication
public class ProxiBanqueV4Application implements CommandLineRunner {
	@Autowired
	private IClientService cltService;

	public static void main(String[] args) {
		SpringApplication.run(ProxiBanqueV4Application.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		//Test
		
		cltService.create(new Client("amer", "hind","hind@gmail.com", "sidimaarouf"));
		cltService.create(new Client("baatouti", "badr","badr@gmail.com", "oulfa"));
		cltService.create(new Client("hariri", "yassine","harharos@gmail.com", "hay salama"));
		cltService.create(new Client("quinouni", "issam","issamos@gmail.com", "hay hassani"));
		cltService.getAllClient().forEach(c->{
		
	System.out.println(c.getNom());
	});
}
}
