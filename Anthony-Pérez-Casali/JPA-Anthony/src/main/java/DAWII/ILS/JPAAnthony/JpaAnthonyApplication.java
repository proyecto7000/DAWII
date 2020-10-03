package DAWII.ILS.JPAAnthony;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

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
		guardartodas();
	}
	//METODO CREATE
	private void guardar()
	{
		CATEGORIAS cat = new CATEGORIAS();
		cat.setNombre("FINANZAS");
		cat.setDescripcion("Trabajos relacionados con Finanzas y Contabilidad");
		repo.save(cat);
		System.out.println(cat);
	}
	//METODO BUSCAR
	private void buscarPorID()
	{
		Optional<CATEGORIAS> optional = repo.findById(1);
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
		Optional<CATEGORIAS> optional = repo.findById(1);
		if (optional.isPresent()) 
		{
			CATEGORIAS catTmp = optional.get();
			catTmp.setNombre("FINANZAS NUEVA");
			catTmp.setDescripcion("DESCRIPCION NUEVA");
			repo.save(catTmp);
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
		repo.deleteById(idcategoria);
	}
	//METODO DE CONTAR
	private void contar()
	{
		long count = repo.count();
		System.out.println("TOTAL DE CATEGORIAS: " + count);
	}
	//METODO ELIMINAR TODO
	private void eliminartodo()
	{
		repo.deleteAll();
	}
	//METODO ENCONTRAR POR IDS
	private void encontrarporIDs()
	{
		List<Integer> ids = new LinkedList<Integer>();
		ids.add(1);
		ids.add(4);
		ids.add(6);
		Iterable<CATEGORIAS> categorias = repo.findAllById(ids);
		for (CATEGORIAS cat : categorias)
			{
				System.out.println(cat);
			}
	}
	//METODO EXISTE id
	private void existeID()
	{
		boolean existe = repo.existsById(50);
		System.out.println("LA CATEGORIA EXISTE " + existe);
	}	
	//METODO BUSCAR TODO
	private void buscartodos()
	{
		Iterable<CATEGORIAS> categorias =  repo.findAll();
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
		repo.saveAll(categorias);
	}
}
