package carolina.dawii.empleoscarolina.service;

import java.util.List;

import carolina.dawii.empleoscarolina.model.Vacante;

public interface IVacantesService {
	public List<Vacante> CargaVacantes();
	public Vacante buscarPorId(int idVacante);
	public void guardarVacante(Vacante vacante);
	
}
