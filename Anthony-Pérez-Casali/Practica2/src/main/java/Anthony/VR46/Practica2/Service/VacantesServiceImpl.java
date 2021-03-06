package Anthony.VR46.Practica2.Service;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import Anthony.VR46.Practica2.Model.VACANTE;

@Service
public class VacantesServiceImpl implements IVacantesServices{
	
	List<VACANTE> Lista;
	
	public VacantesServiceImpl() {
		
		VACANTE Vacante1 = new VACANTE();
		Vacante1.setId(1);
		Vacante1.setNombre("Contador");
		Vacante1.setDescripcion("Finanzas nueva");
		Vacante1.setFecha(new Date());
		Vacante1.setSalario(120.57);
		Vacante1.setDestacado(1);
		Vacante1.setImagen("empresa1.png");
		
		VACANTE Vacante2 = new VACANTE();
		Vacante2.setId(2);
		Vacante2.setNombre("Ingeniero Sistemas");
		Vacante2.setDescripcion("software");
		Vacante2.setFecha(new Date());
		Vacante2.setSalario(124.57);
		Vacante2.setDestacado(0);
		Vacante2.setImagen("empresa2.png");
		
		VACANTE Vacante3 = new VACANTE();
		Vacante3.setId(3);
		Vacante3.setNombre("Medico");
		Vacante3.setDescripcion("Forence");
		Vacante3.setFecha(new Date());
		Vacante3.setSalario(234.57);
		Vacante3.setDestacado(1);
		Vacante3.setImagen("empresa3.png");
		
		Lista = new LinkedList<>();
		Lista.add(Vacante1);
		Lista.add(Vacante2);
		Lista.add(Vacante3);
	}
	@Override
	public List<VACANTE> CargaVacantes() {
		// TODO Auto-generated method stub
		return Lista;
	}
	@Override
	public VACANTE buscarporID(int Id) {
		// TODO Auto-generated method stub
		for (VACANTE tmpvacante : Lista) {
			if(tmpvacante.getId()==Id)
				return tmpvacante;
		}
		return null;
	}
	@Override
	public void guardarVacante(VACANTE vacante) {
		// TODO Auto-generated method stub
		Lista.add(vacante);
	}
	@Override
	public List<VACANTE> buscardestacadas() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void eliminar(Integer idvacante) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<VACANTE> buscarByExample(Example<VACANTE> example) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Page<VACANTE> buscartodas(Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}

}
