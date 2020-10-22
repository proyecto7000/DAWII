package dawii.elena.empleoselena.service.db;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import dawii.elena.empleoselena.model.Vacante;
import dawii.elena.empleoselena.repository.VacantesRepository;
import dawii.elena.empleoselena.service.IVacantesService;

@Service
@Primary
public class VacantesServiceJpa implements IVacantesService{

	@Autowired
	private VacantesRepository vacantesRepo;
	
	public List<Vacante> buscarTodas() {
		// TODO Auto-generated method stub
		return vacantesRepo.findAll();
	}

	public Vacante buscarPorId(Integer idVacante) {
		// TODO Auto-generated method stub
		Optional<Vacante> optional = vacantesRepo.findById(idVacante);
			if(optional.isPresent()) {
				optional.get();
		}
		return null;
	}

	public void guardarVacante(Vacante vacante) {
		vacantesRepo.save(vacante);
	}


	public List<Vacante> buscarDestacadas() {
		return vacantesRepo.findByDestacadoAndEstatusOrderByIdDesc(1, "Aprobada");
	}

	public void eliminar(Integer idVacante) {
		vacantesRepo.deleteById(idVacante);
	}
	
	@Override
	public List<Vacante> buscarByExample(Example<Vacante> example) {
		return vacantesRepo.findAll(example);
	}

	@Override
	public Page<Vacante> buscarTodas(Pageable page) {
		// TODO Auto-generated method stub
		return vacantesRepo.findAll(page);
	}


}
