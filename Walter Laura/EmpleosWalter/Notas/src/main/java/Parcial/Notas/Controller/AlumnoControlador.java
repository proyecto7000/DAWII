package Parcial.Notas.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import Parcial.Notas.Model.alumno;
import Parcial.Notas.Service.IAlumno;


@Controller
@RequestMapping("/notas")
public class AlumnoControlador {

	@Autowired
	private IAlumno servicioAlumno;
	
	@GetMapping ("/Index")
	public String mostrarIndex(Model model) {
		List<alumno> listaS= servicioAlumno.listarAlumnos();

		model.addAttribute("Alumnos",listaS);
		
		return "notas/ListaAlumnos";
	}
	
	
	@GetMapping ("/Create")
	public String Crear(alumno alumno) {
		return "notas/NotasAlumnos";
	}

	@PostMapping("/Save")
	public String guardar(alumno alumno,double nota1,double nota2,Model model){
		
		servicioAlumno.guardarAlumno(alumno);
		
		return "redirect:/notas/Index";
	
	}
	
}
