package Anthony.VR46.Practica2.Service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import Anthony.VR46.Practica2.Model.CATEGORIAS;

public interface ICategoriasService {
	void guardarcategoria(CATEGORIAS categoria);
	List<CATEGORIAS> cargarcategorias();
	CATEGORIAS buscarPorId(Integer idCategoria);
	void eliminarcat(Integer idCategoria);
	Page<CATEGORIAS> buscartodas(Pageable page);
}
