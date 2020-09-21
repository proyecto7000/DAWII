package ils.rafael.empleosproyecto.service;


import java.util.List;
import ils.rafael.empleosproyecto.model.categoria;




public interface icategoriasService {

	
	void guardar(categoria categoria);
	
	List<categoria> buscarTodas();
	
	categoria buscarPorId(Integer idCategoria);	
}

