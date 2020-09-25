package DAWII.EPANTHONY.DAWIIEPANTHONY.Model;

public class Alumnos {
	
	private String Codigo ;
	private String Nombre ;
	private Double Nota1 ;
	private Double Nota2 ;
	private Double Promedio ;
	
	public String getCodigo() {
		return Codigo;
	}
	public void setCodigo(String codigo) {
		Codigo = codigo;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public Double getNota1() {
		return Nota1;
	}
	public void setNota1(Double nota1) {
		Nota1 = nota1;
	}
	public Double getNota2() {
		return Nota2;
	}
	public void setNota2(Double nota2) {
		Nota2 = nota2;
	}
	public Double getPromedio() {
		return Promedio;
	}
	public void setPromedio(Double promedio) {
		Promedio = promedio;
	}
	
	@Override
	public String toString() {
		return "Alumnos [Codigo=" + Codigo + ", Nombre=" + Nombre + ", Nota1=" + Nota1 + ", Nota2=" + Nota2
				+ ", Promedio=" + Promedio + "]";
	}
	
}
