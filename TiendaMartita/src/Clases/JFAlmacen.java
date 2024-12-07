package Clases;

public class JFAlmacen extends Trabajador{
	private String areaJFALmacen;
	public JFAlmacen(String codigoTrabajador, String nombreTrabajador, String apellidoTrabajador, String dniTrabajador,
			String generoTrabajador, String correoTrabajador, String celularTrabajador, int edadTrabajador,
			String usuarioTrabajador, String contraseņaTrabajador, int tipoTrabajador, double sueldoTrabajador,
			String areaJFALmacen) {
		super(codigoTrabajador, nombreTrabajador, apellidoTrabajador, dniTrabajador, generoTrabajador, correoTrabajador,
				celularTrabajador, edadTrabajador, usuarioTrabajador, contraseņaTrabajador, tipoTrabajador,
				sueldoTrabajador);
		this.areaJFALmacen = areaJFALmacen;
	}
	
	public JFAlmacen(String codigoTrabajador, String nombreTrabajador, String apellidoTrabajador, String dniTrabajador,
			String generoTrabajador, String correoTrabajador, String celularTrabajador, int edadTrabajador,
			double sueldoTrabajador, String areaJFALmacen) {
		super(codigoTrabajador, nombreTrabajador, apellidoTrabajador, dniTrabajador, generoTrabajador, correoTrabajador,
				celularTrabajador, edadTrabajador, sueldoTrabajador);
		this.areaJFALmacen = areaJFALmacen;
	}

	public String getAreaJFALmacen() {
		return areaJFALmacen;
	}
	public void setAreaJFALmacen(String areaJFALmacen) {
		this.areaJFALmacen = areaJFALmacen;
	}
	
}
