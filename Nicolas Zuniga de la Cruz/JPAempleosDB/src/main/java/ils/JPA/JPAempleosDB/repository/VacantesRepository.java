package ils.JPA.JPAempleosDB.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
import ils.JPA.JPAempleosDB.model.Vacante;

public interface VacantesRepository extends JpaRepository<Vacante, Integer> {
	List<Vacante> findByEstatus(String estatus);
	List<Vacante> findByDestacadoAndEstatusOrderByIdDesc(Integer destacado, String estatus);
	List<Vacante> findBySalarioBetween(double s1 , double s2);
	List<Vacante> findBySalarioBetweenOrderBySalarioDesc(double s1 , double s2);
	List<Vacante> findByEstatusIn(String[] estatus);
}
