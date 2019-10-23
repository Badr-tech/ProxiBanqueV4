package ma.jit.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.jit.entities.Client;
/**
 * @author AMERMOUCH Hind
 *   ELHARIRI Yassine
 *   ELKACHAF Mustapha
 * 
 *
 */

/**
 * Declaration de la repository Client
 *
 */
public interface IClientDao extends JpaRepository<Client, Long> {

	
	
	/**
	 * Declaration de la methode trouver un Client par son nom
	 * @param nom
	 * @return
	 */
	Client findByNom(String nom);

}
