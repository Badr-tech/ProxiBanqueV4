package ma.jit.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import ma.jit.domaine.Conseiller;


@Service
public interface IConseillerService{

	public void create(Conseiller conseiller);
	public void deleteById(Long id);
	public void update(Conseiller conseiller);
	public List<Conseiller> getAll();
	public Conseiller getById(int id);
	public List<Conseiller> findByFirstName(String firstName);
	public List<Conseiller> findByFirstNameAndLastName(String firstName, String lastName); 
	public Page<Conseiller> findAll(int page, int size);

}
