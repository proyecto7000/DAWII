package ils.rafael.empleosproyecto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value="/categorias")
public class categoriascontroller {

	
	@GetMapping("/index")
	public String mostrarindex(Model model){
		return "categorias/listacategorias";
	}
	
	@GetMapping("/create")
	public String mostrarcrear(){
		return "categorias/formcategorias";
	}
	
	
	@PostMapping("/save")
	public String guardado(@RequestParam("nombre") String elnombre, @RequestParam("descripcion") String ladescripcion){
               System.out.println("nombre de la categoria: " + elnombre);
               System.out.println("Descripcion : " + ladescripcion);
		       
		return "categorias/listacategorias";
	}
	
	
	@GetMapping("/delete")
	public String borrar(@RequestParam("id") int id, Model model){
       		
		System.out.println("ELIMINADO CON ID: " + id);
		  model.addAttribute("borrarid", id);
		return "categorias/mensajeborrar";
	}
	
	
}
