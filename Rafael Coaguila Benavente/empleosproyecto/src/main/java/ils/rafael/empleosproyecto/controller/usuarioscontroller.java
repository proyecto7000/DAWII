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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import ils.rafael.empleosproyecto.model.usuario;
import ils.rafael.empleosproyecto.model.vacante;
import ils.rafael.empleosproyecto.service.iUsuariosService;
import ils.rafael.empleosproyecto.service.vacantesService;


@Controller
@RequestMapping(value="/usuarios")
public class usuarioscontroller {
	
	
	@Autowired
	private iUsuariosService usuariosServicio;
	
	
	 @GetMapping("/index")
		public String mostrarIndex(Model model) {

		  List<usuario>lista = usuariosServicio.buscarTodos();
			
			model.addAttribute("usuarioslista" , lista);
	
	    	return "/usuarios/listausuarios";
		}
	    
	    @GetMapping("/delete/{id}")
		public String eliminar(@PathVariable("id") int idusuario, RedirectAttributes Attributes) {		    	
			
	    	 System.out.println("Borrando vacante por id:" + idusuario);    
	         usuariosServicio.eliminar(idusuario); 
	 		Attributes.addFlashAttribute("msg", "El usuario fue eliminado con exito!");
	    	
			return "redirect:/usuarios/index";
		}
	
}
