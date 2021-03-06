package DAWII.ILS.JPAAnthony.REPOSITORIO;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import DAWII.ILS.JPAAnthony.Model.VACANTE;

public interface VACANTESRepositorio extends JpaRepository<VACANTE, Integer> {
	List<VACANTE> findByEstatus(String estatus);
	
	List<VACANTE> findByDestacadoAndEstatusOrderByIdDesc(int destacado, String estatus);
	
	List<VACANTE> findBySalarioBetweenOrderBySalarioDesc(double s1, double s2);
	
	List<VACANTE> findByEstatusIn(String[] estatus);
	
	List<VACANTE> findBySalarioGreaterThanEqual(double s);
	
	List<VACANTE> findFirst7ByOrderByIdDesc();
	
}
