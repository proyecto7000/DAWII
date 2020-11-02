package Nico.ils.EmpleoNicolas.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import Nico.ils.EmpleoNicolas.model.Solicitud;

public interface SolicitudesRepository extends JpaRepository<Solicitud, Integer> {

}