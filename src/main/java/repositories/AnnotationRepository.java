package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domain.Annotation;

@Repository
public interface AnnotationRepository extends JpaRepository<Annotation, Integer>{

}
