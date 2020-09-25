package carolina.dawii.empleoscarolina.Notas.Service;

import java.util.List;

import carolina.dawii.empleoscarolina.Notas.Model.Alumno;

public interface IAlumnosService {

	public List<Alumno>listarAlumnos();
	public void guardarAlumno(Alumno alumno);
	public double calcularPromedio(double nota1, double nota2);
}
