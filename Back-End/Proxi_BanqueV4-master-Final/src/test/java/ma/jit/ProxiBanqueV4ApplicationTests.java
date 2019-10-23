package ma.jit;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import ma.jit.dao.IClientDao;
import ma.jit.dao.ICompteDao;
import ma.jit.dao.IConseillerDao;
import ma.jit.entities.Client;
import ma.jit.entities.Conseiller;
import ma.jit.service.IClientService;
import ma.jit.service.ICompteService;
import ma.jit.service.IConseillerService;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProxiBanqueV4ApplicationTests {
    @Autowired
    private IClientService clientService;
    @MockBean
    private IClientDao clientDao;
    @Autowired
    private ICompteService CompteService;
    @MockBean
    private ICompteDao compteDao;
    @Autowired
    private IConseillerService conseillerService;
    @MockBean
    private IConseillerDao conseillerDao;
    @Test
    public void getAllClientsTest() {
        when(clientDao.findAll())
                .thenReturn(Stream
                        .of(new Client("Kadiri", "Julia", "julia@gmail.com", "sidi maarouf"),
                                new Client("Kadi", "Julio", "julio@gmail.com", "californie"))
                        .collect(Collectors.toList()));
        assertEquals(2, clientService.getAllClient().size());
    }
    @Test
    public void getAllConseillersTest() {
        when(conseillerDao.findAll()).thenReturn(Stream
                .of(new Conseiller("amer", "hind", "hindproxi", "hind123", "sidi maarouf", "hindamer92@gmail.com"),
                        new Conseiller("ame2", "loulou", "loulouproxi", "hind1234", "californie", "hind92@gmail.com"))
                .collect(Collectors.toList()));
        assertEquals(2, conseillerService.getAllConseiller().size());
    }
  
//    @Test
//    public void saveClientTest() throws Exception {
//        Client client = new Client("hind", "hind", "julia@gmail.com", "sidi maarouf");
//        Conseiller conseiller = new Conseiller("juju", "jiji", "loubna", "loubna123", "2mars", "hind@gmail.com");
//        client.setConseiller(conseiller);
//        when(clientDao.save(client)).thenReturn(client);
//        assertEquals(client, clientService.createClient(client, conseiller));
//    }
    
    @Test
   public void deleteClientTest() {
       Client client = new Client(1L,"juju", "jiji", "loubna", "loubna123");
       clientService.deleteClient(1L);
       verify(clientDao,times(1)).deleteById(1L);
   }
    
       @Test
        public void getClientByNameTest() {
           String nom = "Hind";
            Conseiller conseiller = new Conseiller("juju", "jiji", "loubna", "loubna123", "2mars", "hind@gmail.com");
            Client client = new Client(1L, "Hind", "jiji", "loubna", "loubna123");
            client.setConseiller(conseiller);
            when(clientDao.findByNom(nom)).thenReturn(client);
            assertEquals(client, clientService.getClientByNom(nom));
        }
    
}







