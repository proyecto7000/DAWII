package dawii.elena.empleoselena.service;

import java.util.List;


import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import dawii.elena.empleoselena.model.Vacante;


public interface IVacantesService {
	public List<Vacante> buscarTodas();
	public Vacante buscarPorId(Integer  idVacante);
	public void guardarVacante(Vacante vacante);
	List<Vacante> buscarDestacadas();
	void eliminar(Integer idVacante);
	List<Vacante> buscarByExample(Example<Vacante> example);
	Page<Vacante>buscarTodas(Pageable page);
}
