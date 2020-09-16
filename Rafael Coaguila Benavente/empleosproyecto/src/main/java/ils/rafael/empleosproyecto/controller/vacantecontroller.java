package ils.rafael.empleosproyecto.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ils.rafael.empleosproyecto.model.vacante;
import ils.rafael.empleosproyecto.service.vacantesService;

@Controller
@RequestMapping(value="/vacantes")
public class vacantecontroller {

	
	@Autowired
	
	private vacantesService vacanteservicio;
	
	@GetMapping("/detalle/{id}")
	public String mostrardetalle(@PathVariable("id") int idvacante , Model model) {
		
        System.out.println("PathVariable:" + idvacante);    
        
        vacante estavacante =  vacanteservicio.buscaridvacante(idvacante);
        
		model.addAttribute("listados",estavacante );
		
		return "vacantes/detalle";
	}
	
	
	@GetMapping("/index")
	public String index(Model model) {
		
	    List<vacante>lista = vacanteservicio.cargarvacante();
		
		model.addAttribute("vacanteslista" , lista);
		
		return  "/vacantes/listavacantes";
	}
	
	
	
	
	@GetMapping("/createvacante")
	public String vacantenueva() 
	{
		return "/vacantes/formvacante";
	}
	
	@PostMapping("/savevacante")
	
	public String guardarvacante (vacante vacante )
	{
		
		System.out.println (vacante.toString());
		
		
		 return "/vacantes/listavacantes";
	}
	
	@InitBinder
	public  void  initBinder(WebDataBinder webDataBinder) {
		
		SimpleDateFormat dateFormat = new 	 SimpleDateFormat("dd-MM-yyyy");
		webDataBinder.registerCustomEditor(Date.class, new  CustomDateEditor(dateFormat , false)) ;
	}
	
	
	
//	@PostMapping("/savevacante")
//		public String vacantenueva
//	
//			(
//			@RequestParam("nombre") String nombre,
//			@RequestParam("descripcion") String descripcion,
//			@RequestParam("fecha") String fecha,
//			@RequestParam("destacada") String destacada,
//			@RequestParam("salario") String salario,
//			@RequestParam("categoria") String categoria
//			
//			)
//	
//	{
//		
//		System.out.println("nombre : "   + nombre);
//		System.out.println("descripcion : "   + descripcion);
//		System.out.println("fecha : "   + fecha);
//		System.out.println("destacada : "   + destacada);
//		System.out.println("salario : "   + salario);
//		System.out.println("categoria : "   + categoria);
//		
//		
//		return "/vacantes/listavacantes";
//	}
	
	
	
	
	
	
	
//	@GetMapping("/listadetalle")
//	public String listadetalles(@RequestParam("id") int idvacante , Model model) {
//		
//        System.out.println("PathVariable:" + idvacante);           
//		model.addAttribute("codigovacante",idvacante );
//		
//		return "vacantes/detalle";
//	}
//	
}
