package ma.jit.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.jit.entities.Role;

public interface IRole extends JpaRepository<Role, Long>{

	public Role findByRole(String rolename);

}
