package ma.jit.service;

import java.util.List;

import ma.jit.entities.Conseiller;

/**
 * Declaration de l'interface ConseillerService
 *
 */
public interface IConseillerService {
	/**
	 * Declaration des methodes metier
	 */
	public void createConseiller(Conseiller conseiller) throws Exception;

	public List<Conseiller> getAllConseiller();

	public void deleteConseiller(Long id);

	public void updateConseiller(Conseiller conseiller);

	public Conseiller getConseillerById(Long id);

}
