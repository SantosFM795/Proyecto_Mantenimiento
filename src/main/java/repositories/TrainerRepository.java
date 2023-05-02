package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Trainer;

@Repository
public interface TrainerRepository extends JpaRepository<Trainer, Integer>{
	
	@Query("select t from Trainer t where t.userAccount.id = ?1")
	Trainer findByUserAccountId(int userAccountId);
	
	
}
