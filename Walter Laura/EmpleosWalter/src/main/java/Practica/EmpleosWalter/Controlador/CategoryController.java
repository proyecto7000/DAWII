package Practica.EmpleosWalter.Controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import Practica.EmpleosWalter.Modelo.Categorias;
import Practica.EmpleosWalter.Modelo.Vacantes;
import Practica.EmpleosWalter.Servicio.CategoriaService;



@Controller
@RequestMapping(value="/categorias")
public class CategoryController {

	@Autowired
	private CategoriaService servicioCategorias;
	
	@RequestMapping(value="/Index")
	public String mostrarIndex(Model model) {
		
		List<Categorias>list = servicioCategorias.buscarTodas();
		model.addAttribute("Categorias" , list);
		return "categorias/listCategorias";
	}
	 

	@RequestMapping(value="/Crear")
	public String crearCategoria(Categorias categoria) {
		return "categorias/formCategorias";
	}
	

	@RequestMapping(value="/Guardar", method=RequestMethod.POST)
	public String guardarCategoria(Categorias categoria, BindingResult result,RedirectAttributes Attributes) {
		
		if(result.hasErrors()){
			for(ObjectError error: result.getAllErrors()){

	            System.out.println("Ocurrio un error en : " +  error.getDefaultMessage()); 
			}

			return "categorias/formCategorias";
			}

		String   msje="categoria agregada exitosamente";
			
	        Attributes.addFlashAttribute("mensaje", msje);
			
	        servicioCategorias.guardar(categoria);
			return "redirect:/categorias/Index";
	}
	
	
	@GetMapping("/delete")
	public String borrar(@RequestParam("id") int id, Model model){
       		
		System.out.println("Eliminar id: " + id);
		  model.addAttribute("borrarid", id);
		return "categorias/mensaje";
	}
	
	
}
