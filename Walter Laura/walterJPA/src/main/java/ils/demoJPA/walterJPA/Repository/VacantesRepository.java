package ils.demoJPA.walterJPA.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ils.demoJPA.walterJPA.model.Vacantes;

public interface VacantesRepository extends JpaRepository<Vacantes, Integer> {
	
	
List<Vacantes> findByEstatus(String estatus);
List<Vacantes> findByDestacadoAndEstatusOrderByIdDesc(int destacado,String estatus);
List<Vacantes> findBySalarioBetween(double s1,double s2);
List<Vacantes> findByEstatusIn(String[] estatus);

List <Vacantes> findBySalarioGreaterThanEqual(double s1);
List <Vacantes>findTop7ByOrderByIdAsc();



}
