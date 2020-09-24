package Nico.ils.EmpleoNicolas.controller;

import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	@GetMapping("/create")
	public String nuevaVacante(Vacante vacante) {

		return "vacantes/formVacante";
	}
	
//	@PostMapping("/save")
//	public String nuevaVacante(
//			@RequestParam("nombre") String nombre,
//			@RequestParam("categoria") String categoria,
//			@RequestParam("fecha") String fecha,
//			@RequestParam("destacado") String destacado,
//			@RequestParam("estatus") String estatus,
//			@RequestParam("salario") String salario)
//	{
//			
//			
//		
//		
//			System.out.println("nombre "+nombre);
//			System.out.println("categoria "+categoria);
//			System.out.println("fecha "+fecha);
//			System.out.println("destacado "+destacado);
//			System.out.println("estatus "+estatus);
//			System.out.println("salario "+salario);
//		
//		return "vacantes/listaVacantes";
//	}
	

	@PostMapping("/save")
	public String nuevaVacante(Vacante miVacante, BindingResult miResultado,RedirectAttributes atributo){
		
		if(miResultado.hasErrors()) {
			
		for(ObjectError error: miResultado.getAllErrors()) {
			System.out.println("Ocurrio un Error: "+error.getDefaultMessage());	
		}
		return "vacantes/formVacante";	
		}
		
		String msj="Vacante Agregada Exitosamente";
		atributo.addFlashAttribute("mensaje",msj);
		
		vacanteServicio.guardarvacante(miVacante);
		
		System.out.println(miVacante.toString());
		return "redirect:/vacantes/index";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder WDBinder) {
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		WDBinder.registerCustomEditor(Date.class, new CustomDateEditor(sdf , false));
		
	}
	
	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		
		List<Vacante> lista = vacanteServicio.CargaVacantes();
		model.addAttribute("vacantesV", lista);
		
		return "vacantes/listaVacantes";
	}
	
}
