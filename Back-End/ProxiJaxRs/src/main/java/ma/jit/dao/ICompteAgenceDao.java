package ma.jit.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.jit.entities.CompteAgence;

public interface ICompteAgenceDao extends JpaRepository<CompteAgence, Long>{

}
