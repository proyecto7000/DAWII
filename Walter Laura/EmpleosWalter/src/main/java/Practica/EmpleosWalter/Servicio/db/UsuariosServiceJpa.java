package Practica.EmpleosWalter.Servicio.db;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import Practica.EmpleosWalter.Modelo.Usuario;
import Practica.EmpleosWalter.Repository.UsuariosRepository;
import Practica.EmpleosWalter.Servicio.IUsuariosService;


@Service
@Primary
public class UsuariosServiceJpa implements IUsuariosService {

	@Autowired
	private UsuariosRepository repoUsuarios;
	
	@Override
	public void guardar(Usuario usuario) {
		repoUsuarios.save(usuario);
		
	}

	@Override
	public void eliminar(Integer idUsuario) {
		repoUsuarios.deleteById(idUsuario);
		
	}

	@Override
	public List<Usuario> buscarTodos() {
		return repoUsuarios.findAll();
	}
	
	

}
