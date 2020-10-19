package Practica.EmpleosWalter.Controlador;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import Practica.EmpleosWalter.Modelo.Usuario;
import Practica.EmpleosWalter.Servicio.IUsuariosService;



@Controller
@RequestMapping("/usuarios")
public class UsuariosController {

	@Autowired
	private IUsuariosService usuariosServicio;
	
    @GetMapping("/index")
	public String mostrarIndex(Model model) {
		  List<Usuario>lista = usuariosServicio.buscarTodos();
			
			model.addAttribute("Usuarios" , lista);
    	return "usuarios/listUsuario";
	}
    
    @GetMapping("/delete/{id}")
	public String eliminar(@PathVariable("id") int idUsuario, RedirectAttributes attributes) {		    	
		
   	 System.out.println("Borrando vacante por id:" + idUsuario);    
     usuariosServicio.eliminar(idUsuario); 
     attributes.addFlashAttribute("msg", "El usuario fue eliminado con exito!");
    	
		return "redirect:/usuarios/index";
	}
}
