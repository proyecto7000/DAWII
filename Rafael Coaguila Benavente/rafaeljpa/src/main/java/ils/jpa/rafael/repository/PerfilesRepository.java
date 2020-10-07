package ils.jpa.rafael.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import ils.jpa.rafael.model.perfil;

public interface PerfilesRepository extends JpaRepository<perfil, Integer> {

}
