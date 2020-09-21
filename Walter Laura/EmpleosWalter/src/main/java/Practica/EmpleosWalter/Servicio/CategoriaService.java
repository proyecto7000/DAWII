package Practica.EmpleosWalter.Servicio;

import java.util.List;

import Practica.EmpleosWalter.Modelo.Categorias;


public interface CategoriaService {
	
	void guardar(Categorias categoria);
	List<Categorias> buscarTodas();
	Categorias buscarPorId(Integer idCategoria);	
}
