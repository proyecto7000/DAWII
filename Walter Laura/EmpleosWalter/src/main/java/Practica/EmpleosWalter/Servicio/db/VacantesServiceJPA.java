package Practica.EmpleosWalter.Servicio.db;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import Practica.EmpleosWalter.Modelo.Vacantes;
import Practica.EmpleosWalter.Repository.VacantesRepository;
import Practica.EmpleosWalter.Servicio.VacantService;

@Service
@Primary
public class VacantesServiceJPA implements VacantService{

	@Autowired
	private VacantesRepository repoVacantes;
	

	public List<Vacantes> cargarDatos() {
		return repoVacantes.findAll();
	}
	

	public void guardar(Vacantes vacante) {
		repoVacantes.save(vacante);	
		
	}
	

	public Vacantes buscarId(Integer idVacante) {
		Optional<Vacantes> optional = repoVacantes.findById(idVacante);
		
		if(optional.isPresent()) {
			return optional.get();
		}
		
		return null;
	}


	public List<Vacantes> buscarDestacados() {
		// TODO Auto-generated method stub
		return repoVacantes.findByDestacadoAndEstatusOrderByIdDesc(1, "Aprobada");
	}


	public void eliminar(Integer idVacante) {
		repoVacantes.deleteById(idVacante);
		
	}

	@Override
	public List<Vacantes> buscarByExample(Example<Vacantes> example) {
		return repoVacantes.findAll(example);
	}


	@Override
	public Page<Vacantes> buscarTodas(Pageable page) {
		return repoVacantes.findAll(page);
	}



}
