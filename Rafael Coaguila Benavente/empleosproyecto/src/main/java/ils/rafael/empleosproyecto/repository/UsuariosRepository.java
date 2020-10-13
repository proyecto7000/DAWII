package ils.rafael.empleosproyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import ils.rafael.empleosproyecto.model.usuario;



public interface UsuariosRepository extends JpaRepository<usuario, Integer> {

	
	
	
}
