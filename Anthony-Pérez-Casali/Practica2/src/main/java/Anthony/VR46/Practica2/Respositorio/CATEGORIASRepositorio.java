package Anthony.VR46.Practica2.Respositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import Anthony.VR46.Practica2.Model.CATEGORIAS;


public interface CATEGORIASRepositorio extends JpaRepository<CATEGORIAS, Integer> {

}
