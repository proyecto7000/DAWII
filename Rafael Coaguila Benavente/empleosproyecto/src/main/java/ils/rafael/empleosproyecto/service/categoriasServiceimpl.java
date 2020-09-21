package ils.rafael.empleosproyecto.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import ils.rafael.empleosproyecto.model.categoria;
import ils.rafael.empleosproyecto.model.vacante;

@Service
public class categoriasServiceimpl implements icategoriasService{

	
	
	
	
	List<categoria>list;
	  
	public categoriasServiceimpl() {
		
		categoria categoria1 = new categoria();
		categoria1.setId(1);
		categoria1.setNombre("maquinaria");
		categoria1.setDescripcion("carga pesada");
		
		categoria categoria2 = new categoria();
		categoria2.setId(2);
		categoria2.setNombre("secretaria");
		categoria2.setDescripcion("trabajo de oficina");
		
		categoria categoria3 = new categoria();
		categoria3.setId(3);
		categoria3.setNombre("contabilidad");
		categoria3.setDescripcion("numero por monton");

		list = new LinkedList<>();
		
		
		list.add(categoria1);
		list.add(categoria2);
		list.add(categoria3);
	}
	
	
	
	
	
	
	
	
	
	
	@Override
	public void guardar(categoria categoria) {
		// TODO Auto-generated method stub
		list.add(categoria);
	}

	@Override
	public List<categoria> buscarTodas() {
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public categoria buscarPorId(Integer idCategoria) {
		// TODO Auto-generated method stub
		for (categoria  buscarid : list)
		{
			if (buscarid.getId()==idCategoria)
			{
				return buscarid;
			}
		}
		
		
		
		return null;
	}

	
	
	
	
	
}
