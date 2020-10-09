package ils.empleos.jpaCarolina.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ils.empleos.jpaCarolina.model.Vacante;

public interface VacantesRepository extends JpaRepository<Vacante, Integer> {
	
	List <Vacante> findByEstatus(String estatus);

	List <Vacante> findByDestacadoAndEstatusOrderByIdDesc(int destacado, String estatus);
	
	List <Vacante> findBySalarioBetweenOrderBySalarioDesc(double s1, double s2);
	
	List <Vacante> findByEstatusIn(String [] estatus);
	
	
	
	
	List <Vacante> findBySalarioGreaterThanEqual(double s1);
	
	List <Vacante>findTop7ByOrderByIdAsc();
	
	
	
		
	


}
