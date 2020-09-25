package carolina.dawii.empleoscarolina.Notas.Service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import carolina.dawii.empleoscarolina.Notas.Model.Alumno;

@Service
public class AlumnosServiceImpl implements IAlumnosService{

	
	private List<Alumno> lista;
	
	public AlumnosServiceImpl() {
		
		lista=new LinkedList<Alumno>();
		
		Alumno alum1= new Alumno();
		alum1.setCodigo("A01");
		alum1.setNombre("Laura");
		alum1.setNota1(11);
		alum1.setNota2(13);
		alum1.setPromedio(12);
		
		Alumno alum2= new Alumno();
		alum2.setCodigo("A02");
		alum2.setNombre("Jorge");
		alum2.setNota1(15);
		alum2.setNota2(17);
		alum2.setPromedio(16);
	}
	
	
	
	
	@Override
	public List<Alumno> listarAlumnos() {
		// TODO Auto-generated method stub
		return lista;
	}

	@Override
	public void guardarAlumno(Alumno alumno) {
		// TODO Auto-generated method stub
		lista.add(alumno);
	}

	@Override
	public double calcularPromedio(double nota1, double nota2) {
		// TODO Auto-generated method stub
		return 0;
	}

}
