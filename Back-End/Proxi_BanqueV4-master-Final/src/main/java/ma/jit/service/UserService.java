package ma.jit.service;

import ma.jit.entities.Role;
import ma.jit.entities.Users;

/**
 * Declaration de l'interface UserService
 *
 */
public interface UserService {
	/**
	 * Declaration des methodes metier
	 */
	public Users saveuser(Users user);

	public Role saverole(Role role);

	public void addRoleToUse(String username, String rolename);

	public Users findByUsername(String username);

}
