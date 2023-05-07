package services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import domain.Activity;
import domain.Manager;
import repositories.ActivityRepository;

@Service
@Transactional
public class ActivityService {
	
	// Managed repository -------------------------
	
	@Autowired
	private ActivityRepository activityRepository;
	
	// Supporting services ------------------------
	@Autowired
	private ManagerService managerService;
	// Constructor --------------------------------
	
	public ActivityService() {
		super();
	}
	
	//Simple CRUD methods -------------------------
	
	//LAS ACTIVIDADES NO SE PUEDEN CREAR NI BORRAR
	
	public Collection<Activity> findAll(){
		Collection<Activity> result;
		
		Assert.notNull(this.activityRepository);
		result=this.activityRepository.findAll();
		Assert.notNull(result);
		
		return result;
	}
	
	public Activity findOne(final int activityId) {
		Activity result;
		
		result=this.activityRepository.findOne(activityId);
		
		return result;
	}
	
	//Other business methods ----------------------
	//HABRIA QUE CREAR UNO QUE SEA MOSTRAR TODAS LAS ACTIVIDADES A LAS QUE SE PUEDA APUNTAR UN CUSTOMER
	
	public Collection<Activity> findByManager(){
		Collection<Activity> result;
		Manager manager;
		
		manager = this.managerService.findByPrincipal();
		Assert.notNull(manager);
		result = this.activityRepository.findByManagerId(manager.getId());
		
		return result;
	}
	
	public Collection<Activity> findAllActive(){
		Collection<Activity> result;
		
		result=this.activityRepository.findAllActive();
		Assert.notNull(result);
		
		return result;
	}

}
