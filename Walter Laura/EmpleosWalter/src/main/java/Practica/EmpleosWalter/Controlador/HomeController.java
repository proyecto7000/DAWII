package Practica.EmpleosWalter.Controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String Principal(Model modelo) {
		
		modelo.addAttribute("nombre","Walter Noel");
		return "Vista";
	}
	
}
