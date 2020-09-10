package Practica.EmpleosWalter.Controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value="/categorias")
public class CategoryController {

	//@GetMapping("Index")
	@RequestMapping(value="/Index", method =RequestMethod.GET)
	public String mostrarIndex(Model model) {
		return "categorias/listCategorias";
	}
	 
	//@GetMapping("/Crear")
	@RequestMapping(value="/Crear", method=RequestMethod.GET)
	public String crearCategoria() {
		return "categorias/formCategorias";
	}
	
	//@PostMapping("/Guardar")
	@RequestMapping(value="/Guardar", method=RequestMethod.POST)
	public String guardarCategoria(@RequestParam("nombre")String nombre,@RequestParam("descripcion")String descripcion) {
		System.out.println("Nombre: "+nombre);
		System.out.println("Descripcion: "+descripcion);
		return "categorias/listCategorias";
	}
}
