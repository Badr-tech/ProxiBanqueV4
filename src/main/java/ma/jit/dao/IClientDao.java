package ma.jit.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import ma.jit.domaine.Client;
@RepositoryRestResource
@CrossOrigin
public interface IClientDao extends JpaRepository<Client, Long>{
	
	public List<Client> findByNom(String nom);

}
