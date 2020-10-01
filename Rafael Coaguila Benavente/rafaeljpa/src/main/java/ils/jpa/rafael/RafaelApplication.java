package ils.jpa.rafael;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ils.jpa.rafael.model.categoria;
import ils.jpa.rafael.repository.CategoriasRepository;

@SpringBootApplication
public class RafaelApplication implements CommandLineRunner {

	@Autowired
	private CategoriasRepository repo;
	
	public static void main(String[] args) {
		SpringApplication.run(RafaelApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println(repo);
		guardar();
		
	}
	
	private void guardar() {
		
		categoria cat =  new categoria();
		cat.setNombre("Contabilidad");
		cat.setDescripcion("todo lo que sea contar");
		repo.save(cat);
		System.out.println(cat);
		
	}
	
	private void eliminar() {
		System.out.println("eliminando el registro");
	}

}
