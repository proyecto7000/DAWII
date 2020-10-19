package Anthony.VR46.Practica2.Service;
import java.util.LinkedList;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import Anthony.VR46.Practica2.Model.CATEGORIAS;

@Service
//@Primary
public class CategoriasServiceImpl implements ICategoriasService {

private List<CATEGORIAS> ListaC;
	
	public CategoriasServiceImpl() {
		// TODO Auto-generated constructor stub
	
		
		CATEGORIAS Categoria1 = new CATEGORIAS();
		Categoria1.setId(1);
		Categoria1.setNombre("VENTAS");
		Categoria1.setDescripcion("VENTA GENERAL");
		
		CATEGORIAS Categoria2 = new CATEGORIAS();
		Categoria2.setId(2);
		Categoria2.setNombre("CONTABILIDAD");
		Categoria2.setDescripcion("GENERAL");
		
		CATEGORIAS Categoria3 = new CATEGORIAS();
		Categoria3.setId(3);
		Categoria3.setNombre("TRANSPORTE");
		Categoria3.setDescripcion("INTERPROVINCIAL");
		
		ListaC = new LinkedList<>();
		ListaC.add(Categoria1);
		ListaC.add(Categoria2);
		ListaC.add(Categoria3);
	}
	
	@Override
	public List<CATEGORIAS> cargarcategorias() {
		// TODO Auto-generated method stub
		return ListaC;
	}

	@Override
	public CATEGORIAS buscarPorId(Integer idCategoria) {
		for (CATEGORIAS tmpcategoria : ListaC) {
			if(tmpcategoria.getId()==idCategoria)
				return tmpcategoria;
		}
		return null;
	}

	@Override
	public void guardarcategoria(CATEGORIAS categoria) {
		// TODO Auto-generated method stub
		ListaC.add(categoria);
	}

	@Override
	public void eliminarcat(Integer idCategoria) {
		// TODO Auto-generated method stub
		
	}
}
