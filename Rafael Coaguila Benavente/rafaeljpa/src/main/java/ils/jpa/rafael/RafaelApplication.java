package ils.jpa.rafael;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import ils.jpa.rafael.model.categoria;
import ils.jpa.rafael.model.vacante;
import ils.jpa.rafael.repository.CategoriasRepository;
import ils.jpa.rafael.repository.VacantesRepository;

@SpringBootApplication
public class RafaelApplication implements CommandLineRunner {

	@Autowired
	private CategoriasRepository repo;
	
	@Autowired
	private VacantesRepository repovacantes;
	
	public static void main(String[] args) {
		SpringApplication.run(RafaelApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		guardarvacante();
		
	}
	
	
	private void guardarvacante() {
		vacante vacante = new vacante();
		vacante.setNombre("Profesor de matematicas");
		vacante.setDescripcion("Escuela primeria  solicita profesor para curso de matematicas");
		vacante.setFecha(new Date());
		vacante.setSalario(8500.0);
		vacante.setEstatus("Aprobada");
		vacante.setDestacado(0);
		vacante.setImagen("escuela.png");
		vacante.setDetalles("<h1>los requisitos para profesor de matematicas</h1>");
		categoria cat = new  categoria();
		cat.setId(15);
		vacante.setCategoria(cat);
		repovacantes.save(vacante);
	}
	
	
	
	// TODO ESTO ES VACANTES
	
	private void buscatodasVacantes() {
		List<vacante> lista = repovacantes.findAll();
		for(vacante v : lista ) {
			System.out.println(v.getId()+"  "+ v.getNombre()+" /// "+ v.getCategoria().getNombre());
		}
		
	}
	
	
	
	
	
	
	//-----------------------------------------------------------------------------------------------------------------------------------------------------
	
	// TODO ESTO ES CATEGORIAS
	
	// busca  la tabla (comienza desde la tabla 0) o la que deseee, y de segundo parametro el numero de registro que se desea buscar y mostrar
	private void Buscartodaspaginacion() {
		Page<categoria> page =  repo.findAll(PageRequest.of(0, 5,Sort.by("nombre")));
	     
		//campos adicionales  para ver el total de registros y paginas.
		System.out.println("Total de registros " +  page.getTotalElements());
		System.out.println("Total de paginas " +  page.getTotalPages());
		 
		for(categoria c : page.getContent()) {
			System.out.println(c.getId()+" "+ c.getNombre());
		}
	}
	
	
	
	
	//  busca todas la lista  en este caso por nombre de la A a la Z  y si se usa .DESCENDING() Lo hara de manera contraria 
	private void buscartodosOrdenados() {
		 List<categoria> categorias = repo.findAll(Sort.by("nombre"));
		 for(categoria c: categorias) {
			 System.out.println(c.getId()+ " " +  c.getNombre());
		 }
		
	}
	// borra todas las datos insertados de golpe y no uno por uno como lo hace el crud
	
	private void borrartodasEnbloque() {
	                repo.deleteAllInBatch();   
	}
	
	
	//encuentra todos registro para mostrarlo por id y nombre
	
	private void buscartodasjpa() {
		 List<categoria> categorias = repo.findAll();
		 for(categoria c: categorias) {
			 System.out.println(c.getId()+ " " +  c.getNombre());
		 }
		 
		 
	}
	
	//------------------------------------------------------------------------------------------------------------------------------
	//------------------------------------------------------------------------------------------------------------------------------
	
	//CRUD CRUD CRUD CRUD
	
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
