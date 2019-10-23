package ma.jit.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.jit.entities.Compte;

/**
 * @author AMERMOUCH Hind
 *   ELHARIRI Yassine
 *   ELKACHAF Mustapha
 * 
 *
 */
/**
 * Declaration de la Repository Compte
 *
 */
public interface ICompteDao extends JpaRepository<Compte, Long> {

}
