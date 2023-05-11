package controllers.manager;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import controllers.AbstractController;
import domain.Manager;
import services.ManagerService;

@Controller
@RequestMapping("/manager")
public class ManagerController extends AbstractController {
	// Services ---------------------------------------------------------------
	@Autowired
	private ManagerService ManagerService;
	// Constructors -----------------------------------------------------------
	public ManagerController() {
		super();
	}
	
	// Listing ----------------------------------------------------------------
		// Creation ---------------------------------------------------------------
		// Edition ----------------------------------------------------------------
		@RequestMapping(value="/edit",method = RequestMethod.GET)
		public ModelAndView edit() {
			ModelAndView result;
			Manager manager;
			
			manager = ManagerService.findByPrincipal();
			Assert.notNull(manager);
			result = createEditModelAndView(manager);
			return result;
		}
		
		// Save
		@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "save")
		public ModelAndView save(@Valid final Manager manager, final BindingResult binding) {
			ModelAndView result;

			if (binding.hasErrors())
				result = this.createEditModelAndView(manager);
			else
				try {
					this.ManagerService.save(manager);
					result = new ModelAndView("redirect:");
				} catch (final Throwable oops) {
					result = this.createEditModelAndView(manager, "manager.commit.error");
				}

			return result;
		}
		// Delete
		@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "delete")
		public ModelAndView delete(final Manager manager, final BindingResult binding) {
			ModelAndView result;

			try {
				this.ManagerService.delete(manager);
				result = new ModelAndView("redirect:/manager");
			} catch (final Throwable oops) {
				result = this.createEditModelAndView(manager, "manager.commit.error");
			}

			return result;
		}
		// Ancillary methods ------------------------------------------------------

			protected ModelAndView createEditModelAndView(final Manager manager) {
				ModelAndView result;

				result = this.createEditModelAndView(manager, null);

				return result;
			}
		protected ModelAndView createEditModelAndView(Manager manager, final String message) {
			ModelAndView result;
			result = new ModelAndView("manager/edit");
			result.addObject("manager",manager);
			result.addObject("message",message);
			return result;
		}
}