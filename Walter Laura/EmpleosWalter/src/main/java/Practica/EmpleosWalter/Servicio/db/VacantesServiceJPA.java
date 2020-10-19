package Practica.EmpleosWalter.Servicio.db;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import Practica.EmpleosWalter.Modelo.Vacantes;
import Practica.EmpleosWalter.Repository.VacantesRepository;
import Practica.EmpleosWalter.Servicio.VacantService;

@Service
@Primary
public class VacantesServiceJPA implements VacantService{

	@Autowired
	private VacantesRepository repoVacantes;
	
	@Override
	public void guardar(Vacantes vacante) {
		repoVacantes.save(vacante);	
		
	}
	
	@Override
	public List<Vacantes> cargarDatos() {
		return repoVacantes.findAll();
	}

	@Override
	public Vacantes buscarId(Integer idVacante) {
		Optional<Vacantes> optional = repoVacantes.findById(idVacante);
		
		if(optional.isPresent()) {
			return optional.get();
		}
		
		return null;
	}

	@Override
	public List<Vacantes> buscarDestacados() {
		// TODO Auto-generated method stub
		return repoVacantes.findByDestacadoAndEstatusOrderByIdDesc(1, "Aprobada");
	}

	@Override
	public void eliminar(Integer idVacante) {
		repoVacantes.deleteById(idVacante);
		
	}



}
