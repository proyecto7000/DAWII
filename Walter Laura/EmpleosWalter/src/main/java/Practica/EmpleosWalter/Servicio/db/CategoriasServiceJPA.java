package Practica.EmpleosWalter.Servicio.db;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import Practica.EmpleosWalter.Modelo.Categorias;
import Practica.EmpleosWalter.Repository.CategoriasRepository;
import Practica.EmpleosWalter.Servicio.CategoriaService;

@Service
@Primary
public class CategoriasServiceJPA implements CategoriaService{

	@Autowired
	private CategoriasRepository RepoCategorias;
	
	@Override
	public void guardar(Categorias categoria) {
		RepoCategorias.save(categoria);	
	}

	@Override
	public List<Categorias> buscarTodas() {
		return RepoCategorias.findAll();
	}

	@Override
	public Categorias buscarPorId(Integer idCategoria) {
		Optional<Categorias> optional = RepoCategorias.findById(idCategoria);
		
		if(optional.isPresent()) {
			return optional.get();
		}
		
		return null;
	}

	@Override
	public void eliminar(Integer idcategoria) {
		RepoCategorias.deleteById(idcategoria);
		
	}

}
