package Nico.ils.EmpleoNicolas.service.db;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import Nico.ils.EmpleoNicolas.Repository.VacantesRepository;
import Nico.ils.EmpleoNicolas.model.Vacante;
import Nico.ils.EmpleoNicolas.service.IVacantesService;


@Service
@Primary
public class VacantesServiceJPA implements IVacantesService {
	
	@Autowired
	private VacantesRepository vacantesRepo;

	@Override
	public List<Vacante> CargaVacantes() {
		// TODO Auto-generated method stub
		return vacantesRepo.findAll();
	}

	@Override
	public Vacante buscarVacanteporID(int id) {
		// TODO Auto-generated method stub
		Optional<Vacante>  optional = vacantesRepo.findById(id);
		if(optional.isPresent()) {
		return	optional.get();
		}
		return null;
	}

	@Override
	public void guardarvacante(Vacante vacante) {
		// TODO Auto-generated method stub
		vacantesRepo.save(vacante);
	}

	@Override
	public List<Vacante> buscarVacanteDestacadas() {
		// TODO Auto-generated method stub
		return vacantesRepo.findByDestacadoAndEstatusOrderByIdDesc(1,"Aprobada");
	}

	@Override
	public void eliminarVacante(int id) {
		// TODO Auto-generated method stub
		vacantesRepo.deleteById(id);
	}

	@Override
	public List<Vacante> buscarByExample(Example<Vacante> example) {
		// TODO Auto-generated method stub
		return vacantesRepo.findAll(example);
	}

	@Override
	public Page<Vacante> cargarVacante(Pageable page) {
		// TODO Auto-generated method stub
		return vacantesRepo.findAll(page);
	}

}
