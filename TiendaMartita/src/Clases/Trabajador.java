package Clases;

public class Trabajador {
    protected String codigoTrabajador;
    protected String nombreTrabajador;
    protected String apellidoTrabajador;
    protected String dniTrabajador;
    protected String generoTrabajador;
    protected String correoTrabajador;
    protected String celularTrabajador;
    protected int edadTrabajador;
    protected String usuarioTrabajador;
    protected String contraseñaTrabajador;
    protected int tipoTrabajador;
    protected double sueldoTrabajador;
	public Trabajador(String codigoTrabajador, String nombreTrabajador, String apellidoTrabajador, String dniTrabajador,
			String generoTrabajador, String correoTrabajador, String celularTrabajador, int edadTrabajador,
			String usuarioTrabajador, String contraseñaTrabajador, int tipoTrabajador, double sueldoTrabajador) {
		super();
		this.codigoTrabajador = codigoTrabajador;
		this.nombreTrabajador = nombreTrabajador;
		this.apellidoTrabajador = apellidoTrabajador;
		this.dniTrabajador = dniTrabajador;
		this.generoTrabajador = generoTrabajador;
		this.correoTrabajador = correoTrabajador;
		this.celularTrabajador = celularTrabajador;
		this.edadTrabajador = edadTrabajador;
		this.usuarioTrabajador = usuarioTrabajador;
		this.contraseñaTrabajador = contraseñaTrabajador;
		this.tipoTrabajador = tipoTrabajador;
		this.sueldoTrabajador = sueldoTrabajador;
	}
	
	public Trabajador(String codigoTrabajador, String nombreTrabajador, String apellidoTrabajador, String dniTrabajador,
			String generoTrabajador, String correoTrabajador, String celularTrabajador, int edadTrabajador,
			double sueldoTrabajador) {
		super();
		this.codigoTrabajador = codigoTrabajador;
		this.nombreTrabajador = nombreTrabajador;
		this.apellidoTrabajador = apellidoTrabajador;
		this.dniTrabajador = dniTrabajador;
		this.generoTrabajador = generoTrabajador;
		this.correoTrabajador = correoTrabajador;
		this.celularTrabajador = celularTrabajador;
		this.edadTrabajador = edadTrabajador;
		this.sueldoTrabajador = sueldoTrabajador;
	}

	public String getCodigoTrabajador() {
		return codigoTrabajador;
	}
	public void setCodigoTrabajador(String codigoTrabajador) {
		this.codigoTrabajador = codigoTrabajador;
	}
	public String getNombreTrabajador() {
		return nombreTrabajador;
	}
	public void setNombreTrabajador(String nombreTrabajador) {
		this.nombreTrabajador = nombreTrabajador;
	}
	public String getApellidoTrabajador() {
		return apellidoTrabajador;
	}
	public void setApellidoTrabajador(String apellidoTrabajador) {
		this.apellidoTrabajador = apellidoTrabajador;
	}
	public String getDniTrabajador() {
		return dniTrabajador;
	}
	public void setDniTrabajador(String dniTrabajador) {
		this.dniTrabajador = dniTrabajador;
	}
	public String getGeneroTrabajador() {
		return generoTrabajador;
	}
	public void setGeneroTrabajador(String generoTrabajador) {
		this.generoTrabajador = generoTrabajador;
	}
	public String getCorreoTrabajador() {
		return correoTrabajador;
	}
	public void setCorreoTrabajador(String correoTrabajador) {
		this.correoTrabajador = correoTrabajador;
	}
	public String getCelularTrabajador() {
		return celularTrabajador;
	}
	public void setCelularTrabajador(String celularTrabajador) {
		this.celularTrabajador = celularTrabajador;
	}
	public int getEdadTrabajador() {
		return edadTrabajador;
	}
	public void setEdadTrabajador(int edadTrabajador) {
		this.edadTrabajador = edadTrabajador;
	}
	public String getUsuarioTrabajador() {
		return usuarioTrabajador;
	}
	public void setUsuarioTrabajador(String usuarioTrabajador) {
		this.usuarioTrabajador = usuarioTrabajador;
	}
	public String getContraseñaTrabajador() {
		return contraseñaTrabajador;
	}
	public void setContraseñaTrabajador(String contraseñaTrabajador) {
		this.contraseñaTrabajador = contraseñaTrabajador;
	}
	public int getTipoTrabajador() {
		return tipoTrabajador;
	}
	public void setTipoTrabajador(int tipoTrabajador) {
		this.tipoTrabajador = tipoTrabajador;
	}
	public double getSueldoTrabajador() {
		return sueldoTrabajador;
	}
	public void setSueldoTrabajador(double sueldoTrabajador) {
		this.sueldoTrabajador = sueldoTrabajador;
	}
    public String getNombreCompleto(){
    	return nombreTrabajador + " " + apellidoTrabajador;
    }
}
