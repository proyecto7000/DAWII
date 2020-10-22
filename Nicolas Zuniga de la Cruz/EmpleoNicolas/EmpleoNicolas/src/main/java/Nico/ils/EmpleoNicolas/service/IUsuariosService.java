package Nico.ils.EmpleoNicolas.service;

import java.util.List;

import Nico.ils.EmpleoNicolas.model.Usuario;

public interface IUsuariosService {
	List<Usuario> listarUsuarios();
	void guardarUsuario(Usuario usuario);
	void eliminarUsuario(int iduser);
}
