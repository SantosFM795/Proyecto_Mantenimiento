
/*
 * CustomerController.java
 * 
 * Copyright (C) 2017 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the
 * TDG Licence, a copy of which you may download from
 * http://www.tdg-seville.info/License.html
 */

package controllers.customer;

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
import domain.Customer;
import services.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController extends AbstractController {
	// Services ---------------------------------------------------------------
	@Autowired
	private CustomerService customerService;
	// Constructors -----------------------------------------------------------
	public CustomerController() {
		super();
	}
	// Listing ----------------------------------------------------------------
	// Creation ---------------------------------------------------------------
	// Edition ----------------------------------------------------------------
	@RequestMapping(value="/edit",method = RequestMethod.GET)
	public ModelAndView edit() {
		ModelAndView result;
		Customer customer;
		
		customer = customerService.findByPrincipal();
		Assert.notNull(customer);
		result = createEditModelAndView(customer);
		return result;
	}
	// Save
	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "save")
	public ModelAndView save(@Valid final Customer customer, final BindingResult binding) {
		ModelAndView result;

		if (binding.hasErrors())
			result = this.createEditModelAndView(customer);
		else
			try {
				this.customerService.save(customer);
				result = new ModelAndView("redirect:");
			} catch (final Throwable oops) {
				result = this.createEditModelAndView(customer, "customer.commit.error");
			}

		return result;
	}
	// Delete
	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "delete")
	public ModelAndView delete(final Customer customer, final BindingResult binding) {
		ModelAndView result;

		try {
			this.customerService.delete(customer);
			result = new ModelAndView("redirect:/customer");
		} catch (final Throwable oops) {
			result = this.createEditModelAndView(customer, "customer.commit.error");
		}

		return result;
	}
	// Ancillary methods ------------------------------------------------------

		protected ModelAndView createEditModelAndView(final Customer customer) {
			ModelAndView result;

			result = this.createEditModelAndView(customer, null);

			return result;
		}
	protected ModelAndView createEditModelAndView(Customer customer, final String message) {
		// Falta definir steps y anotations al editar un entrenamiento, de momento solo se podran editar sus basicos
		ModelAndView result;
		result = new ModelAndView("customer/edit");
		result.addObject("customer",customer);
		result.addObject("message",message);
		return result;
	}
}
