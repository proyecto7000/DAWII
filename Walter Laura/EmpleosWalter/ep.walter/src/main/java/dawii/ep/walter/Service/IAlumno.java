package dawii.ep.walter.Service;

import java.util.List;

import dawii.ep.walter.Model.alumno;


public interface IAlumno {
	List<alumno> listarAlumnos();
	void guardarAlumno(alumno alumno);
	double calcularPromedio(double nota1, double nota2);
}
