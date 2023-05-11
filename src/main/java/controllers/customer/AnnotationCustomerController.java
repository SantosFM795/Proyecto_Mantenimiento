/*
 * AnnotationCustomerController.java
 * 
 * Copyright (C) 2017 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the
 * TDG Licence, a copy of which you may download from
 * http://www.tdg-seville.info/License.html
 */

package controllers.customer;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import controllers.AbstractController;
import domain.Annotation;
import services.AnnotationService;

@Controller
@RequestMapping("/annotation/customer")
public class AnnotationCustomerController extends AbstractController {

	// Services ---------------------------------------------------------------

	@Autowired
	private AnnotationService annotationService;

	// Constructors -----------------------------------------------------------

	public  AnnotationCustomerController() {
		// TODO Auto-generated constructor stub
		super();
	}

	// Listing ----------------------------------------------------------------
	// Creation ---------------------------------------------------------------

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView create() {
		ModelAndView result;
		Annotation annotation;

		annotation = this.annotationService.create();
		result = this.createEditModelAndView(annotation);

		return result;
	}

	// Edition ----------------------------------------------------------------

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView edit(@RequestParam final int annotationId) {
		ModelAndView result;
		Annotation annotation;

		annotation = this.annotationService.findOne(annotationId);
		Assert.notNull(annotation);
		result = this.createEditModelAndView(annotation);

		return result;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "save")
	public ModelAndView save(@Valid final Annotation annotation, final BindingResult binding) {
		ModelAndView result;

		if (binding.hasErrors())
			result = this.createEditModelAndView(annotation);
		else
			try {
				this.annotationService.save(annotation);
				result = new ModelAndView("redirect:list.do");
			} catch (final Throwable oops) {
				result = this.createEditModelAndView(annotation, "annotation.commit.error");
			}

		return result;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "delete")
	public ModelAndView delete(final Annotation annotation, final BindingResult binding) {
		ModelAndView result;

		try {
			this.annotationService.delete(annotation);
			result = new ModelAndView("redirect:list.do");
		} catch (final Throwable oops) {
			result = this.createEditModelAndView(annotation, "annotation.commit.error");
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
		result = new ModelAndView("annotation/create");
		result.addObject("annotation",annotation);
		result.addObject("message",message);
		return result;
	}

}
