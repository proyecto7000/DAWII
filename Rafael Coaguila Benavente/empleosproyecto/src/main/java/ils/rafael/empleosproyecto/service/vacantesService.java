package ils.rafael.empleosproyecto.service;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ils.rafael.empleosproyecto.model.vacante;

public interface vacantesService {
 
	
	public List<vacante>cargarvacante();
	
	public vacante buscaridvacante(int id);
	
	public  void guardarvacante(vacante vacante);
	
	
	List<vacante> buscarDestacadas();
	
	void eliminar(int id);
	
	List<vacante> buscarByExample(Example<vacante> example);
	
	Page<vacante> cargarvacante(Pageable page);
}
