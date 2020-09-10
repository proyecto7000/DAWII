package ils.rafael.empleosproyecto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class vacantecontroller {

	@GetMapping("vacantes/detalle/{id}")
	public String mostrardetalle(@PathVariable("id") int idvacante , Model model) {
		
        System.out.println("PathVariable:" + idvacante);           
		model.addAttribute("codigovacante",idvacante );
		
		return "vacantes/detalle";
	}
	
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