package Nico.ils.EmpleoNicolas.service;

import java.util.List;
import Nico.ils.EmpleoNicolas.model.Categoria;



public interface ICategoriasService {

	public List<Categoria>CargaCategorias();
	public void guardarCategoria(Categoria categoria);
	Categoria buscarPorId(Integer idCategoria);
	void eliminarCategoria (Integer idcategoria);
	
}
