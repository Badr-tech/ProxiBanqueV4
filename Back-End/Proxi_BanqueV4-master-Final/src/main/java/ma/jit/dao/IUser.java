package ma.jit.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.jit.entities.Users;
/**
 * @author AMERMOUCH Hind
 *   ELHARIRI Yassine
 *   ELKACHAF Mustapha
 * 
 *
 */
/**
 * Declaration de la Repository User
 *
 */
public interface IUser extends JpaRepository<Users, Long> {
	

	/**
	 * Declaration de la methode qui retourne un User par son login
	 * @param login
	 * @return
	 */
	Users findByLogin(String login);

}
