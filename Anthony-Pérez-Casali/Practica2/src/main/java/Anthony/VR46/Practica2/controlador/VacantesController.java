package Anthony.VR46.Practica2.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import Anthony.VR46.Practica2.Model.VACANTE;
import Anthony.VR46.Practica2.Service.IVacantesServices;
//import Anthony.VR46.Practica2.Service.VacantesServiceImpl;

@Controller
public class VacantesController {
	
	@Autowired
	private IVacantesServices vacantesServicio;
	@GetMapping("/detalle/{id}")
	public String mostrarDetalle(@PathVariable("id") int idVacante,Model model){
	System.out.println("PathVariable: " + idVacante);
	VACANTE mivacante = vacantesServicio.buscarporID(idVacante);
	model.addAttribute("MiVacante", mivacante);
	return "VACANTES/Detalle";
	}
	@GetMapping("/delete")
	public String Borrar(@RequestParam("ID") int id, Model mimodelo){
	// Procesamiento del parámetro. Aquí, ya se hizo la conversión a String a int.
	System.out.println("RequestParam: " + id);
	mimodelo.addAttribute("ID", id);
	return "CATEGORIAS/Mensaje";
	}
}
