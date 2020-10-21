package dawii.elena.empleoselena.service;

import java.util.List;

import dawii.elena.empleoselena.model.Categoria;



public interface ICategoriasService {
	
	public List<Categoria> buscarTodas();
	public Categoria buscarPorId(Integer idCategoria);
	public void guardar(Categoria categoria);
	void eliminar(Integer idCategoria);
	

}
