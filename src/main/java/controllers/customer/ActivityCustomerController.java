package controllers.customer;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import controllers.AbstractController;
import domain.Activity;
import forms.Search;
import services.ActivityService;

@Controller
@RequestMapping("/activity/customer")
public class ActivityCustomerController extends AbstractController {
	// Services ---------------------------------------------------------------
	@Autowired
	private ActivityService activityService;
	// Constructors -----------------------------------------------------------
	public ActivityCustomerController() {
		super();
	}
	// Listing ----------------------------------------------------------------
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView result;
		Collection<Activity> activities;
		
		activities = this.activityService.findByCustomer();
		result = new ModelAndView("activity/list");
		result.addObject("requestURI", "activity/customer/list.do");
		result.addObject("activities",activities);
		return result;
	}
	// Search by Key word ----------------------------------------------------------------
			@RequestMapping(value = "/search", method = RequestMethod.GET)
			public ModelAndView listKeyWord() {
				ModelAndView result;
				Search search;
				search = new Search();
				Collection<Activity> activities;
				
				activities = this.activityService.findTrainerByKeyWord(search.getKeyWord());
				result = new ModelAndView("activity/list");
				result.addObject("requestURI", "activity/customer/list.do");
				result.addObject("activities",activities);
				return result;
			}
}