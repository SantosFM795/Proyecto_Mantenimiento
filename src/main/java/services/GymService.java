package services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import domain.Customer;
import domain.Gym;
import domain.Manager;
import domain.Trainer;
import repositories.GymRepository;
@Service
@Transactional
public class GymService {

	// Managed repository -------------------------
	
	@Autowired
	private GymRepository gymRepository;
	
	// Supporting services ------------------------
	@Autowired
	private ManagerService managerService;
	
	@Autowired
	private TrainerService trainerService;
	
	@Autowired
	private CustomerService customerService;
	
	// Constructor --------------------------------
	
	public GymService() {
		super();
	}
	
	//Simple CRUD methods -------------------------
	
	public Collection<Gym> findAll(){
		Collection<Gym> result;
		
		Assert.notNull(this.gymRepository);
		result=this.gymRepository.findAll();
		Assert.notNull(result);
		
		return result;
	}
	
	public Gym findOne(final int gymId) {
		Gym result;
		
		result=this.gymRepository.findOne(gymId);
		
		return result;
	}
	
	public Gym create(Manager manager) {
		Gym result;
		
		result = new Gym();
		
		result.setManager(manager);
		
		return result;
	}
	
	public Gym save(Gym gym) {
		Assert.notNull(gym);
		
		Gym result;
		
		result = gymRepository.save(gym);
		
		return result;
	}
	
	public void delete (Gym gym) {
		Assert.notNull(gym);
		
		Assert.isTrue(gym.getId() != 0);
		
		gym.setActive(false);
		
		save(gym);
	}
	
	//Other business methods ----------------------
	public Collection<Gym> findByManager(){
		Collection<Gym> result;
		Manager manager;
		
		manager = this.managerService.findByPrincipal();
		Assert.notNull(manager);
		result = this.gymRepository.findByManager(manager.getUserAccount().getId());
		
		return result;
	}
	
	public Collection<Gym> findByTrainer(){
		Collection<Gym> result;
		Trainer trainer;
		
		trainer = this.trainerService.findByPrincipal();
		Assert.notNull(trainer);
		result = this.gymRepository.findByTrainer(trainer.getUserAccount().getId());
		
		return result;
	}
	
	public Collection<Gym> findByCustomer(){
		Collection<Gym> result;
		Customer customer;
		
		customer = this.customerService.findByPrincipal();
		Assert.notNull(customer);
		result = this.gymRepository.findByCustomer(customer.getUserAccount().getId());
		
		return result;
	}

}
