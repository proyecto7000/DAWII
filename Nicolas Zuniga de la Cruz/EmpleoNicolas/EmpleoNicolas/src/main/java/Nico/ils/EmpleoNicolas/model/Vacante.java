package Nico.ils.EmpleoNicolas.model;

import java.util.Date;

public class Vacante {
	
	private Integer id;
	private String nombre;
	private String descripcion;
	private Date fecha;
	private Double salario;
	private Integer destacada;
	private String imagen="no-image.png";
	
	private String estatus;
	private String detalle;
	
	
	public Integer getDestacada() {
		return destacada;
	}
	public void setDestacada(Integer destacada) {
		this.destacada = destacada;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Double getSalario() {
		return salario;
	}
	public void setSalario(Double salario) {
		this.salario = salario;
	}
	
	
	
	
	
	public String getStatus() {
		return estatus;
	}
	public void setStatus(String status) {
		this.estatus = status;
	}
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	@Override
	public String toString() {
		return "Vacante [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", fecha=" + fecha
				+ ", salario=" + salario + ", destacada=" + destacada + ", imagen=" + imagen + ", estatus=" + estatus
				+ ", detalle=" + detalle + ", getDestacada()=" + getDestacada() + ", getImagen()=" + getImagen()
				+ ", getId()=" + getId() + ", getNombre()=" + getNombre() + ", getDescripcion()=" + getDescripcion()
				+ ", getFecha()=" + getFecha() + ", getSalario()=" + getSalario() + ", getStatus()=" + getStatus()
				+ ", getDetalle()=" + getDetalle() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

	
	
}
