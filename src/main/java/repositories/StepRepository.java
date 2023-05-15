package repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Gym;
import domain.Step;

@Repository
public interface StepRepository extends JpaRepository<Step, Integer>{
	@Query("select min(t.steps.size), avg(t.steps.size), max(t.steps.size) from Training t")
	Collection<Object[]> findStepsByTraining();
	
	@Query("select t.steps from Training t where t.id = ?1")
	Collection<Step> findByTrainingId(int trainingId);
}
