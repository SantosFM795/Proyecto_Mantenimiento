package controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import domain.Activity;

import services.ActivityService;


@Controller
@RequestMapping("/activity")
public class ActivityController {
	// Services ---------------------------------------------------------------
		@Autowired
		private ActivityService activityService;
		
		// Listing ----------------------------------------------------------------
		@RequestMapping(value = "/list", method = RequestMethod.GET)
		public ModelAndView list() {
			ModelAndView result;
			Collection<Activity> activities;
			
			activities = this.activityService.findAll();
			result = new ModelAndView("activity/list");
			result.addObject("requestURI", "activity/list.do");
			result.addObject("activities",activities);
			return result;
		}

}