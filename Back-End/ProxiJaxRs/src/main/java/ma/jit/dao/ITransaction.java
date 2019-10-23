package ma.jit.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.jit.entities.Transaction;

public interface ITransaction extends JpaRepository<Transaction, Long>{

}
