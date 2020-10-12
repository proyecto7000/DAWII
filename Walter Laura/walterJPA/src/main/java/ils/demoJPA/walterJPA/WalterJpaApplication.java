package ils.demoJPA.walterJPA;

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

import ils.demoJPA.walterJPA.Repository.CategoriasRepository;
import ils.demoJPA.walterJPA.Repository.PerfilesRepository;
import ils.demoJPA.walterJPA.Repository.UsuariosRepository;
import ils.demoJPA.walterJPA.Repository.VacantesRepository;
import ils.demoJPA.walterJPA.model.Categorias;
import ils.demoJPA.walterJPA.model.Perfil;
import ils.demoJPA.walterJPA.model.Usuario;
import ils.demoJPA.walterJPA.model.Vacantes;



@SpringBootApplication
public class WalterJpaApplication implements CommandLineRunner{

	@Autowired
	private CategoriasRepository repoCategorias;
	
	@Autowired
	private VacantesRepository repoVacantes;
	
	@Autowired
	private PerfilesRepository repoPerfiles;
	
	@Autowired
	private UsuariosRepository repoUsuarios;
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(WalterJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		ejercicio2();
		
	}
	
	//Consultas Query tarea
	
	
//	a.	Escriba a continuación cómo sería la declaración de un “Query method” que 
//	implemente una sentencia SELECT para mostrar todas las vacantes que tengan un salario >= 3500
	
	private void ejercicio1() {
		List<Vacantes> lista = repoVacantes.findBySalarioGreaterThanEqual(3500);
		System.out.println("Registros encontrados: " + lista.size());
		for (Vacantes v : lista) {
			System.out.println(v.getId() + ": " + v.getNombre() + ": s/." + v.getSalario());
		}
	}
	
	
//	b.	Escriba a continuación cómo sería la declaración de un “Query method” que 
//	implemente una sentencia SELECT para mostrar las primeras 7 vacantes en orden descedente por el id
	
	private void ejercicio2() {
		List<Vacantes> lista = repoVacantes.findTop7ByOrderByIdAsc();//findTop7ByOrderByIdDesc();
		System.out.println("Registros encontrados: " + lista.size());
		for (Vacantes v : lista) {
			System.out.println(v.getId() + ": " + v.getNombre());
		}
	}
	
	
//	c.	Escriba a continuación cómo sería la declaración de un “Query method” que 
//	implemente una sentencia SELECT para mostrar todas las vacantes que tengan un estatus <> ‘Aprobada’	

	private void ejercicio3() {
		List<Vacantes> lista = repoVacantes.findByEstatus("Aprobada");
		System.out.println("Resgistro encontrados: " + lista.size());
		for(Vacantes v:lista){
			System.out.println(v.getId() +": "+v.getNombre() + ": "+v.getEstatus());
		}
		
	}
	
	//Consultas QUERY
	private void buscarVacantesVariosEstatus() {
		String []estatus=new String [] {"Eliminada","Creada"};
		List<Vacantes> lista = repoVacantes.findByEstatusIn(estatus);
		System.out.println("Resgistro encontrados: " + lista.size());
		for(Vacantes v:lista){
			System.out.println(v.getId() +": "+v.getNombre() + ": "+v.getEstatus());
		}
	}
	
	private void buscarVacantesSalario() {
		List<Vacantes> lista = repoVacantes.findBySalarioBetween(7000, 14000);
		System.out.println("Resgistro encontrados: " + lista.size());
		for(Vacantes v:lista){
			System.out.println(v.getId() +": "+v.getNombre() + ": "+v.getSalario());
		}
		
	}
	
	private void buscarVacantesPorDestacadoEstatus() {
		List<Vacantes> lista = repoVacantes.findByDestacadoAndEstatusOrderByIdDesc(1, "Aprobada");
		System.out.println("Resgistro encontrados: " + lista.size());
		for(Vacantes v:lista){
			System.out.println(v.getId() +": "+v.getEstatus() + ": "+v.getDestacado());
		}
		
	}
	 
	private void buscarVacantesPorEstatus() {
		List<Vacantes> lista = repoVacantes.findByEstatus("Aprobada");
		System.out.println("Resgistro encontrados: " + lista.size());
		for(Vacantes v:lista){
			System.out.println(v.getId() +": "+v.getNombre() + ": "+v.getEstatus());
		}
		
	}
	
	
	
	
	//Usuarios y perfiles
	
	public void buscarUsuario() {
		Optional<Usuario>optional=repoUsuarios.findById(1);
		if(optional.isPresent()) {
			Usuario u=optional.get();
			System.out.println("Usario: "+u.getNombre());
			System.out.println("Perfiles asignados");
			for(Perfil p:u.getPerfiles()) {
				System.out.println(p.getPerfil());
			}
		}else {
			System.out.println("Usuario no encontrado");
		}
	}
	
	
	private void crearUsuarioConDosPerfiles() {
		
		Usuario user = new Usuario();
		user.setNombre("Marco Larota");
		user.setEmail("MarcoL@gmail.com");
		user.setFechaRegistro(new Date());
		user.setUsername("Larota");
		user.setPassword("123");
		user.setEstatus(1);
		
		Perfil per1=new Perfil();
		per1.setId(2);
		
		Perfil per2=new Perfil();
		per2.setId(3);
		
		user.agregar(per1);
		user.agregar(per2);
		
		repoUsuarios.save(user);
	}
	
	private void crearPerfilesAplicacion() {
		repoPerfiles.saveAll(getPerfilesAplicacion());
	}
	
