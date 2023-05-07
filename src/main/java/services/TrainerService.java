package services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import domain.Trainer;
import repositories.TrainerRepository;
import security.LoginService;
import security.UserAccount;

public class TrainerService {

	// Managed repository -------------------------
	
	@Autowired
	private TrainerRepository trainerRepository;
	
	// Supporting services ------------------------
	
	// Constructor --------------------------------
	
	public TrainerService() {
		super();
	}
	
	//Simple CRUD methods -------------------------
	
	public Collection<Trainer> findAll(){
		Collection<Trainer> result;
		
		Assert.notNull(this.trainerRepository);
		result=this.trainerRepository.findAll();
		Assert.notNull(result);
		
		return result;
	}
	
	public Trainer findOne(final int trainerId) {
		Trainer result;
		
		result=this.trainerRepository.findOne(trainerId);
		
		return result;
	}
	
	
	//Other business methods ----------------------
	
	
	public Trainer findByPrincipal() {
		Trainer result;
		UserAccount userAccount;
		
		userAccount= LoginService.getPrincipal();
		Assert.notNull(userAccount);
		result = findByUserAccount(userAccount);
		Assert.notNull(result);
		
		return result;
	}
	
	public Trainer findByUserAccount(UserAccount userAccount) {
		Assert.notNull(userAccount);
		
		Trainer result;
		
		result = trainerRepository.findByUserAccountId(userAccount.getId());
		
		return result;
		
		
	}
}
