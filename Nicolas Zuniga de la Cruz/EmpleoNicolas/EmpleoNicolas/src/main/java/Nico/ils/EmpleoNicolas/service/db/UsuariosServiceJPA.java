package Nico.ils.EmpleoNicolas.service.db;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import Nico.ils.EmpleoNicolas.Repository.UsuariosRepository;
import Nico.ils.EmpleoNicolas.model.Usuario;
import Nico.ils.EmpleoNicolas.service.IUsuariosService;



@Service
@Primary
public class UsuariosServiceJPA implements IUsuariosService {
	
	@Autowired
	private UsuariosRepository usuariosRepo;

	@Override
	public List<Usuario> listarUsuarios() {
		// TODO Auto-generated method stub
		return usuariosRepo.findAll();
	}

	@Override
	public void guardarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		usuariosRepo.save(usuario);
	}

	@Override
	public void eliminarUsuario(int iduser) {
		// TODO Auto-generated method stub
		usuariosRepo.deleteById(iduser);;
	}

}
