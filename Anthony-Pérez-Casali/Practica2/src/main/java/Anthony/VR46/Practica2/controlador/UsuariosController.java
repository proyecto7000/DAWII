package Anthony.VR46.Practica2.controlador;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import Anthony.VR46.Practica2.Model.PERFIL;
import Anthony.VR46.Practica2.Model.USUARIO;
import Anthony.VR46.Practica2.Service.IUsuariosService;


@Controller
public class UsuariosController {
	@Autowired
	@Qualifier("usuarioServiceJPA")
	private IUsuariosService usuarioServicio;
	
	@GetMapping("/indexusuario")
	public String mostrarIndex(Model model) {
		List<USUARIO> Listauser= usuarioServicio.CargaUsuario();
		model.addAttribute("usuarios", Listauser);
    	return "USUARIOS/listUsuarios";
	}
	
	@PostMapping("/saveusuario")
	//@RequestMapping(value="/savecategoria", method=RequestMethod.POST)
	public String NuevaVacante(USUARIO usuario, BindingResult miresultado, RedirectAttributes atributos){
		
		usuario.setFechaRegistro(new Date());
		
		PERFIL perfil = new PERFIL();
		perfil.setId(3);
		usuario.agregar(perfil);
		
		for(ObjectError error: miresultado.getAllErrors()) {
			System.out.println("OCURRIO UN ERROR: " + error.getDefaultMessage());
			}
				
			if (miresultado.hasErrors()){
				return "/USUARIOS/formRegistro";
			}
				
			String msje = "USUARIO AGREGADO EXITOSAMENTE";
				
			atributos.addFlashAttribute("mensaje", msje);
						
			System.out.println(usuario.toString());
			usuarioServicio.guardarusuario(usuario);
			return "redirect:/indexusuario";
	    }
    
	//METODO DE EDICION JPA
			@GetMapping("/editaruser/{id}")
			public String EDITAR(@PathVariable("id") int idusuario, Model model)
			{
				USUARIO usuario = usuarioServicio.buscarPorId(idusuario);
				model.addAttribute("USUARIO", usuario);
				//model.addAttribute("Categorias", ServiceCategoria.cargarcategorias());
				return "USUARIOS/formRegistro";
			}
	
    @GetMapping("/deleteuser")
	public String eliminar(@RequestParam("id") int idusuario, RedirectAttributes attributes) {		    	
    	System.out.println("PathVariable: " + idusuario);
		usuarioServicio.eliminaruser(idusuario);
		attributes.addFlashAttribute("msg", "USUARIO ELIMINADA CON EXITO");
    	return "redirect:/indexusuario";
	}
}
