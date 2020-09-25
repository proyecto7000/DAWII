package Nico.ils.EmpleoNicolas.model;

public class Alumno {
 private String codigo;
 private String nombre;
 private Double nota1;
 private Double nota2;
 private Double promedio;
 
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
public Double getPromedio() {
	return promedio;
}
public void setPromedio(Double promedio) {
	this.promedio = promedio;
}
@Override
public String toString() {
	return "Alumno [codigo=" + codigo + ", nombre=" + nombre + ", nota1=" + nota1 + ", nota2=" + nota2 + ", promedio="
			+ promedio + ", getCodigo()=" + getCodigo() + ", getNombre()=" + getNombre() + ", getNota1()=" + getNota1()
			+ ", getNota2()=" + getNota2() + ", getPromedio()=" + getPromedio() + ", getClass()=" + getClass()
			+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
}
 
 
 
}
