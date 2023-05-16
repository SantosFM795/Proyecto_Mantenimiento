package services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import domain.Activity;
import domain.Annotation;
import domain.Step;
import repositories.StepRepository;



@Service
@Transactional
public class StepService {
	// Managed repository -------------------------
	
		@Autowired
		private StepRepository stepRepository;
		
		// Supporting services ------------------------
		
		// Constructor --------------------------------
		
		public StepService() {
			super();
		}
		
		//Simple CRUD methods -------------------------
		
	
		
		public Step findOne(final int stepId) {
			Step result;
			
			result=this.stepRepository.findOne(stepId);
			
			return result;
		}
		
		public Step create() {
			Step result;
			
			result = new Step();
			
			return result;
		}
		
		public void delete (Step step) {
			Assert.notNull(step);
			
			Assert.isTrue(step.getId() != 0);
			
			stepRepository.delete(step);
		}
		
		public Collection<Step> findByTraining(int trainingId){
			Assert.isTrue(trainingId != 0);
			Collection<Step> result;
			
			result=this.stepRepository.findByTrainingId(trainingId);
			Assert.notNull(result);
			
			return result;
		}
		
		public Collection<Object[]> findStepsByTraining(){
			Collection<Object[]> result;
			
			result = this.stepRepository.findStepsByTraining();
			return result;
		}
}
