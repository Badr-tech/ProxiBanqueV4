package ma.jit.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.jit.entities.BackOffice;

/**
 * @author AMERMOUCH Hind
 *   ELHARIRI Yassine
 *   ELKACHAF Mustapha
 * 
 *
 */

/**
 * Declaration de la repository BackOffice
 *
 */
public interface IBackOfficeDao extends JpaRepository<BackOffice, Long> {

}
