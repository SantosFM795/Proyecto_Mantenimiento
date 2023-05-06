package services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import domain.Manager;
import repositories.ManagerRepository;

@Service
@Transactional
public class ManagerService {
	
	// Managed repository -------------------------
	
		@Autowired
		private ManagerRepository managerRepository;
		
		// Supporting services ------------------------
		
		// Constructor --------------------------------
		
		public ManagerService() {
			super();
		}
		
		//Simple CRUD methods -------------------------
		
		public Collection<Manager> findAll(){
			Collection<Manager> result;
			
			Assert.notNull(this.managerRepository);
			result=this.managerRepository.findAll();
			Assert.notNull(result);
			
			return result;
		}
		
		public Manager findOne(final int managerId) {
			Manager result;
			
			result=this.managerRepository.findOne(managerId);
			
			return result;
		}
		
		public Manager create() {
			Manager result;
			
			result = new Manager();
			
			return result;
		}
		
		public Manager save(Manager manager) {
			Assert.notNull(manager);
			
			Manager result;
			
			result = managerRepository.save(manager);
			
			return result;
		}
		
}
