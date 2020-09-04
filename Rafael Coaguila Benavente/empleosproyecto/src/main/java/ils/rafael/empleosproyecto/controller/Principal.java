package ils.rafael.empleosproyecto.controller;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ils.rafael.empleosproyecto.model.vacante;

@Controller
public class Principal {

	
	@GetMapping("/inicio")
	public String paginainicio(Model model){
	model.addAttribute("mensaje","Rafael");
		
		return "home";
	}
	
	
	
	@GetMapping("/detalle")
	public String mostrarlistadetalle(Model model){
        
		vacante vacante1= new vacante();
		vacante1.setId(1);
		vacante1.setNombre("ingeniero de comunicaciones");
		vacante1.setDescripcion("se necesita ingeniero para soporte intranet");
		vacante1.setFecha(new Date());
		vacante1.setSalario(8000.0);
		vacante1.setDestacada(0);
		vacante1.setLogo("empresa1.png");
		
		
		vacante vacante2= new vacante();
		vacante2.setId(2);
		vacante2.setNombre("ingeniero de Sistemas");
		vacante2.setDescripcion("se necesita ingeniero de sistemas");
		vacante2.setFecha(new Date());
		vacante2.setSalario(10000.0);
		vacante2.setDestacada(1);
		vacante2.setLogo("empresa2.png");
		
		vacante vacante3= new vacante();
		vacante3.setId(3);
		vacante3.setNombre("Abogado");
		vacante3.setDescripcion(" Se necesita abogado se paga poco");
		vacante3.setFecha(new Date());
		vacante3.setSalario(320.50);
		vacante3.setDestacada(2);
		vacante3.setLogo("empresa3.png");
		
		vacante vacante4= new vacante();
		vacante4.setId(4);
		vacante4.setNombre("Doctor");
		vacante4.setDescripcion("se necesita Doctor con doctorado ");
		vacante4.setFecha(new Date());
		vacante4.setSalario(5650.0);
		vacante4.setDestacada(1);
    	
		
		
		List<vacante>  lista = new LinkedList<>();
		
		lista.add(vacante1);
		lista.add(vacante2);
		lista.add(vacante3);
		lista.add(vacante4);
		
		model.addAttribute( "vacantes" , lista );
          	  	
		return "detalle";
	}
	
	
}
