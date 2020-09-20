package ils.dawii.empleos.Controller;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ils.dawii.empleos.model.Vacante;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String paginaInicial(Model model) {
		
		String nombre="abc";
		Integer edad=22;
		Double peso=40.30;
		Boolean sexo=true;
		
		model.addAttribute("nombreV",nombre);
		model.addAttribute("edadV",edad);
		model.addAttribute("pesoV",peso);
		model.addAttribute("sexoV",sexo);
		
		return "home";
	}
	
	@GetMapping("/detalle")
	public String mostrarDetalle(Model model) {
			
		Vacante miVacante=new Vacante();
		
		miVacante.setId(1);
		miVacante.setNombre("Contadr");
		miVacante.setDescripcion("Finanzas personal");
		miVacante.setFecha(new Date());
		miVacante.setSalario(110.43);
		
		model.addAttribute("vacanteV", miVacante);
		
		return "detalle";
	}	
	@GetMapping("/lista")
	public String mostrarLista(Model model){ 
		
	List<Vacante> listaS = cargaVacantes();
	
	model.addAttribute("vacantesV",listaS);
	
	return "lista";
	
	}
	
	public List<Vacante> cargaVacantes() {
		
		Vacante miVacante1=new Vacante();
		
		miVacante1.setId(1);
		miVacante1.setNombre("Contador");
		miVacante1.setDescripcion("Finanzas personales");
		miVacante1.setFecha(new Date());
		miVacante1.setSalario(123.43);
		
        Vacante miVacante2=new Vacante();
		
		miVacante2.setId(2);
		miVacante2.setNombre("Enfermero");
		miVacante2.setDescripcion("Para Ancianos");
		miVacante2.setFecha( new Date());
		miVacante2.setSalario(543.23);
		

        Vacante miVacante3=new Vacante();
		
		miVacante3.setId(3);
		miVacante3.setNombre("Electricista");
		miVacante3.setDescripcion("Instalacionesw caseras");
		miVacante3.setFecha( new Date());
		miVacante3.setSalario(800.41);
		
        List<Vacante> lista=new LinkedList<>();
		
		lista.add(miVacante1);
		lista.add(miVacante2);
		lista.add(miVacante3);
		
		
		return lista;
	}
}