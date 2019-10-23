package ma.jit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ma.jit.dao.IConseillerDao;
import ma.jit.dao.IParametrageDao;
import ma.jit.dao.IRole;
import ma.jit.entities.Conseiller;
import ma.jit.entities.Role;

/**
 * @author AMERMOUCH Hind
 * ELHARIRI Yassine
 * ELKACHAF Mustapha
 *
 */
/**
 * Declaration de la classe metier qui implemente l'interface IConseillerService
 *
 */
@Service
public class ConseillerService implements IConseillerService {

	/**
	 * Injection des repositories
	 */
	@Autowired
	private IConseillerDao conseillerDao;

	@Autowired
	private IParametrageDao parametrageDao;

	@Autowired
	private IRole roleDao;

	@Autowired
	private BCryptPasswordEncoder bCryptPassword;

	/**
	 * Methode creer un conseiller
	 */
	@Override
	public void createConseiller(Conseiller conseiller) throws Exception {
		int maxConseiller = parametrageDao.findById(1L).get().getMaxCons();
		if (conseillerDao.findAll().size() < maxConseiller) {
			Role role = roleDao.findById(2L).get();
			role.getListeUser().add(conseiller);
			String mpasse = bCryptPassword.encode(conseiller.getPassword());
			conseiller.setPassword(mpasse);
			conseiller.setRole(role);
			conseillerDao.save(conseiller);
		} else {
			throw new Exception("nbre max atteint");
		}
	}

	/**
	 * Methode retourner une liste des conseillers
	 */
	@Override
	public List<Conseiller> getAllConseiller() {

		return (List<Conseiller>) conseillerDao.findAll();
	}

	/**
	 * Methode supprimer un conseiller
	 */
	@Override
	public void deleteConseiller(Long id) {
		conseillerDao.deleteById(id);

	}

	/**
	 * Methode modifier un conseiller
	 */
	@Override
	public void updateConseiller(Conseiller conseiller) {
		conseillerDao.save(conseiller);

	}

	/**
	 * Methode retourner un conseiller par son id
	 */
	@Override
	public Conseiller getConseillerById(Long id) {

		return conseillerDao.findById(id).get();
	}

}
