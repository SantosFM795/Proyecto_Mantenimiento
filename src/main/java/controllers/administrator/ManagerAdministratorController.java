package controllers.administrator;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	private ManagerService ManagerService;
	// Constructors -----------------------------------------------------------
	public ManagerAdministratorController() {
		super();
	}
	// Listing ----------------------------------------------------------------
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView result;
		Collection<Manager> managers;
		
		managers = this.ManagerService.findAll();
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
		
		manager = this.ManagerService.findOne(managerId);
		result = new ModelAndView("manager/edit");
		result.addObject("requestURI", "manager/administrator/edit.do");
		result.addObject("manager",manager);
		return result;
	}
}