package dawii.elena.empleoselena.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import dawii.elena.empleoselena.model.Vacante;
import dawii.elena.empleoselena.service.IVacantesService;




@Controller
public class Principalcar {
	
	@Autowired
	private IVacantesService vacanteServicio;
	
	@GetMapping("/lista")
	public String mostrarLista(Model model){
		List<Vacante> lista = vacanteServicio.CargaVacantes(); 
		 model.addAttribute("vacantesV", lista);
		 return "lista";
	}
	
	@GetMapping("/detalle")
	public String verDetalle(Model model) {
		
		Vacante mivacante1=new Vacante();
		
		mivacante1.setId(1);
		mivacante1.setNombre("Contador");
		mivacante1.setDescripcion("Finanzas de la empresa");
		mivacante1.setFecha(new Date());
		mivacante1.setSalario(900.90);
		mivacante1.setDestacado(1);
		mivacante1.setImagen("empresa1.png");
		
		return "detalle";
	}
	
	@GetMapping("/")
	public String paginaInicial(Model model) {
		
		List<Vacante> lista=vacanteServicio.CargaVacantes();
		model.addAttribute("vacantesV", lista);
		return "home";
	}
	
	

	
//	public List<Vacante> cargaVacantes(){
//		
//		Vacante mivacante1=new Vacante();
//		mivacante1.setId(1);
//		mivacante1.setNombre("Contador");
//		mivacante1.setDescripcion("Finanzas de la empresa");
//		mivacante1.setFecha(new Date());
//		mivacante1.setSalario(125.90);
//		mivacante1.setDestacada(1);
//		mivacante1.setImagen("empresa1.png");
//		
//		
//		Vacante mivacante2=new Vacante();
//		mivacante2.setId(2);
//		mivacante2.setNombre("Ingeniero de sistemas");
//		mivacante2.setDescripcion("Programacion");
//		mivacante2.setFecha(new Date());
//		mivacante2.setSalario(250.90);
//		mivacante2.setDestacada(2);
//		mivacante2.setImagen("empresa2.png");
//		
//	
//		Vacante mivacante3=new Vacante();
//		mivacante3.setId(3);
//		mivacante3.setNombre("Tecnico de reparaciones");
//		mivacante3.setDescripcion("Instalaciones");
//		mivacante3.setFecha(new Date());
//		mivacante3.setSalario(120.90);
//		mivacante3.setDestacada(3);
//		mivacante3.setImagen("empresa3.png");
//		
//		
//		  List<Vacante> lista =new LinkedList<>(); 
//		  lista.add(mivacante1); 
//		  lista.add(mivacante2);
//		  lista.add(mivacante3); 
//		  
//		  return lista;
//	}
//	
	
	
}
