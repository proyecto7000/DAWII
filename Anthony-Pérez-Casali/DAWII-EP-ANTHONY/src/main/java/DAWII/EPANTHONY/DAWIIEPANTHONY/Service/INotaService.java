package DAWII.EPANTHONY.DAWIIEPANTHONY.Service;

import java.util.List;
import DAWII.EPANTHONY.DAWIIEPANTHONY.Model.Alumnos;

public interface INotaService {
	
	public List<Alumnos> listarAlumnos();
	void guardarAlumno(Alumnos alumno);
	double calcularPromedio(double Nota1, double Nota2);

}
