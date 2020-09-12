package carolina.dawii.empleoscarolina.service;

import java.util.List;

import carolina.dawii.empleoscarolina.model.Vacante;

public interface IVacantesService {
	List<Vacante> CargaVacantes();
	Vacante buscarPorId(Integer idVacante);
}
