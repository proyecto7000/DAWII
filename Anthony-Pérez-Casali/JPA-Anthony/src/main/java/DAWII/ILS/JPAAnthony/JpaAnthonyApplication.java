package DAWII.ILS.JPAAnthony;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import DAWII.ILS.JPAAnthony.Model.CATEGORIAS;
import DAWII.ILS.JPAAnthony.REPOSITORIO.CATEGORIASRepositorio;

@SpringBootApplication
public class JpaAnthonyApplication implements CommandLineRunner {

	@Autowired
	private CATEGORIASRepositorio repo;
	
	public static void main(String[] args) {
		SpringApplication.run(JpaAnthonyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		guardar();
	}
	private void guardar()
	{
		CATEGORIAS cat = new CATEGORIAS();
		cat.setNombre("FINANZAS");
		cat.setDescripcion("Trabajos relacionados con Finanzas y Contabilidad");
		repo.save(cat);
		System.out.println(cat);
	}
}
