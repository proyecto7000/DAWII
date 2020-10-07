package DAWII.ILS.JPAAnthony;

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

import DAWII.ILS.JPAAnthony.Model.CATEGORIAS;
import DAWII.ILS.JPAAnthony.Model.VACANTE;
import DAWII.ILS.JPAAnthony.REPOSITORIO.CATEGORIASRepositorio;
import DAWII.ILS.JPAAnthony.REPOSITORIO.VACANTESRepositorio;

@SpringBootApplication
public class JpaAnthonyApplication implements CommandLineRunner {

	@Autowired
	private CATEGORIASRepositorio repocategorias;
	
	@Autowired
	private VACANTESRepositorio repovacantes;
	
	public static void main(String[] args) {
		SpringApplication.run(JpaAnthonyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		guardarvacante();
	}
	
	private void guardarvacante()
	{
		VACANTE vac = new VACANTE();
		vac.setNombre("PROFESOR MATEMATICO");
		vac.setDescripcion("Trabajos relacionados con EDUCACION");
		vac.setFecha(new Date());
		vac.setSalario(433.0);
		vac.setEstatus("Aprobada");
		vac.setDestacado(0);
		vac.setImagen("escuela.png");
		vac.setdetalles("<h1>los requisitos</h1>");
		CATEGORIAS cat = new CATEGORIAS();
		cat.setId(15);
		vac.setCategoria(cat);
		repovacantes.save(vac);
		System.out.println(vac);
	}
	
	private void buscarvacantes()
	{
		List<VACANTE> lista = repovacantes.findAll();
		for(VACANTE v : lista)
		{
			System.out.println(v.getID() + " :NOMBRE: " + v.getNombre() + " :CATEGORIA: " + v.getCategoria().getNombre());
		}
	}
	
	
	
	//METODO CREATE
	private void guardar()
	{
		CATEGORIAS cat = new CATEGORIAS();
		cat.setNombre("FINANZAS");
		cat.setDescripcion("Trabajos relacionados con Finanzas y Contabilidad");
		repocategorias.save(cat);
		System.out.println(cat);
	}
	//METODO BUSCAR
	private void buscarPorID()
	{
		Optional<CATEGORIAS> optional = repocategorias.findById(1);
		if (optional.isPresent()) 
		{
			System.out.println(optional.get());
		}
		else
		{
			System.out.println("CATEGORIA NO ENCONTRADA");
		}
	}
	//METODOMODIFICAR
	private void modificar()
	{
		Optional<CATEGORIAS> optional = repocategorias.findById(1);
		if (optional.isPresent()) 
		{
			CATEGORIAS catTmp = optional.get();
			catTmp.setNombre("FINANZAS NUEVA");
			catTmp.setDescripcion("DESCRIPCION NUEVA");
			repocategorias.save(catTmp);
			System.out.println("MODIFICADA CON EXITO: " + optional.get());
		}else
		{
			System.out.println("CATEGORIA NO ENCONTRADA");
		}
	}
	//METODO ELIMINAR
	private void eliminar()
	{
		int idcategoria = 2;
		repocategorias.deleteById(idcategoria);
	}
	//METODO DE CONTAR
	private void contar()
	{
		long count = repocategorias.count();
		System.out.println("TOTAL DE CATEGORIAS: " + count);
	}
	//METODO ELIMINAR TODO
	private void eliminartodo()
	{
		repocategorias.deleteAll();
	}
	//METODO ENCONTRAR POR IDS
	private void encontrarporIDs()
	{
		List<Integer> ids = new LinkedList<Integer>();
		ids.add(1);
		ids.add(4);
		ids.add(6);
		Iterable<CATEGORIAS> categorias = repocategorias.findAllById(ids);
		for (CATEGORIAS cat : categorias)
			{
				System.out.println(cat);
			}
	}
	//METODO EXISTE id
	private void existeID()
	{
		boolean existe = repocategorias.existsById(50);
		System.out.println("LA CATEGORIA EXISTE " + existe);
	}	
	//METODO BUSCAR TODO
	private void buscartodos()
	{
		Iterable<CATEGORIAS> categorias =  repocategorias.findAll();
		for(CATEGORIAS cat : categorias)
		{
			System.out.println(cat);
		}
	}
	
	private List<CATEGORIAS> getListaCategorias()
	{
		List<CATEGORIAS> lista = new LinkedList<CATEGORIAS>();
		
		CATEGORIAS cat1 = new CATEGORIAS();
		cat1.setNombre("programador de blockchain");
		cat1.setDescripcion("Trabajos relacionados con bitcoin");
		
		CATEGORIAS cat2 = new CATEGORIAS();
		cat2.setNombre("SOLDADURA/PINTURA");
		cat2.setDescripcion("Trabajos relacionados con soldadura pintura y enderezado");
		
		CATEGORIAS cat3 = new CATEGORIAS();
		cat3.setNombre("INGENIERO INDUSTRIAL");
		cat3.setDescripcion("Trabajos relacionados con ingenieria industrial");
		
		lista.add(cat1);
		lista.add(cat2);
		lista.add(cat3);
		return lista;
	}
	private void guardartodas()
	{
		List<CATEGORIAS> categorias = getListaCategorias();
		repocategorias.saveAll(categorias);
	}
	
	private void borrarbloque()
	{
		repocategorias.deleteAllInBatch();
	}
	
	private void buscartodosjpa()
	{
		List<CATEGORIAS> categorias = repocategorias.findAll();
		for(CATEGORIAS c : categorias)
		{
			System.out.println(c.getId() + " " + c.getNombre());
		}
	}

	private void buscartodosordenado()
	{
		List<CATEGORIAS> categorias = repocategorias.findAll(Sort.by("nombre"));
		for(CATEGORIAS c : categorias)
		{
			System.out.println(c.getId() + " " + c.getNombre());
		}
	}
	
	private void buscartodospaginacion()
	{
		Page<CATEGORIAS> page = repocategorias.findAll(PageRequest.of(1, 5, Sort.by("nombre")));
		System.out.println("TOTAL REGISTROS: " + page.getTotalElements());
		System.out.println("TOTAL PAGINAS: " + page.getTotalPages());
		for(CATEGORIAS c : page.getContent())
		{
			System.out.println(c.getId() + " " + c.getNombre());
		}
	}
}
