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
@RequestMapping("/Activity/manager")
public class ActivityManagerController extends AbstractController {
	// Services ---------------------------------------------------------------
	@Autowired
	private ActivityService ActivityService;
	// Constructors -----------------------------------------------------------
	public ActivityManagerController() {
		super();
	}
	// Listing ----------------------------------------------------------------
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView result;
		Collection<Activity> Activitys;
		
		Activitys = this.ActivityService.findAll();
		result = new ModelAndView("Activity/list");
		result.addObject("requestURI", "Activity/manager/list.do");
		result.addObject("Activitys",Activitys);
		return result;
	}
	// Creation ---------------------------------------------------------------
	// Edition ----------------------------------------------------------------
	// Save
	// Delete
	// Ancillary methods ------------------------------------------------------

		protected ModelAndView createEditModelAndView(final Activity Activity) {
			ModelAndView result;

			result = this.createEditModelAndView(Activity, null);

			return result;
		}
	protected ModelAndView createEditModelAndView(Activity Activity, final String message) {
		ModelAndView result;
		result = new ModelAndView("Activity/edit");
		result.addObject("Activity",Activity);
		result.addObject("message",message);
		return result;
	}
}
