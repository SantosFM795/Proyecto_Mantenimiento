package repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Activity;
import domain.Customer;
import domain.Trainer;

@Repository
public interface TrainerRepository extends JpaRepository<Trainer, Integer>{
		
	@Query("select t from Trainer t where t.userAccount.id = ?1")
	Trainer findByUserAccountId(int userAccountId);
	@Query("select t.trainer from Trainer t where t.manager.userAccount.id = ?1")
	Collection<Trainer> findByManagerId(int id);
}
