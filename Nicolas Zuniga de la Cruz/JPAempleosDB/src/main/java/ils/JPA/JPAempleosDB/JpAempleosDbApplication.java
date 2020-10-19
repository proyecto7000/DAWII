package ils.JPA.JPAempleosDB;


import java.util.LinkedList;
import java.util.List;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import ils.JPA.JPAempleosDB.model.Categoria;
import ils.JPA.JPAempleosDB.model.Vacante;


import ils.JPA.JPAempleosDB.repository.CategoriasRepository;
import ils.JPA.JPAempleosDB.repository.VacantesRepository;

import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class JpAempleosDbApplication implements CommandLineRunner{

	@Autowired
	private CategoriasRepository repo;
	
	@Autowired
	private VacantesRepository repoVacantes;
	
	public static void main(String[] args) {
		SpringApplication.run(JpAempleosDbApplication.class, args);
	}
	
	
	//--------------------------------- JPA -------------------------
	
	
	
	@Override
	public void run(String... args) throws Exception{
		//buscartodasJPA();
		//borrartodoenBloque();
		//buscartodosOrdenados();
		//buscartodosPaginacion();
		//buscartodosPaginacionOrdenado();
		
		//VACANTES
		
		//buscarVacantes();
		//guardarVacante();
		//buscarVacantesPorEstatus();
		//buscarVacantesPorDestacadoEstatus();
		//buscarVacanteSalario();
		BuscarVacantesVariosEstatus();
		
	}
	
	
	
	//----------------------VACANTES--------------------
	//BUSCAR VANCANTES
	private void buscarVacantes() {
		List<Vacante> lista=repoVacantes.findAll();
		for(Vacante v : lista) {
			System.out.println(v.getId()+ "  "+v.getNombre()+"  "+v.getCategoria().getNombre());
		}
	}
	
	
	//GUARDAR UNA NUEVA VACANTE
	private void guardarVacante() {
		Vacante v = new Vacante();
		v.setNombre("Profesor de matematicas");
		v.setDescripcion("Escuela primeria  solicita profesor para curso de matematicas");
		v.setFecha(new Date());
		v.setSalario(8500.0);
		v.setEstatus("Aprobada");
		v.setDestacado(0);
		v.setImagen("escuela.png");
		v.setDetalles("<h1>los requisitos para profesor de matematicas</h1>");
		Categoria cat = new  Categoria();
		cat.setId(15);
		v.setCategoria(cat);
		repoVacantes.save(v);
	}
	
	//BUSCAR VACANTES POR ESTATUS
	private void buscarVacantesPorEstatus() {
		List<Vacante> lista=repoVacantes.findByEstatus("Aprobada");
		System.out.println("Registros encontrados: "+lista.size());
		for(Vacante v:lista) {
			System.out.println(v.getId()+" "+v.getNombre()+" "+v.getEstatus());
		}
	}
	
	//BUSCAR VACANTES POR ESTATUS DESTACADO
	private void buscarVacantesPorDestacadoEstatus() {
		List<Vacante> Lista=repoVacantes.findByDestacadoAndEstatusOrderByIdDesc(1, "Aprobada");
		System.out.println("Registros encontrados: "+Lista.size());
		for(Vacante v:Lista) {
			System.out.println(v.getId()+" "+v.getNombre()+" "+v.getEstatus()+" "+v.getEstatus());
		}
	}
	
	//BUSCAR VACANTES POR SALARIO
	private void buscarVacanteSalario() {
		List<Vacante> lista = repoVacantes.findBySalarioBetween(7000, 14000);
		System.out.println("Registros encontrados: "+ lista.size());
		for (Vacante v : lista ) {
			System.out.println(v.getId()+" : " + v.getNombre() +" : "+ v.getSalario());
		}
	}
	
	//BUSCAR POR ESTATUS
    private void BuscarVacantesVariosEstatus() {
    	
    	String[]  estatus = new  String[] {"Eliminada", "Creada"};
    	List<Vacante> lista = repoVacantes.findByEstatusIn(estatus);
    	System.out.println("Registros encontrados:" +  lista.size());
    	for(Vacante v : lista) {
    		System.out.println(v.getId() +" : " + v.getNombre()+ " : "+v.getEstatus());
    	}
    }
	//----------------------CATEGORIAS------------------
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
		for(Categoria c : categorias) {
			System.out.println(c.getId()+" "+c.getNombre());
		}
	}
	
	//
	private void buscartodosPaginacion() {
		Page<Categoria> page=repo.findAll(PageRequest.of(0, 5));
		for(Categoria p : page.getContent()) {
			System.out.println(p.getId()+" "+p.getNombre());
		}
	}
	
	//
	private void buscartodosPaginacionOrdenado() {
		Page<Categoria> page=repo.findAll(PageRequest.of(0, 5,Sort.by("nombre")));
		System.out.println("Total Registros: "+page.getTotalElements());
		System.out.println("Total paginas: "+page.getTotalPages());
		for(Categoria p : page.getContent()) {
			System.out.println(p.getId()+" "+p.getNombre());
		}
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
