package ils.rafael.empleosproyecto.service.db;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import ils.rafael.empleosproyecto.model.categoria;
import ils.rafael.empleosproyecto.repository.CategoriasRepository;
import ils.rafael.empleosproyecto.service.icategoriasService;

@Service
@Primary
public class CategoriaServiceJpa implements icategoriasService {

	@Autowired
	private CategoriasRepository categoriasRepo;
	
	@Override
	public void guardar(categoria categoria) {
		
		
		categoriasRepo.save(categoria);
          
	}

	@Override
	public List<categoria> buscarTodas() {
		
		return categoriasRepo.findAll();
	}

	@Override
	public categoria buscarPorId(Integer idCategoria) {
		Optional<categoria> optional = categoriasRepo.findById(idCategoria);
		if(optional.isPresent())
		{
			return optional.get();
		}
		return null;
	}

}
