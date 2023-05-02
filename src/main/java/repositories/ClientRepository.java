package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domain.Customer;

@Repository
public interface ClientRepository extends JpaRepository<Customer, Integer>{

}
