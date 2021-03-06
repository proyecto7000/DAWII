package ils.rafael.empleosproyecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ils.rafael.empleosproyecto.model.categoria;
import ils.rafael.empleosproyecto.model.vacante;
import ils.rafael.empleosproyecto.service.icategoriasService;
import ils.rafael.empleosproyecto.service.vacantesService;

@Controller
@RequestMapping(value="/categorias")
public class categoriascontroller {

	
@Autowired
	private icategoriasService categoriaServicio;

@GetMapping("/indexcategoria")
	public String mostrarindex(Model model){
	
	   List<categoria>list = categoriaServicio.buscarTodas();
		
			model.addAttribute("categoriaslista" , list);

		return "/categorias/listacategorias";
	}
	

@GetMapping("/delete/{id}")
     public String eliminar(@PathVariable("id") int idcategoria, RedirectAttributes attributes) {

      System.out.println("Borrando Categoria por id:" + idcategoria);    
         categoriaServicio.eliminar(idcategoria); 
         attributes.addFlashAttribute("msg", "la vacante fue eliminada con exito!");
     return "redirect:/categorias/indexcategoria";
}


@GetMapping("/editar/{id}")
public String editar(@PathVariable("id") int idCategoria, Model model) {

             categoria categoria = categoriaServicio.buscarPorId(idCategoria);
             model.addAttribute("categoria"  , categoria);
             
      return "/categorias/formcategorias";
}


	@GetMapping("/createcategoria")
	public String mostrarcrear(categoria categoria , Model model){
		
		
		
		return "/categorias/formcategorias";
	}
	
	
	@PostMapping("/savecategoria")
	
	public String guardarcato(categoria categoria, BindingResult resultado,RedirectAttributes Attributes) 
	{
		
		for(ObjectError error: resultado.getAllErrors()){

            System.out.println("Ocurrio un error en : " +  error.getDefaultMessage()); 
		}
		
		if(resultado.hasErrors()){
			return "/categorias/formcategorias";
		}
		
		
		
		String   msje="categoria agregada exitosamente";
		
            Attributes.addFlashAttribute("mensajeExitosocategoria", msje);
		
		
		
		
		
		System.out.println(categoria.toString());
		categoriaServicio.guardar(categoria);
		 return "redirect:/categorias/indexcategoria";
	}
	

//	public String guardado(@RequestParam("nombre") String elnombre, @RequestParam("descripcion") String ladescripcion){
//               System.out.println("nombre de la categoria: " + elnombre);
//               System.out.println("Descripcion : " + ladescripcion);
//		       
//		return "categorias/listacategorias";
//	}
	
	
	
	
	
	
	
	
	
}
