package Practica.EmpleosWalter.Modelo;

public class Vacantes {

	private int Codigo;
	private String Nombre;
	private int edad;
	private boolean Educacion; 
	private String Direccion;
	private int Telefono;
	private int destacado;
	private String imagenes="no-image.png";

	public String getImagenes() {
		return imagenes;
	}
	public void setImagenes(String imagenes) {
		this.imagenes = imagenes;
	}
	public int getDestacado() {
		return destacado;
	}
	public void setDestacado(int destacado) {
		this.destacado = destacado;
	}
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
		return "Vacantes [Codigo=" + Codigo + ", Nombre=" + Nombre + ", edad=" + edad + ", Educacion=" + Educacion
				+ ", Direccion=" + Direccion + ", Telefono=" + Telefono + ", destacado=" + destacado + ", imagenes="
				+ imagenes + "]";
	}
}
