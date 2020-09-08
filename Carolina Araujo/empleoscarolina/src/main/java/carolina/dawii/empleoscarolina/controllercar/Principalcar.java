package carolina.dawii.empleoscarolina.controllercar;


import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import carolina.dawii.empleoscarolina.model.Vacante;



@Controller
public class Principalcar {
	
	/*
	@GetMapping("/")
	public String paginaInicial(Model model){
		
		String nombre="marta";
		Integer edad=19;
		Double peso=47.6;
		Boolean sexo=true;
		
		
		
		model.addAttribute("nombreV", nombre);
		model.addAttribute("edadV", edad);
		model.addAttribute("pesoV", peso);
		model.addAttribute("sexoV", sexo);
		
		return "homecar";
	}
	*/

	
	@GetMapping("/lista")
	public String mostrarLista(Model model){
		
		 List<Vacante> listas = cargaVacantes(); 

		 model.addAttribute("vacantesV", listas);
		 return "lista";
	}
	
	public List<Vacante> cargaVacantes(){
		
		Vacante mivacante1=new Vacante();
		mivacante1.setId(1);
		mivacante1.setNombre("Contador");
		mivacante1.setDescripcion("Finanzas de la empresa");
		mivacante1.setFecha(new Date());
		mivacante1.setSalario(125.90);
		mivacante1.setDestacada(1);
		mivacante1.setImagen("empresa1.png");
		
		
		Vacante mivacante2=new Vacante();
		mivacante2.setId(2);
		mivacante2.setNombre("Ingeniero de sistemas");
		mivacante2.setDescripcion("Programacion");
		mivacante2.setFecha(new Date());
		mivacante2.setSalario(250.90);
		mivacante2.setDestacada(2);
		mivacante2.setImagen("empresa2.png");
		
	
		Vacante mivacante3=new Vacante();
		mivacante3.setId(3);
		mivacante3.setNombre("Tecnico de reparaciones");
		mivacante3.setDescripcion("Instalaciones");
		mivacante3.setFecha(new Date());
		mivacante3.setSalario(120.90);
		mivacante3.setDestacada(3);
		mivacante3.setImagen("empresa3.png");
		
		
		  List<Vacante> lista =new LinkedList<>(); 
		  lista.add(mivacante1); 
		  lista.add(mivacante2);
		  lista.add(mivacante3); 
		  
		  return lista;
	}
	
	
	
}
