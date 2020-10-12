package Parcial.Notas.Service;

import java.util.List;

import Parcial.Notas.Model.alumno;

public interface IAlumno {
	
	List<alumno> listarAlumnos();
	void guardarAlumno(alumno alumno);
	double calcularPromedio(double nota1, double nota2);

}
