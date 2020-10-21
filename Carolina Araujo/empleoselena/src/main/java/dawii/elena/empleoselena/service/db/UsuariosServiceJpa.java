package dawii.elena.empleoselena.service.db;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import dawii.elena.empleoselena.model.Usuario;
import dawii.elena.empleoselena.repository.UsuariosRepository;
import dawii.elena.empleoselena.service.IUsuariosService;

@Service
@Primary
public class UsuariosServiceJpa implements IUsuariosService {

	
	@Autowired
	private UsuariosRepository usuariosRepo;
	
	public List<Usuario> buscarTodos() {
		// TODO Auto-generated method stub
		return usuariosRepo.findAll();
	}

	public void guardar(Usuario usuario) {
		// TODO Auto-generated method stub
		usuariosRepo.save(usuario);
	}

	public void eliminar(Integer idUsuario) {
		// TODO Auto-generated method stub
		usuariosRepo.deleteById(idUsuario);
	}

}
