package controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import domain.Step;
import services.StepService;

@Controller
@RequestMapping("/step")
public class StepController {
	// Services ---------------------------------------------------------------
		@Autowired
		private StepService stepService;
		
		// Listing ----------------------------------------------------------------
		@RequestMapping(value = "/list", method = RequestMethod.GET)
		public ModelAndView list(@RequestParam  int trainingId) {
			ModelAndView result;
			Collection<Step> steps;
			
			steps = this.stepService.findByTraining(trainingId);
			result = new ModelAndView("step/list");
			result.addObject("requestURI", "step/list.do");
			result.addObject("steps",steps);
			return result;
		}
	

}
