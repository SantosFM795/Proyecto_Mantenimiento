package repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Annotation;

@Repository
public interface AnnotationRepository extends JpaRepository<Annotation, Integer>{
	
	@Query("select a from Annotation a where a.training.id = ?1")
	Collection<Annotation> findByTrainingId(int TrainingId);
	
	@Query("select a from Annotation a where a.gym.id = ?1")
	Collection<Annotation> findByGymId(int GymId);
	
	@Query("select a from Annotation a where a.activity.id = ?1")
	Collection<Annotation> findByActivityId(int ActivityId);
	
	@Query("select avg(g.annotation.size), stddev(g.annotation.size) from Gym g")
	Collection<Object[]> findAnnotationGym();
	
	@Query("select avg(t.annotations.size), stddev(t.annotations.size) from Training t")
	Collection<Object[]> findAnnotationTraining();
	
	@Query("select avg(ac.annotations.size), stddev(ac.annotations.size) from Activity ac")
	Collection<Object[]> findAnnotationActivity();
}
