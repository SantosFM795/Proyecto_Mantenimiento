package controllers.trainer;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import domain.Trainer;
import services.TrainerService;

@Controller
@RequestMapping("/trainer")
public class TrainerController {
	// Services ---------------------------------------------------------------
	@Autowired
	private TrainerService TrainerService;
	// Constructors -----------------------------------------------------------
	public TrainerController() {
		super();
	}
	
	// Listing ----------------------------------------------------------------
		// Creation ---------------------------------------------------------------
		// Edition ----------------------------------------------------------------
		@RequestMapping(value="/edit",method = RequestMethod.GET)
		public ModelAndView edit() {
			ModelAndView result;
			Trainer Trainer;
			
			Trainer = TrainerService.findByPrincipal();
			Assert.notNull(Trainer);
			result = createEditModelAndView(Trainer);
			return result;
		}
		
		// Save
		@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "save")
		public ModelAndView save(@Valid final Trainer Trainer, final BindingResult binding) {
			ModelAndView result;

			if (binding.hasErrors())
				result = this.createEditModelAndView(Trainer);
			else
				try {
					this.TrainerService.save(Trainer);
					result = new ModelAndView("redirect:");
				} catch (final Throwable oops) {
					result = this.createEditModelAndView(Trainer, "manager.commit.error");
				}

			return result;
		}
		// Delete
		@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "delete")
		public ModelAndView delete(final Trainer Trainer, final BindingResult binding) {
			ModelAndView result;

			try {
				this.TrainerService.delete(Trainer);
				result = new ModelAndView("redirect:/trainer");
			} catch (final Throwable oops) {
				result = this.createEditModelAndView(Trainer, "trainer.commit.error");
			}

			return result;
		}
		// Ancillary methods ------------------------------------------------------

			protected ModelAndView createEditModelAndView(final Trainer Trainer) {
				ModelAndView result;

				result = this.createEditModelAndView(Trainer, null);

				return result;
			}
		protected ModelAndView createEditModelAndView(Trainer Trainer, final String message) {
			ModelAndView result;
			result = new ModelAndView("trainer/edit");
			result.addObject("trainer",Trainer);
			result.addObject("message",message);
			return result;
		}
}
