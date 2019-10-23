package ma.jit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.jit.entities.Compte;
import ma.jit.service.ICompteService;

import java.util.HashMap;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Component
@Path("/app")
public class JaxRsController {

  JaxRsController(){
      System.out.println(this);
  }

  @GET
  @Path("/{type}")
  public String getMessage(@PathParam("type") String type) {
      return "message from JAX-RS app for " + type;
  }
  
  @Autowired
  ICompteService ico;

  @Path(value="/compte")
  @Produces(MediaType.APPLICATION_JSON)
  @GET
  public List<Compte> getAllCompte() {
  	return ico.getAllCompte();
  }

  @Path(value="/comptes")
  @Produces(MediaType.APPLICATION_JSON)
  @POST
  public void verser(HashMap<String,Object> versement) {
  	int code = (int) versement.get("code");
  	Long code1=Long.valueOf(code);
  	double montant = (double) versement.get("montant");
  	ico.verser(code1, montant);
  }


  @Path(value="/virement")
  @POST
  public void virement(HashMap<String,Object> virement) {
  	int code1 = (int) virement.get("code1");
  	int code2 = (int) virement.get("code2");
  	Long numCompte1=Long.valueOf(code1);
  	Long numCompte2=Long.valueOf(code2);
  	double montant = (double) virement.get("montant");
  	ico.virement(numCompte1, numCompte2, montant);
  }
}