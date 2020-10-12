package dawii.elena.empleoselena.service.db;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import dawii.elena.empleoselena.model.Categoria;
import dawii.elena.empleoselena.repository.CategoriasRepository;
import dawii.elena.empleoselena.service.ICategoriasService;

@Service
@Primary
public class CategoriasServiceJpa implements ICategoriasService{

	@Autowired
	private CategoriasRepository categoriasRepo;
	
	public void guardar(Categoria categoria) {
		// TODO Auto-generated method stub
		categoriasRepo.save(categoria);
	}
	
	public List<Categoria> buscarTodas() {
		// TODO Auto-generated method stub
		return categoriasRepo.findAll();
	}

	public Categoria buscarPorId(Integer idCategoria) {
		// TODO Auto-generated method stub
		Optional<Categoria> optional = categoriasRepo.findById(idCategoria);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	

}
