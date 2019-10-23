package ma.jit.service;

import ma.jit.entities.Gerant;

/**
 * Declaration de l'interface GerantService
 *
 */
public interface IGerantService {
	/**
	 * Declaration des methodes metier
	 */
	public void createGerant(Gerant gerant);

	public void updateGerant(Gerant gerant);

	public void getGerantById(Long id);

	public void deleteGerant(Long id);

}
