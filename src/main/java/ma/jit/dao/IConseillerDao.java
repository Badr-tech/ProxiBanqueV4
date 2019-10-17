package ma.jit.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.jit.domaine.Conseiller;

public interface IConseillerDao extends JpaRepository<Conseiller, Long> {

}
