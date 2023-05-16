package controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import domain.Annotation;
import services.AnnotationService;

@Controller
@RequestMapping("/annotation")
public class AnnotationController {
	// Services ---------------------------------------------------------------
		@Autowired
		private AnnotationService annotationService;
		
		// Listing ----------------------------------------------------------------
		@RequestMapping(value = "/list", method = RequestMethod.GET)
		public ModelAndView list() {
			ModelAndView result;
			Collection<Annotation> annotations;
			
			annotations = this.annotationService.findAll();
			result = new ModelAndView("annotation/list");
			result.addObject("requestURI", "annotation/list.do");
			result.addObject("annotations",annotations);
			return result;
		}
		
		@RequestMapping(value = "/listActivity", method = RequestMethod.GET)
		public ModelAndView listActivity(@RequestParam int activityId) {
			ModelAndView result;
			Collection<Annotation> annotations;
			
			annotations = this.annotationService.findByActivity(activityId);
			result = new ModelAndView("annotation/list");
			result.addObject("requestURI", "annotation/list.do");
			result.addObject("annotations",annotations);
			return result;
		}
		
		@RequestMapping(value = "/listGym", method = RequestMethod.GET)
		public ModelAndView listGym(@RequestParam int gymId) {
			ModelAndView result;
			Collection<Annotation> annotations;
			
			annotations = this.annotationService.findByGym(gymId);
			result = new ModelAndView("annotation/list");
			result.addObject("requestURI", "annotation/list.do");
			result.addObject("annotations",annotations);
			return result;
		}
		
		@RequestMapping(value = "/listTraining", method = RequestMethod.GET)
		public ModelAndView listTraining(@RequestParam int trainingId) {
			ModelAndView result;
			Collection<Annotation> annotations;
			
			annotations = this.annotationService.findByTraining(trainingId);
			result = new ModelAndView("annotation/list");
			result.addObject("requestURI", "annotation/list.do");
			result.addObject("annotations",annotations);
			return result;
		}
	
}