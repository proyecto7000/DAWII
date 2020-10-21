package Practica.EmpleosWalter.Controlador;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import Practica.EmpleosWalter.Modelo.Perfil;
import Practica.EmpleosWalter.Modelo.Usuario;
import Practica.EmpleosWalter.Modelo.Vacantes;
import Practica.EmpleosWalter.Servicio.CategoriaService;
import Practica.EmpleosWalter.Servicio.IUsuariosService;
import Practica.EmpleosWalter.Servicio.VacantService;

@Controller
public class HomeController {

	@Autowired
	private CategoriaService servicioCategorias;
	
	@Autowired
	private VacantService servicioVacantes;
		
	@Autowired
   	private IUsuariosService servicioUsuarios;
	
	@GetMapping("/lista")
	public String mostrarLista(Model model) {
	
//		List<Vacantes> listaS= servicioVacantes.cargarDatos();
//		model.addAttribute("Vacantes",listaS);
		return "Listas";
	}
	
	@ModelAttribute
	public void  setGenericos(Model model) {
		
		Vacantes vacanteSearch = new Vacantes();
		vacanteSearch.reset();
		model.addAttribute("Vacantes",servicioVacantes.buscarDestacados());
		model.addAttribute("Categorias",servicioCategorias.buscarTodas());
		model.addAttribute("search",vacanteSearch);
	}
	
	//USuarios y perfiles
	
	
	@GetMapping("/CrearUsuario")
	public String registrarse(Usuario usuario) {
	
		return "usuarios/formUsuario";
	}
	
	@PostMapping("/GuardarUsuario")
	public String guardarRegistro(Usuario usuario, BindingResult resultado,RedirectAttributes Attributes) {
	
		usuario.setEstatus(1);
		usuario.setFechaRegistro(new Date());
		
		Perfil perfil = new Perfil();
		perfil.setId(3);
		usuario.agregar(perfil);
		
		for(ObjectError error: resultado.getAllErrors()){

            System.out.println("Ocurrio un error en : " +  error.getDefaultMessage()); 
		}
		
		if(resultado.hasErrors()){
			return "usuarios/formUsuario";
		}
			
		String   msje="Usuario agregado exitosamente";
        Attributes.addFlashAttribute("mensaje", msje);
		System.out.println(usuario.toString());
		servicioUsuarios.guardar(usuario);
		 
		return "redirect:/usuarios/index";
	}	
	
	@GetMapping("/search")
	public String buscar(@ModelAttribute("search") Vacantes vacante, Model model){
		
		System.out.println("Buscando por : "  + vacante );
		                                 // where  descripcion like '%?%'
		ExampleMatcher martcher =  ExampleMatcher.matching().withMatcher("descripcion", ExampleMatcher.GenericPropertyMatchers.contains());
		
		
		Example<Vacantes> example = Example.of(vacante,martcher);
		List<Vacantes> lista =  servicioVacantes.buscarByExample(example);
		//nombre del modelo para buscar
		model.addAttribute("Vacantes", lista);
		return "Listas";
	}
	
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		
		
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
		
	}
	
	
}

