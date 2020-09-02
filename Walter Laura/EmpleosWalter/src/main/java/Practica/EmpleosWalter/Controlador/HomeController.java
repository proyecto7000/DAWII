package Practica.EmpleosWalter.Controlador;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import Practica.EmpleosWalter.Modelo.Vacantes;

@Controller
public class HomeController {

	@GetMapping("/")
	public String Principal(Model modelo) {
		
		modelo.addAttribute("nombre","Walter Noel");
		return "Vista";
	}
	
	@GetMapping("/lista")
	public String mostrarLista(Model model) {
	
		List<Vacantes> listaS= cargar();
		model.addAttribute("Vacantes",listaS);
		return "Listas";
	}
	
	public List<Vacantes> cargar(){
		
		Vacantes v1=new Vacantes();
		v1.setCodigo(1);
		v1.setNombre("Miguel");
		v1.setEdad(25);
		v1.setDireccion("Rivero 205");
		v1.setTelefono(931478758);
		
		Vacantes v2=new Vacantes();
		v2.setCodigo(2);
		v2.setNombre("Juan");
		v2.setEdad(30);
		v2.setDireccion("Rivero 206");
		v2.setTelefono(921478783);
		
		Vacantes v3=new Vacantes();
		v3.setCodigo(3);
		v3.setNombre("Cesar");
		v3.setEdad(45);
		v3.setDireccion("Rivero 207");
		v3.setTelefono(976478198);
		
		Vacantes v4=new Vacantes();
		v4.setCodigo(4);
		v4.setNombre("Andrew");
		v4.setEdad(20);
		v4.setDireccion("Rivero 208");
		v4.setTelefono(946478156);
		
		List<Vacantes> listas=new LinkedList<>();
		
		listas.add(v1);
		listas.add(v2);
		listas.add(v3);
		listas.add(v4);
		
		return listas;
	}
}

