package ils.empleos.jpaCarolina.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ils.empleos.jpaCarolina.model.Vacante;

public interface VacantesRepository extends JpaRepository<Vacante, Integer> {

}
