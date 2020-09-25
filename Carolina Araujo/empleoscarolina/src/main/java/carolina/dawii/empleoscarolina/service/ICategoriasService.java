package carolina.dawii.empleoscarolina.service;

import java.util.List;

import carolina.dawii.empleoscarolina.model.Categoria;

public interface ICategoriasService {
	
	public List<Categoria> buscarTodas();
	public Categoria buscarPorId(Integer idCategoria);
	public void guardar(Categoria categoria);

}
