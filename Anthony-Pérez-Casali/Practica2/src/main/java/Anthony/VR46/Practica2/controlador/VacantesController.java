package Anthony.VR46.Practica2.controlador;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import Anthony.VR46.Practica2.Model.VACANTE;
import Anthony.VR46.Practica2.Service.ICategoriasService;
import Anthony.VR46.Practica2.Service.IVacantesServices;
import Anthony.VR46.Practica2.Util.Utileria;

@Controller
public class VacantesController {
	
	@Value("${empleosApp.ruta.imagenes}")
	private String ruta;
	
	@Autowired
	private IVacantesServices vacantesServicio;
	
	@Autowired
	@Qualifier("categoriasServiceJPA")
	 private ICategoriasService ServiceCategoria;
	
	//Implemente el controlador /vacantes/index 
	@GetMapping("/indexvacante")
	public String MostrarIndex(Model model){
		List<VACANTE> Listas= vacantesServicio.CargaVacantes();
		model.addAttribute("VacantesV", Listas);
		return "/VACANTES/listVacantes";
	}
	
	@GetMapping("/detalle/{id}")
	public String mostrarDetalle(@PathVariable("id") int idVacante,Model model){
	System.out.println("PathVariable: " + idVacante);
	VACANTE vacante = vacantesServicio.buscarporID(idVacante);
	model.addAttribute("MiVacante", vacante);
	return "VACANTES/Detalle";
	}
	
	@GetMapping("/delete")
	public String Borrar(@RequestParam("ID") int id, Model mimodelo){
	// Procesamiento del parámetro. Aquí, ya se hizo la conversión a String a int.
	System.out.println("RequestParam: " + id);
	mimodelo.addAttribute("ID", id);
	return "CATEGORIAS/Mensaje";
	}
	
	@GetMapping("/createvacante")
	public String NuevaVacante(VACANTE vacante , Model model)
	{
		model.addAttribute("Categorias", ServiceCategoria.cargarcategorias());
		return "VACANTES/formVacante";
	}
	
	@PostMapping("/savevacante")
	public String guardarvacante(VACANTE vacante, BindingResult miresultado, RedirectAttributes Attributes,@RequestParam("archivoImagen") MultipartFile multiPart)
	{
		
		
		for(ObjectError error: miresultado.getAllErrors()) 
		{
			System.out.println("OCURRIO UN ERROR: " + error.getDefaultMessage());
		}
		
		if (miresultado.hasErrors())
		{
			return "/VACANTES/formVacante";
		}
		
		if (!multiPart.isEmpty()) {
			//String ruta = "/empleos/img-vacantes/"; // Linux/MAC
			//String ruta = "c:/empleos/img-vacantes/"; // Windows
			String nombreImagen = Utileria.guardarArchivo(multiPart, ruta);
			if (nombreImagen != null){ // La imagen si se subio
			// Procesamos la variable nombreImagen
			vacante.setImagen(nombreImagen);
			}
		}
		
		
		String msje = "VACANTE AGREGADA EXITOSAMENTE";
		
		Attributes.addFlashAttribute("mensaje", msje);
				
		System.out.println(vacante.toString());
		vacantesServicio.guardarVacante(vacante);
		return "redirect:/indexvacante";
    }
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
//	@PostMapping("/savevacante")
//	public String NuevaVacante(
//
//			@RequestParam("nombre") String nombre,
//			@RequestParam("descripcion") String descripcion,
//			@RequestParam("fecha") String fecha,
//			@RequestParam("categoria") String categoria,
//			@RequestParam("salario") String salario,
//			@RequestParam("destacado") String destacado
//			
//			){
//			
//			System.out.println("NOMBRE : "+ nombre);
//			System.out.println("DESCRIPCION : "+ descripcion);
//			System.out.println("FECHA : "+ fecha);
//			System.out.println("CATEGORIA : "+ categoria);
//			System.out.println("SALARIO : "+ salario);
//			System.out.println("DESTACADO : "+ destacado);
//		
//	return "/VACANTES/ListaVacantes";
//	}
}
