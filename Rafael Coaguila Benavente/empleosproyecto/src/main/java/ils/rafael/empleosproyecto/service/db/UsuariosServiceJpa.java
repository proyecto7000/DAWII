package ils.rafael.empleosproyecto.service.db;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import ils.rafael.empleosproyecto.model.usuario;
import ils.rafael.empleosproyecto.repository.UsuariosRepository;
import ils.rafael.empleosproyecto.service.iUsuariosService;

@Service
@Primary
public class UsuariosServiceJpa implements iUsuariosService {
	
	@Autowired
	private UsuariosRepository usuariosRepo;
	

	@Override
	public void guardar(usuario usuario) {
		// TODO Auto-generated method stub
		
		usuariosRepo.save(usuario);

	}

	@Override
	public void eliminar(int idusuario) {
		// TODO Auto-generated method stub
		usuariosRepo.deleteById(idusuario);
	}

	@Override
	public List<usuario> buscarTodos() {
		// TODO Auto-generated method stub
		return usuariosRepo.findAll();
	}

}
