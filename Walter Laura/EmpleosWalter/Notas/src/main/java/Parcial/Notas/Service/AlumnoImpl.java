package Parcial.Notas.Service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import Parcial.Notas.Model.alumno;

@Service
public class AlumnoImpl implements IAlumno{

	List<alumno> lista;
	
	public  AlumnoImpl () {
		try {
			alumno a1=new alumno();		
			a1.setCodigo("A01");
			a1.setNombre("Laura");
			a1.setNota1(11);
			a1.setNota2(13);
			a1.setPromedio(12);
			
			alumno a2=new alumno();
			a2.setCodigo("A02");
			a2.setNombre("jorge");
			a2.setNota1(15);
			a2.setNota2(16);
			a2.setPromedio(17);
			
			lista = new LinkedList<>();
			
			lista.add(a1);
			lista.add(a2);

			
		}catch(Exception s) {
			System.out.println("Error: "+s.getMessage());
		}
	}
	
	
	@Override
	public List<alumno> listarAlumnos() {
		return lista;
	}

	@Override
	public void guardarAlumno(alumno alumno) {
		lista.add(alumno);
	}

	@Override
	public double calcularPromedio(double nota1, double nota2) {
		return nota1+nota2;
	}

}
