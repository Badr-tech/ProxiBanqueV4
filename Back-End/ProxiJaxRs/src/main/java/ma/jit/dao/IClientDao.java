package ma.jit.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.jit.entities.Client;

public interface IClientDao extends JpaRepository<Client, Long>{

	Client findByNom(String nom);

}
