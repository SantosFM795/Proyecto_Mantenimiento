package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domain.Signing;

@Repository
public interface SigningRepository extends JpaRepository<Signing, Integer>{

}
