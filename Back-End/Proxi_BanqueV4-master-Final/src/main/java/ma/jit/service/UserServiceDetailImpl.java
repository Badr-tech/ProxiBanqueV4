package ma.jit.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ma.jit.entities.Users;

/**
 * @author AMERMOUCH Hind
 * ELHARIRI Yassine
 * ELKACHAF Mustapha
 *
 */
/**
 * Declaration de la classe metier qui implemente l'interface UserDetailsService
 *
 */
@Service
public class UserServiceDetailImpl implements UserDetailsService {
	/**
	 * Injection de la repository UserService
	 */
	@Autowired
	private UserService userService;

	/**
	 * Methode retourne un user par son userName
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user = userService.findByUsername(username);
		if (user == null)
			throw new UsernameNotFoundException(username);
		Collection<GrantedAuthority> authorities = new ArrayList<>();
		// user.getRoles().forEach(r->{
		authorities.add(new SimpleGrantedAuthority(user.getRole().getRole()));

		return new User(user.getLogin(), user.getPassword(), authorities);
	}

}
