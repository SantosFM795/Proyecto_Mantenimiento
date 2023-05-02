package repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Activity;
import domain.Customer;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Integer>{
	
	@Query("select c.activities from Customer c where c.userAccount.id = ?1")
	Collection<Activity> findByUserAccountId(int userAccountId);
	
}
