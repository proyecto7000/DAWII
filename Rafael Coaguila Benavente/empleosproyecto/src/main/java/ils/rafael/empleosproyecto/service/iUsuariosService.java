package ils.rafael.empleosproyecto.service;

import java.util.List;

import ils.rafael.empleosproyecto.model.usuario;

public interface iUsuariosService {

	void guardar(usuario usuario);
	
	void eliminar(int idusuario);
	
	List<usuario> buscarTodos();
	
	
}
