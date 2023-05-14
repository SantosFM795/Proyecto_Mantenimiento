package controllers.customer;

import java.util.ArrayList;
import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import controllers.AbstractController;
import domain.Activity;
import domain.Training;
import forms.Search;
import services.CustomerService;
import services.TrainingService;

@Controller
@RequestMapping("/training/customer")
public class TrainingCustomerController extends AbstractController{
	// Services ---------------------------------------------------------------
	@Autowired TrainingService trainingService;
	@Autowired CustomerService customerService;
	// Constructors -----------------------------------------------------------
	public TrainingCustomerController() {
		super();
	}
	// Listing ----------------------------------------------------------------
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView result;
		Collection<Training> trainings;
		trainings = this.trainingService.findAll();
		result = new ModelAndView("training/list");
		result.addObject("trainings", trainings);
		return result;
	}
	// Search by Key word
		// ----------------------------------------------------------------
		@RequestMapping(value = "/search", method = RequestMethod.GET)
		public ModelAndView search() {
			ModelAndView result;
			Collection<Training> trainings = new ArrayList<Training>();

			result = new ModelAndView("training/search");
			result.addObject("search", new Search());
			result.addObject("trainings", trainings);
			result.addObject("requestURI", "training/search.do");

			return result;

		}
		@RequestMapping(value = "/search", method = RequestMethod.POST, params = "search")
		public ModelAndView listKeyWord(@Valid final Search search, final BindingResult binding) {
			ModelAndView result;
			 String keyword = search.getKeyWord().replace(",","");
			 Collection<Training> trainings;
			if (binding.hasErrors())
				result = this.createEditModelAndView(search);
			else
				try {
					trainings = this.trainingService.findTrainerByKeyWord(keyword);
					result = new ModelAndView("training/list");
					result.addObject("requestURI", "training/customer/list.do");
					result.addObject("trainings", trainings);
				} catch (final Throwable oops) {
					result = this.createEditModelAndView(search, "search.commit.error");
				}

			return result;

		}

		// Ancillary methods ------------------------------------------------------

		protected ModelAndView createEditModelAndView(final Search search) {
			ModelAndView result;

			result = this.createEditModelAndView(search, null);

			return result;
		}

		protected ModelAndView createEditModelAndView(final Search search, final String message) {
			ModelAndView result;
			result = new ModelAndView("training/search");
			result.addObject("search", search);
			result.addObject("message", message);
			return result;
		}
}