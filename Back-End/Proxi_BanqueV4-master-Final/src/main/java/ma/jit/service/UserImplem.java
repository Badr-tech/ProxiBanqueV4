package ma.jit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ma.jit.dao.IRole;
import ma.jit.dao.IUser;
import ma.jit.entities.Role;
import ma.jit.entities.Users;

/**
 * @author AMERMOUCH Hind
 * ELHARIRI Yassine
 * ELKACHAF Mustapha
 *
 */
/**
 * Declaration de la classe metier qui implemente l'interface UserService
 *
 */
@Service
public class UserImplem implements UserService {
	/**
	 * Injection des repositories
	 */
	@Autowired
	private IRole roleDao;
	@Autowired
	private IUser userDao;
	@Autowired
	private BCryptPasswordEncoder bCryptPassword;

	/**
	 * Methode ajouter un user
	 */
	@Override
	public Users saveuser(Users user) {
		String motDePass = bCryptPassword.encode(user.getPassword());
		user.setPassword(motDePass);
		return userDao.save(user);
	}

	/**
	 * Methode ajouter un role
	 */
	@Override
	public Role saverole(Role role) {

		return roleDao.save(role);
	}

	/**
	 * Methode affecter un role à un user
	 */
	@Override
	public void addRoleToUse(String username, String rolename) {
		Role role = roleDao.findByRole(rolename);
		Users user = userDao.findByLogin(username);
		user.setRole(role);

	}

	/**
	 * Methode trouver un user par son username
	 */
	@Override
	public Users findByUsername(String username) {
		// TODO Auto-generated method stub
		return userDao.findByLogin(username);
	}

}
