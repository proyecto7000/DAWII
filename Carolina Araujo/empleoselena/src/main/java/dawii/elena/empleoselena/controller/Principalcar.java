package dawii.elena.empleoselena.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import dawii.elena.empleoselena.model.Perfil;
import dawii.elena.empleoselena.model.Usuario;
import dawii.elena.empleoselena.model.Vacante;
import dawii.elena.empleoselena.service.ICategoriasService;
import dawii.elena.empleoselena.service.IUsuariosService;
import dawii.elena.empleoselena.service.IVacantesService;




@Controller
public class Principalcar {
	
	@Autowired
	private IVacantesService vacanteServicio;
	
	@Autowired
	private ICategoriasService categoriaServicio;
	
	@Autowired
	private IUsuariosService usuarioServicio;
	
	
	@GetMapping("/lista")
	public String mostrarLista(Model model){
		List<Vacante> lista = vacanteServicio.buscarTodas(); 
		 model.addAttribute("vacantesV", lista);
		 return "lista";
	}

	
	@GetMapping("/")
	public String paginaInicial(Model model) {
		
		List<Vacante> lista=vacanteServicio.buscarTodas();
		model.addAttribute("vacante", lista);
		return "home";
	}
	
	
	@GetMapping("/signup")
	public String registrarse(Usuario usuario) {
		return "usuarios/formRegistro";
	}
	
	
	@PostMapping("/signup")
	public String guardarRegistro(Usuario usuario, RedirectAttributes attributes) {

		// Ejercicio
		usuario.setEstatus(1);
		usuario.setFechaRegistro(new Date());
		
		Perfil perfil = new Perfil();
		perfil.setId(3);
		usuario.agregar(perfil);
		
		usuarioServicio.guardar(usuario);
		attributes.addFlashAttribute("msg", "El registro se realizo exitosamente!");
		
		return "redirect:/usuarios/index";
	}

	
	
	
	
	@GetMapping("/search")
	public String buscar(@ModelAttribute("search") Vacante vacante, Model model) {
		System.out.println("Buscando por : "+ vacante);
		
		ExampleMatcher matcher = ExampleMatcher.
				//where descripcion like '%?%'
				matching().withMatcher("descripcion", ExampleMatcher.GenericPropertyMatchers.contains());
		
		Example<Vacante> example = Example.of(vacante);
		List<Vacante> lista = vacanteServicio.buscarByExample(example);
		model.addAttribute("vacantesV", lista);
		return "home";
	}
	
	@InitBinder
	public void InitBender(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}
	
	@ModelAttribute
	public void setGenericos(Model model) {
		Vacante vacanteSearch = new Vacante();
		vacanteSearch.reset();
		model.addAttribute("vacantesV", vacanteServicio.buscarDestacadas());
		model.addAttribute("listaCategorias", categoriaServicio.buscarTodas());
		model.addAttribute("search",vacanteSearch);
		
	}
	
	
	
	
	
	
	
	
	
	
	
//	@GetMapping("/detalle")
//	public String verDetalle(Model model) {
//		
//		Vacante mivacante1=new Vacante();
//		
//		mivacante1.setId(1);
//		mivacante1.setNombre("Contador");
//		mivacante1.setDescripcion("Finanzas de la empresa");
//		mivacante1.setFecha(new Date());
//		mivacante1.setSalario(900.90);
//		mivacante1.setDestacado(1);
//		mivacante1.setImagen("empresa1.png");
//		
//		return "detalle";
//	}
	
	
	
	

	
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
