package Anthony.VR46.Practica2.Service;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import Anthony.VR46.Practica2.Model.VACANTE;

public interface IVacantesServices 
{
	public List<VACANTE>CargaVacantes();
	public VACANTE buscarporID(int ID);
	public void guardarVacante(VACANTE vacantee);
	List<VACANTE> buscardestacadas();
	void eliminar(Integer idvacante);
	List<VACANTE> buscarByExample(Example<VACANTE> example);
	Page<VACANTE> buscartodas(Pageable page);
}
