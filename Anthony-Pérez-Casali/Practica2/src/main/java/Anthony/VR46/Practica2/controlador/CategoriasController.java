package Anthony.VR46.Practica2.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import Anthony.VR46.Practica2.Model.CATEGORIAS;
import Anthony.VR46.Practica2.Model.VACANTE;
import Anthony.VR46.Practica2.Service.ICategoriasService;

@Controller
public class CategoriasController {
	
	@Autowired
	@Qualifier("categoriasServiceJPA")
	private ICategoriasService categoriasService;
	
	
		@GetMapping("/indexcategoria")
		//@RequestMapping(value="/index", method=RequestMethod.GET)
		public String mostrarIndex(Model model) {
			List<CATEGORIAS> ListaC= categoriasService.cargarcategorias();
			model.addAttribute("CategoriasV", ListaC);
			return "/CATEGORIAS/ListaCategoria";
		}
		
		@GetMapping(value="/indexpaginatecat")
		public String mostrarindexpaginado(Model model , Pageable page)
		{
			Page<CATEGORIAS> lista = categoriasService.buscartodas(page);
			model.addAttribute("CategoriasV",lista);
			return "/CATEGORIAS/ListaCategoria";
		}
		
		@GetMapping("/createcategoria")
		//@RequestMapping(value="/create", method=RequestMethod.GET)
		public String crearCat(CATEGORIAS categorias) {
		return "CATEGORIAS/FormCategoria";
		}
		
		@PostMapping("/savecategoria")
		//@RequestMapping(value="/savecategoria", method=RequestMethod.POST)
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
		
		@GetMapping("/detalleC/{id}")
		public String mostrarDetalleC(@PathVariable("id") int idCategoria,Model model){
		System.out.println("PathVariable: " + idCategoria);
		CATEGORIAS micategoria = categoriasService.buscarPorId(idCategoria);
		model.addAttribute("MiCategoria", micategoria);
		return "CATEGORIAS/DetalleC";
		}
		
		//METODO DE EDICION JPA
		@GetMapping("/editarcat/{id}")
		public String EDITAR(@PathVariable("id") int idCategoria, Model model)
		{
			CATEGORIAS categoria = categoriasService.buscarPorId(idCategoria);
			model.addAttribute("CATEGORIAS", categoria);
			//model.addAttribute("Categorias", ServiceCategoria.cargarcategorias());
			return "CATEGORIAS/FormCategoria";
		}
		
		
		@GetMapping("/deleteC")
		public String BorrarC(@RequestParam("id") int idCategoria, RedirectAttributes atributo){
		System.out.println("PathVariable: " + idCategoria);
		categoriasService.eliminarcat(idCategoria);
		atributo.addFlashAttribute("msg", "CATEGORIA ELIMINADA CON EXITO");
		return "redirect:/indexcategoria";
		}
		
		
		
		
		
		
}
