package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domain.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer>{

}
