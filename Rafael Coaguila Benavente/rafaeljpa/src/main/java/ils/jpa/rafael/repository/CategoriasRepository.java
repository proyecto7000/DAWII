package ils.jpa.rafael.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import ils.jpa.rafael.model.categoria;


//public interface CategoriasRepository extends CrudRepository<categoria, Integer> {
public interface CategoriasRepository extends JpaRepository<categoria, Integer> {

}
