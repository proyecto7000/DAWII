package Practica.EmpleosWalter.Servicio;

import java.util.LinkedList;
import java.util.List;
import org.springframework.stereotype.Service;
import Practica.EmpleosWalter.Modelo.Categorias;



@Service
//@Primary
public class CategoriaServiceImpl implements CategoriaService{

	List<Categorias>list;
	  
	public CategoriaServiceImpl() {
		
		Categorias categoria1 = new Categorias();
		categoria1.setId(1);
		categoria1.setNombre("Administracion");
		categoria1.setDescripcion("Gestion");
		
		Categorias categoria2 = new Categorias();
		categoria2.setId(2);
		categoria2.setNombre("Programador");
		categoria2.setDescripcion("Desarrollo de software");
		
		Categorias categoria3 = new Categorias();
		categoria3.setId(3);
		categoria3.setNombre("Contabilidad");
		categoria3.setDescripcion("Contador");
		
		Categorias categoria4 = new Categorias();
		categoria4.setId(4);
		categoria4.setNombre("Ingeniero");
		categoria4.setDescripcion("De construccion civil");

		list = new LinkedList<>();
		
		
		list.add(categoria1);
		list.add(categoria2);
		list.add(categoria3);
		list.add(categoria4);
	}
	
	
	
	@Override
	public void guardar(Categorias categoria) {
		list.add(categoria);
		
	}

	@Override
	public List<Categorias> buscarTodas() {

		return list;
	}

	@Override
	public Categorias buscarPorId(Integer idCategoria) {
		for (Categorias  buscarid : list)
		{
			if (buscarid.getId()==idCategoria)
			{
				return buscarid;
			}
		}
		
		
		
		return null;
	}



	@Override
	public void eliminar(Integer idcategoria) {
		// TODO Auto-generated method stub
		
	}

}
