package dawii.elena.empleoselena.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import dawii.elena.empleoselena.model.Categoria;
import dawii.elena.empleoselena.service.ICategoriasService;




@Controller
@RequestMapping(value="/categorias")
public class CategoriasController {


	@Autowired
	private ICategoriasService categoriaServicio;

	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String mostrarindex(Model model){
	
	   List<Categoria>lista = categoriaServicio.buscarTodas();
		
			model.addAttribute("listaCategorias" , lista);

		return "/categorias/listaCategorias";
	}
	
	

	
	@GetMapping("/create")
	//@RequestMapping(value="/create", method=RequestMethod.GET)
	public String crear(Categoria categoria) {
		return "/categorias/formCategoria";
	}
	
	
	
	
	
	
		@PostMapping("/save")
		
		public String guardar(Categoria categoria, BindingResult resultado,RedirectAttributes Attributes) 
		{
			
			for(ObjectError error: resultado.getAllErrors()){
	
	            System.out.println("Ocurrio un error en : " +  error.getDefaultMessage()); 
			}
			
			if(resultado.hasErrors()){
				return "/categorias/formCategorias";
			}
			
			
			
			String msg="categoria agregada exitosamente";
			
	        Attributes.addFlashAttribute(msg, "categoria exitosa");
			
			
			
			
			System.out.println(categoria.toString());
			categoriaServicio.guardar(categoria);
			 return "redirect:/categorias/listaCategorias";
		}
	
	
	
	
	
	
	
		@GetMapping("/delete")
		public String borrar(@RequestParam("id") int id, Model miModelo) {
			//Procesamiento del parámetro. Aqui ya se hizo la conversion de String a int
			System.out.println("RequestParam: "+ id);
			miModelo.addAttribute("miId" , id);
			return "categorias/mensaje";
		}
	
	
}
