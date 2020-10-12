package dawii.elena.empleoselena.service;

import java.util.LinkedList;
import java.util.List;
import org.springframework.stereotype.Service;

import dawii.elena.empleoselena.model.Categoria;

@Service
public class CategoriasServiceImpl implements ICategoriasService {

	
	List<Categoria> lista;
	  
  	public CategoriasServiceImpl(){
  
		  
		  Categoria cat1=new Categoria(); 
		  cat1.setId(1);
		  cat1.setNombre("Ventas");
		  cat1.setDescripcion("Empresariales");
		  
		  Categoria cat2=new Categoria(); 
		  cat2.setId(2);
		  cat2.setNombre("Contabilidad");
		  cat2.setDescripcion("Libros contables");
		  
		  Categoria cat3=new Categoria(); 
		  cat3.setId(3);
		  cat3.setNombre("Transporte");
		  cat3.setDescripcion("Maquinarias");
		  
		  Categoria cat4=new Categoria(); 
		  cat4.setId(4);
		  cat4.setNombre("Informatica");
		  cat4.setDescripcion("Desarrollo Web");
		  
		  Categoria cat5=new Categoria(); 
		  cat5.setId(5);
		  cat5.setNombre("Construccion");
		  cat5.setDescripcion("Edificios");
		  
		 
		  
		  
		  lista =new LinkedList<>();
		  
		  //agregamos los 5 objetos 
		  lista.add(cat1); 
		  lista.add(cat2); 
		  lista.add(cat3);
		  lista.add(cat4); 
		  lista.add(cat5);
		  
  	}

  	@Override
	public List<Categoria> buscarTodas() {
		// TODO Auto-generated method stub
		return lista;
	}

  	@Override
	public Categoria buscarPorId(Integer idCategoria) {
		// TODO Auto-generated method stub
		for (Categoria  cat : lista)
		{
			if (cat.getId()==idCategoria)
			{
				return cat;
			}
		}
		return null;
	}

  	@Override
	public void guardar(Categoria categoria) {
		// TODO Auto-generated method stub
		lista.add(categoria);
		
	}
  
  
  
  
  
}