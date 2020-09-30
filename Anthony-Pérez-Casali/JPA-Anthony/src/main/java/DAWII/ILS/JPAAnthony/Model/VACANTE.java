package DAWII.ILS.JPAAnthony.Model;

import java.util.Date;

public class VACANTE {
	
	private Integer ID;
	private String Nombre;
	private String Descripcion;
	private Date Fecha;
	private double Salario;
	private Integer Destacado;
	private String imagen="no-image.png";
	private String Estatus;
	private String detalles;
	private CATEGORIAS Categoria;
	
	public String getEstatus() {
		return Estatus;
	}
	public void setEstatus(String estatus) {
		Estatus = estatus;
	}
	public String getdetalles() {
		return detalles;
	}
	public void setdetalles(String detalle) {
		detalles = detalle;
	}
	
	
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
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
	public Integer getDestacado() {
		return Destacado;
	}
	public void setDestacado(Integer destacado) {
		Destacado = destacado;
	}
	
	public CATEGORIAS getCategoria() {
		return Categoria;
	}
	public void setCategoria(CATEGORIAS categoria) {
		Categoria = categoria;
	}
	
	@Override
	public String toString() {
		return "VACANTE [ID=" + ID + ", Nombre=" + Nombre + ", Descripcion=" + Descripcion + ", Fecha=" + Fecha
				+ ", Salario=" + Salario + ", Destacado=" + Destacado + ", imagen=" + imagen + ", Estatus=" + Estatus
				+ ", detalles=" + detalles + ", Categoria=" + Categoria + "]";
	}
	
}
