package services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import domain.CV;
import repositories.CVRepository;

@Service
@Transactional
public class CVService {
	
	// Managed repository -------------------------
	
		@Autowired
		private CVRepository cvRepository;
		
		// Supporting services ------------------------
		
		// Constructor --------------------------------
		
		public CVService() {
			super();
		}
		
		//Simple CRUD methods -------------------------
		
		public CV save(CV cv) {
			Assert.notNull(cv);
			
			CV result;
			
			result=cvRepository.save(cv);
			
			return result;
		}
		
		//LAS ACTIVIDADES NO SE PUEDEN CREAR NI BORRAR
		
		public Collection<CV> findAll(){
			Collection<CV> result;
			
			Assert.notNull(this.cvRepository);
			result=this.cvRepository.findAll();
			Assert.notNull(result);
			
			return result;
		}
		
		
		//Other business methods ----------------------
		
		public CV findByTrainer (int trainerId) {
			Assert.isTrue(trainerId != 0);
			
			CV result;
			
			result=cvRepository.findByTrainerId(trainerId);
			
			return result;
		}

}
