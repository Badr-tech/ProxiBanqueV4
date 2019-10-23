package ma.jit.service;

import java.util.List;

import ma.jit.entities.BackOffice;

/**
 * Declaration de l'interface BackOfficeService
 *
 */
public interface IBackOfficeService {
	/**
	 * Declaration des methodes metier
	 */
	public void createBackOffice(BackOffice backoffice);

	public void deleteBackOffice(Long id);

	public void updateBackOffice(BackOffice backoffice);

	public BackOffice getBackOfficeById(Long id);

	public List<BackOffice> getAllBackOffice();
}
