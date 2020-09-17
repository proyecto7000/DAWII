package carolina.dawii.empleoscarolina.controllercar;


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

import carolina.dawii.empleoscarolina.model.Vacante;
import carolina.dawii.empleoscarolina.service.IVacantesService;

@Controller
@RequestMapping("/")
public class VacantesController {
	
	@Autowired
	private IVacantesService vacanteServicio;
	
	@GetMapping("/detalle/{id}")
	public String verDetalle(@PathVariable("id") int idVacante, Model model) {
		
		System.out.println("PathVariable: "+ idVacante);
		
		Vacante estaVacante= vacanteServicio.buscarPorId(idVacante);
		
		model.addAttribute("vacanteV", estaVacante);
		return "vacantes/detalle";
	}
	
	@GetMapping("/delete")
	public String borrar(@RequestParam("id") int id, Model miModelo) {
		//Procesamiento del parámetro. Aqui ya se hizo la conversion de String a int
		System.out.println("RequestParam: "+ id);
		miModelo.addAttribute("miId" , id);
		return "categorias/mensaje";
	}
	
	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		List<Vacante> listas=vacanteServicio.CargaVacantes();
		model.addAttribute("vacantesV", listas);
		return "/vacantes/listVacantes";
	}
	
	
	@GetMapping("/create")
	public String nuevaVacante() {
		return "vacantes/formVacante";
	}

	
	@PostMapping("/save")
	public String nuevaVacante(Vacante miVacante) {
		System.out.println(miVacante.toString());
		return "/lista";
	}
	
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		webDataBinder.registerCustomEditor(Date.class,  new CustomDateEditor(dateFormat, false));
	}
	
	
	
	
	
	/*
	 * @PostMapping("/save") public String nuevaVacante(
	 * 
	 * @RequestParam("nombre") String nombre,
	 * 
	 * @RequestParam("descripcion") String descripcion,
	 * 
	 * @RequestParam("fecha") String fecha,
	 * 
	 * @RequestParam("categoria") String categoria,
	 * 
	 * @RequestParam("salario") String salario,
	 * 
	 * @RequestParam("destacado") String destacado) {
	 * 
	 * 
	 * 
	 * System.out.println("nombre :"+ nombre); System.out.println("descripcion :"+
	 * descripcion); System.out.println("fecha :"+ fecha);
	 * System.out.println("categoria :"+ categoria); System.out.println("salario :"+
	 * salario); System.out.println("destacado :"+ destacado);
	 * 
	 * return "vacantes/listVacantes"; }
	 */
	

}
