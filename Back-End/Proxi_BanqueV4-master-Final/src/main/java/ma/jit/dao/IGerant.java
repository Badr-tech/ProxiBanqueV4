package ma.jit.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.jit.entities.Gerant;

/**
 * @author AMERMOUCH Hind
 *   ELHARIRI Yassine
 *   ELKACHAF Mustapha
 * 
 *
 */
/**
 * Declaration de la Repository Gerant
 *
 */
public interface IGerant extends JpaRepository<Gerant, Long> {

}
