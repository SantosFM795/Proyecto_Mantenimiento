package controllers;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import domain.Activity;
import domain.Annotation;
import services.ActivityService;
import services.AnnotationService;

@Controller
@RequestMapping("/annotation")
public class AnnotationController {
	// Services ---------------------------------------------------------------
		@Autowired
		private AnnotationService annotationService;
		private ActivityService activityService;
		private Integer activityId;
		
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
		@RequestMapping(value = "/createByActivity", method = RequestMethod.GET)
		public ModelAndView create(@RequestParam int activityId) {
			ModelAndView result;
			Annotation annotation;
			this.activityId = activityId;
			annotation = this.annotationService.create();
			result = new ModelAndView("annotation/edit");
			result.addObject("annotation", annotation);
			result.addObject("requestURI", "annotation/edit.do");
			return result;
		}

		@RequestMapping(value = "/create", method = RequestMethod.POST, params = "save")
		public ModelAndView saveActivity(@Valid Annotation annotation, final BindingResult binding) {
			ModelAndView result;
			if (binding.hasErrors()) {
				result = new ModelAndView("annotation/edit");
			}
			else {
				try {
					annotation.setActivity(activityService.findOne(activityId));	
					annotation.setGym(null);
					annotation.setTraining(null);
					annotation = annotationService.save(annotation);
					Activity a = annotation.getActivity();
					Collection<Annotation> tmp = a.getAnnotations();
					tmp.add(annotation);
					a.setAnnotations(tmp);
					activityService.save(a);
					result =  new ModelAndView("redirect:/activity/customer/list.do");
				} catch (final Throwable oopxs) {
					result = this.createEditModelAndView(annotation, "annotation.commit.error");
				}

			}

			return result;

		}

		// Ancillary methods ------------------------------------------------------

		protected ModelAndView createEditModelAndView(final Annotation annotation) {
			ModelAndView result;

			result = this.createEditModelAndView(annotation, null);

			return result;
		}

		protected ModelAndView createEditModelAndView(final Annotation annotation, final String message) {
			ModelAndView result;
			result = new ModelAndView("annotation/edit");
			result.addObject("annotation", annotation);
			result.addObject("message", message);
			return result;
		}

	
}