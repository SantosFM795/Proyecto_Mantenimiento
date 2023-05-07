package repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{
		
	@Query("select s.customer from Signing s where s.gym.id = ?1")
	Collection<Customer> findByGymId(int gymId);
	
	@Query("select a.customers from Activity a where a.id = ?1")
	Collection<Customer> findByActivityId(int activityId);
	
	@Query("select c from Customer c where c.userAccount.id = ?1")
	Customer findByUserAccountId(int userAccountId);
}
