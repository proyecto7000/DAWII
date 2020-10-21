 package dawii.elena.empleoselena.service;

import java.util.List;

import dawii.elena.empleoselena.model.Usuario;


public interface IUsuariosService {

	public List<Usuario> buscarTodos();
	public void guardar(Usuario usuario);
	void eliminar(Integer idUsuario);
	
	
	
}
