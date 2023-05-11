package services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

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
}
