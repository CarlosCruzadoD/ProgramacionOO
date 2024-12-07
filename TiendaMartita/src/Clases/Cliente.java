package Clases;

public class Cliente {
	private String codigoCliente;
	private String nombreCliente;
	private String apellidoCliente;
	private String dniCliente;
	private String generoCliente;
	private String correoCliente;
	private String celularCliente;
	private int edadCliente;
	public Cliente(String codigoCliente, String nombreCliente, String apellidoCliente, String dniCliente,
			String generoCliente, String correoCliente, String celularCliente, int edadCliente) {
		super();
		this.codigoCliente = codigoCliente;
		this.nombreCliente = nombreCliente;
		this.apellidoCliente = apellidoCliente;
		this.dniCliente = dniCliente;
		this.generoCliente = generoCliente;
		this.correoCliente = correoCliente;
		this.celularCliente = celularCliente;
		this.edadCliente = edadCliente;
	}	
	public Cliente(String codigoCliente, String nombreCliente, String apellidoCliente) {
		super();
		this.codigoCliente = codigoCliente;
		this.nombreCliente = nombreCliente;
		this.apellidoCliente = apellidoCliente;
	}

	public String getCodigoCliente() {
		return codigoCliente;
	}
	public void setCodigoCliente(String codigoCliente) {
		this.codigoCliente = codigoCliente;
	}
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	public String getApellidoCliente() {
		return apellidoCliente;
	}
	public void setApellidoCliente(String apellidoCliente) {
		this.apellidoCliente = apellidoCliente;
	}
	public String getDniCliente() {
		return dniCliente;
	}
	public void setDniCliente(String dniCliente) {
		this.dniCliente = dniCliente;
	}
	public String getGeneroCliente() {
		return generoCliente;
	}
	public void setGeneroCliente(String generoCliente) {
		this.generoCliente = generoCliente;
	}
	public String getCorreoCliente() {
		return correoCliente;
	}
	public void setCorreoCliente(String correoCliente) {
		this.correoCliente = correoCliente;
	}
	public String getCelularCliente() {
		return celularCliente;
	}
	public void setCelularCliente(String celularCliente) {
		this.celularCliente = celularCliente;
	}
	public int getEdadCliente() {
		return edadCliente;
	}
	public void setEdadCliente(int edadCliente) {
		this.edadCliente = edadCliente;
	}
	
}
