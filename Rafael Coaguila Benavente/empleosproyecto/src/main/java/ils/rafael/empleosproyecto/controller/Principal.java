package ils.rafael.empleosproyecto.controller;


import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ils.rafael.empleosproyecto.model.perfil;
import ils.rafael.empleosproyecto.model.usuario;
import ils.rafael.empleosproyecto.model.vacante;
import ils.rafael.empleosproyecto.service.iUsuariosService;
import ils.rafael.empleosproyecto.service.icategoriasService;
import ils.rafael.empleosproyecto.service.vacantesService;


@Controller
public class Principal {

	
	@Autowired
	icategoriasService categoriasservicio;
	
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
		vacante vacantesearch =  new vacante();
		vacantesearch.reset();
		model.addAttribute("vacantes", vacantesservicio.buscarDestacadas());
		model.addAttribute("categorias", categoriasservicio.buscarTodas());
		model.addAttribute("search" , vacantesearch);
		
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

	
	
	@GetMapping("/search")
	public String buscar(@ModelAttribute("search") vacante vacante, Model model){
		
		System.out.println("Buscando por : "  + vacante );
		                                 // where  descripcion like '%?%'
		ExampleMatcher martcher =  ExampleMatcher.matching().withMatcher("descripcion", ExampleMatcher.GenericPropertyMatchers.contains());
		
		
		Example<vacante> example = Example.of(vacante,martcher);
		List<vacante> lista =  vacantesservicio.buscarByExample(example);
		model.addAttribute("vacantes", lista);
		return "/vacantes/home";
	}
	
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		
		
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
		
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
	