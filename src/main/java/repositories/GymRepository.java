package repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Gym;

@Repository
public interface GymRepository extends JpaRepository<Gym, Integer>{

	@Query("select m.gyms from Manager m where m.userAccount.id = ?1")
	Collection<Gym> findByManager(int UserAccountId);
	
	@Query("select t.gyms from Trainer t where t.userAccount.id = ?1")
	Collection<Gym> findByTrainer(int UserAccountId);
	
	@Query("select s.gym from Signing s where s.customer.userAccount.id = ?1 AND s.gym.active=true")
	Collection<Gym> findByCustomer(int UserAccountId);
}
