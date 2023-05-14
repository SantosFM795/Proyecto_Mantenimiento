package controllers.customer;

import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import controllers.AbstractController;
import domain.Activity;
import domain.Annotation;
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
		result.addObject("activities", activities);
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