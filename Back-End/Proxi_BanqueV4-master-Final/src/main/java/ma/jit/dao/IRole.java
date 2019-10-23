package ma.jit.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.jit.entities.Role;
/**
 * @author AMERMOUCH Hind
 *   ELHARIRI Yassine
 *   ELKACHAF Mustapha
 * 
 *
 */
/**
 * Declaration de la Repository Role
 *
 */
public interface IRole extends JpaRepository<Role, Long>{

	/**
	 * Declaration de la methode qui retourne le role
	 * @param rolename
	 * @return
	 */
	public Role findByRole(String rolename);

}
