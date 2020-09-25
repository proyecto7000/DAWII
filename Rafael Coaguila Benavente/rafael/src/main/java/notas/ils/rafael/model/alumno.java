package notas.ils.rafael.model;

public class alumno {

	
	String codigo;
	String nombre;
	Double  nota1;
	Double  nota2;
	Double  nota3;
	Double  promedio;
	
	
	public Double getPromedio() {
		return promedio;
	}
	public void setPromedio(Double promedio) {
		this.promedio = promedio;
	}
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
	public Double getNota1() {
		return nota1;
	}
	public void setNota1(Double nota1) {
		this.nota1 = nota1;
	}
	public Double getNota2() {
		return nota2;
	}
	public void setNota2(Double nota2) {
		this.nota2 = nota2;
	}
	public Double getNota3() {
		return nota3;
	}
	public void setNota3(Double nota3) {
		this.nota3 = nota3;
	}
	@Override
	public String toString() {
		return "alumno [codigo=" + codigo + ", nombre=" + nombre + ", nota1=" + nota1 + ", nota2=" + nota2 + ", nota3="
				+ nota3 + ", promedio=" + promedio + "]";
	}
	
	
	
	
	
	
	
	
}
