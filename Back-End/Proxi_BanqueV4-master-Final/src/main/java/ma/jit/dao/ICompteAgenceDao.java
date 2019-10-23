package ma.jit.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.jit.entities.CompteAgence;

/**
 * @author AMERMOUCH Hind
 *   ELHARIRI Yassine
 *   ELKACHAF Mustapha
 * 
 *
 */
/**
 * Declaration de la Repository CompteAgence
 *
 */
public interface ICompteAgenceDao extends JpaRepository<CompteAgence, Long> {

}
