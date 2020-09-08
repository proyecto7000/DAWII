package Anthony.VR46.Practica2.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class VacantesController {
	@GetMapping("/detalle/{id}")
	public String mostrarDetalle(@PathVariable("id") int idVacante,Model model){
	System.out.println("PathVariable: " + idVacante);
	model.addAttribute("MiIDVacante", idVacante);
	return "VACANTES/Detalle";
	}
}
