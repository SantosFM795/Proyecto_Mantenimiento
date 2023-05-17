package controllers.customer;

import java.util.ArrayList;
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
import domain.Activity;
import domain.Annotation;
import forms.Search;
import services.ActivityService;
import services.CustomerService;

@Controller
@RequestMapping("/activity/customer")
public class ActivityCustomerController extends AbstractController {
	// Services ---------------------------------------------------------------
	@Autowired
	private ActivityService activityService;
	
	@Autowired
	private CustomerService customerService;

	// Constructors -----------------------------------------------------------
	public ActivityCustomerController() {
		super();
	}

	// Listing ----------------------------------------------------------------
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView result;
		Collection<Activity> activities;
		int customerId=customerService.findByPrincipal().getId();
		int aux=0;
		activities = this.activityService.findByCustomerJoin();
		result = new ModelAndView("activity/list");
		result.addObject("requestURI", "activity/customer/list.do");
		result.addObject("activities", activities);
		result.addObject("customerId", customerId);
		result.addObject("aux", aux);
		
		return result;
	}
	// Search by Key word
	// ----------------------------------------------------------------
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ModelAndView search() {
		ModelAndView result;
		Collection<Activity> activities = new ArrayList<Activity>();

		result = new ModelAndView("activity/search");
		result.addObject("search", new Search());
		result.addObject("activities", activities);
		result.addObject("requestURI", "activity/search.do");

		return result;

	}
	@RequestMapping(value = "/search", method = RequestMethod.POST, params = "search")
	public ModelAndView listKeyWord(@Valid final Search search, final BindingResult binding) {
		ModelAndView result;
		 String keyword = search.getKeyWord().replace(",","");
		Collection<Activity> activities;
		if (binding.hasErrors())
			result = this.createEditModelAndView(search);
		else
			try {
				activities = this.activityService.findTrainerByKeyWord(keyword);
				result = new ModelAndView("activity/list");
				result.addObject("requestURI", "activity/customer/list.do");
				result.addObject("activities", activities);
			} catch (final Throwable oops) {
				result = this.createEditModelAndView(search, "search.commit.error");
			}

		return result;

	}
	
	//Quit
	@RequestMapping(value = "/quit", method = RequestMethod.GET)
	public ModelAndView quit(@RequestParam int activityId, int customerId) {
		ModelAndView result;
		this.activityService.quit(activityId,customerId);

		
		result=this.list();

		return result;

	}

	// Ancillary methods ------------------------------------------------------

	protected ModelAndView createEditModelAndView(final Search search) {
		ModelAndView result;

		result = this.createEditModelAndView(search, null);

		return result;
	}

	protected ModelAndView createEditModelAndView(final Search search, final String message) {
		ModelAndView result;
		result = new ModelAndView("activity/search");
		result.addObject("search", search);
		result.addObject("message", message);
		return result;
	}
}