package services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import domain.Gym;
import repositories.GymRepository;
import security.LoginService;

@Service
@Transactional
public class GymService {

	// Managed repository -------------------------
	
	@Autowired
	private GymRepository gymRepository;
	
	// Supporting services ------------------------
	
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
	//siempre el id del userAccount
	public Collection<Gym> findByManager(int managerId){
		Assert.isTrue(managerId != 0);
		
		Collection<Gym> result;
		
		result=gymRepository.findByManager(managerId);
		
		return result;
		
	}
	
	public Collection<Gym> findByTrainer(int trainerId){
		Assert.isTrue(trainerId != 0);
		
		Collection<Gym> result;
		
		result=gymRepository.findByTrainer(trainerId);
		
		return result;
		
	}
	
	public Collection<Gym> findByCustomer(int customerId){
		Assert.isTrue(customerId != 0);
		
		Collection<Gym> result;
		
		result=gymRepository.findByCustomer(customerId);
		
		return result;
		
	}
}
