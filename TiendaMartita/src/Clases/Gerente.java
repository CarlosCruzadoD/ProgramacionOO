package Clases;

public class Gerente extends Trabajador {
	private String areaGerente;
	public Gerente(String codigoTrabajador, String nombreTrabajador, String apellidoTrabajador, String dniTrabajador,
			String generoTrabajador, String correoTrabajador, String celularTrabajador, int edadTrabajador,
			String usuarioTrabajador, String contraseñaTrabajador, int tipoTrabajador, double sueldoTrabajador,
			String areaGerente) {
		super(codigoTrabajador, nombreTrabajador, apellidoTrabajador, dniTrabajador, generoTrabajador, correoTrabajador,
				celularTrabajador, edadTrabajador, usuarioTrabajador, contraseñaTrabajador, tipoTrabajador,
				sueldoTrabajador);
		this.areaGerente = areaGerente;
	}
	
	public Gerente(String codigoTrabajador, String nombreTrabajador, String apellidoTrabajador, String dniTrabajador,
			String generoTrabajador, String correoTrabajador, String celularTrabajador, int edadTrabajador,
			double sueldoTrabajador, String areaGerente) {
		super(codigoTrabajador, nombreTrabajador, apellidoTrabajador, dniTrabajador, generoTrabajador, correoTrabajador,
				celularTrabajador, edadTrabajador, sueldoTrabajador);
		this.areaGerente = areaGerente;
	}
	public String getArea() {
		return areaGerente;
	}
	public void setArea(String areaGerente) {
		this.areaGerente = areaGerente;
	}
	
}
