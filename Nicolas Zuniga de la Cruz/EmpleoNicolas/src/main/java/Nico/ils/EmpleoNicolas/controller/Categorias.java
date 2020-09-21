package Nico.ils.EmpleoNicolas.controller;

import org.springframework.stereotype.Controller;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

//antepone categorias a todos los metodos
@RequestMapping(value="/categorias") 

public class Categorias {
	
	@GetMapping("/index")
	//@RequestMapping(value="/index", method=RequestMethod.GET)
	public String mostrarIndex(Model model) {
		
		return "categorias/listCategorias";
	}
	
	@GetMapping("/create")
	//@RequestMapping(value="/create", method=RequestMethod.GET)
		public String crear() {
			
			return "categorias/formCategoria";
		}
		
	@PostMapping("/save")
	//@RequestMapping(value="/save", method=RequestMethod.POST)
	public String guardar(@RequestParam("nombre") String nombre, @RequestParam("descripcion") String descripcion) {
		System.out.println("Nombre de categoria: " +nombre);
		System.out.println("Descripcion de Catetgoria: " +descripcion);
		return "categorias/listCategorias";
	}
	
	@GetMapping("/delete")
	public String borrar(@RequestParam("idVacante") int id, Model miModelo) {
		//procesamiento del parametro
		//aquí ya se realizo la converción de String a int 	
		System.out.println("RequestParam: "+id);
		miModelo.addAttribute("idVacante",id);
		return "categorias/mensaje";
	}
}
