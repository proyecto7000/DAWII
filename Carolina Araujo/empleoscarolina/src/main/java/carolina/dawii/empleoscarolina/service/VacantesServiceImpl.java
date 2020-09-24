package carolina.dawii.empleoscarolina.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import carolina.dawii.empleoscarolina.model.Vacante;

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
		mivacante1.setDestacada(1);
		mivacante1.setImagen("empresa1.png");
		
		
		Vacante mivacante2=new Vacante();
		mivacante2.setId(2);
		mivacante2.setNombre("Ingeniero de sistemas");
		mivacante2.setDescripcion("Programacion");
		mivacante2.setFecha(new Date());
		mivacante2.setSalario(250.90);
		mivacante2.setDestacada(2);
		mivacante2.setImagen("empresa2.png");
		
	
		Vacante mivacante3=new Vacante();
		mivacante3.setId(3);
		mivacante3.setNombre("Tecnico de reparaciones");
		mivacante3.setDescripcion("Instalaciones");
		mivacante3.setFecha(new Date());
		mivacante3.setSalario(120.90);
		mivacante3.setDestacada(3);
		mivacante3.setImagen("empresa3.png");
		
		
		  lista =new LinkedList<>(); 
		  
		  lista.add(mivacante1); 
		  lista.add(mivacante2);
		  lista.add(mivacante3);
		  
	}
	
	
	@Override
	public List<Vacante> CargaVacantes() {
		// TODO Auto-generated method stub
		return lista;
	}

	@Override
	public Vacante buscarPorId(Integer idVacante) {
		// TODO Auto-generated method stub
		for(Vacante v : lista) {
			if(v.getId()==idVacante) {
				return v;
			}
		}
		return null;
	}

		
}