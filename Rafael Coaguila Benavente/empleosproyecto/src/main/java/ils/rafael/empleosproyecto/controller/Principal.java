package ils.rafael.empleosproyecto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Principal {

	
	@GetMapping("/inicio")
	public String paginainicio(Model model){
	model.addAttribute("mensaje","Rafael");
		
		return "home";
	}
	
}
