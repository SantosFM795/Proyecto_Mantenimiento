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
	
	@Query("select g.trainer from Gym g where g.manager.userAccount.id = ?1")
	Collection<Trainer> findByManagerId(int userAccountid);
	
	@Query("select g.trainer from Gym g where g.id = ?1")
	Collection<Trainer> findByGymId(int gymId);
	
	@Query("select a.trainer from Activity a where a.id = ?1")
	Collection<Trainer> findByActivityId(int activityId);
	
	
	@Query("select t from Trainer t where (t.name LIKE %?1% OR t.lastName LIKE %?1%)")
	Collection<Trainer> findTrainerByKeyWord(String name);
	
	@Query("select min(c.rrss.size), avg(c.rrss.size), max(c.rrss.size) from Trainer t join t.curriculum c")
	Collection<Object[]> findSocialIdentitiesTrainer();
}
