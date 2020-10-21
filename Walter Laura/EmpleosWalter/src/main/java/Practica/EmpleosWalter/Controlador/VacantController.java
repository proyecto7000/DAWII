package Practica.EmpleosWalter.Controlador;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import Practica.EmpleosWalter.Modelo.Vacantes;
import Practica.EmpleosWalter.Servicio.CategoriaService;
import Practica.EmpleosWalter.Servicio.VacantService;
import Practica.EmpleosWalter.Util.Utileria;

@Controller
@RequestMapping("/vacantes")
public class VacantController {

	@Value("${empleosapp.ruta.imagenes}")
	private String ruta;
	
	@Autowired
	private VacantService servicioVacantes;
	
	@Autowired
//	@Qualifier("CategoriasServiceJPA")
	private CategoriaService servicioCategorias;
	
	@GetMapping ("/Index")
	public String mostrarIndex(Model model) {
		
		List<Vacantes> listaS= servicioVacantes.cargarDatos();
		model.addAttribute("Vacantes",listaS);
		return "vacantes/listVacante";
	}
	
	//paginacion
	@GetMapping(value="/indexPaginate")
	public String mostrarIndexPaginado(Model model, Pageable page) {
		Page<Vacantes>listaS=servicioVacantes.buscarTodas(page);
		model.addAttribute("Vacantes",listaS);
		return "vacantes/listVacante";
	}
	
	@GetMapping ("/Create")
	public String Crear(Vacantes vacante,Model model) {

		return "vacantes/formVacante";
	}

	@PostMapping("/Save")
	public String guardar(Vacantes vacante, BindingResult result,RedirectAttributes Attributes,
			@RequestParam("archivoImagen") MultipartFile multipart){
		
		if(result.hasErrors()){
		for(ObjectError error: result.getAllErrors()){

            System.out.println("Ocurrio un error en : " +  error.getDefaultMessage()); 
		}

			return "vacantes/formVacante";
		}

		if(!multipart.isEmpty()) {
			//String ruta="c:/empleos/img-vacantes/";
			String nombreImagen =Utileria.guardarArchivo(multipart, ruta);
			if(nombreImagen !=null) {
				vacante.setImagen(nombreImagen);
			}
		}
		
		
		String   msje="Vacante agregada exitosamente";
		
        Attributes.addFlashAttribute("mensaje", msje);
		
		servicioVacantes.guardar(vacante);
		return "redirect:/vacantes/Index";
	
	}
	
	//borrar vacante
	@GetMapping ("/Borrar/{id}")
	public String eliminar(@RequestParam("id")int idVacante, RedirectAttributes Attributes) {
		System.out.println("Borrando vacante con id: "+idVacante);
		servicioVacantes.eliminar(idVacante);
		Attributes.addFlashAttribute("msj", "La vacante fue eliminada");
		return "redirect:/vacantes/Index";
	}
	
//	//editar vacante
	
	@GetMapping("/Editar/{id}")
	public String editar(@PathVariable("id") int idVacante,Model model) {
		
		Vacantes vacante=servicioVacantes.buscarId(idVacante);
		model.addAttribute("vacantes", vacante);

		return "vacantes/formVacante";
	}
	
	
	@GetMapping("/Vistas/{id}")
	public String mostrardetalle(@PathVariable("id") int idvacante , Model model) {
		
        System.out.println("PathVariable:" + idvacante);    
        
        Vacantes estavacante =  servicioVacantes.buscarId(idvacante);
        
		model.addAttribute("VacanteV",estavacante );
		
		return "vacantes/detalle";
	}
	
	@ModelAttribute
	public void  setGenericos(Model model) {
		model.addAttribute("categorias", servicioCategorias.buscarTodas());
	}
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	} 
	
}
