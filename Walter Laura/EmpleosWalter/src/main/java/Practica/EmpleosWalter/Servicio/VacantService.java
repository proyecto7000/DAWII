package Practica.EmpleosWalter.Servicio;

import java.util.List;



import Practica.EmpleosWalter.Modelo.Vacantes;


public interface VacantService {
List<Vacantes> cargarDatos();
Vacantes buscarId(Integer idVacante);
}
