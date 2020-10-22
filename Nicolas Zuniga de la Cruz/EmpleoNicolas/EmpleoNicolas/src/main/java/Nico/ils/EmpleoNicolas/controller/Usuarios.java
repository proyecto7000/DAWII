package Nico.ils.EmpleoNicolas.controller;


import java.util.List;
import org.springframework.ui.Model;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.beans.factory.annotation.Autowired;


import Nico.ils.EmpleoNicolas.model.Usuario;


import Nico.ils.EmpleoNicolas.service.IUsuariosService;
import Nico.ils.EmpleoNicolas.service.IVacantesService;

@Controller
@RequestMapping(value="/usuarios")
public class Usuarios {
	
	
@Autowired
private IUsuariosService usuariosServicio;



@GetMapping("/index")
public String mostrarIndex(Model model) {
	
	List<Usuario> lista = usuariosServicio.listarUsuarios();
	model.addAttribute("usuariosU", lista);
	
	return "usuarios/ListUsuarios";
}


@GetMapping("/delete/{id}")
public String borrar(@PathVariable("id") int id, RedirectAttributes attributes) {
	System.out.println("Id de usuario a eliminar: "+ id);
	usuariosServicio.eliminarUsuario(id);
	attributes.addFlashAttribute("msj", "Usuario eliminado con exito!");
	return "redirect:/usuarios/index";
}

@GetMapping("/create")
public String nuevoUsuario(Usuario usuario) {
	return "usuarios/formRegistro";
}

@GetMapping("/prueba")
public String prueba() {
	return "usuarios/prueba";
}

@PostMapping("/save")
public String guardar(Usuario usuario, BindingResult miResultado, RedirectAttributes atributo) {
	
	if(miResultado.hasErrors()) {
		
		for(ObjectError error: miResultado.getAllErrors()) {
			System.out.println("Ocurrio un Error: "+error.getDefaultMessage());	
		}
		return "usuarios/formRegistro";	
		}
		
		String msj="Usuario Agregado Exitosamente";
		atributo.addFlashAttribute("mensajeNuevoUsuario",msj);
		
		usuariosServicio.guardarUsuario(usuario);
		
		System.out.println(usuario.toString());
		
		return "redirect:/usuarios/index";
	
}

}
