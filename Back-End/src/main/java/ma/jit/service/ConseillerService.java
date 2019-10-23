package ma.jit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import ma.jit.dao.IConseillerDao;
import ma.jit.domaine.Conseiller;

@Service
public class ConseillerService implements IConseillerService{
	@Autowired
	IConseillerDao conseillerDao;
	
	@Override
	public void create(Conseiller conseiller) {
		conseillerDao.save(conseiller);
		
	}

	@Override
	public void deleteById(Long id) {
		conseillerDao.deleteById(id);
		
	}

	@Override
	public void update(Conseiller conseiller) {
		conseillerDao.save(conseiller);
		
	}

	@Override
	public List<Conseiller> getAll() {
		
		return conseillerDao.findAll();
	}

	@Override
	public Conseiller getById(int id) {
		
		return conseillerDao.findAll().get(id);
	}

	@Override
	public List<Conseiller> findByFirstName(String firstName) {
		
		return null;
	}

	@Override
	public List<Conseiller> findByFirstNameAndLastName(String firstName, String lastName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Conseiller> findAll(int page, int size) {
		// TODO Auto-generated method stub
		return null;
	}

}
