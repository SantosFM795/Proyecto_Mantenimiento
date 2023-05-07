package controllers.trainer;

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
import domain.CV;
import services.CVService;

// Se puede editar el cv

@Controller
@RequestMapping("/cv/trainer")
public class CvTrainerController extends AbstractController {
	// Services ---------------------------------------------------------------
	@Autowired
	private CVService cvService;

	// Constructors -----------------------------------------------------------
	public CvTrainerController() {
		super();
	}

	// Listing ----------------------------------------------------------------
	// Creation ---------------------------------------------------------------
	// Edition ----------------------------------------------------------------
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView edit(@RequestParam int cvId) {
		ModelAndView result;
		CV cv;

		cv = cvService.findOne(cvId);
		Assert.notNull(cv);
		result = createEditModelAndView(cv);
		return result;
	}

	// Save
	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "save")
	public ModelAndView save(@Valid final CV cv, final BindingResult binding) {
		ModelAndView result;

		if (binding.hasErrors())
			result = this.createEditModelAndView(cv);
		else
			try {
				this.cvService.save(cv);
				result = new ModelAndView("redirect:list.do");
			} catch (final Throwable oops) {
				result = this.createEditModelAndView(cv, "cv.commit.error");
			}

		return result;
	}

	// Delete
	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "delete")
	public ModelAndView delete(final CV cv, final BindingResult binding) {
		ModelAndView result;

		try {
			this.cvService.delete(cv);
			result = new ModelAndView("redirect:list.do");
		} catch (final Throwable oops) {
			result = this.createEditModelAndView(cv, "cv.commit.error");
		}

		return result;
	}
	// Ancillary methods ------------------------------------------------------

	protected ModelAndView createEditModelAndView(final CV cv) {
		ModelAndView result;

		result = this.createEditModelAndView(cv, null);

		return result;
	}

	protected ModelAndView createEditModelAndView(CV cv, final String message) {
		// Falta definir steps y anotations al editar un entrenamiento, de momento solo
		// se podran editar sus basicos
		ModelAndView result;
		result = new ModelAndView("cv/edit");
		result.addObject("cv", cv);
		result.addObject("message", message);
		return result;
	}
}
