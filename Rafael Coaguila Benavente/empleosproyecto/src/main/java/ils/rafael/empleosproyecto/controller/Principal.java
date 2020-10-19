package ils.rafael.empleosproyecto.controller;


import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ils.rafael.empleosproyecto.model.perfil;
import ils.rafael.empleosproyecto.model.usuario;
import ils.rafael.empleosproyecto.model.vacante;
import ils.rafael.empleosproyecto.service.iUsuariosService;
import ils.rafael.empleosproyecto.service.vacantesService;


@Controller
public class Principal {

	@Autowired
	vacantesService vacantesservicio;
	
	@Autowired
   	private iUsuariosService usuariosServicio;
	
	@GetMapping("/")
	public String paginainicio(Model model){

		
	//	List<vacante> lista  =  vacantesservicio.cargarvacante(); 
		
	//	model.addAttribute( "vacantes" , lista );
          	  			
		return "vacantes/home";
	}
	
	@ModelAttribute
	public void  setGenerico(Model model) {
		
		model.addAttribute("vacantes", vacantesservicio.buscarDestacadas());
		
	}
	
	
	@GetMapping("/lista")
	public String mostrarlistadetalle(Model model){
        
		List<vacante> lista  =  vacantesservicio.cargarvacante(); 
		
		model.addAttribute( "vacantes" , lista );
          	  	
		return "/vacantes/listadetalle";
	}
	

	
	@Autowired
	private iUsuariosService UsuariosServicio;
	
	
	
	
	@GetMapping("/createusuario")
	public String mostrarcrear(usuario usuario, Model model){
		
		
		
		return "/usuarios/formusuario";
	}

	
	
	
@PostMapping("/saveusuario")
	
	public String guardarusu(usuario usuario, BindingResult resultado,RedirectAttributes Attributes) 
	{
		usuario.setEstatus(1);
		usuario.setFechaRegistro(new Date());
		
		perfil perfil = new perfil();
		perfil.setId(3);
		usuario.agregar(perfil);
		
		for(ObjectError error: resultado.getAllErrors()){

            System.out.println("Ocurrio un error en : " +  error.getDefaultMessage()); 
		}
		
		if(resultado.hasErrors()){
			return "/usuarios/formusuario";
		}
		
		
		
		String   msje="Usuario agregado exitosamente";
		
            Attributes.addFlashAttribute("mensajeExitosoUsuario", msje);
		
		
		
		
		
		System.out.println(usuario.toString());
		UsuariosServicio.guardar(usuario);
		 return "redirect:/usuarios/index";
	}

	
	
}
	