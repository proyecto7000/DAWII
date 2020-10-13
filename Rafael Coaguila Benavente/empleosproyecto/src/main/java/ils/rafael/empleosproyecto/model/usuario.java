package ils.rafael.empleosproyecto.model;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="usuarios")
public class usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String username;
	private String nombre;
	private String email;
	private String password;
	private Integer estatus;
	private Date fechaRegistro;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="UsuarioPerfil", 
	           joinColumns = @JoinColumn(name="idusuario"),
	           inverseJoinColumns = @JoinColumn(name="idperfil")
			)
	
	
	private List<perfil> perfiles;
	
	public void agregar (perfil tempPerfil) {
		if (perfiles == null) {
			perfiles = new LinkedList<perfil>();
		}
		perfiles.add(tempPerfil);
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getEstatus() {
		return estatus;
	}
	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	
	
	
	
	
	
	public List<perfil> getPerfiles() {
		return perfiles;
	}
	public void setPerfiles(List<perfil> perfiles) {
		this.perfiles = perfiles;
	}
	@Override
	public String toString() {
		return "usuario [id=" + id + ", username=" + username + ", nombre=" + nombre + ", email=" + email
				+ ", password=" + password + ", estatus=" + estatus + ", fechaRegistro=" + fechaRegistro + ", perfiles="
				+ perfiles + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
}
