package Nico.ils.EmpleoNicolas.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import Nico.ils.EmpleoNicolas.model.Alumno;

@Service
public class NotasService implements INotasService{

	
	private List<Alumno> lista;
	
	public NotasService() {
		Alumno alu1=new Alumno();
		Alumno alu2=new Alumno();
		//CARGAMOS 1
		alu1.setCodigo("A01");
		alu1.setNombre("Laura");
		alu1.setNota1(Double.parseDouble("11"));
		alu1.setNota2(Double.parseDouble("13"));
		alu1.setPromedio(Double.parseDouble("12"));
		
		
		//CARGAMOS 2
				alu2.setCodigo("A02");
				alu2.setNombre("Jorge");
				alu2.setNota1(Double.parseDouble("13"));
				alu2.setNota2(Double.parseDouble("17"));
				alu2.setPromedio(Double.parseDouble("16"));
				
				lista= new LinkedList<>();
				lista.add(alu1);
				lista.add(alu2);
	}
	
	
	
	
	
	@Override
	public List<Alumno> CargaAlumnos() {
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
		double promedio=(nota1+nota2)/2;
		
		
		return promedio;
	}

}
