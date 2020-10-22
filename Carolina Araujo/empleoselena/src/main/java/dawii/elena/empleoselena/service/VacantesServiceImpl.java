package dawii.elena.empleoselena.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import dawii.elena.empleoselena.model.Vacante;


@Service
public class VacantesServiceImpl implements IVacantesService {	
	
	private List<Vacante> lista;
	
	public VacantesServiceImpl(){
		
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		lista=new LinkedList<Vacante>();
		
		Vacante mivacante1=new Vacante();
		mivacante1.setId(1);
		mivacante1.setNombre("Contador");
		mivacante1.setDescripcion("Finanzas de la empresa");
		mivacante1.setFecha(new Date());
		mivacante1.setSalario(900.90);
		mivacante1.setDestacado(1);
		mivacante1.setImagen("empresa1.png");
		
		
		Vacante mivacante2=new Vacante();
		mivacante2.setId(2);
		mivacante2.setNombre("Ingeniero de sistemas");
		mivacante2.setDescripcion("Programacion");
		mivacante2.setFecha(new Date());
		mivacante2.setSalario(250.90);
		mivacante2.setDestacado(2);
		mivacante2.setImagen("empresa2.png");
		
	
		Vacante mivacante3=new Vacante();
		mivacante3.setId(3);
		mivacante3.setNombre("Tecnico de reparaciones");
		mivacante3.setDescripcion("Instalaciones");
		mivacante3.setFecha(new Date());
		mivacante3.setSalario(120.90);
		mivacante3.setDestacado(3);
		mivacante3.setImagen("empresa3.png");
		
		
		  lista =new LinkedList<>(); 
		  
		  lista.add(mivacante1); 
		  lista.add(mivacante2);
		  lista.add(mivacante3);
		  
	}
	
	public List<Vacante> buscarTodas(){
		return lista;
	}
	
	public Vacante buscarPorId(Integer idVacante) {
		// TODO Auto-generated method stub
		for(Vacante v : lista) {
			if(v.getId()==idVacante) {
				return v;
			}
		}
		return null;
	}


	public void guardarVacante(Vacante miVacante) {
		// TODO Auto-generated method stub
		lista.add(miVacante);
	}

	public List<Vacante> buscarDestacadas() {
		// TODO Auto-generated method stub
		return null;
	}

	public void eliminar(Integer idVacante) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Vacante> buscarByExample(Example<Vacante> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Vacante> buscarTodas(Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}

	

	



	

	
	
	



		
}