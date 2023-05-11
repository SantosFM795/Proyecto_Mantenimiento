package controllers.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import controllers.AbstractController;
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
}