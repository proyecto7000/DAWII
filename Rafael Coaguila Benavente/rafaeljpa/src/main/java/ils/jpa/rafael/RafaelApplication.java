package ils.jpa.rafael;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

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
		
		guardartodas();
		
	}
	
	// guarda los insert en cantidad y no una por una 
	private void guardartodas() {
		List<categoria>  categorias  = getListaCategorias();
		repo.saveAll(categorias);		
		
	}
	
	
	
	// muestra si existe o no el  insert por id
	private void existeid() {
		boolean existe  = repo.existsById(8);
		System.out.println("la categoria  existe : "+ existe);
	}
	
	
	// busca todos los insert
	private void  buscartodos() {
		Iterable<categoria> categorias = repo.findAll();
		for (categoria cat : categorias) {
			System.out.println(cat);
		}
	}
	
	
	// encuentra por id
	private void encontraporid() {
		List<Integer> ids = new  LinkedList<Integer>();
		ids.add(1);
		ids.add(4);
		ids.add(5);
      Iterable<categoria> categorias =  repo.findAllById(ids);
      for (categoria cat : categorias) {
    	  System.out.println(cat);   
      }
	}
	
	// elimina todo lo  insertado
	private void eliminartodo() {
		repo.deleteAll();
	}
	
	// te muestra la cantidad de insert que se hizo
	private void  conteo(){
		long count = repo.count();
		System.out.println(" Hay : " + count + " Categorias");
		
	}
	
	// modifica el insert  y si no hay nada la crea
	private  void modificar() {
		
		Optional<categoria> optional  = repo.findById(2);
		if(optional.isPresent()) {
			categoria categoriatemp = optional.get();
			categoriatemp.setNombre("Computacion e informatica");
			categoriatemp.setDescripcion(" solo para hombres ");
			repo.save(categoriatemp);
		  System.out.println(optional.get());
		}
		else 
			System.out.println("Categoria no encontrada");
	}
	
	
	// busca  el insert por id
	private void buscarporid() {
		
		Optional<categoria> optional  = repo.findById(1);
		if(optional.isPresent())
		  System.out.println(optional.get());
		else 
			System.out.println("Categoria no encontrada");
		
	}
	//  guarda el insert
	private void guardar() {
		
		categoria cat =  new categoria();
		cat.setNombre("Ingenieria de Sistemas");
		cat.setDescripcion("para hombres tambien");
		repo.save(cat);
		System.out.println(cat);
		
	}
	// elimina el insert
	private void eliminar() {
		int idcategoria = 1;
		repo.deleteById(idcategoria);
		System.out.println("Registro eliminado mi Omnipotente");
	}
	
	
	
	private List<categoria> getListaCategorias(){
		List<categoria> lista =  new  LinkedList<categoria>();
		// categoria 1
		categoria cat1 = new  categoria();
		cat1.setNombre("Programador Sise");
		cat1.setDescripcion("el buen programador");
		//  catego  2
		categoria cat2 = new  categoria();
		cat2.setNombre("Ciencia de la computacion");
		cat2.setDescripcion("la mejor carrera app");
		//   catego  3
		categoria cat3 = new  categoria();
		cat3.setNombre("Ingeniero industrial");
		cat3.setDescripcion("carrera de calidad");
		
		
		lista.add(cat1);
		lista.add(cat2);
		lista.add(cat3);
		
		
		
		
		return lista;
		
		
	}
	

}
