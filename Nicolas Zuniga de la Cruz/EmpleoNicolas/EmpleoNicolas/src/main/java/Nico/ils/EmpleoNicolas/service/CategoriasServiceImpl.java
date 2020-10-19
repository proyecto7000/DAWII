package Nico.ils.EmpleoNicolas.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import Nico.ils.EmpleoNicolas.model.Categoria;


@Service
//@Primary
public class CategoriasServiceImpl implements ICategoriasService {
	
	
	private List<Categoria> lista;
	/*Create Constructor*/
	
	public CategoriasServiceImpl() {
		
		Categoria cat1=new Categoria();
		Categoria cat2=new Categoria();
		Categoria cat3=new Categoria();
		
		/*CATEGORIA 1*/
		cat1.setId(1);
		cat1.setNombre("Recursos Humanos");
		cat1.setDescripcion("Trabajos relacionados con el area de RH.");
		/*CATEGORIA 2*/
		cat2.setId(2);
		cat2.setNombre("Ventas");
		cat2.setDescripcion("Ofertas de trabajo relacionado con ventas.");
		/*CATEGORIA 3*/
		cat3.setId(3);
		cat3.setNombre("Arquitectura");
		cat3.setDescripcion("Diseño de planos en general y trabajos relacionados.");
		
		/*AGREGAMOS A LA LISTA*/
		lista= new LinkedList<>();
		lista.add(cat1);
		lista.add(cat2);
		lista.add(cat3);
		
	}

	@Override
	public List<Categoria> CargaCategorias() {
		// TODO Auto-generated method stub
		return lista;
	}
	

	@Override
	public void guardarCategoria(Categoria categoria) {
		// TODO Auto-generated method stub
		lista.add(categoria);
	}
	
	

	@Override
	public Categoria buscarPorId(Integer idCategoria) {
		// TODO Auto-generated method stub
		for (Categoria  buscarid : lista)
		{
			if (buscarid.getId()==idCategoria)
			{
				return buscarid;
			}
		}	
		return null;
	}
	
	

	@Override
	public void eliminarCategoria(Integer idcategoria) {
		// TODO Auto-generated method stub
		
	}
	



}