	//Vacantes
	public void guardarVacante() {
		Vacantes vacante = new Vacantes();
		vacante.setNombre("Profesor de matematicas");
		vacante.setDescripcion("Escuela primaria solicita docente");
		vacante.setFecha(new Date());
		vacante.setSalario(9000.500);
		vacante.setEstatus("Aprobada");
		vacante.setDestacado(0);
		vacante.setImagenes("escuela.png");
		vacante.setDetalles("Requisitos para profesor");
		
		Categorias cat = new Categorias();
		cat.setId(15);
		vacante.setCategoria(cat);
		repoVacantes.save(vacante);
	}
	
	

	
	private void buscarVacantes() {
		List<Vacantes> lista = repoVacantes.findAll();
		for(Vacantes v : lista ) {
			System.out.println(v.getId()+"  "+ v.getNombre()+" /// "+ v.getCategoria().getNombre());
		}
		
	}
	
	
	//Categorias

	private void Buscartodaspaginacion() {
		Page<Categorias> page =  repoCategorias.findAll(PageRequest.of(0, 5,Sort.by("nombre")));
	     
		System.out.println("Total de registros: " +  page.getTotalElements());
		System.out.println("Total de paginas: " +  page.getTotalPages());
		 
		for(Categorias c : page.getContent()) {
			System.out.println(c.getId()+" "+ c.getNombre());
		}
	}
	
	private void buscartodosOrdenados() {
		 List<Categorias> categorias = repoCategorias.findAll(Sort.by("nombre"));
		 for(Categorias c: categorias) {
			 System.out.println(c.getId()+ " " +  c.getNombre());
		 }
	}

	private void borrartodasEnbloque() {
		repoCategorias.deleteAllInBatch();   
	}
	
	private void buscartodasjpa() {
		 List<Categorias> categorias = repoCategorias.findAll();
		 for(Categorias c: categorias) {
			 System.out.println(c.getId()+ " " +  c.getNombre());
		 }
		 
		 
	}
	
	//------------------------------------------------------------------------------------------------------------------------------

	//CRUD
	
	private void guardartodas() {
		List<Categorias>  categorias  = getListaCategorias();
		repoCategorias.saveAll(categorias);		
		
	}
	
	private void existeid() {
		boolean existe  = repoCategorias.existsById(8);
		System.out.println("la categoria  existe: "+ existe);
	}
	
	private void  buscartodos() {
		Iterable<Categorias> categorias = repoCategorias.findAll();
		for (Categorias cat : categorias) {
			System.out.println(cat);
		}
	}
	
	private void encontraporid() {
		List<Integer> ids = new  LinkedList<Integer>();
		ids.add(1);
		ids.add(4);
		ids.add(5);
      Iterable<Categorias> categorias =  repoCategorias.findAllById(ids);
      for (Categorias cat : categorias) {
    	  System.out.println(cat);   
      }
	}
	
	private void eliminartodo() {
		repoCategorias.deleteAll();
	}
	
	private void  conteo(){
		long count = repoCategorias.count();
		System.out.println(" Hay : " + count + " Categorias");
		
	}
	
	private  void modificar() {
		
		Optional<Categorias> optional  = repoCategorias.findById(2);
		if(optional.isPresent()) {
			Categorias categoriatemp = optional.get();
			categoriatemp.setNombre("Programacion");
			categoriatemp.setDescripcion("Tener una PC en casa");
			repoCategorias.save(categoriatemp);
		  System.out.println(optional.get());
		}
		else 
			System.out.println("Categoria no encontrada");
	}
	
	
	private void buscarporid() {
		
		Optional<Categorias> optional  = repoCategorias.findById(1);
		if(optional.isPresent())
		  System.out.println(optional.get());
		else 
			System.out.println("Categoria no encontrada");
		
	}
	private void guardar() {
		
		Categorias cat =  new Categorias();
		cat.setNombre("Ingenieria de Sistemas");
		cat.setDescripcion("Requisitos");
		repoCategorias.save(cat);
		System.out.println(cat);
		
	}
	
	private void eliminar() {
		int idcategoria = 1;
		repoCategorias.deleteById(idcategoria);
		System.out.println("Registro eliminado");
	}
	
	
	
	private List<Categorias> getListaCategorias(){
		List<Categorias> lista =  new  LinkedList<Categorias>();

		Categorias cat1 = new  Categorias();
		cat1.setNombre("Programador");
		cat1.setDescripcion("Trabajos en plataformas Java y C++");

		Categorias cat2 = new  Categorias();
		cat2.setNombre("Soldador/pintura");
		cat2.setDescripcion("Trabajos en soldadura metalica");

		Categorias cat3 = new  Categorias();
		cat3.setNombre("Ingeniero industrial");
		cat3.setDescripcion("Trabajos relacionados con la Ing Industrial");
		
		
		lista.add(cat1);
		lista.add(cat2);
		lista.add(cat3);
		
		
		
		
		return lista;
		
		
	}
	
	
	private List<Perfil> getPerfilesAplicacion(){
		List<Perfil> lista=new LinkedList<Perfil>();
		Perfil per1 = new Perfil();
		per1.setPerfil("Supervisor");
		
		Perfil per2 = new Perfil();
		per2.setPerfil("Administrador");
		
		Perfil per3 = new Perfil();
		per3.setPerfil("Usuario");
		
		lista.add(per1);
		lista.add(per2);
		lista.add(per3);
		
		return lista;
	}
	
	
	
	
	
	
}
