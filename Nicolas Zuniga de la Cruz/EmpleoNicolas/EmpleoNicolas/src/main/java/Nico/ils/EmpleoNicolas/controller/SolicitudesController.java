package Nico.ils.EmpleoNicolas.controller;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import Nico.ils.EmpleoNicolas.model.Solicitud;
import Nico.ils.EmpleoNicolas.model.Vacante;
import Nico.ils.EmpleoNicolas.service.ISolicitudesService;

@Controller
@RequestMapping("/solicitudes")
public class SolicitudesController {
	
	@Autowired
	private ISolicitudesService solicitudServicio;
	
	
	
	@Value("${empleosapp.ruta.cv}")
	private String ruta;
	
    /**
	 * Metodo que muestra la lista de solicitudes sin paginacion
	 * Seguridad: Solo disponible para un usuarios con perfil ADMINISTRADOR/SUPERVISOR.
	 * @return
	 */
    @GetMapping("/index") 
	public String mostrarIndex(Model model) {
    	
    	List<Solicitud> lista=solicitudServicio.buscarTodas();
    	model.addAttribute("Solicitudes", lista);
    	
    	
		return "solicitud/listSolicitudes";
		
	}
    
    /**
	 * Metodo que muestra la lista de solicitudes con paginacion
	 * Seguridad: Solo disponible para usuarios con perfil ADMINISTRADOR/SUPERVISOR.
	 * @return
	 */
	@GetMapping("/indexPaginate")
	public String mostrarIndexPaginado() {
		
		// EJERCICIO
		return "solicitud/listSolicitudes";
		
	}
    
	/**
	 * Método para renderizar el formulario para aplicar para una Vacante
	 * Seguridad: Solo disponible para un usuario con perfil USUARIO.
	 * @return
	 */
	@GetMapping("/create/{idVacante}")
	public String crear(Solicitud solicitud) {
		return "solicitud/formSolicitud";
		
	}
	
	/**
	 * Método que guarda la solicitud enviada por el usuario en la base de datos
	 * Seguridad: Solo disponible para un usuario con perfil USUARIO.
	 * @return
	 */
	@PostMapping("/save")
	public String guardar(Solicitud solicitud, BindingResult miResultado, RedirectAttributes atributo) {
		
		if(miResultado.hasErrors()) {
			
			for(ObjectError error: miResultado.getAllErrors()) {
				System.out.println("Ocurrio un Error: "+error.getDefaultMessage());	
			}
			return "solicitud/formSolicitud";	
			}
			
			String msj="Solicitud Agregada";
			atributo.addFlashAttribute("msjSolicitud",msj);
			
			solicitudServicio.guardar(solicitud);
			
			System.out.println(solicitud.toString());
			
			return "redirect:/solicitud/index";
		
	}
	
	/**
	 * Método para eliminar una solicitud
	 * Seguridad: Solo disponible para usuarios con perfil ADMINISTRADOR/SUPERVISOR. 
	 * @return
	 */
	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable("id") int id, RedirectAttributes attributes) {
		System.out.println("Id de solicitud a eliminar: "+ id);
		solicitudServicio.eliminar(id);
		attributes.addFlashAttribute("msj", "Solicitud eliminada con exito!");
		return "redirect:/solicitud/index";
		//return "redirect:/solicitudes/indexPaginate";
		
	}
			
	/**
	 * Personalizamos el Data Binding para todas las propiedades de tipo Date
	 * @param webDataBinder
	 */
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

}
