package controllers.manager;

import java.util.Collection;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import controllers.AbstractController;
import domain.Activity;
import domain.Gym;
import domain.Training;
import domain.Manager;
import services.ActivityService;
import services.GymService;
import services.ManagerService;
import services.TrainingService;

@Controller
@RequestMapping("/gym/manager")
public class GymManagerController extends AbstractController {
	// Services ---------------------------------------------------------------
	@Autowired
	private GymService gymService;
	@Autowired
	private ActivityService activityService;
	@Autowired
	private TrainingService trainingService;
	@Autowired
	private ManagerService managerService;
	// Constructors -----------------------------------------------------------
	public GymManagerController() {
		super();
	}
	// Listing ----------------------------------------------------------------
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView result;
		Collection<Gym> gyms;
		
		gyms = this.gymService.findByManager();
		result = new ModelAndView("gym/list");
		result.addObject("requestURI", "gym/manager/list.do");
		result.addObject("gyms",gyms);
		return result;
	}
	// Creation ---------------------------------------------------------------
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView create() {
		ModelAndView result;
		Gym gym;
		Manager manager=managerService.findByPrincipal();
		gym = this.gymService.create(manager);
		result = this.createEditModelAndView(gym);
		return result;
	}
	// Edition ----------------------------------------------------------------
	@RequestMapping(value="/edit",method = RequestMethod.GET)
	public ModelAndView edit(@RequestParam int gymId) {
		ModelAndView result;
		Gym gym;
		
		gym = gymService.findOne(gymId);
		Assert.notNull(gym);
		result = createEditModelAndView(gym);
		return result;
	}
	// Save
	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "save")
	public ModelAndView save(@Valid final Gym gym, final BindingResult binding) {
		ModelAndView result;

		if (binding.hasErrors())
			result = this.createEditModelAndView(gym);
		else
			try {
				this.gymService.save(gym);
				result = new ModelAndView("redirect:list.do");
			} catch (final Throwable oops) {
				result = this.createEditModelAndView(gym, "gym.commit.error");
			}

		return result;
	}
	

	// Delete, los gimnasios no se eliminan realmente, algo habr� que tocar en alg�n lado
	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "delete")
	public ModelAndView delete(final Gym gym, final BindingResult binding) {
		ModelAndView result;

		try {
			this.gymService.delete(gym);
			result = new ModelAndView("redirect:list.do");
		} catch (final Throwable oops) {
			result = this.createEditModelAndView(gym, "gym.commit.error");
		}

		return result;
	}
	//Add an Activity
	@RequestMapping(value="/addActivity",method = RequestMethod.GET)
	public ModelAndView addActivity(@RequestParam int gymId) {
		ModelAndView result;
		Gym gym;
		Collection<Activity> activities;
		
		gym = gymService.findOne(gymId);
		Assert.notNull(gym);
		
		activities=activityService.findAll();
		result = new ModelAndView("gym/addActivity");
		result.addObject("gym", gym);
		result.addObject("activity", activities);
		result.addObject("requestURI", "gym/manager/addActivity.do");
		return result;
	}
	
	@RequestMapping(value="/addTraining",method = RequestMethod.GET)
	public ModelAndView addTraining(@RequestParam int gymId) {
		ModelAndView result;
		Gym gym;
		Collection<Training> training;
		
		gym = gymService.findOne(gymId);
		Assert.notNull(gym);
		
		training=trainingService.findAll();
		result = new ModelAndView("gym/addTraining");
		result.addObject("gym", gym);
		result.addObject("training", training);
		result.addObject("requestURI", "gym/manager/addTraining.do");
		return result;
	}
	
	// Banning ----------------------------------------------------------------
		@RequestMapping(value = "/activate", method = RequestMethod.GET)
		public ModelAndView activateGym(@RequestParam int gymId) {
			ModelAndView result;
			try {
				this.gymService.activate(gymId);
				result=this.list();
				result.addObject("message", "manager.commit.ok");
			}catch(final Throwable oops) {
				result=this.list();
				result.addObject("message", "manager.commit.error");
			}
			
			
			
			return result;
		}
		
		@RequestMapping(value = "/desactivate", method = RequestMethod.GET)
		public ModelAndView desactivateGym(@RequestParam int gymId) {
			ModelAndView result;
			try {
				this.gymService.desactivate(gymId);
				result=this.list();
				result.addObject("message", "manager.commit.ok");
			}catch(final Throwable oops) {
				result=this.list();
				result.addObject("message", "manager.commit.error");
			}
			
			
			
			return result;
		}
	// Ancillary methods ------------------------------------------------------
	
	protected ModelAndView createEditModelAndView(final Gym gym) {
		ModelAndView result;

		result = this.createEditModelAndView(gym, null);

		return result;
	}
	
	protected ModelAndView createEditModelAndView(Gym gym, final String message) {
		//dir�a que aqu� con esto sirve. El manager desde aqu� no puede a�adirle actividades, eso
		//creo yo que se hace en la propia actividades, lo mismo con training
		
		ModelAndView result;
		result = new ModelAndView("gym/edit");
		result.addObject("gym",gym);
		result.addObject("message",message);
		result.addObject("requestURI","gym/manager/edit.do");
		return result;
	}
}