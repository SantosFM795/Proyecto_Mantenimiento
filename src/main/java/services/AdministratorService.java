package services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import domain.Administrator;
import repositories.AdministratorRepository;;

@Service
@Transactional
public class AdministratorService {
	
	// Managed repository -------------------------
	
	@Autowired
	private AdministratorRepository AdministratorRepository;
	
	// Supporting services ------------------------
	
	// Constructor --------------------------------
	
	public AdministratorService() {
		super();
	}
	
	//Simple CRUD methods -------------------------
	
	public Administrator create() {
		Administrator result;
		
		result = new Administrator();
		
		return result;
	}
	
	public Administrator save(Administrator customer) {
		Assert.notNull(customer);
		
		Administrator result;
		
		result = AdministratorRepository.save(customer);
		
		return result;
	}
	
	public void delete (Administrator customer) {
		Assert.notNull(customer);
		
		Assert.isTrue(customer.getId() != 0);
		
		AdministratorRepository.delete(customer);
	}
}
