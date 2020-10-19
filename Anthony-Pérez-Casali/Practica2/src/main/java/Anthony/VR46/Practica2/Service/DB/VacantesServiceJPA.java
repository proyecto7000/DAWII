package Anthony.VR46.Practica2.Service.DB;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import Anthony.VR46.Practica2.Model.VACANTE;
import Anthony.VR46.Practica2.Respositorio.VACANTESRepositorio;
import Anthony.VR46.Practica2.Service.IVacantesServices;

@Service
@Primary
public class VacantesServiceJPA implements IVacantesServices {

	@Autowired
	private VACANTESRepositorio vacantesrepositorio;
	public List<VACANTE> CargaVacantes() {
		// TODO Auto-generated method stub
		return vacantesrepositorio.findAll();
	}

	public VACANTE buscarporID(int ID) {
		// TODO Auto-generated method stub
		Optional<VACANTE> optional = vacantesrepositorio.findById(ID);
		if(optional.isPresent())
			{
				return optional.get();
			}
		return null;
	}

	public void guardarVacante(VACANTE vacantee) {
		// TODO Auto-generated method stub
		vacantesrepositorio.save(vacantee);
	}

	@Override
	public List<VACANTE> buscardestacadas() {
		// TODO Auto-generated method stub
		return vacantesrepositorio.findByDestacadoAndEstatusOrderByIdDesc(1, "Aprobada");
	}

	@Override
	public void eliminar(Integer idvacante) {
		// TODO Auto-generated method stub
		vacantesrepositorio.deleteById(idvacante);
	}

}
