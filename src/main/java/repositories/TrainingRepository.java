package repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Activity;
import domain.Training;

@Repository
public interface TrainingRepository extends JpaRepository<Training, Integer>{
	/*@Query("select t.title, avg(a.rating) as media from training t "
			+ "inner join annotation a on (a.training_id=t.id) "
			+ "group by t.title order by media desc")
	Collection<Training> avgRatingPerTraining();*/
	
	@Query("select g.training from Gym g where g.id = ?1")
	Collection<Training> findByGymId();
	
	@Query("select g.training from Gym g where g.manager.userAccount.id = ?1")
	Collection<Training> findByManagerId(int userAccountId);
	
	@Query("select g.training from Gym g where g.id = ?1")
	Collection<Training> findByGymId(int gymId);
	
	@Query("select s.gym.training from Signing s where s.customer.userAccount.id = ?1")
	Collection<Training> findByCustomerId(int userAccountId);
	
	@Query("select min(g.training.size), avg(g.training.size), max(g.training.size) from Gym g")
	Collection<Object[]> findTrainingByGym();
	
	@Query("select t from Training t order by t.steps.size DESC")
	Collection<Training> findOrderTraining();
	
	@Query("select t  from Training t where (t.title LIKE %?1% or t.description LIKE %?1%)")
	Collection<Training> findTrainerByKeyWord(String keyWord);
}
