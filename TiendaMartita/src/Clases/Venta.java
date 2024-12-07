package Clases;

import java.util.Date;

public class Venta {
    private String nroVenta;
    private String codigoClienteVenta;
    private String codigoVendedorVenta;
    private double montoFinalVenta;
    private double descuentoTotalVenta;
    private String metodoPagoVenta;
    private String comprobantePagoVenta;
    private Date fechaVenta;
	public Venta(String nroVenta, String codigoClienteVenta, String codigoVendedorVenta, double montoFinalVenta,
			double descuentoTotalVenta, String metodoPagoVenta, String comprobantePagoVenta, Date fechaVenta) {
		this.nroVenta = nroVenta;
		this.codigoClienteVenta = codigoClienteVenta;
		this.codigoVendedorVenta = codigoVendedorVenta;
		this.montoFinalVenta = montoFinalVenta;
		this.descuentoTotalVenta = descuentoTotalVenta;
		this.metodoPagoVenta = metodoPagoVenta;
		this.comprobantePagoVenta = comprobantePagoVenta;
		this.fechaVenta = fechaVenta;
	}
	public String getNroVenta() {
		return nroVenta;
	}
	public void setNroVenta(String nroVenta) {
		this.nroVenta = nroVenta;
	}
	public String getCodigoClienteVenta() {
		return codigoClienteVenta;
	}
	public void setCodigoClienteVenta(String codigoClienteVenta) {
		this.codigoClienteVenta = codigoClienteVenta;
	}
	public String getCodigoVendedorVenta() {
		return codigoVendedorVenta;
	}
	public void setCodigoVendedorVenta(String codigoVendedorVenta) {
		this.codigoVendedorVenta = codigoVendedorVenta;
	}
	public double getMontoFinalVenta() {
		return montoFinalVenta;
	}
	public void setMontoFinalVenta(double montoFinalVenta) {
		this.montoFinalVenta = montoFinalVenta;
	}
	public double getDescuentoTotalVenta() {
		return descuentoTotalVenta;
	}
	public void setDescuentoTotalVenta(double descuentoTotalVenta) {
		this.descuentoTotalVenta = descuentoTotalVenta;
	}
	public String getMetodoPagoVenta() {
		return metodoPagoVenta;
	}
	public void setMetodoPagoVenta(String metodoPagoVenta) {
		this.metodoPagoVenta = metodoPagoVenta;
	}
	public String getComprobantePagoVenta() {
		return comprobantePagoVenta;
	}
	public void setComprobantePagoVenta(String comprobantePagoVenta) {
		this.comprobantePagoVenta = comprobantePagoVenta;
	}
	public Date getFechaVenta() {
		return fechaVenta;
	}
	public void setFechaVenta(Date fechaVenta) {
		this.fechaVenta = fechaVenta;
	}
    
    
}
