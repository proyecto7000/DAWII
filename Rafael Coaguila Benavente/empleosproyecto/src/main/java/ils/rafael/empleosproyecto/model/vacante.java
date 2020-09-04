package ils.rafael.empleosproyecto.model;

import java.util.Date;

public class vacante {

	private Integer   id;
	private String  nombre;
    private String   descripcion;
    private  Date fecha;
    private Double salario;
    private Integer destacada;
    private String logo="no-image.png";
    
    
    
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public Integer getDestacada() {
		return destacada;
	}
	public void setDestacada(Integer destacada) {
		this.destacada = destacada;
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
	
	@Override
	public String toString() {
		return "vacante [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", fecha=" + fecha
				+ ", salario=" + salario + "]";
	}
	
    
    
    
}
