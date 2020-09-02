package Practica.EmpleosWalter.Modelo;

public class Vacantes {

	private int Codigo;
	private String Nombre;
	private int edad;
	private boolean Educacion; 
	private String Direccion;
	private int Telefono;
	
	public int getCodigo() {
		return Codigo;
	}
	public void setCodigo(int codigo) {
		Codigo = codigo;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public boolean isEducacion() {
		return Educacion;
	}
	public void setEducacion(boolean educacion) {
		Educacion = educacion;
	}
	public String getDireccion() {
		return Direccion;
	}
	public void setDireccion(String direccion) {
		Direccion = direccion;
	}
	public int getTelefono() {
		return Telefono;
	}
	public void setTelefono(int telefono) {
		Telefono = telefono;
	}
	
	@Override
	public String toString() {
		return "Vacantes [Codido=" + Codigo + ", Nombre=" + Nombre + ", edad=" + edad + ", Educacion=" + Educacion
				+ ", Direccion=" + Direccion + ", Telefono=" + Telefono + "]";
	}
}
