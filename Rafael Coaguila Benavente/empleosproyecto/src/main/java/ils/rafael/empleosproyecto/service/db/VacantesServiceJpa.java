package ils.rafael.empleosproyecto.service.db;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import ils.rafael.empleosproyecto.model.vacante;
import ils.rafael.empleosproyecto.repository.VacantesRepository;
import ils.rafael.empleosproyecto.service.vacantesService;
@Service
@Primary
public class VacantesServiceJpa implements vacantesService {

	@Autowired
	private VacantesRepository vacantesrepo;
	
	@Override
	public List<vacante> cargarvacante() {
		// TODO Auto-generated method stub
		return vacantesrepo.findAll();
	}

	@Override
	public vacante buscaridvacante(int id) {
		Optional<vacante>  optional = vacantesrepo.findById(id);
		if(optional.isPresent()) {
		return	optional.get();
		}
		return null;
	}

	@Override
	public void guardarvacante(vacante vacante) {
		
		vacantesrepo.save(vacante);

	}

	@Override
	public List<vacante> buscarDestacadas() {
		// TODO Auto-generated method stub
		return vacantesrepo.findByDestacadoAndEstatusOrderByIdDesc(1,"Aprobada");
	}

}
