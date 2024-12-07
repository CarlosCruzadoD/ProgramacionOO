package Clases;

public class Categoria {
	private String nombreCategoria;
	private String observacionCategoria;
	public Categoria(String nombreCategoria, String observacionCategoria) {
		super();
		this.nombreCategoria = nombreCategoria;
		this.observacionCategoria = observacionCategoria;
	}
	public String getNombreCategoria() {
		return nombreCategoria;
	}
	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}
	public String getObservacionCategoria() {
		return observacionCategoria;
	}
	public void setObservacionCategoria(String observacionCategoria) {
		this.observacionCategoria = observacionCategoria;
	}
	
}
