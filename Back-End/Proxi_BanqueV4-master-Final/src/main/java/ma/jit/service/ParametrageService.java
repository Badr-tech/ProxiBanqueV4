package ma.jit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.jit.dao.IParametrageDao;
import ma.jit.entities.Parametrage;

/**
 * @author AMERMOUCH Hind
 * ELHARIRI Yassine
 * ELKACHAF Mustapha
 *
 */
/**
 * Declaration de la classe metier qui implemente l'interface
 * IParametrageService
 *
 */
@Service
public class ParametrageService implements IParametrageService {

	/**
	 * Injection de la repository Parametrage
	 */
	@Autowired
	private IParametrageDao parametrageDao;

	/**
	 * Methode modifier parametrage
	 */
	@Override
	public void updateParametrage(Parametrage parametrage) {
		this.parametrageDao.save(parametrage);
	}

}
