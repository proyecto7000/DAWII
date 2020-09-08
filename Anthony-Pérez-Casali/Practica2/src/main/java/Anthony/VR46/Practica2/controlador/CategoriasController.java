package Anthony.VR46.Practica2.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CategoriasController {
		//@GetMapping("/index")
		@RequestMapping(value="/index", method=RequestMethod.GET)
		public String mostrarIndex(Model model) {
		return "/CATEGORIAS/ListaCategoria";
		}
		// @GetMapping("/create")
		@RequestMapping(value="/create", method=RequestMethod.GET)
		public String crear() {
		return "CATEGORIAS/FormCategoria";
		}
		// @PostMapping("/save")
		@RequestMapping(value="/save", method=RequestMethod.POST)
		public String guardar() {
		return "CATEGORIAS/FormCategoria";
		}
}
