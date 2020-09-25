package notas.ils.rafael.service;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;


import notas.ils.rafael.model.alumno;


@Service
public class notasServiceimpl implements notasService {

	   List<alumno>lista;
		
       public notasServiceimpl() {
		
    	alumno notas1= new alumno();
   		notas1.setCodigo("1");
   		
   		notas1.setNombre("jorge");
   		notas1.setNota1(15.1);
   		notas1.setNota2(13.5);
   		notas1.setPromedio(15.5);
   		
   		alumno notas2= new alumno();
   		notas2.setCodigo("1");
   		
   		notas2.setNombre("carlos");
   		notas2.setNota1(17.1);
   		notas2.setNota2(12.5);
   		notas2.setPromedio(16.5);
   
   		
lista = new LinkedList<>();
   		
   		
   		lista.add(notas1);
   		lista.add(notas2);
   		
	
	
	
}

	@Override
	public List<alumno> cargarvacante() {
		// TODO Auto-generated method stub
		return lista;
	}

	@Override
	public alumno buscaridalumno(String id) {
		// TODO Auto-generated method stub
		for (alumno  buscarid : lista)
		{
			if (buscarid.getCodigo()==id)
			{
				return buscarid;
			}
		}
		
		return null;
	}

	@Override
	public void guardaralumno(alumno alumno) {
		// TODO Auto-generated method stub
		
		lista.add(alumno);
		
	}

}