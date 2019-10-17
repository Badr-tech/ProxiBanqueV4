package ma.jit.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ma.jit.entities.Compte;
@RepositoryRestResource
public interface ICompteDao  extends JpaRepository<Compte, Long> {

}
