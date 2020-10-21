package Practica.EmpleosWalter.Servicio;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import Practica.EmpleosWalter.Modelo.Vacantes;

public interface VacantService {
List<Vacantes> cargarDatos();
Vacantes buscarId(Integer idVacante);
void guardar(Vacantes vacante);

List<Vacantes>buscarDestacados();
void eliminar(Integer idVacante);

List<Vacantes> buscarByExample(Example<Vacantes> example);
Page<Vacantes> buscarTodas(Pageable page);
}
