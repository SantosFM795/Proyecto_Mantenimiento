package repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.CV;

@Repository
public interface CVRepository extends JpaRepository<CV, Integer>{

	@Query("select t.cv from Trainer t where t.userAccount_id = ?1")
	CV findByTrainerId(int userAccountId);
}
