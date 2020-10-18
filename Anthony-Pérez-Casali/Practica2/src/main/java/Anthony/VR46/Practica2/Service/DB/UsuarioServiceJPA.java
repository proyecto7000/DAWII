package Anthony.VR46.Practica2.Service.DB;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import Anthony.VR46.Practica2.Model.USUARIO;
import Anthony.VR46.Practica2.Respositorio.USUARIOSRepositorio;
import Anthony.VR46.Practica2.Service.IUsuariosService;

@Service
@Primary
public class UsuarioServiceJPA implements IUsuariosService {

	@Autowired
	private USUARIOSRepositorio usuariosrepositorio;
	
	public List<USUARIO> CargaUsuario() {
		// TODO Auto-generated method stub
		return usuariosrepositorio.findAll();
	}
	
	public void guardarusuario(USUARIO usuario) {
		// TODO Auto-generated method stub
		usuariosrepositorio.save(usuario);
	}

	public void eliminaruser(Integer idusuario) {
		// TODO Auto-generated method stub
		usuariosrepositorio.deleteById(idusuario);
	}

	
}
