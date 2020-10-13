package ils.rafael.empleosproyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import ils.rafael.empleosproyecto.model.perfil;



public interface PerfilesRepository extends JpaRepository<perfil, Integer> {

}
