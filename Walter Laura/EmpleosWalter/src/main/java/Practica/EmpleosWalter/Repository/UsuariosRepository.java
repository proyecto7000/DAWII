package Practica.EmpleosWalter.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Practica.EmpleosWalter.Modelo.Usuario;


public interface UsuariosRepository  extends JpaRepository<Usuario,Integer> {

}
