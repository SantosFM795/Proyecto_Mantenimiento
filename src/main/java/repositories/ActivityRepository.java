package repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Activity;
import domain.Customer;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Integer>{
	
	@Query("select g.activity from Gym g where g.id = ?1")
	Collection<Activity> findByGymId(int userAccountId);
	
	@Query("select g.activity from Gym g where active=true")
	Collection<Activity> findAllActive();
	
	@Query("select g.activity from Gym g where g.manager.userAccount.id = ?1")
	Collection<Activity> findByManagerId(int userAccountId);
	
	
}
