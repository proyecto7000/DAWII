package Anthony.VR46.Practica2.controlador;

import java.util.Date;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import Anthony.VR46.Practica2.Model.VACANTE;



@Controller
public class Principal {
	@GetMapping("/VR46")
	public String PaginaPrimera(Model model) {
		model.addAttribute("Nombre", "Anthony Pérez Casali");
		return "Home";	
	}
	
	@GetMapping("/")
	public String MostrarLista(Model model) {
		
		VACANTE Vacante1 = new VACANTE();
		Vacante1.setID(1);
		Vacante1.setNombre("Contador");
		Vacante1.setDescripcion("Finanzas");
		Vacante1.setFecha(new Date());
		Vacante1.setSalario(120.57);
		
		VACANTE Vacante2 = new VACANTE();
		Vacante2.setID(2);
		Vacante2.setNombre("Ingeniero Sistemas");
		Vacante2.setDescripcion("software");
		Vacante2.setFecha(new Date());
		Vacante2.setSalario(124.57);
		
		VACANTE Vacante3 = new VACANTE();
		Vacante3.setID(3);
		Vacante3.setNombre("Medico");
		Vacante3.setDescripcion("Forence");
		Vacante3.setFecha(new Date());
		Vacante3.setSalario(234.57);
		
		List<VACANTE> Lista = new LinkedList<>();
		Lista.add(Vacante1);
		Lista.add(Vacante2);
		Lista.add(Vacante3);
		
		model.addAttribute("VacantesV", Lista);
		
		return "Lista";	
	}

}
