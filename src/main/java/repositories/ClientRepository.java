package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domain.Costumer;

@Repository
public interface ClientRepository extends JpaRepository<Costumer, Integer>{

}
