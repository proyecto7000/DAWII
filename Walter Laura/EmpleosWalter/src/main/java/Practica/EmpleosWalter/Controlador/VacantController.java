package Practica.EmpleosWalter.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Practica.EmpleosWalter.Modelo.Vacantes;
import Practica.EmpleosWalter.Servicio.VacantService;

@Controller
@RequestMapping("/vacantes")
public class VacantController {

	@Autowired
	private VacantService servicioVacantes;
	
	@GetMapping ("/Borrar")
	public String eliminar(@RequestParam("id")int idVacante, Model model) {
		System.out.println("Borrando vacante con id: "+idVacante);
		model.addAttribute("id",idVacante);
		return "vacantes/mensaje";
	}
	
	@GetMapping ("/Vistas/{id}")
	public String verDetalle(@PathVariable("id")int idVacante, Model model) {
		
		Vacantes vacante = servicioVacantes.buscarId(idVacante);	
		model.addAttribute("VacanteV",vacante);
		return "vacantes/detalle";
	}
}
