package Nico.ils.EmpleoNicolas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import Nico.ils.EmpleoNicolas.model.Alumno;
import Nico.ils.EmpleoNicolas.service.INotasService;

@Controller
public class Notas {
	@Autowired
	private INotasService NotasServicio;
	
	@GetMapping("/lista")
	public String mostrarLista(Model model) {
		
		List<Alumno> lista = NotasServicio.CargaAlumnos();
		model.addAttribute("AlumnosV", lista);

		return "listaAlumnos";
	}
	
	@GetMapping("/create")
	public String nuevoAlumno(Alumno alumno) {

		return "notasAlumnos";
	}
	
	@PostMapping("/save")
	public String nuevaVacante(Alumno miAlumno, Model modelo ,@RequestParam("nota1") Double nota1, @RequestParam("nota2") Double nota2,RedirectAttributes prom){
		
		
		System.out.println(NotasServicio.calcularPromedio(nota1, nota2));
		prom.addFlashAttribute("promedio",NotasServicio.calcularPromedio(nota1, nota2));
		NotasServicio.guardarAlumno(miAlumno);
		
		System.out.println(miAlumno.toString());
		return "redirect:/lista";
	}

}
