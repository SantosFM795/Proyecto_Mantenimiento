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
import domain.Trainer;
import services.TrainerService;

@Controller
@RequestMapping("/trainer/manager")
public class TrainerManagerController extends AbstractController {
	// Services ---------------------------------------------------------------
	@Autowired
	private TrainerService TrainerService;
	// Constructors -----------------------------------------------------------
	public TrainerManagerController() {
		super();
	}
	// Listing ----------------------------------------------------------------
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView result;
		Collection<Trainer> trainers;
		// Para listar solo los trainers de los gyms que gestiona el manager
		trainers = this.TrainerService.findAll();
		result = new ModelAndView("trainer/list");
		result.addObject("requestURI", "trainer/manager/list.do");
		result.addObject("trainers",trainers);
		return result;
	}
	// Creation ---------------------------------------------------------------
	// Edition ----------------------------------------------------------------
	// Save
	// Delete
	// Ancillary methods ------------------------------------------------------
	

}