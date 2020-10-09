package ils.empleos.jpaCarolina;

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

import ils.empleos.jpaCarolina.model.Categoria;
import ils.empleos.jpaCarolina.model.Perfil;
import ils.empleos.jpaCarolina.model.Usuario;
import ils.empleos.jpaCarolina.model.Vacante;
import ils.empleos.jpaCarolina.repository.CategoriasRepository;
import ils.empleos.jpaCarolina.repository.PerfilesRepository;
import ils.empleos.jpaCarolina.repository.UsuariosRepository;
import ils.empleos.jpaCarolina.repository.VacantesRepository;

@SpringBootApplication
public class JpaCarolinaApplication implements CommandLineRunner{

	@Autowired
	private CategoriasRepository repoCategorias;
	
	@Autowired
	private VacantesRepository repoVacantes;
	
	@Autowired
	private UsuariosRepository repoUsuarios;
	
	@Autowired
	private PerfilesRepository repoPerfiles;
	
	
	

	
	public static void main(String[] args) {
		SpringApplication.run(JpaCarolinaApplication.class, args);
	}

	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		tarea2();
	}
	
	
	
	
	public void tarea1() {
		List<Vacante> lista = repoVacantes.findBySalarioGreaterThanEqual(3500);
		System.out.println("Registros encontrados: " + lista.size());
		for (Vacante v : lista) {
			System.out.println(v.getId() + ": " + v.getNombre() + ": s/." + v.getSalario());
		}
	}
	
	public void tarea2() {
		List<Vacante> lista = repoVacantes.findTop7ByOrderByIdAsc();
		System.out.println("Registros encontrados: " + lista.size());
		for (Vacante v : lista) {
			System.out.println(v.getId() + ": " + v.getNombre());
		}
	}
	
	
	
	
	private void buscarVacantesVariosEstatus() {
		String[] estatus = new String[] {"Eliminada", "Aprobada"};
		List<Vacante> lista = repoVacantes.findByEstatusIn(estatus);
		for(Vacante v : lista) {
			System.out.println(v.getId() + ": " + v.getNombre() + ": " + v.getEstatus());
		}
	}
	
	
	private void buscarVacantesSalario() {
		List<Vacante> lista = repoVacantes.findBySalarioBetweenOrderBySalarioDesc(7000, 14000);
		System.out.println("Registros encontrados: " + lista.size());
		for (Vacante v : lista) {
			System.out.println(v.getId() + ": " + v.getNombre() + ": s/." + v.getSalario());
		}
	}
	
	
	private void buscarVacantesPorDestacadoEstatus() {
		List<Vacante> lista = repoVacantes.findByDestacadoAndEstatusOrderByIdDesc(1, "Aprobada");
		System.out.println("Registros encontrados: " + lista.size());
		for (Vacante v : lista) {
			System.out.println(v.getId() + ": " + v.getNombre() + ": " + v.getEstatus() + ": " + v.getDestacado());
		}
	}

	
	private void buscarVacantesPorEstatus() {
		List<Vacante> lista = repoVacantes.findByEstatus("Aprobada");
		System.out.println("Registros encontrados: " + lista.size());
		for (Vacante v : lista) {
			System.out.println(v.getId() + ": " + v.getNombre() + ": " + v.getEstatus());
		}
	}
	
	
	
	
	
	//METODO PARA CREAR PERFILES / ROLES
	private void crearPerfilesAplicacion() {
		repoPerfiles.saveAll(getPerfilesAplicacion());
	}
	
	
	public void buscarUsuario() {
		Optional<Usuario> optional = repoUsuarios.findById(1);
		if(optional.isPresent()) {
			Usuario u= optional.get();
			System.out.println("Usuario: " + u.getNombre());
			System.out.println("Perfiles asignados");
			for(Perfil p : u.getPerfiles()) {
				System.out.println(p.getPerfil());
			}
		}else {
			System.out.println("Usuario no encontrado");
		}
	}
	
	private void crearUsuarioConDosPerfiles() {
		Usuario user = new Usuario();
		user.setNombre("Ivan Tinajero");
		user.setEmail("ivanetinajero@gmail.com");
		user.setFechaRegistro(new Date());
		user.setUsername("itinajero");
		user.setPassword("12345");
		user.setEstatus(1);
		
		Perfil per1 = new Perfil();
		per1.setId(2);
		
		Perfil per2 = new Perfil();
		per2.setId(3);
		
		user.agregar(per1);
		user.agregar(per2);
		
		repoUsuarios.save(user);
	}
	
	
	
	
	
	private void guardarVacante() {
		Vacante vacante = new Vacante();
		vacante.setNombre("Profesor de matemáticas");
		vacante.setDescripcion("Escuela primaria solicita profesor para curso de matemáicas");
		vacante.setFecha(new Date());
		vacante.setSalario(8500.0);
		vacante.setEstatus("Aprobada");
		vacante.setDestacado(0);
		vacante.setImagen("escuela.png");
		vacante.setDetalles("<h1>Los requisitos para profesor de Matematicas</h1>");
		Categoria cat = new Categoria();
		cat.setId(15);
		vacante.setCategoria(cat);
		repoVacantes.save(vacante);
	}
	
	
	
	private void buscarTodas() {
		List<Vacante> lista = repoVacantes.findAll();
		for(Vacante v : lista) {
			System.out.println(v.getId() + " " + v.getNombre() + "-> " + v.getCategoria().getNombre());
		}
			
		
	}
	
	private void buscarTodosPaginacion() {
		Page<Categoria> page = repoCategorias.findAll(PageRequest.of(0, 5, Sort.by("nombre").descending()));
		System.out.println("Total Registros: " + page.getTotalElements());
		System.out.println("Total Paginas: " + page.getTotalPages());
		for(Categoria c : page.getContent()) {
			System.out.println(c.getId() + " " + c.getNombre());
		}
	}
	
	
	
	private void buscarTodosOrdenados() {
		List<Categoria> categorias = repoCategorias.findAll(Sort.by("nombre").descending());
		for(Categoria c : categorias) {
			System.out.println(c.getId() + " " + c.getNombre());
		}
	}
	

	 private void borrarTodoEnBloque() { 
		 repoCategorias.deleteAllInBatch(); 
	 }

	
	
	private void buscarTodosJpa() {
		List<Categoria> categorias = repoCategorias.findAll();
		for(Categoria c : categorias) {
			System.out.println(c.getId() + " " + c.getNombre());
		}
	}
 
	private void guardar() {
		// TODO Auto-generated method stub
		Categoria cat=new Categoria();
		cat.setNombre("Finanzas");
		cat.setDescripcion("Trabajos relacionados con finanzas y contabilidad");
		repoCategorias.save(cat);
		System.out.println(cat);
	}
	
	 
	private void buscarPorId(){
		Optional<Categoria> optional = repoCategorias.findById(1);
		if(optional.isPresent()){
		System.out.println(optional.get());
		}else
		System.out.println("Categoria no encontrada");
	}


	private void modificar(){
		Optional<Categoria> optional = repoCategorias.findById(2);
		if(optional.isPresent()){
		Categoria catTmp = optional.get();
		catTmp.setNombre("Ing. de software");
		catTmp.setDescripcion("Desarrollo de sistemas");
		repoCategorias.save(catTmp);
		System.out.println(optional.get());
		}else
		System.out.println("Categoria no encontrada");	
	}


	private void eliminar(){
		int idCategoria = 1;
		repoCategorias.deleteById(idCategoria);
	}


	private void conteo(){
		long count=repoCategorias.count();
		System.out.println("Total de Categorías: " + count);
	}
	
	private void eliminarTodos() {
		repoCategorias.deleteAll();
	}
	
	
	
	//insertar categorias.sql
	
	private void encontrarPorIds() {
		List<Integer> ids=new LinkedList<Integer>();
		ids.add(1);
		ids.add(4);
		ids.add(10);
		Iterable<Categoria> categorias = repoCategorias.findAllById(ids);
		for(Categoria cat : categorias) {
			System.out.println(cat);
		}
		
	}

	private void buscarTodos() {
		Iterable<Categoria> categorias = repoCategorias.findAll();
		for (Categoria cat : categorias) {
			System.out.println(cat);
		}
	}
	
	
	private void existeId() {
		boolean existe = repoCategorias.existsById(16);
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
		repoCategorias.saveAll(categorias);
	}
	
	
	
	private List<Perfil> getPerfilesAplicacion(){
		List<Perfil> lista = new LinkedList<Perfil>();
		
		Perfil per1 = new Perfil();
		per1.setPerfil("SUPERVISOR");
		
		Perfil per2 = new Perfil();
		per2.setPerfil("ADMINISTRADOR");
		
		Perfil per3 = new Perfil();
		per3.setPerfil("USUARIO");
		
		lista.add(per1);
		lista.add(per2);
		lista.add(per3);
		
		return lista;
		
		
	}
	
	

}
