package carolina.dawii.empleoscarolina.controllercar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value="/categorias")
public class CategoriasController {


	
	
	@GetMapping("/create")
	//@RequestMapping(value="/create", method=RequestMethod.GET)
	public String crear() {
		return "categorias/formCategorias";
	}
	
	
	@PostMapping("/save")
	//@RequestMapping(value="/save", method=RequestMethod.POST)
	public String guardar(@RequestParam("nombre") String nombre, @RequestParam("descripcion") String descripcion) {
		System.out.println("Nombre de categoria: " +nombre);
		System.out.println("Descripcion de Catetgoria: " +descripcion);
		return "/categorias/listaCategorias";
	}
	
	
		@GetMapping("/delete")
		public String borrar(@RequestParam("id") int id, Model miModelo) {
			//Procesamiento del parámetro. Aqui ya se hizo la conversion de String a int
			System.out.println("RequestParam: "+ id);
			miModelo.addAttribute("miId" , id);
			return "categorias/mensaje";
		}
	
	
}