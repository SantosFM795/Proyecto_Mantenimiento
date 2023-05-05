package services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import domain.Training;
import repositories.TrainingRepository;

@Service
@Transactional
public class TrainingService {
	// Managed repository -------------------------
	
	@Autowired
	private TrainingRepository trainingRepository;
	
	// Supporting services ------------------------
	
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
}
