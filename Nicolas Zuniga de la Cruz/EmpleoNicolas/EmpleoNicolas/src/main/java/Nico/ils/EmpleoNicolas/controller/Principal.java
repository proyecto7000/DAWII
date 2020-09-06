package Nico.ils.EmpleoNicolas.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import Nico.ils.EmpleoNicolas.model.Vacante;

@Controller

public class Principal {
	
	@GetMapping("/tabla")
	public String mostrarTabla(Model model) {
		List<Vacante> lista = getVacantes();
		model.addAttribute("vacantesV", lista);
		return "tabla";
	}
	
	
	
//@GetMapping("/")
//public String paginaInicial(Model model) {
//
////	String nombre="abc";
////	Integer edad=22;
////	Double peso=40.3;
////	Boolean sexo=true;
////	
////	model.addAttribute("nombreV",nombre);
////	model.addAttribute("edadV",edad);
////	model.addAttribute("pesoV",peso);
////	model.addAttribute("sexoV",sexo);
//
//	// MODELO 2
//	
//	String nombre="Auxiliar de Contabilidad";
//	Date fechaPub=new Date();
//	double salario=9000.0;
//	boolean vigente=true;
//	
//	model.addAttribute("nombre",nombre);
//	model.addAttribute("fecha",fechaPub);
//	model.addAttribute("salario",salario);
//	model.addAttribute("vigente",vigente);
//	
//	
//	return "home";
//}

@GetMapping("/detalle")
public String mostrarDetalle(Model model) {
	
	Vacante vacante=new Vacante();
	
	vacante.setNombre("Ingenier de Comunicaciones");
	vacante.setDescripcion("Se solicita ingeniero para dar soporte a intranet");
	vacante.setFecha(new Date());
	vacante.setSalario(9700.00);
	
	model.addAttribute("vacante",vacante);
	return "detalle";
}

@GetMapping("/listado")
public String mostrarListado(Model model) {
//	List<String> lista=new LinkedList<String>();
//	lista.add("Ingeniero de sistemas");
//	lista.add("Auxiliar de Contabilidad");
//	lista.add("Vendedor");
//	lista.add("Arquitecto");
//	
//	model.addAttribute("empleos",lista);
	
	
	
	return "listado";
}









private List<Vacante> getVacantes(){
	SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
	List<Vacante> lista=new LinkedList<Vacante>();
	try {
		//oferta de trabajo 1
		Vacante vacante1=new Vacante();
		vacante1.setId(1);
		vacante1.setNombre("Ingeniero Civil");
		vacante1.setDescripcion("Solicitamos Ing Civil para diseñar puente peatonal");
		vacante1.setFecha(sdf.parse("08-02-2020"));
		vacante1.setSalario(8500.00);
		vacante1.setDestacada(1);
		vacante1.setImagen("img1.png");
		//oferta de trabajo 2
				Vacante vacante2=new Vacante();
				vacante2.setId(2);
				vacante2.setNombre("Contador Publico");
				vacante2.setDescripcion("Empresa importante solicita contador con 5 años de experiencia titulado");
				vacante2.setFecha(sdf.parse("09-02-2020"));
				vacante2.setSalario(12000.00);
				vacante2.setDestacada(2);
				vacante2.setImagen("img2.png");
		
		//oferta de trabajo 3
				Vacante vacante3=new Vacante();
				vacante3.setId(3);
				vacante3.setNombre("Ingeniero Electronico");
				vacante3.setDescripcion("Empresa internacional solicita mecanico para mant e inst elèctrica");
				vacante3.setFecha(sdf.parse("10-02-2020"));
				vacante3.setSalario(10500.00);
				vacante3.setDestacada(3);
				vacante3.setImagen("img3.png");
				
		//oferta de trabajo 4.
				Vacante vacante4=new Vacante();
				vacante4.setId(4);
				vacante4.setNombre("Diseñador Grafico");
				vacante4.setDescripcion("Solicitamos Diseñador Gràfio titulado para diseñar publicidad de la empresa");
				vacante4.setFecha(sdf.parse("11-02-2020"));
				vacante4.setSalario(7500.00);
				vacante4.setDestacada(0);
				//AGREGAMOS A LA LISTA
				lista.add(vacante1);
				lista.add(vacante2);
				lista.add(vacante3);
				lista.add(vacante4);
	}catch(ParseException e) {
		System.out.println("Error: " + e.getMessage());
	}
	return lista;
}


}
