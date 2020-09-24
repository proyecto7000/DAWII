package Nico.ils.EmpleoNicolas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import Nico.ils.EmpleoNicolas.model.Categoria;
import Nico.ils.EmpleoNicolas.model.Vacante;
import Nico.ils.EmpleoNicolas.service.ICategoriasService;

@Controller

//antepone categorias a todos los metodos
@RequestMapping(value="/categorias") 

public class Categorias {
	
	@Autowired
	private ICategoriasService categoriaServicio; 
	
	@GetMapping("/index")
	//@RequestMapping(value="/index", method=RequestMethod.GET)
	public String mostrarIndex(Model model) {
		
		List<Categoria> listaCat = categoriaServicio.CargaCategorias();
		model.addAttribute("CategoriasV", listaCat);
		return "categorias/listCategorias";
	}
	
	@GetMapping("/create")
	//@RequestMapping(value="/create", method=RequestMethod.GET)
		public String crear() {
			
			return "categorias/formCategoria";
		}
		
//	@PostMapping("/save")
//	//@RequestMapping(value="/save", method=RequestMethod.POST)
//	public String nuevaCategoria(@RequestParam("nombre") String nombre, @RequestParam("descripcion") String descripcion) {
//		System.out.println("Nombre de categoria: " +nombre);
//		System.out.println("Descripcion de Catetgoria: " +descripcion);
//		return "categorias/listCategorias";
//	}

	@PostMapping("/save")
	//@RequestMapping(value="/save", method=RequestMethod.POST)
	public String nuevaCategoria(Categoria miCategoria, BindingResult miResultado,RedirectAttributes atributo) {
		
		if(miResultado.hasErrors()) {
			
		for(ObjectError error: miResultado.getAllErrors()) {
			System.out.println("Ocurrio un Error: "+error.getDefaultMessage());	
		}
		return "categorias/formCategoria";	
		}
		
		String msj="Categoria Agregada Exitosamente";
		atributo.addFlashAttribute("mensaje",msj);
		
		categoriaServicio.guardarVacante(miCategoria);
		
		System.out.println(miCategoria.toString());
		
		return "redirect:/categorias/index";
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
