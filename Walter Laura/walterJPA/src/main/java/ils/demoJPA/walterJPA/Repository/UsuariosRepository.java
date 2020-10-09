package ils.demoJPA.walterJPA.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ils.demoJPA.walterJPA.model.Usuario;

public interface UsuariosRepository  extends JpaRepository<Usuario,Integer> {

}
