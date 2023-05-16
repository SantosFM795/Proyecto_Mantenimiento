
/*
 * administratorController.java
 * 
 * Copyright (C) 2017 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the
 * TDG Licence, a copy of which you may download from
 * http://www.tdg-seville.info/License.html
 */

package controllers.administrator;

import java.util.ArrayList;
import java.util.Collection;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import controllers.AbstractController;
import domain.Administrator;
import domain.Training;
import services.AdministratorService;
import services.GymService;
import services.StepService;
import services.TrainingService;

@Controller
@RequestMapping("/administrator")
public class AdministratorController extends AbstractController {
	// Services ---------------------------------------------------------------
	@Autowired
	private AdministratorService administratorService;
	@Autowired
	private GymService gymService;
	@Autowired
	private TrainingService trainingService;
	@Autowired
	private StepService stepService;
	// Constructors -----------------------------------------------------------
	public AdministratorController() {
		super();
	}
	// Listing ----------------------------------------------------------------
	// Information Board ----------------------------------------------------------------
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView result;
		Collection<Object[]> gymsByManager;
		Collection<Training> trainingOrder;
		Collection<Object[]> trainingG;
		Collection<Object[]> steps = new ArrayList<Object[]>();
		
		gymsByManager = this.gymService.findGymsByManager();
		//Assert.notNull(gymsM);
		result = new ModelAndView("administrator/list");
		result.addObject("gymsByManager",gymsByManager);
		
		trainingG = this.trainingService.findTrainingByGym();
		//Assert.notNull(trainingG);
		result.addObject("trainingG", trainingG);
		
		steps = this.stepService.findStepsByTraining();
		//Assert.notNull(steps);
		result.addObject("steps", steps);
		
		
		trainingOrder = this.trainingService.findOrderTraining();
		//Assert.notNull(trainingOrder);
		result.addObject("trainingOrder", trainingOrder);
		
		
		result.addObject("requestURI", "administrator/list.do");
		System.out.println("aaaaa");
		
		return result;
	}
	// Creation ---------------------------------------------------------------
	// Edition ----------------------------------------------------------------
	@RequestMapping(value="/edit",method = RequestMethod.GET)
	public ModelAndView edit() {
		ModelAndView result;
		Administrator administrator;
		
		administrator = administratorService.findByPrincipal();
		Assert.notNull(administrator);
		result = createEditModelAndView(administrator);
		return result;
	}
	// Save
	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "save")
	public ModelAndView save(@Valid final Administrator administrator, final BindingResult binding) {
		ModelAndView result;

		if (binding.hasErrors())
			result = this.createEditModelAndView(administrator);
		else
			try {
				this.administratorService.save(administrator);
				result = new ModelAndView("redirect:");
			} catch (final Throwable oops) {
				result = this.createEditModelAndView(administrator, "administrator.commit.error");
			}

		return result;
	}
	// Delete
	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "delete")
	public ModelAndView delete(final Administrator administrator, final BindingResult binding) {
		ModelAndView result;

		try {
			this.administratorService.delete(administrator);
			result = new ModelAndView("redirect:/administrator");
		} catch (final Throwable oops) {
			result = this.createEditModelAndView(administrator, "administrator.commit.error");
		}

		return result;
	}
	// Ancillary methods ------------------------------------------------------

		protected ModelAndView createEditModelAndView(final Administrator administrator) {
			ModelAndView result;

			result = this.createEditModelAndView(administrator, null);

			return result;
		}
	protected ModelAndView createEditModelAndView(Administrator administrator, final String message) {
		// Falta definir steps y anotations al editar un entrenamiento, de momento solo se podran editar sus basicos
		ModelAndView result;
		result = new ModelAndView("administrator/edit");
		result.addObject("administrator",administrator);
		result.addObject("message",message);
		return result;
	}
}
