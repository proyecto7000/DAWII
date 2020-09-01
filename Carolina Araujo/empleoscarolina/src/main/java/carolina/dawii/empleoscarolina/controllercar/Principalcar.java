package carolina.dawii.empleoscarolina.controllercar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Principalcar {

	@GetMapping("/")
	public String paginaInicial(Model model){
		model.addAttribute("nombre", "Carolina");
		return "homecar";
	}
}
