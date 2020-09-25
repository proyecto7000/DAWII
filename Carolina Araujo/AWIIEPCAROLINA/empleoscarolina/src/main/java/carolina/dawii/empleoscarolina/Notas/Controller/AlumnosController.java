package carolina.dawii.empleoscarolina.Notas.Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import carolina.dawii.empleoscarolina.Notas.Model.Alumno;
import carolina.dawii.empleoscarolina.Notas.Service.IAlumnosService;


@Controller
@RequestMapping(value="/alumnos")
public class AlumnosController {

	@Autowired IAlumnosService alumnoServicio;
	
	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		List<Alumno> listas=alumnoServicio.listarAlumnos();
		model.addAttribute("alumnos", listas);
		return "/ListaAlumnos";
		
		
		
	}
	
	@GetMapping("/create")
	public String guardarAlumno(Alumno alumno) {
		return "/NotasAlumnos";
	}
	
	
	@PostMapping("/save")
	public String guardarAlumno(Alumno alumno, BindingResult result, RedirectAttributes attributes ) { 
		if(result.hasErrors()) {
			for(ObjectError error: result.getAllErrors()) {
				System.out.println("Ocurrio un error: "+error.getDefaultMessage());
			}

				return "/NotasAlumnos";
		}
	
		alumnoServicio.guardarAlumno(alumno);
		attributes.addFlashAttribute("msg", "Registro guardado");
		System.out.println("Alumno: "+alumno);
		
		return "redirect:/listaAlumnos";
	}
	

	
	
	
}
