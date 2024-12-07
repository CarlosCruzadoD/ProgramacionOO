package Clases;

public class Marca {
	private String nombreMarca;
	private String observacionMarca;
	public Marca(String nombreMarca, String observacionMarca) {
		super();
		this.nombreMarca = nombreMarca;
		this.observacionMarca = observacionMarca;
	}
	public String getNombreMarca() {
		return nombreMarca;
	}
	public void setNombreMarca(String nombreMarca) {
		this.nombreMarca = nombreMarca;
	}
	public String getObservacionMarca() {
		return observacionMarca;
	}
	public void setObservacionMarca(String observacionMarca) {
		this.observacionMarca = observacionMarca;
	}	
}
