package ils.empleos.jpaCarolina;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ils.empleos.jpaCarolina.model.Categoria;
import ils.empleos.jpaCarolina.repository.CategoriasRepository;

@SpringBootApplication
public class JpaCarolinaApplication implements CommandLineRunner{

	@Autowired
	private CategoriasRepository repo;
	
	public static void main(String[] args) {
		SpringApplication.run(JpaCarolinaApplication.class, args);
	}

	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		guardarTodas();
	}
 
	private void guardar() {
		// TODO Auto-generated method stub
		Categoria cat=new Categoria();
		cat.setNombre("Finanzas");
		cat.setDescripcion("Trabajos relacionados con finanzas y contabilidad");
		repo.save(cat);
		System.out.println(cat);
	}
	
	 
	private void buscarPorId(){
		Optional<Categoria> optional = repo.findById(1);
		if(optional.isPresent()){
		System.out.println(optional.get());
		}else
		System.out.println("Categoria no encontrada");
	}


	private void modificar(){
		Optional<Categoria> optional = repo.findById(2);
		if(optional.isPresent()){
		Categoria catTmp = optional.get();
		catTmp.setNombre("Ing. de software");
		catTmp.setDescripcion("Desarrollo de sistemas");
		repo.save(catTmp);
		System.out.println(optional.get());
		}else
		System.out.println("Categoria no encontrada");	
	}


	private void eliminar(){
		int idCategoria = 1;
		repo.deleteById(idCategoria);
	}


	private void conteo(){
		long count=repo.count();
		System.out.println("Total de Categorías: " + count);
	}
	
	private void eliminarTodos() {
		repo.deleteAll();
	}
	
	
	
	//insertar categorias.sql
	
	private void encontrarPorIds() {
		List<Integer> ids=new LinkedList<Integer>();
		ids.add(1);
		ids.add(4);
		ids.add(10);
		Iterable<Categoria> categorias = repo.findAllById(ids);
		for(Categoria cat : categorias) {
			System.out.println(cat);
		}
		
	}

	private void buscarTodos() {
		Iterable<Categoria> categorias = repo.findAll();
		for (Categoria cat : categorias) {
			System.out.println(cat);
		}
	}
	
	
	private void existeId() {
		boolean existe = repo.existsById(16);
		System.out.println("La categoria existe: " + existe);
	}
	

	
	
	private List<Categoria> getListaCategorias(){
		List<Categoria> lista=new LinkedList<Categoria>();
		
		Categoria cat1= new Categoria();
		cat1.setNombre("Programador de Blockchain");
		cat1.setDescripcion("Trabajos elacionados con Bitcoin y Criptomonedas");
		
		Categoria cat2= new Categoria();
		cat2.setNombre("Soldador/Pintura");
		cat2.setDescripcion("Trabajos relacionados coon soldadura, pintura y enderezado");
		
		Categoria cat3= new Categoria();
		cat3.setNombre("Ingeniero Industrial");
		cat3.setDescripcion("Trabajos relacionados con Ingieneria Industrial");
		
		lista.add(cat1);
		lista.add(cat2);
		lista.add(cat3);
		
		return lista;
	
	}
	
	
	
	private void guardarTodas() {
		List<Categoria> categorias= getListaCategorias();
		repo.saveAll(categorias);
	}
	
	

}
