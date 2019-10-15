package ma.jit.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ma.jit.domaine.Client;
@RepositoryRestResource
public interface IClientDao extends JpaRepository<Client, Long>{

}
