package Clases;

public class ProductoVender {
	private Producto producto;
	private int cantidad;
	private double descuento;
	public ProductoVender(Producto producto, int cantidad, double descuento) {
		super();
		this.producto = producto;
		this.cantidad = cantidad;
		this.descuento = descuento;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public double getDescuento() {
		return descuento;
	}
	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}
	public double totalProducto(){
		return cantidad * producto.getPrecio();
	}
}
