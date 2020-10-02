package ils.demoJPA.walterJPA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ils.demoJPA.walterJPA.Repository.CategoriasRepository;
import ils.demoJPA.walterJPA.model.Categorias;

@SpringBootApplication
public class WalterJpaApplication implements CommandLineRunner{

	@Autowired
	private CategoriasRepository repo;
	
	public static void main(String[] args) {
		SpringApplication.run(WalterJpaApplication.class, args);
	}
	public void run(String...args)throws Exception{
		guardar();
	}
	private void guardar() {
		Categorias cat=new  Categorias();
		cat.setNombre("Finanzas");
		cat.setDescripcion("Trabajos relacionado con finanzas y contabilidad");
		repo.save(cat);
		System.out.println(cat);
	}
	private void eliminar() {
		System.out.println("Eliminando un registro");
	}
}
