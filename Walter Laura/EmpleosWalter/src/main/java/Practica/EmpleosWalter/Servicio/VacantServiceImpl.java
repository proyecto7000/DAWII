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
		//SimpleDateFormat fech=new SimpleDateFormat("dd-MM-yyyy");
		lista = new LinkedList<Vacantes>();
		
		try {
			Vacantes v1=new Vacantes();
			v1.setCodigo(1);
			v1.setNombre("Miguel");
			v1.setEdad(25);
			v1.setDireccion("Rivero 205");
			v1.setTelefono(931478758);
			v1.setDestacado(0);
			v1.setImagenes("empresa1.png");
			
			Vacantes v2=new Vacantes();
			v2.setCodigo(2);
			v2.setNombre("Juan");
			v2.setEdad(30);
			v2.setDireccion("Rivero 206");
			v2.setTelefono(921478783);
			v2.setDestacado(1);
			v2.setImagenes("empresa2.png");
			
			Vacantes v3=new Vacantes();
			v3.setCodigo(3);
			v3.setNombre("Cesar");
			v3.setEdad(45);
			v3.setDireccion("Rivero 207");
			v3.setTelefono(976478198);
			v3.setDestacado(1);
			v3.setImagenes("empresa3.png");
			
			Vacantes v4=new Vacantes();
			v4.setCodigo(4);
			v4.setNombre("Andrew");
			v4.setEdad(20);
			v4.setDireccion("Rivero 208");
			v4.setTelefono(946478156);
			v4.setDestacado(0);
			v4.setImagenes("logo.png");
			

			
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
			if(v.getCodigo()==idVacante) {
				return v;
			}
		}
		return null;
	}

}
