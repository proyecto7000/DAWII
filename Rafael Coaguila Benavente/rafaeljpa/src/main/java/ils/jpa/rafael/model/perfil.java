package ils.jpa.rafael.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name= "perfiles")
public class perfil {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //auto incremento de SQL
	private Integer id ;
	private  String  perfil;
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPerfil() {
		return perfil;
	}
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	
	
	
	@Override
	public String toString() {
		return "perfil [id=" + id + ", perfil=" + perfil + "]";
	}
	
	
	
	
}
