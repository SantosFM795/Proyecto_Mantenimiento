package controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import domain.Activity;
import domain.Gym;
import services.GymService;

@Controller
@RequestMapping("/gym")
public class GymController {
	// Services ---------------------------------------------------------------
		@Autowired
		private GymService gymService;
		
		// Listing ----------------------------------------------------------------
		@RequestMapping(value = "/list", method = RequestMethod.GET)
		public ModelAndView list() {
			ModelAndView result;
			Collection<Gym> gyms;
			
			gyms = this.gymService.findAll();
			result = new ModelAndView("gym/list");
			result.addObject("requestURI", "gym/list.do");
			result.addObject("gyms",gyms);
			return result;
		}
	

}
