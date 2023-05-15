package controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
}