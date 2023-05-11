package controllers.administrator;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import controllers.AbstractController;
import domain.Manager;
import services.ManagerService;

@Controller
@RequestMapping("/manager/administrator")
public class ManagerAdministratorController extends AbstractController {
	// Services ---------------------------------------------------------------
	@Autowired
	private ManagerService managerService;
	// Constructors -----------------------------------------------------------
	public ManagerAdministratorController() {
		super();
	}
	// Listing ----------------------------------------------------------------
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView result;
		Collection<Manager> managers;
		
		managers = this.managerService.findAll();
		result = new ModelAndView("manager/list");
		result.addObject("requestURI", "manager/administrator/list.do");
		result.addObject("managers",managers);
		return result;
	}
	
	// Banning ----------------------------------------------------------------
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView banManager(@RequestParam int managerId) {
		ModelAndView result;
		Manager manager;
		
		manager = this.managerService.findOne(managerId);
		result = new ModelAndView("manager/edit");
		result.addObject("requestURI", "manager/administrator/edit.do");
		result.addObject("manager",manager);
		return result;
	}
	
	// Create ----------------------------------------------------------------
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView create() {
		ModelAndView result;
		Manager manager;
		
		manager = this.managerService.create();
		result = createEditModelAndView(manager);
		return result;
	}
	
	// Save ----------------------------------------------------------------
	@RequestMapping(value = "/edit", method = RequestMethod.POST, params="save")
	public ModelAndView save(@Valid Manager manager, BindingResult binding) {
		ModelAndView result;
		
		if(binding.hasErrors()) {
			result = createEditModelAndView(manager);
		}else {
			try {
				managerService.save(manager);
				result = new ModelAndView("redirect:list.do");
			}catch(Throwable oops) {
				result = createEditModelAndView(manager,"manager.commit.error");
			}
		}
		return result;
	}
	
	
	//Ancillary method--------------------------------------------------------
	
	protected ModelAndView createEditModelAndView(Manager manager) {
		ModelAndView result;
		
		result = this.createEditModelAndView(manager,null);
		
		return result;
	}
	protected ModelAndView createEditModelAndView(Manager manager, String message) {
		ModelAndView result;
		
		result=new ModelAndView("manager/edit");
		result.addObject("manager", manager);
		result.addObject("message", message);
		result.addObject("requestURI", "manager/administrator/edit.do");
		
		return result;
	}
}