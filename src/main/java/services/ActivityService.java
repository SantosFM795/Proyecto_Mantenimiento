package services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import domain.Activity;
import domain.Customer;
import domain.Gym;
import domain.Manager;
import domain.Trainer;
import domain.Training;
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
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private TrainerService trainerService;
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
	
	public Activity create() {
		Activity result;
		
		result = new Activity();
		result.setCancelled(false);
		return result;
	}
	
	public Activity save(Activity activity) {
		Assert.notNull(activity);
		
		Activity result;
		
		result = activityRepository.save(activity);
		
		return result;
	}
	
	
	//Other business methods ----------------------
	//HABRIA QUE CREAR UNO QUE SEA MOSTRAR TODAS LAS ACTIVIDADES A LAS QUE SE PUEDA APUNTAR UN CUSTOMER
	//Solucionao, al final no hace falta, con que se muestren las actividades de un gimnasio basta
	//ya que lo unico que hay que hacer es obtener los gyms de un customer
	
	public Collection<Activity> findByManager(){
		Collection<Activity> result;
		Manager manager;
		
		manager = this.managerService.findByPrincipal();
		Assert.notNull(manager);
		result = this.activityRepository.findByManagerId(manager.getUserAccount().getId());
		
		return result;
	}
	
	public Collection<Activity> findAllActive(){
		Collection<Activity> result;
		
		result=this.activityRepository.findAllActive();
		Assert.notNull(result);
		
		return result;
	}
	
	public Collection<Activity> findByGym(int gymId){
		Assert.isTrue(gymId != 0);
		Collection<Activity> result;
		
		result=this.activityRepository.findByGymId(gymId);
		Assert.notNull(result);
		
		return result;
	}
	
	public Collection<Activity> findByCustomer(){
		Collection<Activity> result;
		Customer customer;
		
		customer = this.customerService.findByPrincipal();
		Assert.notNull(customer);
		result = this.activityRepository.findByCustomerId(customer.getUserAccount().getId());
		
		return result;
	}
	
	public Collection<Activity> findByCustomerJoin(){
		Collection<Activity> result;
		Customer customer;
		
		customer = this.customerService.findByPrincipal();
		Assert.notNull(customer);
		result = this.activityRepository.findByCustomerJoin(customer.getUserAccount().getId());
		
		return result;
	}

	public Collection<Activity> findTrainerByKeyWord(String keyWord) {
		Collection<Activity> result;
		
		Assert.notNull(keyWord);
		result = this.activityRepository.findTrainerByKeyWord(keyWord);
		
		return result;
	}

	public void activate(int activityId) {
		Activity activity;
		activity=this.findOne(activityId);
		Assert.notNull(activity);
		activity.setCancelled(false);
		activityRepository.save(activity);
		
	}

	public void desactivate(int activityId) {
		Activity activity;
		activity=this.findOne(activityId);
		Assert.notNull(activity);
		activity.setCancelled(true);
		activityRepository.save(activity);
		
	}
	
	public Collection<Activity> findToAdd(int gymId){
		Collection<Activity> result=this.findAll();
		Collection<Activity> gym=activityRepository.findForAllGym();
		result.removeAll(gym);
		return result;
	}

	public void addTrainer(int activityId, int trainerId) {
		Activity activity=this.findOne(activityId);
		Trainer trainer = trainerService.findOne(trainerId);
		
		activity.addTrainer(trainer);
		trainer.addActivity(activity);	
		
	}

	public void quit(int activityId, int customerId) {
		Activity activity=this.findOne(activityId);
		
		Customer customer=customerService.findOne(customerId);
		
		activity.quit(customer);
		
		customer.quit(activity);
		
	}
		
	

}