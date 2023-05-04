package services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import domain.Gym;
import repositories.GymRepository;

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
		
		//Other business methods ----------------------
}
