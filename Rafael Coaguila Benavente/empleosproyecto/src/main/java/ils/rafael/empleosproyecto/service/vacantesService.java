package ils.rafael.empleosproyecto.service;

import java.util.List;

import ils.rafael.empleosproyecto.model.vacante;

public interface vacantesService {
 
	
	public List<vacante>cargarvacante();
	
	public vacante buscaridvacante(int id);
	
	public  void guardarvacante(vacante vacante);
	
	
	List<vacante> buscarDestacadas();
	
	void eliminar(int id);
}
