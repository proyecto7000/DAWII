package Nico.ils.EmpleoNicolas.service;

import java.util.List;
import Nico.ils.EmpleoNicolas.model.Vacante;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IVacantesService {
	//EN INTERFACE SE DECLARAN LSO METODOS MAS NO SE IMPLEMENTAN
	public List<Vacante>CargaVacantes();
	public Vacante buscarVacanteporID(int id);
	public  void guardarvacante(Vacante vacante);
	
	List<Vacante> buscarVacanteDestacadas();
	void eliminarVacante(int id);
	List<Vacante> buscarByExample(Example<Vacante> example);
	Page<Vacante> cargarVacante(Pageable page);
	
}
