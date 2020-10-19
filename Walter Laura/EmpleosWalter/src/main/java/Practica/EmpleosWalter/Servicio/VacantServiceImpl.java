package Practica.EmpleosWalter.Servicio;

import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import Practica.EmpleosWalter.Modelo.Vacantes;

@Service
public class VacantServiceImpl implements VacantService {

	private List<Vacantes> lista=null;
	
	public VacantServiceImpl() {
		SimpleDateFormat fech=new SimpleDateFormat("dd-MM-yyyy");
		lista = new LinkedList<Vacantes>();
		
		try {
			Vacantes v1=new Vacantes();		
			v1.setId(1);
			v1.setNombre("Luis Alberto");
			v1.setFecha(fech.parse("08-02-2019"));
			v1.setDescripcion("Las");
			v1.setSalario(8000.500);
			v1.setDestacado(1);
			v1.setEstatus("Aprobado");
			v1.setImagen("logo1.png");
			v1.setDetalles("");
			
			
			Vacantes v2=new Vacantes();
			v2.setId(1);
			v2.setNombre("Juan Carlos");
			v2.setFecha(fech.parse("15-02-2015"));
			v2.setDescripcion("Las");
			v2.setSalario(2000.100);
			v2.setDestacado(1);
			v2.setEstatus("Creado");
			v2.setImagen("logo2.png");
			v2.setDetalles("");

			
			Vacantes v3=new Vacantes();
			v3.setId(1);
			v3.setNombre("Angela Flores");
			v3.setFecha(fech.parse("25-09-2019"));
			v3.setDescripcion("Las");
			v3.setSalario(6000.000);
			v3.setDestacado(0);
			v3.setEstatus("Eliminado");
			v3.setImagen("logo3.png");
			v3.setDetalles("");

			
			Vacantes v4=new Vacantes();
			v4.setId(1);
			v4.setNombre("Maria Fernanda");
			v4.setFecha(fech.parse("01-02-2020"));
			v4.setDescripcion("Las");
			v4.setSalario(7000.800);
			v4.setDestacado(1);
			v4.setEstatus("Aprobado");
			v4.setImagen("logo4.png");
			v4.setDetalles("");

			
			lista.add(v1);
			lista.add(v2);
			lista.add(v3);
			lista.add(v4);
			
		}catch(Exception s) {
			System.out.println("Error: "+s.getMessage());
		}
	}
	
	@Override
	public List<Vacantes> cargarDatos() {
		// TODO Auto-generated method stub
		return lista;
	}

	@Override
	public Vacantes buscarId(Integer idVacante) {
		for(Vacantes v:lista) {
			if(v.getId()==idVacante) {
				return v;
			}
		}
		return null;
	}

	@Override
	public void guardar(Vacantes vacante) {
		lista.add(vacante);
		
	}

	@Override
	public List<Vacantes> buscarDestacados() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(Integer idVacante) {
		// TODO Auto-generated method stub
		
	}

}
