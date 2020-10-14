package Anthony.VR46.Practica2.Service;

import java.util.List;
import Anthony.VR46.Practica2.Model.VACANTE;

public interface IVacantesServices 
{
	public List<VACANTE>CargaVacantes();
	public VACANTE buscarporID(int ID);
	public void guardarVacante(VACANTE vacantee);
	List<VACANTE> buscardestacadas();
}
