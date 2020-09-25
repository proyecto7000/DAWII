package notas.ils.rafael.service;

import java.util.List;

import notas.ils.rafael.model.alumno;



public interface notasService {

	
	public List<alumno>cargarvacante();
	
	public alumno buscaridalumno(String id);
	
	public  void guardaralumno(alumno alumno);

}
