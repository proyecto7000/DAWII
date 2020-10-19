package Anthony.VR46.Practica2.controlador;

import java.util.Date;

//import java.util.Date;

//import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import Anthony.VR46.Practica2.Model.USUARIO;
import Anthony.VR46.Practica2.Model.VACANTE;
import Anthony.VR46.Practica2.Service.ICategoriasService;
import Anthony.VR46.Practica2.Service.IVacantesServices;



@Controller
public class Principal {
	
	
	@Autowired
	ICategoriasService categoriaServicio;
	
	@Autowired
	IVacantesServices vacanteServicio;
	
	@GetMapping("/VR46")
	public String PaginaPrimera(Model model) {
		List<VACANTE> Listas= vacanteServicio.CargaVacantes();
		model.addAttribute("VacantesV", Listas);
		return "Home";	
	}
	
	@GetMapping("/signup")
	public String registrarse(USUARIO usuario) {
		return "/USUARIOS/formRegistro";
	}
	
	@PostMapping("/signup")
	public String guardarRegistro(USUARIO usuario, RedirectAttributes attributes) {

		
		return "redirect:/usuarios/index";
	}
	
	
	
	@GetMapping("/lista")
	public String Mostrarlista(Model model) {
		List<VACANTE> Listas= vacanteServicio.CargaVacantes();
		model.addAttribute("VacantesV", Listas);
		return "lista";	
	}
	
	@GetMapping("/search")
	public String buscar(@ModelAttribute("search")  VACANTE vacante , Model model)
	{
		System.out.println("buscando por : " + vacante);
		Example<VACANTE> example = Example.of(vacante);
		List<VACANTE> lista = vacanteServicio.buscarByExample(example);
		model.addAttribute("vacantes", lista);
		return "Home";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder)
	{
		binder.registerCustomEditor(String.class,new StringTrimmerEditor(true));
	}
	
	@ModelAttribute
	public void setGenericos(Model model)
	{
		VACANTE vacanteSearch = new VACANTE();
		vacanteSearch.reset();
		model.addAttribute("vacantes", vacanteServicio.buscardestacadas());
		model.addAttribute("CATEGORIAS", categoriaServicio.cargarcategorias());
		model.addAttribute("search", vacanteSearch);
	}
//	@GetMapping("/lista")
//	public String MostrarLista(Model model) {
//		
//		VACANTE Vacante1 = new VACANTE();
//		Vacante1.setID(1);
//		Vacante1.setNombre("Contador");
//		Vacante1.setDescripcion("Finanzas");
//		Vacante1.setFecha(new Date());
//		Vacante1.setSalario(120.57);
//		Vacante1.setDestacado(1);
//		Vacante1.setImagen("empresa1.png");
//		
//		VACANTE Vacante2 = new VACANTE();
//		Vacante2.setID(2);
//		Vacante2.setNombre("Ingeniero Sistemas");
//		Vacante2.setDescripcion("software");
//		Vacante2.setFecha(new Date());
//		Vacante2.setSalario(124.57);
//		Vacante2.setDestacado(0);
//		Vacante2.setImagen("empresa2.png");
//		
//		VACANTE Vacante3 = new VACANTE();
//		Vacante3.setID(3);
//		Vacante3.setNombre("Medico");
//		Vacante3.setDescripcion("Forence");
//		Vacante3.setFecha(new Date());
//		Vacante3.setSalario(234.57);
//		Vacante3.setDestacado(1);
//		Vacante3.setImagen("empresa3.png");
//		
//		List<VACANTE> Lista = new LinkedList<>();
//		Lista.add(Vacante1);
//		Lista.add(Vacante2);
//		Lista.add(Vacante3);
//		
//		model.addAttribute("VacantesV", Lista);
//		
//		return "Lista";	
//	}

}
