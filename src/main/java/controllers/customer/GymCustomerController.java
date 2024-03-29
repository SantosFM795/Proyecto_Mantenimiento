package controllers.customer;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import controllers.AbstractController;
import domain.Gym;
import services.CustomerService;
import services.GymService;


@Controller
@RequestMapping("/gym/customer")
public class GymCustomerController extends AbstractController {
	// Services ---------------------------------------------------------------
	@Autowired
	private GymService gymService;
	@Autowired
	private CustomerService customerService;
	// Constructors -----------------------------------------------------------
	public GymCustomerController() {
		super();
	}
	// Listing ----------------------------------------------------------------
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView result;
		Collection<Gym> gyms;
		int aux=0;
		gyms = this.gymService.findByCustomerJoined();
		result = new ModelAndView("gym/list");
		result.addObject("requestURI", "gym/customer/list.do");
		result.addObject("gyms",gyms);
		result.addObject("aux",aux);
		return result;
	}
	
	@RequestMapping(value = "/listToJoin", method = RequestMethod.GET)
	public ModelAndView listToJoin() {
		ModelAndView result;
		Collection<Gym> gyms;
		int aux=1;
		gyms = this.gymService.listToJoin();
		result = new ModelAndView("gym/list");
		result.addObject("requestURI", "gym/customer/list.do");
		result.addObject("gyms",gyms);
		result.addObject("aux",aux);
		return result;
	}
	
	
	//Quit
	@RequestMapping(value = "/quit", method = RequestMethod.GET)
	public ModelAndView quit(@RequestParam int gymId) {
		ModelAndView result;
		this.gymService.quit(gymId);

		
		result=this.list();

		return result;

	}
		
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public ModelAndView join(@RequestParam int gymId) {
			ModelAndView result;
			this.gymService.join(gymId);

			
			result=this.list();

			return result;

	}
}
