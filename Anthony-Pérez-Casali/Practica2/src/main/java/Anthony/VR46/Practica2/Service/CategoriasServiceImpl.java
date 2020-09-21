package Anthony.VR46.Practica2.Service;
import java.util.LinkedList;
import java.util.List;
import org.springframework.stereotype.Service;
import Anthony.VR46.Practica2.Model.CATEGORIAS;

@Service
public class CategoriasServiceImpl implements ICategoriasService {

private List<CATEGORIAS> ListaC;
	
	public CategoriasServiceImpl() {
		// TODO Auto-generated constructor stub
	
		
		CATEGORIAS Categoria1 = new CATEGORIAS();
		Categoria1.setIDC(1);
		Categoria1.setNombreCat("VENTAS");
		Categoria1.setDescripcionCat("VENTA GENERAL");
		
		CATEGORIAS Categoria2 = new CATEGORIAS();
		Categoria2.setIDC(2);
		Categoria2.setNombreCat("CONTABILIDAD");
		Categoria2.setDescripcionCat("GENERAL");
		
		CATEGORIAS Categoria3 = new CATEGORIAS();
		Categoria3.setIDC(3);
		Categoria3.setNombreCat("TRANSPORTE");
		Categoria3.setDescripcionCat("INTERPROVINCIAL");
		
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
			if(tmpcategoria.getIDC()==idCategoria)
				return tmpcategoria;
		}
		return null;
	}

	@Override
	public void guardarcategoria(CATEGORIAS categoria) {
		// TODO Auto-generated method stub
		ListaC.add(categoria);
	}
}
