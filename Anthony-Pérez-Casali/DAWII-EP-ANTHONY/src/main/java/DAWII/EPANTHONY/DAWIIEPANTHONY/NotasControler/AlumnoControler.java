package DAWII.EPANTHONY.DAWIIEPANTHONY.NotasControler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import DAWII.EPANTHONY.DAWIIEPANTHONY.Model.Alumnos;
import DAWII.EPANTHONY.DAWIIEPANTHONY.Service.INotaService;

@Controller
public class AlumnoControler 
{
	@Autowired
	INotaService alumnoservicio;
	
	@GetMapping("/indexalumno")
	public String MostrarLista(Model model){
		List<Alumnos> Lista = alumnoservicio.listarAlumnos();
		model.addAttribute("ALUMNO", Lista );
		return "/ALUMNOS/ListaAlumnos.html";
	}
	
	@GetMapping("/createalumno")
	public String CrearAlm(Alumnos alumno, Model model) 
	{
//		model.addAttribute("Alumnos", alumnoservicio.guardarAlumno());
		return "/NOTAS/NotasAlumno";
	}
	
	@GetMapping("/savealumno")
	public String guardaralumno(Alumnos alumno, Model model) 
	{
		return "redirect:/indexalumno";
	}
}
