package ils.rafael.empleosproyecto.service.db;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ils.rafael.empleosproyecto.model.vacante;
import ils.rafael.empleosproyecto.repository.VacantesRepository;
import ils.rafael.empleosproyecto.service.vacantesService;
@Service
@Primary
public class VacantesServiceJpa implements vacantesService {

	@Autowired
	private VacantesRepository vacantesrepo;
	
	public List<vacante> cargarvacante() {
		// TODO Auto-generated method stub
		return vacantesrepo.findAll();
	}

	public vacante buscaridvacante(int id) {
		Optional<vacante>  optional = vacantesrepo.findById(id);
		if(optional.isPresent()) {
		return	optional.get();
		}
		return null;
	}

	public void guardarvacante(vacante vacante) {
		
		vacantesrepo.save(vacante);

	}

	public List<vacante> buscarDestacadas() {
		// TODO Auto-generated method stub
		return vacantesrepo.findByDestacadoAndEstatusOrderByIdDesc(1,"Aprobada");
	}

	public void eliminar(int id) {
		// TODO Auto-generated method stub
		vacantesrepo.deleteById(id);
	}

	@Override
	public List<vacante> buscarByExample(Example<vacante> example) {
		// TODO Auto-generated method stub
		return vacantesrepo.findAll(example);
	}

	@Override
	public Page<vacante> cargarvacante(Pageable page) {
		// TODO Auto-generated method stub
		return vacantesrepo.findAll(page);
	}

}
