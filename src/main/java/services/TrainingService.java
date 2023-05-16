package services;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import domain.Activity;
import domain.Customer;
import domain.Gym;
import domain.Manager;
import domain.Training;
import repositories.TrainingRepository;

@Service
@Transactional
public class TrainingService {
	// Managed repository -------------------------
	
	@Autowired
	private TrainingRepository trainingRepository;
	
	// Supporting services ------------------------
	@Autowired
	private CustomerService customerService;
	@Autowired
	private ManagerService managerService;
	
	
	// Constructor --------------------------------
	
	public TrainingService() {
		super();
	}
	
	//Simple CRUD methods -------------------------
	
	public Collection<Training> findAll(){
		Collection<Training> result;
		
		Assert.notNull(this.trainingRepository);
		result=this.trainingRepository.findAll();
		Assert.notNull(result);
		
		return result;
	}
	
	public Training findOne(final int trainingId) {
		Training result;
		
		result=this.trainingRepository.findOne(trainingId);
		
		return result;
	}
	
	public Training create() {
		Training result;
		
		result = new Training();
		
		return result;
	}
	
	public Training save(Training training) {
		Assert.notNull(training);
		
		Training result;
		
		result = trainingRepository.save(training);
		
		return result;
	}
	
	public void delete (Training training) {
		Assert.notNull(training);
		
		Assert.isTrue(training.getId() != 0);
		
		trainingRepository.delete(training);
	}


	
	//Other business methods ----------------------
	
	public Collection<Training> findByCustomer(){
		Collection<Training> result;
		Customer customer;
		
		customer = this.customerService.findByPrincipal();
		Assert.notNull(customer);
		result = this.trainingRepository.findByCustomerId(customer.getUserAccount().getId());
		
		return result;
	}
	
	public Collection<Training> findByManager(){
		Collection<Training> result;
		Manager manager;
		
		manager = this.managerService.findByPrincipal();
		Assert.notNull(manager);
		result = this.trainingRepository.findByManagerId(manager.getUserAccount().getId());
		
		return result;
	}
	
	public Collection<Training> findByGym(int gymId){
		Collection<Training> result;
		
		result = this.trainingRepository.findByGymId(gymId);
		
		return result;
	}

	public Collection<Training> findTrainerByKeyWord(String keyWord) {
		Collection<Training> result;
		
		Assert.notNull(keyWord);
		result = this.trainingRepository.findTrainerByKeyWord(keyWord);
		
		return result;
	}
	
	public Collection<Training> findToAdd(int gymId){
		Collection<Training> result=this.findAll();
		Collection<Training> gym=this.findByGym(gymId);
		result.removeAll(gym);
		return result;
	}
}
