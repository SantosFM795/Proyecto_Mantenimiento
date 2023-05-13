package repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Customer;
import domain.Gym;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{
		
	@Query("select s.customer from Signing s where s.gym.id = ?1")
	Collection<Customer> findByGymId(int gymId);
	
	@Query("select a.customers from Activity a where a.id = ?1")
	Collection<Customer> findByActivityId(int activityId);
	
	@Query("select c from Customer c where c.userAccount.id = ?1")
	Customer findByUserAccountId(int userAccountId);
	
	@Query("select min(g.signing.customer.size), avg(g.signing.customer.size), max(g.signing.customer.size), stddev(g.signing.customer.size) from Gym g")
	Collection<Object[]> findCustomersByGym(); 
	
	@Query("select c1 from Customer c1 where (select count(a1) from Customer c join c.activities a1 where g1=g) >= ALL(select count(a2) from Customer c2 join c2.activities a2 group by c2")
	Collection<Customer> findMaxCustomerActivity();
}
