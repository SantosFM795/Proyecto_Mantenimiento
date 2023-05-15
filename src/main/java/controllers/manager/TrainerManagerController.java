package controllers.manager;

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
import domain.Trainer;
import forms.Search;
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
		trainers = this.trainerService.findAll();
		result = new ModelAndView("trainer/list");
		result.addObject("requestURI", "trainer/manager/list.do");
		result.addObject("trainers", trainers);
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
	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "save")
	public ModelAndView save(@Valid final Trainer trainer, final BindingResult binding) {
		ModelAndView result;

		if (binding.hasErrors()) {
			result = createEditModelAndView(trainer);
		} else {
			try {
				trainerService.save(trainer);
				result = new ModelAndView("redirect:list.do");
			} catch (Throwable oops) {
				result = createEditModelAndView(trainer, "trainer.commit.error");
			}
		}
		return result;
	}

	// Search by Key word
	// ----------------------------------------------------------------
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ModelAndView search() {
		ModelAndView result;
		Collection<Trainer> trainers = new ArrayList<Trainer>();

		result = new ModelAndView("trainer/search");
		result.addObject("search", new Search());
		result.addObject("trainers", trainers);
		result.addObject("requestURI", "trainer/search.do");

		return result;

	}

	@RequestMapping(value = "/search", method = RequestMethod.POST, params = "search")
	public ModelAndView listKeyWord(@Valid final Search search, final BindingResult binding) {
		ModelAndView result;
		String keyword = search.getKeyWord().replace(",", "");
		Collection<Trainer> trainers;
		if (binding.hasErrors())
			result = this.createEditModelAndView(search);
		else
			try {
				trainers = this.trainerService.findTrainerByKeyWord(keyword);
				result = new ModelAndView("trainer/list");
				result.addObject("requestURI", "trainer/manager/list.do");
				result.addObject("trainers", trainers);
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
		result = new ModelAndView("trainer/search");
		result.addObject("search", search);
		result.addObject("message", message);
		return result;
	}

	protected ModelAndView createEditModelAndView(Trainer trainer) {
		ModelAndView result;

		result = this.createEditModelAndView(trainer, null);

		return result;
	}

	protected ModelAndView createEditModelAndView(Trainer trainer, String message) {
		ModelAndView result;

		result = new ModelAndView("trainer/edit");
		result.addObject("trainer", trainer);
		result.addObject("message", message);
		result.addObject("requestURI", "trainer/manager/edit.do");

		return result;
	}

}