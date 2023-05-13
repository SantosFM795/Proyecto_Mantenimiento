package controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import domain.Training;
import services.TrainingService;

@Controller
@RequestMapping("/training")
public class TrainingController {
	// Services ---------------------------------------------------------------
		@Autowired
		private TrainingService trainingService;
		
		// Listing ----------------------------------------------------------------
		@RequestMapping(value = "/list", method = RequestMethod.GET)
		public ModelAndView list() {
			ModelAndView result;
			Collection<Training> trainings;
			
			trainings = this.trainingService.findAll();
			result = new ModelAndView("training/list");
			result.addObject("requestURI", "training/list.do");
			result.addObject("trainings",trainings);
			return result;
		}

}