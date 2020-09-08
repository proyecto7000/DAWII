package ils.rafael.empleosproyecto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/categorias")
public class categoriascontroller {

	
	@GetMapping("/index")
	public String mostrarindex(Model model){
		
		
		return "categorias/listacategorias";
	}
	
	@GetMapping("/create")
	public String mostrarcrear(Model model){
		
		
		return "categorias/formcategorias";
	}
	
	
	@GetMapping("/save")
	public String guardado(Model model){
		
		
		return "categorias/listacategorias";
	}
	
}
