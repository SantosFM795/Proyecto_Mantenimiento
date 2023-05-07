package services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import domain.Customer;
import domain.Gym;
import repositories.CustomerRepository;
import security.LoginService;
import security.UserAccount;

@Service
@Transactional
public class CustomerService {

	// Managed repository -------------------------
	
	@Autowired
	private CustomerRepository customerRepository;
	
	// Supporting services ------------------------
	
	// Constructor --------------------------------
	
	public CustomerService() {
		super();
	}
	
	//Simple CRUD methods -------------------------
	
	public Collection<Customer> findAll(){
		Collection<Customer> result;
		
		Assert.notNull(this.customerRepository);
		result=this.customerRepository.findAll();
		Assert.notNull(result);
		
		return result;
	}
	
	public Customer findOne(final int customerId) {
		Customer result;
		
		result=this.customerRepository.findOne(customerId);
		
		return result;
	}
	
	public Customer create() {
		Customer result;
		
		result = new Customer();
		
		return result;
	}
	
	public Customer save(Customer customer) {
		Assert.notNull(customer);
		
		Customer result;
		
		result = customerRepository.save(customer);
		
		return result;
	}
	
	public void delete (Customer customer) {
		Assert.notNull(customer);
		
		Assert.isTrue(customer.getId() != 0);
		
		customerRepository.delete(customer);
	}
	
	//Other business methods ----------------------
	
	
	public Collection<Customer> findByGym(int gymId){
		Assert.isTrue(gymId != 0);
		
		Collection<Customer> result;
		
		result=customerRepository.findByGymId(gymId);
		
		return result;	
	}

	public Collection<Customer> findByActivity(int activityId){
		Assert.isTrue(activityId != 0);
		
		Collection<Customer> result;
		
		result=customerRepository.findByActivityId(activityId);
		
		return result;	
	}	
	
	public Customer findByPrincipal() {
		Customer result;
		UserAccount userAccount;
		
		userAccount= LoginService.getPrincipal();
		Assert.notNull(userAccount);
		result = findByUserAccount(userAccount);
		Assert.notNull(result);
		
		return result;
	}
	
	public Customer findByUserAccount(UserAccount userAccount) {
		Assert.notNull(userAccount);
		
		Customer result;
		
		result = customerRepository.findByUserAccountId(userAccount.getId());
		
		return result;
		
		
	}
}
