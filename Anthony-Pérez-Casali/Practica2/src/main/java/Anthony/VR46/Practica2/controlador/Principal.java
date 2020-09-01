package Anthony.VR46.Practica2.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Principal {
	@GetMapping("/VR46")
	public String PaginaPrimera(Model model) {
		model.addAttribute("Nombre", "Anthony Pérez Casali");
		return "Home";	
	}

}
