package Nico.ils.EmpleoNicolas.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;


import org.springframework.stereotype.Service;

import Nico.ils.EmpleoNicolas.model.Vacante;

@Service
public class VacanteServiceImpl implements IVacantesService {
	
	private List<Vacante> lista;
	
	//Los Constructores nunca devuelven un valor solo definen o cargar variables
	//CONSTRUCTOR
	public VacanteServiceImpl () {
		
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
				//OFERTA DE TRABAJO 1
				Vacante vacante1=new Vacante();
				
				
				vacante1.setId(1);
				vacante1.setNombre("Ingeniero Civil");
				vacante1.setDescripcion("Solicitamos Ing Civil para diseñar puente peatonal");
				vacante1.setFecha(new Date());
				vacante1.setSalario(9999.00);
				vacante1.setDestacada(1);
				vacante1.setImagen("img1.png");
				
				
				//OFERTA DE TRABAJO 2
						Vacante vacante2=new Vacante();
						vacante2.setId(2);
						vacante2.setNombre("Contador Publico");
						vacante2.setDescripcion("Empresa importante solicita contador con 5 años de experiencia titulado");
						vacante2.setFecha(new Date());
						vacante2.setSalario(12000.00);
						vacante2.setDestacada(2);
						vacante2.setImagen("img2.png");
				
						
				//OFERTA DE TRABAJO 3
						Vacante vacante3=new Vacante();
						vacante3.setId(3);
						vacante3.setNombre("Ingeniero Electronico");
						vacante3.setDescripcion("Empresa internacional solicita mecanico para mant e inst elèctrica");
						vacante3.setFecha(new Date());
						vacante3.setSalario(10500.00);
						vacante3.setDestacada(1);
						vacante3.setImagen("img3.png");
						
						
				//OFERTA DE TRABAJO 4
						Vacante vacante4=new Vacante();
						vacante4.setId(4);
						vacante4.setNombre("Diseñador Grafico");
						vacante4.setDescripcion("Solicitamos Diseñador Gràfio titulado para diseñar publicidad de la empresa");
						vacante4.setFecha(new Date());
						vacante4.setSalario(7500.00);
						vacante4.setDestacada(4);
						
						
						
						//AGREGAMOS A LA LISTA
						lista= new LinkedList<>();
						
						lista.add(vacante1);
						lista.add(vacante2);
						lista.add(vacante3);
						lista.add(vacante4);
	}	
	
	@Override	
	public List<Vacante> CargaVacantes() {
		// TODO Auto-generated method stub
		
		return lista;
	}

	@Override
	public Vacante buscarVacanteporID(int id) {
		// TODO Auto-generated method stub
		
		for(Vacante tmpVacante : lista) {
			
			if(tmpVacante.getId()==id) 
				return tmpVacante;
		}
		
		return null;
	}
	
	
	
}
