package Anthony.VR46.Practica2.Model;

public class CATEGORIAS {
	private Integer IDC;
	private String NombreCat;
	private String DescripcionCat;
	
	//METODOS getter and setter
	
	public Integer getIDC() {
		return IDC;
	}
	public void setIDC(Integer iDC) {
		IDC = iDC;
	}
	public String getNombreCat() {
		return NombreCat;
	}
	public void setNombreCat(String nombreCat) {
		NombreCat = nombreCat;
	}
	public String getDescripcionCat() {
		return DescripcionCat;
	}
	public void setDescripcionCat(String descripcionCat) {
		DescripcionCat = descripcionCat;
	}
	
	//METODO TO STRING
	
	@Override
	public String toString() {
		return "CATEGORIAS [IDC=" + IDC + ", NombreCat=" + NombreCat + ", DescripcionCat=" + DescripcionCat + "]";
	}
	
}
