package controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import domain.CV;
import services.CVService;

@Controller
@RequestMapping("/cv")
public class CVController {
	// Services ---------------------------------------------------------------
		@Autowired
		private CVService cvService;
		
		// Listing ----------------------------------------------------------------
		@RequestMapping(value = "/list", method = RequestMethod.GET)
		public ModelAndView list(@RequestParam int trainerId) {
			ModelAndView result;
			CV cv;
			
			cv = this.cvService.findByTrainer(trainerId);
			result = new ModelAndView("cv/list");
			result.addObject("requestURI", "cv/list.do");
			result.addObject("cv",cv);
			return result;
		}
	
}
