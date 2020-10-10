package Anthony.VR46.Practica2.Respositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import Anthony.VR46.Practica2.Model.VACANTE;


public interface VACANTESRepositorio extends JpaRepository<VACANTE, Integer> {
	List<VACANTE> findByEstatus(String estatus);
	
	List<VACANTE> findByDestacadoAndEstatusOrderByIdDesc(int destacado, String estatus);
	
	List<VACANTE> findBySalarioBetweenOrderBySalarioDesc(double s1, double s2);
	
	List<VACANTE> findByEstatusIn(String[] estatus);
	
}
