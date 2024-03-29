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
import domain.Gym;
import domain.Manager;
import services.GymService;
import services.ManagerService;

@Controller
@RequestMapping("/gym/manager")
public class GymManagerController extends AbstractController {
	// Services ---------------------------------------------------------------
	@Autowired
	private GymService gymService;
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
	

	
	
	

	
	
	
	
	// Activate ----------------------------------------------------------------
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