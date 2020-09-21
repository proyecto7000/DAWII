package Nico.ils.EmpleoNicolas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Nico.ils.EmpleoNicolas.model.Vacante;
import Nico.ils.EmpleoNicolas.service.IVacantesService;



@Controller
@RequestMapping("/vacantes")

public class Vacantes {
	
	@Autowired
	private IVacantesService vacanteServicio;

	@GetMapping("/detalle/{id}")
	public String mostrarDetalle(@PathVariable("id") int idVacante, Model model) {
		System.out.println("PathVariable: "+idVacante);
		
		Vacante estaVacante= vacanteServicio.buscarVacanteporID(idVacante);
		
		model.addAttribute("vacanteV", estaVacante);
		return "detalle";
	}
	
	@GetMapping("/delete")
	public String borrar(@RequestParam("id") int id, Model miModelo) {
		//Procesamiento del parámetro 
		//Aquí ya se hizo la conversión de STRING a INT
		System.out.println("RequestParam: "+ id);
		miModelo.addAttribute("miIdVacante" , id);
		return "Categorias/mensaje";
	}
	
}
