package Nico.ils.EmpleoNicolas.service.db;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import Nico.ils.EmpleoNicolas.Repository.SolicitudesRepository;
import Nico.ils.EmpleoNicolas.model.Solicitud;
import Nico.ils.EmpleoNicolas.service.ISolicitudesService;

@Service
@Primary
public class SolicitudesServiceJPA implements ISolicitudesService {
	
	
	@Autowired
	private SolicitudesRepository solicitudesRepo;

	@Override
	public void guardar(Solicitud solicitud) {
		// TODO Auto-generated method stub
		solicitudesRepo.save(solicitud);
	}

	@Override
	public void eliminar(Integer idSolicitud) {
		// TODO Auto-generated method stub
		solicitudesRepo.deleteById(idSolicitud);
	}

	@Override
	public List<Solicitud> buscarTodas() {
		// TODO Auto-generated method stub
		return solicitudesRepo.findAll();
	}

	@Override
	public Solicitud buscarPorId(Integer idSolicitud) {
		// TODO Auto-generated method stub
		Optional<Solicitud> optional = solicitudesRepo.findById(idSolicitud);
		if(optional.isPresent())
		{
			return optional.get();
		}
		return null;
	}

	@Override
	public Page<Solicitud> buscarTodas(Pageable page) {
		// TODO Auto-generated method stub
		return solicitudesRepo.findAll(page);
	}

}
