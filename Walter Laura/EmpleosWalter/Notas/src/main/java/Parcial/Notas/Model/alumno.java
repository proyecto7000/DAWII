package Parcial.Notas.Model;

public class alumno {

	private String codigo;
	private	String nombre;
	private	double nota1;
	private	double nota2;
	private	double promedio;
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getNota1() {
		return nota1;
	}
	public void setNota1(double nota1) {
		this.nota1 = nota1;
	}
	public double getNota2() {
		return nota2;
	}
	public void setNota2(double nota2) {
		this.nota2 = nota2;
	}
	public double getPromedio() {
		return promedio;
	}
	public void setPromedio(double promedio) {
		this.promedio = promedio;
	}
	
	@Override
	public String toString() {
		return "alumno [codigo=" + codigo + ", nombre=" + nombre + ", nota1=" + nota1 + ", nota2=" + nota2
				+ ", promedio=" + promedio + "]";
	}

}
