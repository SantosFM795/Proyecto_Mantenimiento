package services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import domain.Customer;
import domain.Gym;
import domain.Signing;
import services.CustomerService;
import repositories.SigningRepository;

@Service
@Transactional
public class SigningService {

	// Managed repository -------------------------
	@Autowired
	private SigningRepository signingRepository;
	
	// Supporting services ------------------------
	
	@Autowired
	private CustomerService customerService;
	
	// Constructor --------------------------------
	
	public SigningService() {
		super();
	}
	
	//Simple CRUD methods -------------------------
	
	public Signing create(Gym gym, Customer customer) {
		Signing result=new Signing();
		Date date=new Date();
		
		result.setGym(gym);
		result.setCustomer(customer);
		result.setSign_date(date);
		this.signingRepository.save(result);
		
		return result;
		
	}
	
	//Other business methods ----------------------
	
	public Signing findByGymAndCustomer(int gymId){
		Signing result;
		Customer customer;
		
		customer = this.customerService.findByPrincipal();
		Assert.notNull(customer);
		result = this.signingRepository.findByGymAndCustomer(customer.getUserAccount().getId(), gymId);
		
		return result;
	}

	
	
	
}
