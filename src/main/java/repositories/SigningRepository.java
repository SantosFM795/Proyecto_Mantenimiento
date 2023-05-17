package repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Gym;
import domain.Signing;

@Repository
public interface SigningRepository extends JpaRepository<Signing, Integer>{
	@Query("select s from Signing s where s.customer.userAccount.id = ?1 AND s.gym.id=?2 AND leaving_date IS NULL")
	Signing findByGymAndCustomer(int customerId, int gymId);
}
