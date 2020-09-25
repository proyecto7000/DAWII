package DAWII.EPANTHONY.DAWIIEPANTHONY.Service;

import java.util.LinkedList;
import java.util.List;
import org.springframework.stereotype.Service;
import DAWII.EPANTHONY.DAWIIEPANTHONY.Model.Alumnos;

@Service
public class NotaServiceImpl implements INotaService 
{

	List<Alumnos> ListaA;
	
	public NotaServiceImpl() 
	{
		Alumnos Alumno1 = new Alumnos();
		Alumno1.setCodigo("A01");
		Alumno1.setNombre("LAURA");
		Alumno1.setNota1(11.0);
		Alumno1.setNota2(13.0);
		Alumno1.setPromedio(12.0);
		
		Alumnos Alumno2 = new Alumnos();
		Alumno2.setCodigo("A02");
		Alumno2.setNombre("JORGE");
		Alumno2.setNota1(15.0);
		Alumno2.setNota2(17.0);
		Alumno2.setPromedio(16.0);
		
		ListaA = new LinkedList<>();
		ListaA.add(Alumno1);
		ListaA.add(Alumno2);
	}

	@Override
	public List<Alumnos> listarAlumnos() {
		// TODO Auto-generated method stub
		return ListaA;
	}

	@Override
	public void guardarAlumno(Alumnos alumno) {
		// TODO Auto-generated method stub
		ListaA.add(alumno);
	}

	@Override
	public double calcularPromedio(double Nota1, double Nota2) {
		// TODO Auto-generated method stub
		return 0;
	}
}
