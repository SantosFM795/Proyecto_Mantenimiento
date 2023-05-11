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
import domain.Manager;
import domain.Trainer;
import services.TrainerService;

@Controller
@RequestMapping("/trainer/manager")
public class TrainerManagerController extends AbstractController {
	// Services ---------------------------------------------------------------
	@Autowired
	private TrainerService trainerService;
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
		trainers = this.trainerService.findAll();
		result = new ModelAndView("trainer/list");
		result.addObject("requestURI", "trainer/manager/list.do");
		result.addObject("trainers",trainers);
		return result;
	}
	// Create ----------------------------------------------------------------
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView create() {
		ModelAndView result;
		Trainer trainer;
		
		trainer = this.trainerService.create();
		result = createEditModelAndView(trainer);
		return result;
	}
	
	// Save ----------------------------------------------------------------
	@RequestMapping(value = "/edit", method = RequestMethod.POST, params="save")
	public ModelAndView save(@Valid Trainer trainer, BindingResult binding) {
		ModelAndView result;
		
		if(binding.hasErrors()) {
			result = createEditModelAndView(trainer);
		}else {
			try {
				trainerService.save(trainer);
				result = new ModelAndView("redirect:list.do");
			}catch(Throwable oops) {
				result = createEditModelAndView(trainer,"trainer.commit.error");
			}
		}
		return result;
	}
	
	
	//Ancillary method--------------------------------------------------------
	
	protected ModelAndView createEditModelAndView(Trainer trainer) {
		ModelAndView result;
		
		result = this.createEditModelAndView(trainer,null);
		
		return result;
	}
	protected ModelAndView createEditModelAndView(Trainer trainer, String message) {
		ModelAndView result;
		
		result=new ModelAndView("trainer/edit");
		result.addObject("trainer", trainer);
		result.addObject("message", message);
		result.addObject("requestURI", "trainer/manager/edit.do");
		
		return result;
	}


}