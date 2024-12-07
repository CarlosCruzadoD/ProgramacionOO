package Clases;

public class Producto {
	private String codigoProducto;
	private String IDMarca;
	private String IDCategoria;
	private String IDProovedor;
	private int Stock;
	private double Precio;
	private String talla;
	private String color;
	public Producto(String codigoProducto, String iDMarca, String iDCategoria, int stock, double precio, String talla,
			String color) {
		super();
		this.codigoProducto = codigoProducto;
		IDMarca = iDMarca;
		IDCategoria = iDCategoria;
		Stock = stock;
		Precio = precio;
		this.talla = talla;
		this.color = color;
	}	
	public Producto(String codigoProducto, String iDMarca, String iDCategoria, String iDProovedor, int stock,
			double precio, String talla, String color) {
		super();
		this.codigoProducto = codigoProducto;
		IDMarca = iDMarca;
		IDCategoria = iDCategoria;
		IDProovedor = iDProovedor;
		Stock = stock;
		Precio = precio;
		this.talla = talla;
		this.color = color;
	}
	public String getIDProovedor() {
		return IDProovedor;
	}
	public void setIDProovedor(String iDProovedor) {
		IDProovedor = iDProovedor;
	}
	public String getCodigoProducto() {
		return codigoProducto;
	}
	public void setCodigoProducto(String codigoProducto) {
		this.codigoProducto = codigoProducto;
	}
	public String getIDMarca() {
		return IDMarca;
	}
	public void setIDMarca(String iDMarca) {
		IDMarca = iDMarca;
	}
	public String getIDCategoria() {
		return IDCategoria;
	}
	public void setIDCategoria(String iDCategoria) {
		IDCategoria = iDCategoria;
	}
	public int getStock() {
		return Stock;
	}
	public void setStock(int stock) {
		Stock = stock;
	}
	public double getPrecio() {
		return Precio;
	}
	public void setPrecio(double precio) {
		Precio = precio;
	}
	public String getTalla() {
		return talla;
	}
	public void setTalla(String talla) {
		this.talla = talla;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
}
