/*
 * trainingManagerController.java
 * 
 * Copyright (C) 2017 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the
 * TDG Licence, a copy of which you may download from
 * http://www.tdg-seville.info/License.html
 */

package controllers.manager;

import java.util.Collection;
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
import domain.Training;
import services.TrainingService;

@Controller
@RequestMapping("/training/manager")
public class TrainingManagerController extends AbstractController {
	// Services ---------------------------------------------------------------
	@Autowired
	private TrainingService trainingService;
	// Constructors -----------------------------------------------------------
	public TrainingManagerController() {
		super();
	}
	// Listing ----------------------------------------------------------------
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView result;
		Collection<Training> trainings;
		
		trainings = this.trainingService.findByManager();
		result = new ModelAndView("training/list");
		result.addObject("requestURI", "training/manager/list.do");
		result.addObject("trainings",trainings);
		return result;
	}
	// Creation ---------------------------------------------------------------
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView create() {
		ModelAndView result;
		Training training;
		
		training = this.trainingService.create();
		result = this.createEditModelAndView(training);
		return result;
	}
	// Edition ----------------------------------------------------------------
	@RequestMapping(value="/edit",method = RequestMethod.GET)
	public ModelAndView edit(@RequestParam int trainingId) {
		ModelAndView result;
		Training training;
		
		training = trainingService.findOne(trainingId);
		Assert.notNull(training);
		result = createEditModelAndView(training);
		return result;
	}
	// Save
	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "save")
	public ModelAndView save(@Valid final Training training, final BindingResult binding) {
		ModelAndView result;

		if (binding.hasErrors())
			result = this.createEditModelAndView(training);
		else
			try {
				this.trainingService.save(training);
				result = new ModelAndView("redirect:list.do");
			} catch (final Throwable oops) {
				result = this.createEditModelAndView(training, "training.commit.error");
			}

		return result;
	}
	// Delete
	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "delete")
	public ModelAndView delete(final Training training, final BindingResult binding) {
		ModelAndView result;

		try {
			this.trainingService.delete(training);
			result = new ModelAndView("redirect:list.do");
		} catch (final Throwable oops) {
			result = this.createEditModelAndView(training, "training.commit.error");
		}

		return result;
	}
	// Ancillary methods ------------------------------------------------------

		protected ModelAndView createEditModelAndView(final Training training) {
			ModelAndView result;

			result = this.createEditModelAndView(training, null);

			return result;
		}
	protected ModelAndView createEditModelAndView(Training training, final String message) {
		// Falta definir steps y anotations al editar un entrenamiento, de momento solo se podran editar sus basicos
		ModelAndView result;
		result = new ModelAndView("training/edit");
		result.addObject("training",training);
		result.addObject("message",message);
		return result;
	}
}
