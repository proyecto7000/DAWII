package dawii.elena.empleoselena.controller;

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

import dawii.elena.empleoselena.model.Categoria;
import dawii.elena.empleoselena.model.Vacante;
import dawii.elena.empleoselena.service.ICategoriasService;
import dawii.elena.empleoselena.service.IVacantesService;
import dawii.elena.empleoselena.util.Utileria;



@Controller
@RequestMapping(value="/VACANTE")
public class VacantesController {
	
	@Value("${empleoscarolina.ruta.imagenes}")
	private String ruta;
	
	@Autowired
	private IVacantesService vacanteServicio;
	
	
	@Autowired
	private ICategoriasService categoriaServicio;
	
	
	
	@GetMapping("/index")
	public String mostrarIndex(Model model) { 
		List<Vacante> listas=vacanteServicio.buscarTodas();
		model.addAttribute("vacantesV", listas);
		return "vacantes/listVacantes";
	}
	
	@GetMapping(value="/indexPaginate")
	public String mostrarIndexPaginado(Model model, Pageable page) { 
		Page<Vacante> listas=vacanteServicio.buscarTodas(page);
		model.addAttribute("vacantesV", listas);
		return "vacantes/listVacantes";
	}
	
	
	
	@GetMapping("/create")
	public String nuevaVacante(Vacante vacante, Model model) {
		model.addAttribute("categorias", categoriaServicio.buscarTodas());
		return "/vacantes/formVacante";
	}

	
	@GetMapping("/detalle/{id}")
	public String verDetalle(@PathVariable("id") int idVacante, Model model) {
		System.out.println("PathVariable: " + idVacante);
		Vacante vacante= vacanteServicio.buscarPorId(idVacante);	
		model.addAttribute("vacante", vacante);
		return "vacantes/detalle";
	}
	
	
	
	@GetMapping("/delete/{id}")
	public String borrar(@PathVariable("id") int idVacante, RedirectAttributes attributes) {
		//Procesamiento del parámetro. Aqui ya se hizo la conversion de String a int
		System.out.println("Borrando vacante con id: "+ idVacante);
		vacanteServicio.eliminar(idVacante);
		attributes.addFlashAttribute("msg","La vacante fue eliminada!");
		return "redirect:/VACANTE/index";
	}
	
	@GetMapping("/edit/{id}")
	public String editar(@PathVariable("id") int idVacante, Model model) {
		Vacante vacante = vacanteServicio.buscarPorId(idVacante);
		model.addAttribute("vacante", vacante);
		//model.addAttribute("categorias", categoriaServicio.buscarTodas());
		return "vacantes/formVacante";
	}
	
	@PostMapping("/save")
	public String guardarVacante(Vacante vacante, BindingResult result, RedirectAttributes attributes, 
	@RequestParam("archivoImagen") MultipartFile multiPart) {
		if(result.hasErrors()) {
			for(ObjectError error: result.getAllErrors()) {
				System.out.println("Ocurrio un error: "+error.getDefaultMessage());
			}
				return "/vacantes/formVacante";			
		}
		
		if (!multiPart.isEmpty()) {
			//String ruta = "/empleos/img-vacantes/"; // Linux/MAC
			String ruta = "c:/empleos/img-vacantes/"; // Windows
			String nombreImagen = Utileria.guardarArchivo(multiPart, ruta);
			if (nombreImagen != null){ // La imagen si se subio
			// Procesamos la variable nombreImagen
			vacante.setImagen(nombreImagen); 
		
			}
		}

		
		vacanteServicio.guardarVacante(vacante);
		attributes.addFlashAttribute("msg","Registro guardado");
		System.out.println("vacante: "+ vacante );
		return "redirect:/";
	}
	
	@ModelAttribute
	public void setGenericos(Model model) {
		model.addAttribute("categoria", categoriaServicio.buscarTodas());
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
