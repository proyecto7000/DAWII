package ils.JPA.JPAempleosDB;


import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

import ils.JPA.JPAempleosDB.model.Categoria;
import ils.JPA.JPAempleosDB.repository.CategoriasRepository;
//import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;

import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class JpAempleosDbApplication implements CommandLineRunner{

	@Autowired
	private CategoriasRepository repo;
	
	public static void main(String[] args) {
		SpringApplication.run(JpAempleosDbApplication.class, args);
	}
	
	
	//--------------------------------- JPA -------------------------
	
	
	
	@Override
	public void run(String... args) throws Exception{
		//buscartodasJPA();
		//borrartodoenBloque();
	}
	
	
	//LISTAR TODAS LAS CATEGORIAS
	
	private void buscartodasJPA() {
		List<Categoria> categorias=repo.findAll();
		for(Categoria c : categorias) {
			System.out.println(c.getId()+" "+c.getNombre());
		}
	}
	
	//BORRA TODOS LOS DATOS DE LA TABLA Y RESETEA EL AUTOINCREMENT
	private void borrartodoenBloque() {
		repo.deleteAllInBatch();
	}
	
	//BUSCAR TODOS POR ORDENAMIENTO BY
	private void buscartodosOrdenados() {
		List<Categoria> categorias=repo.findAll(Sort.by("nombre"));
	}
	
	
	
	
	
	
	
	//----------------METODOS BASICOS CON CRUD-------------
	
	
	
	//METODO DE EJECUCION
	
	//@Override
	//public void run(String... args) throws Exception{
		//System.out.println(repo);
		//guardar();
		//buscarPorID();
		//buscarTodos();
		//encontraporId();
		//existeId();
		//guardartodas();
	//}	
	
	
	private void buscarTodos() {
		Iterable<Categoria> categorias = repo.findAll();
		for (Categoria cat : categorias) {
			System.out.println(cat);
		}
	}
	
	//METODOS DE BUSQUEDA
	
	//busca por id
	private void buscarPorID() {
		Optional<Categoria> optional  = repo.findById(1);
		if(optional.isPresent())
		  System.out.println(optional.get());
		else 
			System.out.println("Categoria no encontrada");
	}
	
	
	//lista de busquedas por id
	private void encontraporId() {
		List<Integer> ids = new  LinkedList<Integer>();
		ids.add(1);
		ids.add(4);
		ids.add(5);
      Iterable<Categoria> categorias =  repo.findAllById(ids);
      for (Categoria cat : categorias) {
    	  System.out.println(cat);   
      }
	}
	
	//existencia de busqueda
	private void existeId() {
		boolean existe  = repo.existsById(8);
		System.out.println("la categoria  existe : "+ existe);
	}
	
	//METODOS EXTRA
	
	private void guardartodas() {
		List<Categoria>  categorias  = getListaCategorias();
		repo.saveAll(categorias);		
		
	}
	
	private void guardar() {
		Categoria cat=new Categoria();
		cat.setNombre("Finanzas");
		cat.setDescripcion("Trabajos relacionados con finanzas y contabilidad");
		repo.save(cat);
		System.out.println(cat);
	}
	
	private void eliminar() {
		System.out.println("Eliminando un Registro");
	}
	
	//LISTA CATEGORIAS
	private List<Categoria> getListaCategorias(){
		List<Categoria> lista =  new  LinkedList<Categoria>();
		// categoria 1
		Categoria cat1 = new  Categoria();
		cat1.setNombre("Programador de BlockChain");
		cat1.setDescripcion("Trabajos relacionados con Bit coins");
		//  categoria  2
		Categoria cat2 = new  Categoria();
		cat2.setNombre("Soldador Pintura");
		cat2.setDescripcion("Trabajos Relacionados con Soldadura y pintura");
		//   catego  3
		Categoria cat3 = new  Categoria();
		cat3.setNombre("Ingeniero industrial");
		cat3.setDescripcion("Trabajos relacionados con ingenieria industrial");
		
		
		lista.add(cat1);
		lista.add(cat2);
		lista.add(cat3);	
		return lista;	
		
	}
}
