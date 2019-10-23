package ma.jit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.jit.dao.IBackOfficeDao;
import ma.jit.entities.BackOffice;
import ma.jit.entities.Role;

/**
 * @author AMERMOUCH Hind
 * ELHARIRI Yassine
 * ELKACHAF Mustapha
 *
 */
/**
 * Declaration de la classe metier qui implemente l'interface IBackOfficeService
 *
 */
@Service
public class BackOfficeService implements IBackOfficeService {
	/**
	 * Injection de la repository BackOffice
	 */
	@Autowired
	private IBackOfficeDao backOffice;

	/**
	 * Methode creer un user backOffice
	 */
	@Override
	public void createBackOffice(BackOffice backoffice) {
		Role role = new Role();
		role.setId(3L);
		role.getListeUser().add(backoffice);
		backoffice.setRole(role);
		this.backOffice.save(backoffice);

	}

	/**
	 * Methode retourner une liste des users backOffice
	 */
	@Override
	public List<BackOffice> getAllBackOffice() {
		return (List<BackOffice>) this.backOffice.findAll();
	}

	/**
	 * Methode supprimer un user backOffice
	 */
	@Override
	public void deleteBackOffice(Long id) {
		this.backOffice.deleteById(id);

	}

	/**
	 * Methode modifier un user backOffice
	 */
	@Override
	public void updateBackOffice(BackOffice backoffice) {
		this.backOffice.save(backoffice);

	}

	/**
	 * Methode retourner un user backOffice par son id
	 */
	@Override
	public BackOffice getBackOfficeById(Long id) {
		return this.backOffice.findById(id).get();
	}

}
