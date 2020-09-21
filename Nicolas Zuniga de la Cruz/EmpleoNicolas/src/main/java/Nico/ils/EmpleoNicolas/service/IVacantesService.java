package Nico.ils.EmpleoNicolas.service;

import java.util.List;
import Nico.ils.EmpleoNicolas.model.Vacante;

public interface IVacantesService {
	//EN INTERFACE SE DECLARAN LSO METODOS MAS NO SE IMPLEMENTAN
	public List<Vacante>CargaVacantes();
	public Vacante buscarVacanteporID(int id);
	
	
}
