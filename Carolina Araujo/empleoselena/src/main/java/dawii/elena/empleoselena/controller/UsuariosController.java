package dawii.elena.empleoselena.controller;

import java.util.Date;
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

import dawii.elena.empleoselena.model.Perfil;
import dawii.elena.empleoselena.model.Usuario;
import dawii.elena.empleoselena.service.IUsuariosService;

@Controller
@RequestMapping("/usuarios")
public class UsuariosController {
	
	@Autowired
	private IUsuariosService usuarioServicio;
    
    @GetMapping("/index")
    public String mostrarIndex(Model model) {
  		List<Usuario>lista = usuarioServicio.buscarTodos(); 			
  		model.addAttribute("Usuarios" , lista);
    	
    	return "usuarios/listUsuarios";
	}
    
    @PostMapping("/save")
	public String guardar(Usuario usuario, BindingResult result, RedirectAttributes attributes){
		
		usuario.setFechaRegistro(new Date());
		
		Perfil perfil = new Perfil();
		perfil.setId(3);
		usuario.agregar(perfil);
		
		for(ObjectError error: result.getAllErrors()) {
			System.out.println("Ocurrio un error: " + error.getDefaultMessage());
			}
				
			if (result.hasErrors()){
				return "/Usuarios/formRegistro";
			}
				
			String msg = "Usuario agregado exitosamente";
				
			attributes.addFlashAttribute("", msg);
						
			System.out.println(usuario.toString());
			usuarioServicio.guardar(usuario);
			return "redirect:/index";
	    }
    
    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable("id") int idUsuario, RedirectAttributes attributes) {		    	
		
      	System.out.println("Borrando usuario por id:" + idUsuario);    
        usuarioServicio.eliminar(idUsuario); 
        attributes.addFlashAttribute("msg", "El usuario fue eliminado exitosamente");
       	
   		return "redirect:/usuarios/index";
	}
}
