package Clases;

public class Proveedor {
	private String nombreProveedor;
	private String observacionProveedor;
	public Proveedor(String nombreProveedor, String observacionProveedor) {
		this.nombreProveedor = nombreProveedor;
		this.observacionProveedor = observacionProveedor;
	}
	public String getNombreProveedor() {
		return nombreProveedor;
	}
	public void setNombreProveedor(String nombreProveedor) {
		this.nombreProveedor = nombreProveedor;
	}
	public String getObservacionProveedor() {
		return observacionProveedor;
	}
	public void setObservacionProveedor(String observacionProveedor) {
		this.observacionProveedor = observacionProveedor;
	}	
}
