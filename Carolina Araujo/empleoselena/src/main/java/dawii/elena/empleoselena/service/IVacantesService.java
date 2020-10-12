package dawii.elena.empleoselena.service;

import java.util.List;

import dawii.elena.empleoselena.model.Vacante;


public interface IVacantesService {
	public List<Vacante> CargaVacantes();
	public Vacante buscarPorId(int idVacante);
	public void guardarVacante(Vacante vacante);
	
}
