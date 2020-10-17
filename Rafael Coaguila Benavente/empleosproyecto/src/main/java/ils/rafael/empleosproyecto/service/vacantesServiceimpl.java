package ils.rafael.empleosproyecto.service;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import ils.rafael.empleosproyecto.model.vacante;

@Service
public class vacantesServiceimpl implements vacantesService {

	
	        List<vacante>lista;
	
       public vacantesServiceimpl() {
		
    	vacante vacante1= new vacante();
   		vacante1.setId(1);
   		
   		vacante1.setNombre("ingeniero quimico");
   		vacante1.setDescripcion("se necesita ingeniero para soporte intranet");
   		vacante1.setFecha(new Date());
   		vacante1.setSalario(8000.0);
   		vacante1.setDestacado(0);
   		vacante1.setEstatus("Creada");
   		vacante1.setImagen("empresa1.png");
   		
   		
   		vacante vacante2= new vacante();
   		vacante2.setId(2);
   		
   		vacante2.setNombre("ingeniero de Sistemas");
   		vacante2.setDescripcion("se necesita ingeniero de sistemas");
   		vacante2.setFecha(new Date());
   		vacante2.setSalario(10000.0);
   		vacante2.setDestacado(1);
   		vacante2.setEstatus("Aprobada");
   		vacante2.setImagen("empresa2.png");
   		
   		vacante vacante3= new vacante();
   		vacante3.setId(3);
   		
   		vacante3.setNombre("Abogado");
   		vacante3.setDescripcion(" Se necesita abogado se paga poco");
   		vacante3.setFecha(new Date());
   		vacante3.setSalario(320.50);
   		vacante3.setDestacado(1);
   		vacante3.setEstatus("Eliminada");
   		vacante3.setImagen("empresa3.png");
   		
   		vacante vacante4= new vacante();
   		vacante4.setId(4);
   		
   		vacante4.setNombre("Doctor");
   		vacante4.setDescripcion("se necesita Doctor con doctorado ");
   		vacante4.setFecha(new Date());
   		vacante4.setSalario(5650.0);
   		vacante4.setDestacado(1);
   		vacante4.setEstatus("Creada");
       	
   		
   		lista = new LinkedList<>();
   		
   		
   		lista.add(vacante1);
   		lista.add(vacante2);
   		lista.add(vacante3);
   		lista.add(vacante4);
   		
   		
   		
   		
   			   
	}
	
	
	@Override
	public List<vacante> cargarvacante() {
		// TODO Auto-generated method stub
		return lista;
	}




	@Override
	public vacante buscaridvacante(int id) {
		// TODO Auto-generated method stub
		
		
		for (vacante  buscarid : lista)
		{
			if (buscarid.getId()==id)
			{
				return buscarid;
			}
		}
			
		return null;
	}


	@Override
	public void guardarvacante(vacante vacante) {
		// TODO Auto-generated method stub
		lista.add(vacante);
	}


	@Override
	public List<vacante> buscarDestacadas() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		
	}

}
