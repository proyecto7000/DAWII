package carolina.dawii.empleoscarolina.controllercar;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/vacantes")
public class VacantesController {
	
	@GetMapping("/view/{id}")
	public String verDetalle(@PathVariable("id") int idVacante, Model model) {
		System.out.println("idVacante: "+ idVacante);
		model.addAttribute("idVacante", idVacante);
		return "vacantes/detalle";
	}
	
	@GetMapping("/delete")
	public String borrar(@RequestParam("id") int id, Model miModelo) {
		//Procesamiento del parámetro. Aqui ya se hizo la conversion de String a int
		System.out.println("RequestParam: "+ id);
		miModelo.addAttribute("miId" , id);
		return "categorias/mensaje";
	}
	
	

	

}
