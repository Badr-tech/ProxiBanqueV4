package ma.jit.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.jit.entities.Users;

public interface IUser extends JpaRepository<Users, Long> {

	Users findByLogin(String login);

}
