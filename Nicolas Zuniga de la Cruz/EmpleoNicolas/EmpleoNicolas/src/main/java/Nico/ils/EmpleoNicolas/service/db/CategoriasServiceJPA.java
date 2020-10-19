package Nico.ils.EmpleoNicolas.service.db;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import Nico.ils.EmpleoNicolas.Repository.CategoriasRepository;
import Nico.ils.EmpleoNicolas.model.Categoria;
import Nico.ils.EmpleoNicolas.service.ICategoriasService;


@Service
@Primary
public class CategoriasServiceJPA implements ICategoriasService {

	@Autowired
	private CategoriasRepository categoriasRepo;
	
	@Override
	public List<Categoria> CargaCategorias() {
		// TODO Auto-generated method stub
		return categoriasRepo.findAll();
	}

	@Override
	public void guardarCategoria(Categoria categoria) {
		// TODO Auto-generated method stub
		categoriasRepo.save(categoria);

	}

	@Override
	public Categoria buscarPorId(Integer idCategoria) {
		// TODO Auto-generated method stub
		Optional<Categoria> optional = categoriasRepo.findById(idCategoria);
		if(optional.isPresent())
		{
			return optional.get();
		}
		return null;
	}

	@Override
	public void eliminarCategoria(Integer idcategoria) {
		// TODO Auto-generated method stub
		categoriasRepo.deleteById(idcategoria);

	}

}
