package services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import domain.Activity;
import domain.CV;
import domain.Manager;
import domain.Trainer;
import repositories.TrainerRepository;
import security.LoginService;
import security.UserAccount;

@Service
@Transactional
public class TrainerService {

	// Managed repository -------------------------
	
	@Autowired
	private TrainerRepository trainerRepository;
	
	// Supporting services ------------------------
	@Autowired
	private ManagerService managerService;
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
	
	public Trainer create() {
		Trainer result;
		
		result = new Trainer();
		CV cv;
		cv= new CV();
		result.setCurriculum(cv);
		UserAccount uc=new UserAccount();
		uc.setUsername("betis");
		uc.setUsername("1b3231655cebb7a1f783eddf27d254ca");
		
		return result;
	}
	
	public Trainer save(Trainer trainer) {
		Assert.notNull(trainer);
		
		Trainer result;
		
		result = trainerRepository.save(trainer);
		
		return result;
	}
	
	public void delete (Trainer trainer) {
		Assert.notNull(trainer);
		
		Assert.isTrue(trainer.getId() != 0);
		
		trainerRepository.delete(trainer);
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

	public Collection<Trainer> findByManager() {
		Collection<Trainer> result;
		Manager manager;
		
		manager = this.managerService.findByPrincipal();
		Assert.notNull(manager);
		result = this.trainerRepository.findByManagerId(manager.getUserAccount().getId());
		
		return result;
	}

	
	public Collection<Trainer> findTrainerByKeyWord(String name){
		Collection<Trainer> result;
		
		Assert.notNull(name);
		result = this.trainerRepository.findTrainerByKeyWord(name);
		
		return result;
	}
	
	public Collection<Trainer> findToAdd(int gymId){
		Collection<Trainer> result=this.findAll();
		Collection<Trainer> gym=trainerRepository.findByGymId(gymId);
		result.removeAll(gym);
		return result;
	}

	public Collection<Trainer> findToAddActivity(int activityId) {
		Collection<Trainer> result=this.findAll();
		Collection<Trainer> gym=trainerRepository.findByActivityId(activityId);
		result.removeAll(gym);
		return result;
	}

	public Collection<Trainer> findByActivity(int activityId) {
		Collection<Trainer> result;
		
		
		Assert.notNull(activityId);
		result = this.trainerRepository.findByActivityId(activityId);
		
		return result;
	}
	
	public Collection<Object[]> findSocialIdentitiesTrainer(){
		Collection<Object[]> result;
		
		result = this.trainerRepository.findSocialIdentitiesTrainer();
		return result;
	}
	
}
