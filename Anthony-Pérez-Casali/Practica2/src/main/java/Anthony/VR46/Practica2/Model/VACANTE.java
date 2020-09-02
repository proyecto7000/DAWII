package Anthony.VR46.Practica2.Model;

import java.util.Date;

public class VACANTE {
	
	private Integer ID;
	private String Nombre;
	private String Descripcion;
	private Date Fecha;
	private double Salario;
	
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	public Date getFecha() {
		return Fecha;
	}
	public void setFecha(Date fecha) {
		Fecha = fecha;
	}
	public double getSalario() {
		return Salario;
	}
	public void setSalario(double salario) {
		Salario = salario;
	}
	
	@Override
	public String toString() {
		return "VACANTE [ID=" + ID + ", Nombre=" + Nombre + ", Descripcion=" + Descripcion + ", Fecha=" + Fecha
				+ ", Salario=" + Salario + "]";
	}
}
