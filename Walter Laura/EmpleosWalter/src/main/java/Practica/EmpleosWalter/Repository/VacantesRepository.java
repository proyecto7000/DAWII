package Practica.EmpleosWalter.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import Practica.EmpleosWalter.Modelo.Vacantes;


public interface VacantesRepository extends JpaRepository<Vacantes, Integer> {
	
	
List<Vacantes> findByEstatus(String estatus);
List<Vacantes> findByDestacadoAndEstatusOrderByIdDesc(int destacado,String estatus);
List<Vacantes> findBySalarioBetween(double s1,double s2);
List<Vacantes> findByEstatusIn(String[] estatus);


}
