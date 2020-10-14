package Practica.EmpleosWalter.Controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import Practica.EmpleosWalter.Modelo.Vacantes;
import Practica.EmpleosWalter.Servicio.VacantService;

@Controller
public class HomeController {

	@Autowired
	private VacantService servicioVacantes;
		
	@GetMapping("/lista")
	public String mostrarLista(Model model) {
	
		List<Vacantes> listaS= servicioVacantes.cargarDatos();
		model.addAttribute("Vacantes",listaS);
		return "Listas";
	}
	@ModelAttribute
	public void  setGenericos(Model model) {
		model.addAttribute("Vacantes",servicioVacantes.buscarDestacados());
	}
}

