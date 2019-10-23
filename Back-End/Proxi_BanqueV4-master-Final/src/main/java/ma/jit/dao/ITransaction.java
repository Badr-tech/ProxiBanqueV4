package ma.jit.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.jit.entities.Transaction;
/**
 * @author AMERMOUCH Hind
 *   ELHARIRI Yassine
 *   ELKACHAF Mustapha
 * 
 *
 */
/**
 * Declaration de la Repository Transaction
 *
 */
public interface ITransaction extends JpaRepository<Transaction, Long>{

}
