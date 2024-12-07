package Clases;

public class Vendedor extends Trabajador{
	private double comisionVendedor;
	public Vendedor(String codigoTrabajador, String nombreTrabajador, String apellidoTrabajador, String dniTrabajador,
			String generoTrabajador, String correoTrabajador, String celularTrabajador, int edadTrabajador,
			String usuarioTrabajador, String contraseņaTrabajador, int tipoTrabajador, double sueldoTrabajador, 
			double comisionVendedor) {
		super(codigoTrabajador, nombreTrabajador, apellidoTrabajador, dniTrabajador, generoTrabajador, correoTrabajador,
				celularTrabajador, edadTrabajador, usuarioTrabajador, contraseņaTrabajador, tipoTrabajador,
				sueldoTrabajador);
		this.comisionVendedor = comisionVendedor;
	}	
	public Vendedor(String codigoTrabajador, String nombreTrabajador, String apellidoTrabajador, String dniTrabajador,
			String generoTrabajador, String correoTrabajador, String celularTrabajador, int edadTrabajador,
			double sueldoTrabajador, double comisionVendedor) {
		super(codigoTrabajador, nombreTrabajador, apellidoTrabajador, dniTrabajador, generoTrabajador, correoTrabajador,
				celularTrabajador, edadTrabajador, sueldoTrabajador);
		this.comisionVendedor = comisionVendedor;
	}

	public double getComisionVendedor() {
		return comisionVendedor;
	}
	public void setComisionVendedor(double comisionVendedor) {
		this.comisionVendedor = comisionVendedor;
	}
	
}
