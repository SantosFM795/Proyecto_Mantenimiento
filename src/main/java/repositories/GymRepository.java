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

	/*
	@Query("select min(m.gyms.size), avg(m.gyms.size), max(m.gyms.size), stddev(m.gyms.size) from Manager m")
	Collection<Object[]> findGymsByManager(); 
	
	@Query("select min(mc.gyms.size), avg(c.gyms.size), max(c.gyms.size), stddev(c.gyms.size) from Customer c")
	Collection<Object[]> findGymsByCustomer();
	
	@Query("select g1 from Gym g1 where (select count(a1) from Gym g join g.activity a1 where a1.cancelled=false and g1=g) >= ALL(select count(a2) from Gym g2 join g2.activity a2 where a2.cancelled=false group by g2")
	Collection<Gym> findMaxActivitiesGym();*/
	
}
