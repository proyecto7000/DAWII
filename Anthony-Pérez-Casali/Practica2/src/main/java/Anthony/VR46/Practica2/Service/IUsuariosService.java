package Anthony.VR46.Practica2.Service;

import java.util.List;

import Anthony.VR46.Practica2.Model.USUARIO;

public interface IUsuariosService {
	public List<USUARIO>CargaUsuario();
	public void guardarusuario(USUARIO usuario);
	void eliminaruser(Integer idusuario);
	USUARIO buscarPorId(Integer idusuario);
}
