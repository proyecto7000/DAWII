package ils.demoJPA.walterJPA.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import ils.demoJPA.walterJPA.model.Vacantes;

public interface VacantesRepository extends JpaRepository<Vacantes, Integer> {

}
