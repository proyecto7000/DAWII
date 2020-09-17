package Practica.EmpleosWalter.Controlador;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Practica.EmpleosWalter.Modelo.Vacantes;
import Practica.EmpleosWalter.Servicio.VacantService;

@Controller
@RequestMapping("/vacantes")
public class VacantController {

	@Autowired
	private VacantService servicioVacantes;
	
	@GetMapping ("/Index")
	public String mostrarIndex(Model model) {
		
		List<Vacantes> listaS= servicioVacantes.cargarDatos();
		model.addAttribute("Vacantes",listaS);
		return "vacantes/listVacante";
	}
	
	@GetMapping ("/Create")
	public String Crear() {
		return "vacantes/formVacante";
	}

	@PostMapping("/Save")
	public String guardar(Vacantes vacante){
		servicioVacantes.guardar(vacante);
		System.out.println("Vacantes: " + vacante);
		return "vacantes/listVacante";
	}
	
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
	
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	} 
	
}
