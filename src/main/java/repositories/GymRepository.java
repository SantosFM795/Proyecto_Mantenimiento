package repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Gym;

@Repository
public interface GymRepository extends JpaRepository<Gym, Integer>{

	@Query("select m.gyms from Manager m where m.userAccount_id = ?1")
	Collection<Gym> findByUserAccountManagerId(int UserAccountId);
	
	@Query("select t.gyms from Trainer t where t.userAccount_id = ?1")
	Collection<Gym> findByUserAccountTrainerId(int UserAccountId);
}
