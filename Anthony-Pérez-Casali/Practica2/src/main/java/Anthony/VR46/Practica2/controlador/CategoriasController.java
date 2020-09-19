package Anthony.VR46.Practica2.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import Anthony.VR46.Practica2.Model.CATEGORIAS;
import Anthony.VR46.Practica2.Service.ICategoriasService;

@Controller
public class CategoriasController {
	
	@Autowired
	private ICategoriasService categoriasService;
	
	
		@GetMapping("/indexcategoria")
		//@RequestMapping(value="/index", method=RequestMethod.GET)
		public String mostrarIndex(Model model) {
			List<CATEGORIAS> ListaC= categoriasService.cargarcategorias();
			model.addAttribute("CategoriasV", ListaC);
			return "/CATEGORIAS/ListaCategoria";
		}
		
		@GetMapping("/detalleC/{IDC}")
		public String mostrarDetalleC(@PathVariable("IDC") int idCategoria,Model model){
		System.out.println("PathVariable: " + idCategoria);
		CATEGORIAS micategoria = categoriasService.buscarPorId(idCategoria);
		model.addAttribute("MiCategoria", micategoria);
		return "CATEGORIAS/DetalleC";
		}
		
		@GetMapping("/deleteC")
		public String BorrarC(@RequestParam("IDC") int idCategoria, Model mimodelo){
		System.out.println("RequestParam: " + idCategoria);
		mimodelo.addAttribute("IDC", idCategoria);
		return "CATEGORIAS/Mensaje";
		}
		
		@GetMapping("/createcategoria")
		//@RequestMapping(value="/create", method=RequestMethod.GET)
		public String crearCat(CATEGORIAS categorias) {
		return "CATEGORIAS/FormCategoria";
		}
		
		
		//@PostMapping("/save")
		@RequestMapping(value="/savecategoria", method=RequestMethod.POST)
		public String NuevaVacante(CATEGORIAS categoria, BindingResult miresultado, RedirectAttributes atributos){
			
			for(ObjectError error: miresultado.getAllErrors()) {
				System.out.println("OCURRIO UN ERROR: " + error.getDefaultMessage());
			}
			
			if (miresultado.hasErrors()){
				return "CATEGORIAS/FormCategoria";
			}
			
			String msje = "CATEGORIA AGREGADA EXITOSAMENTE";
			
			atributos.addFlashAttribute("mensaje", msje);
					
			System.out.println(categoria.toString());
			categoriasService.guardarcategoria(categoria);
			return "redirect:/indexcategoria";
	    }
		
}
