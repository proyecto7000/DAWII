package ils.jpa.rafael.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import ils.jpa.rafael.model.vacante;

public interface VacantesRepository extends JpaRepository<vacante, Integer> {

	
	    List<vacante> findByEstatus(String estatus);

        List<vacante> findByDestacadoAndEstatusOrderByIdDesc(Integer destacado, String estatus);
	
	
        List<vacante> findBySalarioBetween(double s1 , double s2);
       
        List<vacante> findBySalarioBetweenOrderBySalarioDesc(double s1 , double s2);
	     
        List<vacante> findByEstatusIn(String[] estatus);
        
       
	    
	   
	
}
