package ma.jit.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.jit.entities.Conseiller;

/**
 * @author AMERMOUCH Hind
 *   ELHARIRI Yassine
 *   ELKACHAF Mustapha
 * 
 *
 */
/**
 * Declaration de la Repository Conseiller
 *
 */
public interface IConseillerDao extends JpaRepository<Conseiller, Long> {

}
