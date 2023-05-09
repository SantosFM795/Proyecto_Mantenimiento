package controllers.manager;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import controllers.AbstractController;
import domain.Activity;
import services.ActivityService;


// Se puede dar de alta, listar y cancelar actividades

@Controller
@RequestMapping("/activity/manager")
public class ActivityManagerController extends AbstractController {
	// Services ---------------------------------------------------------------
	@Autowired
	private ActivityService activityService;
	// Constructors -----------------------------------------------------------
	public ActivityManagerController() {
		super();
	}
	// Listing ----------------------------------------------------------------
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView result;
		Collection<Activity> activities;
		
		activities = this.activityService.findByManager();
		result = new ModelAndView("activity/list");
		result.addObject("requestURI", "activity/manager/list.do");
		result.addObject("activities",activities);
		return result;
	}
	// Creation ---------------------------------------------------------------
	// Edition ----------------------------------------------------------------
	// Save
	// Delete
	// Ancillary methods ------------------------------------------------------

		protected ModelAndView createEditModelAndView(final Activity activity) {
			ModelAndView result;

			result = this.createEditModelAndView(activity, null);

			return result;
		}
	protected ModelAndView createEditModelAndView(Activity activity, final String message) {
		ModelAndView result;
		result = new ModelAndView("activity/edit");
		result.addObject("activity",activity);
		result.addObject("message",message);
		return result;
	}
}
