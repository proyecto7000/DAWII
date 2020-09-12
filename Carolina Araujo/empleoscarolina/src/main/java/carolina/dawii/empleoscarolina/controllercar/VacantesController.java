package carolina.dawii.empleoscarolina.controllercar;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import carolina.dawii.empleoscarolina.model.Vacante;
import carolina.dawii.empleoscarolina.service.IVacantesService;

@Controller
@RequestMapping("/vacantes")
public class VacantesController {
	
	@Autowired
	private IVacantesService vacanteServicio;
	
	@GetMapping("/detalle/{id}")
	public String verDetalle(@PathVariable("id") int idVacante, Model model) {
		
		System.out.println("PathVariable: "+ idVacante);
		
		Vacante estaVacante= vacanteServicio.buscarPorId(idVacante);
		
		model.addAttribute("vacanteV", estaVacante);
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
