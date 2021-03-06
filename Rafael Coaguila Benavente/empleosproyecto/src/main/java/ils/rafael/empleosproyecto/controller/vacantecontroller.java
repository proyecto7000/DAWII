package ils.rafael.empleosproyecto.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.catalina.filters.AddDefaultCharsetFilter;
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

import ils.rafael.empleosproyecto.model.vacante;
import ils.rafael.empleosproyecto.service.icategoriasService;
import ils.rafael.empleosproyecto.service.vacantesService;
import ils.rafael.empleosproyecto.util.Utileria;

@Controller
@RequestMapping(value="/vacantes")
public class vacantecontroller {

	@Value("${empleosproyecto.ruta.imagenes}")
	private String ruta; 
	
	@Autowired
	private vacantesService vacanteservicio;
	 
	@Autowired
	private icategoriasService  categoriaservicio;

	
	@GetMapping("/detalle/{id}")
	public String mostrardetalle(@PathVariable("id") int idvacante , Model model) {
		
        System.out.println("PathVariable:" + idvacante);    
        
        vacante estavacante =  vacanteservicio.buscaridvacante(idvacante);
        
		model.addAttribute("listados",estavacante );
		
		return "/vacantes/detalle";
	}
	
	
	@GetMapping("/index")
	public String index(Model model) {
		
	    List<vacante>lista = vacanteservicio.cargarvacante();
		
		model.addAttribute("vacanteslista" , lista);
		
		return  "/vacantes/listavacantes";
	}
	
	
	
	
	
	@GetMapping(value ="/indexPaginate")
	public String mostraIndexPaginado( Model model, Pageable page) {
		
		 Page<vacante> lista =  vacanteservicio.cargarvacante(page);
		
		model.addAttribute("vacanteslista" , lista);
		
		return "/vacantes/listavacantes";
	}
	
	
	
	
	
	@GetMapping("/createvacante")
	public String vacantenueva( vacante vacante, Model model) 
	{
		model.addAttribute("categoriasD" , categoriaservicio.buscarTodas());
		
		
		return "/vacantes/formvacante";
	}
	
	
	@GetMapping("/delete/{id}")
         public String eliminar(@PathVariable("id") int id, RedirectAttributes attributes) {
		
        System.out.println("Borrando vacante por id:" + id);    
        vacanteservicio.eliminar(id); 
		attributes.addFlashAttribute("msg", "la vacante fue eliminada con exito!");
		return "redirect:/vacantes/index";
	}
	
	
	@GetMapping("/editar/{id}")
    public String editar(@PathVariable("id") int idvacante, Model model) {
	
                 vacante vacante = vacanteservicio.buscaridvacante(idvacante);
                 model.addAttribute("vacante"  , vacante);
                 model.addAttribute("categoriasD" , categoriaservicio.buscarTodas());
                 
	return "vacantes/formvacante";
}
	
	
	
	@PostMapping("/savevacante")
	public String guardarvaca(vacante vacante, BindingResult resultado,RedirectAttributes Attributes,  @RequestParam("archivoImagen") MultipartFile multiPart) 
	{
		
		
		
		
		if(resultado.hasErrors()){
			
			for(ObjectError error: resultado.getAllErrors()){

                System.out.println("Ocurrio un error en : " +  error.getDefaultMessage()); 
}
			
			return "/vacantes/formvacante";
		}
		
		String   msje="Vacante agregada exitosamente";
		
            Attributes.addFlashAttribute("mensaje", msje);
		
		
		 
            if (!multiPart.isEmpty()) {
            	//String ruta = "/empleos/img-vacantes/"; // Linux/MAC
            	//String ruta = "f:/empleos/img-vacantes/"; // Windows
            	String nombreImagen = Utileria.guardarArchivo(multiPart, ruta);
            	if (nombreImagen != null){ // La imagen si se subio
            	// Procesamos la variable nombreImagen
            	vacante.setImagen(nombreImagen); 
            	
            	}
            }
            
		
		
		System.out.println(vacante.toString());
		vacanteservicio.guardarvacante(vacante);
		 return "redirect:/";
	}
	
	
	
	@ModelAttribute
	public void setGenericos(Model model) {
		 model.addAttribute("categoriasD" , categoriaservicio.buscarTodas());
	}
	
	
	
	
	
	@InitBinder
	public  void  initBinder(WebDataBinder webDataBinder) {
		
		SimpleDateFormat dateFormat = new 	 SimpleDateFormat("dd-MM-yyyy");
		webDataBinder.registerCustomEditor(Date.class, new  CustomDateEditor(dateFormat , false)) ;
	}
	
	
	
//	@PostMapping("/savevacante")
//		public String vacantenueva
//	
//			(
//			@RequestParam("nombre") String nombre,
//			@RequestParam("descripcion") String descripcion,
//			@RequestParam("fecha") String fecha,
//			@RequestParam("destacada") String destacada,
//			@RequestParam("salario") String salario,
//			@RequestParam("categoria") String categoria
//			
//			)
//	
//	{
//		
//		System.out.println("nombre : "   + nombre);
//		System.out.println("descripcion : "   + descripcion);
//		System.out.println("fecha : "   + fecha);
//		System.out.println("destacada : "   + destacada);
//		System.out.println("salario : "   + salario);
//		System.out.println("categoria : "   + categoria);
//		
//		
//		return "/vacantes/listavacantes";
//	}
	
	
	
	
	
	
	
//	@GetMapping("/listadetalle")
//	public String listadetalles(@RequestParam("id") int idvacante , Model model) {
//		
//        System.out.println("PathVariable:" + idvacante);           
//		model.addAttribute("codigovacante",idvacante );
//		
//		return "vacantes/detalle";
//	}
//	
}
