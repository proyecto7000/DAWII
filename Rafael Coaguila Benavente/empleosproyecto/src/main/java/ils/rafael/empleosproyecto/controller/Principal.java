package ils.rafael.empleosproyecto.controller;


import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ils.rafael.empleosproyecto.model.vacante;
import ils.rafael.empleosproyecto.service.vacantesService;

@Controller
public class Principal {

	@Autowired
	vacantesService vacantesservicio;
	
	@GetMapping("/")
	public String paginainicio(Model model){

		
		List<vacante> lista  =  vacantesservicio.cargarvacante(); 
		
		model.addAttribute( "vacantes" , lista );
          	  			
		return "vacantes/home";
	}
	
	
	
	@GetMapping("/lista")
	public String mostrarlistadetalle(Model model){
        
		List<vacante> lista  =  vacantesservicio.cargarvacante(); 
		
		model.addAttribute( "vacantes" , lista );
          	  	
		return "vacantes/listadetalle";
	}
	

	

	
	
}
	