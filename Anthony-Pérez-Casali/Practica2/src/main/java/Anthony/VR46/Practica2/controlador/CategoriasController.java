package Anthony.VR46.Practica2.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CategoriasController {
		@GetMapping("/index")
		//@RequestMapping(value="/index", method=RequestMethod.GET)
		public String mostrarIndex(Model model) {
		return "CATEGORIAS/ListaCategoria";
		}
		@GetMapping("/create")
		//@RequestMapping(value="/create", method=RequestMethod.GET)
		public String crear() {
		return "CATEGORIAS/FormCategoria";
		}
		//@PostMapping("/save")
		@RequestMapping(value="/save", method=RequestMethod.POST)
		public String guardar(@RequestParam("Nombre")String MiNombre, @RequestParam("Descripcion")String MiDescripcion) {
			System.out.println("Nombre de Categoria:  "+MiNombre);
			System.out.println("Descripcion de Categoria:  "+MiDescripcion);
		return "CATEGORIAS/ListaCategoria";
		}
		@GetMapping("/delete")
		public String Borrar(@RequestParam("ID") int id, Model mimodelo){
		// Procesamiento del parámetro. Aquí, ya se hizo la conversión a String a int.
		System.out.println("RequestParam: " + id);
		mimodelo.addAttribute("ID", id);
		return "CATEGORIAS/Mensaje";
		}
}
