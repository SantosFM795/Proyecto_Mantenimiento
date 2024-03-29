package repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Activity;
import domain.Gym;

@Repository
public interface GymRepository extends JpaRepository<Gym, Integer>{

	@Query("select m.gyms from Manager m where m.userAccount.id = ?1")
	Collection<Gym> findByManager(int UserAccountId);
	
	@Query("select t.gyms from Trainer t where t.userAccount.id = ?1")
	Collection<Gym> findByTrainer(int UserAccountId);
	
	@Query("select s.gym from Signing s where s.customer.userAccount.id = ?1 AND s.gym.active=true")
	Collection<Gym> findByCustomer(int UserAccountId);

	
	@Query("select min(m.gyms.size), avg(m.gyms.size), max(m.gyms.size), stddev(m.gyms.size) from Manager m")
	Collection<Object[]> findGymsByManager(); 
	
	@Query("select s.gym from Signing s where s.customer.userAccount.id = ?1 AND s.gym.active=true AND leaving_date IS NULL")
	Collection<Gym> findByCustomerJoin(int UserAccountId);
	
	/*
	@Query("select min(s.gym), avg(s.gym), max(s.gym), stddev(s.gym) from Signing s where s.leaving_date=''")
	Collection<Object[]> findGymsBySigning();
	
	
	@Query("select g1 from Gym g1 where (select count(a1) from Gym g inner join g.activity a1 where a1.cancelled=false and g1=g) >= ALL(select count(a2) from Gym g2 inner join g2.activity a2 where a2.cancelled=false group by g2")
	Collection<Gym> findMaxActivitiesGym();

	@Query("select g1 from Gym g1 where (select count(a1) from Gym g join Activity a1 where a1.cancelled=false and g1=g and g.activity=a1) >= ALL(select count(a2) from Gym g2 inner join Activity a2 where a2.cancelled=false and g2.activity=a2 group by g2")
	Collection<Gym> findMaxActivitiesGym();
	*/
}
