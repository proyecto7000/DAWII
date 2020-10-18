package Anthony.VR46.Practica2.Service.DB;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import Anthony.VR46.Practica2.Model.CATEGORIAS;
import Anthony.VR46.Practica2.Respositorio.CATEGORIASRepositorio;
import Anthony.VR46.Practica2.Service.ICategoriasService;

@Service
@Primary
public class CategoriasServiceJPA implements ICategoriasService {

	@Autowired
	private CATEGORIASRepositorio categoriasRepositorio;
	public void guardarcategoria(CATEGORIAS categoria) {
		// TODO Auto-generated method stub
		categoriasRepositorio.save(categoria);
	}

	public List<CATEGORIAS> cargarcategorias() {
		// TODO Auto-generated method stub
		return categoriasRepositorio.findAll();
	}

	public CATEGORIAS buscarPorId(Integer idCategoria) {
		// TODO Auto-generated method stub
		Optional<CATEGORIAS> optional = categoriasRepositorio.findById(idCategoria);
		if(optional.isPresent())
			{
				return optional.get();
			}
		return null;
	}

	@Override
	public void eliminarcat(Integer idCategoria) {
		// TODO Auto-generated method stub
		categoriasRepositorio.deleteById(idCategoria);
	}

}
