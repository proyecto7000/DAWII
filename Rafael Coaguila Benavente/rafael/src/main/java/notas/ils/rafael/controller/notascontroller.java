package notas.ils.rafael.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ils.rafael.empleosproyecto.model.vacante;
import notas.ils.rafael.model.alumno;
import notas.ils.rafael.service.notasService;
@Controller
public class notascontroller {

	
	@Autowired
	notasService notasservicio;
	
	@GetMapping("/create")
	public String paginacrear(Model model){

		
		List<alumno> lista  =  notasservicio.cargarvacante(); 
		
		model.addAttribute( "notas" , lista );
          	  			
		return "/vistas/formulario";
	}
	
	
	@GetMapping("/index")
	public String index(Model model) {
		
	    List<alumno>lista = notasservicio.cargarvacante();
		
		model.addAttribute("vacanteslista" , lista);
		
		return  "/vacantes/listavacantes";
	}
	
	@PostMapping("/savealumno")
	
	public String guardarcato(alumno alumno, BindingResult resultado,RedirectAttributes Attributes) 
	{
		
		for(ObjectError error: resultado.getAllErrors()){

            System.out.println("Ocurrio un error en : " +  error.getDefaultMessage()); 
		}
		
		if(resultado.hasErrors()){
			return "/vistas/formulario";
		}
		
		
		
		String   msje="categoria agregada exitosamente";
		
            Attributes.addFlashAttribute("mensajeExitosocategoria", msje);
		
		
		
		
		
		System.out.println(alumno.toString());
		notasservicio.guardaralumno(alumno);
		 return "/vistas/guardado";
	}
}
