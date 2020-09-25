package Nico.ils.EmpleoNicolas.service;

import java.util.List;

import Nico.ils.EmpleoNicolas.model.Alumno;

public interface INotasService {
	public List<Alumno>CargaAlumnos();
	public  void guardarAlumno(Alumno alumno);
	public double calcularPromedio(double nota1, double nota2);

}
