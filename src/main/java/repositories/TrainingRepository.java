package repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Training;

@Repository
public interface TrainingRepository extends JpaRepository<Training, Integer>{
	@Query("select t.title, avg(a.rating) as media from training t "
			+ "inner join annotation a on (a.training_id=t.id) "
			+ "group by t.title order by media desc;")
	Collection<Training> avgRatingPerTraining();
}
