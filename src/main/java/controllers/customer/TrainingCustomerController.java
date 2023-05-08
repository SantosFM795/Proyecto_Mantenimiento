package controllers.customer;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import controllers.AbstractController;
import domain.Training;
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
	
}