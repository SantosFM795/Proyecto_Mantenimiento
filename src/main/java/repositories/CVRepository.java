package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domain.CV;

@Repository
public interface CVRepository extends JpaRepository<CV, Integer>{

}
