package repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.CV;

@Repository
public interface CVRepository extends JpaRepository<CV, Integer>{

	@Query("select t.curriculum from Trainer t where t.userAccount.id = ?1")
	CV findByTrainerId(int userAccountId);
}
