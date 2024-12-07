package Controladores;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Clases.ProductoVender;
import Clases.Venta;
import Conexion.ConexionBD;

public class VentaBD {
	//------------------------------------------------------------------
	//INSERTAR VENTA A LA BD
	//------------------------------------------------------------------
	
	//************************************
	//Insertar dentro de la tabla Venta
	//************************************
	private void insertarBDVenta(Venta v){
		Connection sql = ConexionBD.getConexion();
		String nroVenta = v.getNroVenta();
		String coCliente = v.getCodigoClienteVenta();
		String coVendedor = v.getCodigoVendedorVenta();
		double monto = v.getMontoFinalVenta();
		double descuento = v.getDescuentoTotalVenta();
		String metodoPago = v.getMetodoPagoVenta();
		String comprobantePago = v.getComprobantePagoVenta();
		String fecha = v.getFechaVenta().toString();
		
		String query = 
				"INSERT INTO Venta "
				+ "(nroVenta, codigoCliente, codigoVendedor, v_montoFinal, v_descuentoTotal, "
				+ "v_metodoPago, v_comprobantePago, v_fechaVenta) "
				+ "VALUES (?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement stmt = sql.prepareStatement(query);
			stmt.setString(1, nroVenta);
			stmt.setString(2, coCliente);
			stmt.setString(3, coVendedor);
			stmt.setDouble(4, monto);
			stmt.setDouble(5, descuento);
			stmt.setString(6, metodoPago);
			stmt.setString(7, comprobantePago);
			stmt.setString(8, fecha);
			stmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.print(" Error: " + e + "\n");
		}
		ConexionBD.closeConexion();
	}
	
	//************************************
	//Insertar dentro de la tabla DTVenta (Todos los productos de la venta)
	//************************************
	private void insertarBDVentaProducto(Venta v, ArrayList<ProductoVender> pro){
		Connection sql = ConexionBD.getConexion();
		String nroVenta = v.getNroVenta();
		for (ProductoVender p: pro) {
			String cod = p.getProducto().getCodigoProducto();
			int cantidad = p.getCantidad();
			double total = p.totalProducto();
			double descuento = p.getDescuento();
			String query = 
					"INSERT INTO DTVenta "
					+ "(nroVenta, codigoProducto, dtv_cantidad, dtv_total, dtv_descuento) "
					+ "VALUES (?,?,?,?,?)";
			try {
				PreparedStatement stmt = sql.prepareStatement(query);
				stmt.setString(1, nroVenta);
				stmt.setString(2, cod);
				stmt.setInt(3, cantidad);
				stmt.setDouble(4, total);
				stmt.setDouble(5, descuento);
				stmt.executeUpdate();				
			} catch (Exception e) {
				System.out.print(" DTVenta Error: " + e + "\n");
			}	
		}
		ConexionBD.closeConexion();
	}
	
	private int verificarStock(String codigoProducto, int cantidad){
		Connection sql = ConexionBD.getConexion();
		int status = 1;
		try {
			int stockActual = 0;
			String queryStock = "SELECT p_stock FROM Producto WHERE codigoProducto = '"+codigoProducto+"'";
			Statement stmt = sql.createStatement();
			ResultSet rs = stmt.executeQuery(queryStock);
			while(rs.next()){
				stockActual = rs.getInt("p_stock");
			}
			int stockNuevo = stockActual - cantidad;
			if(stockNuevo < 0) status = -1;
		} catch (Exception e) {
			System.out.print(" Error: " + e + "\n");
		}
		return status;
	}
	
	private void actualizarStock(String codigoProducto, int cantidad){
		Connection sql = ConexionBD.getConexion();
		try {
			int stockActual = 0;
			String queryStock = "SELECT p_stock FROM Producto WHERE codigoProducto = '"+codigoProducto+"'";
			Statement stmt = sql.createStatement();
			ResultSet rs = stmt.executeQuery(queryStock);
			while(rs.next()){
				stockActual = rs.getInt("p_stock");
			}
			int stockNuevo = stockActual - cantidad;
			String queryUpdate = "UPDATE Producto set p_stock = " + stockNuevo + " "
					+ "WHERE codigoProducto = '"+codigoProducto+"'";
			Statement stmtUP = sql.createStatement();
			stmt.executeUpdate(queryUpdate);
		} catch (Exception e) {
			System.out.print(" Error: " + e + "\n");
		}
	}
	/* ************************************
	 * 
	 * Insertar dentro de la tabla DTRealiza (Venta de cada vendedor)
	 * ESTA FUNCION SE LLAMARA PARA REALIZAR LAS VENTAS GENERALES
	 * DEBIDO A QUE YA CONTIENE LAS OTRAS DOS FUNCIONES DE ARRIBA
	 * 
	 * *********************************** */
	public boolean RealizarVenta(ArrayList<ProductoVender> pro,Venta v){
		Connection sql = ConexionBD.getConexion();		
		boolean key = true;
		try {
			for (ProductoVender p : pro) {
				int i = verificarStock(p.getProducto().getCodigoProducto(), p.getCantidad());
				if(i == -1) {
					key = false;
				}				
			}
			if(key){		
				insertarBDVenta(v);
				insertarBDVentaProducto(v,pro);
				for (ProductoVender p : pro) {
					actualizarStock(p.getProducto().getCodigoProducto(), p.getCantidad());
				}		
				String query = "INSERT INTO DTRealiza (codigoVendedor, nroVenta) VALUES (?,?)";
				PreparedStatement stmt = sql.prepareStatement(query);
				stmt.setString(1, v.getCodigoVendedorVenta());
				stmt.setString(2, v.getNroVenta());
				stmt.executeUpdate();
			}			
		} catch (Exception e) {
			System.out.print(" DTRealizaVenta Error: " + e + "\n");
		}
		ConexionBD.closeConexion();
		return key;
	}
	
	
	//------------------------------------------------------------------
	//VER VENTAS DE LA BD
	//------------------------------------------------------------------
	
	/* ************************************
	 * 
	 * ESTA FUNCION NOS DEVUELCE UN ARRAYLIST DE TODAS LA 
	 * VENTAS REALIZADAS
	 * 
	 * *********************************** */
	
	public ArrayList<Venta> VerTodasVentas(){
		Connection sql = ConexionBD.getConexion();		
		ArrayList<Venta> vs = new ArrayList<>();
		String query = "SELECT * FROM Venta";
		try {
			Statement stmt = sql.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()){
				String nroVenta = rs.getString(1);
				String codigoClienteVenta = rs.getString(2);
				String codigoVendedorVenta = rs.getString(3);
				double montoFinalVenta = rs.getDouble(4);
				double descuentoTotalVenta = rs.getDouble(5);
				String metodoPagoVenta = rs.getString(6);
				String comprobantePagoVenta = rs.getString(7);
				Date fechaVenta = rs.getDate(8);
				Venta v = new Venta(nroVenta, codigoClienteVenta, codigoVendedorVenta, montoFinalVenta, 
						descuentoTotalVenta, metodoPagoVenta, comprobantePagoVenta, fechaVenta);
				vs.add(v);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		ConexionBD.closeConexion();
		return vs;
	}
	
	public ArrayList<Venta> VerFiltroVenta(String NroVenta, String CodCliente, String CodVendedor){
		Connection sql = ConexionBD.getConexion();
		String query = "Select * from Venta"		
				+ "	WHERE nroVenta LIKE '%"+NroVenta+"%' AND "
						+ "codigoCliente LIKE '%"+CodCliente+"%' AND "
								+ "codigoVendedor LIKE '%"+CodVendedor+"%'";
		ArrayList<Venta> vs = new ArrayList<>();
		try{
			Statement s = sql.createStatement();
			ResultSet rs = s.executeQuery(query);
			while(rs.next()){							
				String nroVenta = rs.getString("nroVenta");
				String codigoClienteVenta = rs.getString("codigoCliente");
				String codigoVendedorVenta = rs.getString("codigoVendedor");
				double montoFinalVenta = rs.getDouble("v_montoFinal");
				double descuentoTotalVenta = rs.getDouble("v_descuentoTotal");
				String metodoPagoVenta = rs.getString("v_metodoPago");
				String comprobantePagoVenta = rs.getString("v_comprobantePago");
				Date fechaVenta = rs.getDate("v_fechaVenta");
				
				Venta v = new Venta(nroVenta, codigoClienteVenta, codigoVendedorVenta, montoFinalVenta, 
						descuentoTotalVenta, metodoPagoVenta, comprobantePagoVenta, fechaVenta);
				vs.add(v);
			}
		}catch(Exception e ){			
		}
		return vs;
	}
	
	public boolean verificarNroVenta(String nro){
		Connection sql = ConexionBD.getConexion();
		boolean status=true;
		try {			
			String queryStock = "SELECT nroVenta FROM Venta";
			Statement stmt = sql.createStatement();
			ResultSet rs = stmt.executeQuery(queryStock);
			while(rs.next()){
				if(rs.getString("nroVenta").equals(nro)) status = false;
			}
		} catch (Exception e) {
			System.out.print(" Error: " + e + "\n");
		}
		return status;
	}
	/* ************************************
	 * 
	 * ESTA FUNCION NOS DEVUELCE UN ARRAYLIST DE TODA LA 
	 * VENTA REALIZADAS DE CADA VENDEDOR
	 * 
	 * *********************************** */
	public ArrayList<Venta> VerVentaVendedor(String codigo){
		Connection sql = ConexionBD.getConexion();		
		ArrayList<Venta> vs = new ArrayList<>();
		String query = "SELECT * FROM Venta WHERE codigoVendedor = '"+codigo+"'";
		try {
			Statement stmt = sql.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()){
				String nroVenta = rs.getString(1);
				String codigoClienteVenta = rs.getString(2);
				String codigoVendedorVenta = rs.getString(3);
				double montoFinalVenta = rs.getDouble(4);
				double descuentoTotalVenta = rs.getDouble(5);
				String metodoPagoVenta = rs.getString(6);
				String comprobantePagoVenta = rs.getString(7);
				Date fechaVenta = rs.getDate(8);
				Venta v = new Venta(nroVenta, codigoClienteVenta, codigoVendedorVenta, montoFinalVenta, 
						descuentoTotalVenta, metodoPagoVenta, comprobantePagoVenta, fechaVenta);
				vs.add(v);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		ConexionBD.closeConexion();
		return vs;
	}
	

	public void eliminarVenta(String nroVenta){
		Connection sql = ConexionBD.getConexion();
		try {
		String query = "DELETE FROM Venta WHERE nroVenta = '"+ nroVenta+"'";
		Statement stmt = sql.createStatement();
		stmt.executeUpdate(query);
		} catch (Exception e) {
			System.out.print(" Error eliminar venta: " + e + "\n");
		}
		ConexionBD.closeConexion();
	}
}















