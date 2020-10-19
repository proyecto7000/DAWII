package Practica.EmpleosWalter.Servicio;

import java.util.List;

import Practica.EmpleosWalter.Modelo.Usuario;

public interface IUsuariosService {

	void guardar(Usuario usuario);

	void eliminar(Integer idUsuario);

	List<Usuario> buscarTodos();
}
