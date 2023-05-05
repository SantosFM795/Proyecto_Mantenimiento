package services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import domain.Annotation;
import repositories.AnnotationRepository;

@Service
@Transactional
public class AnnotationService {
	// Managed repository -------------------------
	
	@Autowired
	private AnnotationRepository annotationRepository;
	
	// Supporting services ------------------------
	
	// Constructor --------------------------------
	
	public AnnotationService() {
		super();
	}
	
	//Simple CRUD methods -------------------------
	
	public Collection<Annotation> findAll(){
		Collection<Annotation> result;
		
		Assert.notNull(this.annotationRepository);
		result=this.annotationRepository.findAll();
		Assert.notNull(result);
		
		return result;
	}
	
	public Annotation findOne(final int annotationId) {
		Annotation result;
		
		result=this.annotationRepository.findOne(annotationId);
		
		return result;
	}
	
	public Annotation create() {
		Annotation result;
		
		result = new Annotation();
		
		return result;
	}
	
	public void delete (Annotation annotation) {
		Assert.notNull(annotation);
		
		Assert.isTrue(annotation.getId() != 0);
		
		annotationRepository.delete(annotation);
	}
	
	//Other business methods ----------------------
	
	public Collection<Annotation> findByGym(int gymId){
		Assert.isTrue(gymId != 0);
		
		Collection<Annotation> result;
		
		result=annotationRepository.findByGymId(gymId);
		
		return result;
	}
	
	public Collection<Annotation> findByActivity(int activityId){
		Assert.isTrue(activityId != 0);
		
		Collection<Annotation> result;
		
		result=annotationRepository.findByActivityId(activityId);
		
		return result;
	}
	
	public Collection<Annotation> findByTraining(int trainingId){
		Assert.isTrue(trainingId != 0);
		
		Collection<Annotation> result;
		
		result=annotationRepository.findByTrainingId(trainingId);
		
		return result;
	}
}
