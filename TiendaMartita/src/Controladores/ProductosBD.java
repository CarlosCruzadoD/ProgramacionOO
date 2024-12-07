package Controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Clases.Categoria;
import Clases.Marca;
import Clases.Producto;
import Clases.ProductoVender;
import Clases.Proveedor;
import Conexion.ConexionBD;

public class ProductosBD {	
	
	/* ***************************************
	 * 
	 * Insertar un producto
	 * 
	 * *************************************** */
	
	public void insertarBDProducto(Producto p){
		Connection sql = ConexionBD.getConexion();
		String cod = p.getCodigoProducto();
		String marca = p.getIDMarca();
		String categoria = p.getIDCategoria();
		String proveedor = p.getIDProovedor();
		int stock = p.getStock();
		double precio = p.getPrecio();
		String talla = p.getTalla();
		String color = p.getColor();		
		String query = "INSERT INTO Producto(codigoProducto, idMarca, idCategoria, idProveedor, "
				+ "p_stock, p_precio, p_talla, p_color) VALUES(?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement stmt = sql.prepareStatement(query);
			stmt.setString(1,cod);
			stmt.setInt(2,obtenerIDMarca(marca));
			stmt.setInt(3,obtenerIDCategoria(categoria));
			stmt.setInt(4,obtenerIDProveedor(proveedor));
			stmt.setInt(5,stock);
			stmt.setDouble(6,precio);
			stmt.setString(7,talla);
			stmt.setString(8,color);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		ConexionBD.closeConexion();
	}
	
	/* ***************************************
	 * 
	 * Obtener un TODOS los Productos
	 * 
	 * *************************************** */
	
	public ArrayList<Producto> obtenerBDProductos(){
		Connection sql = ConexionBD.getConexion();
		ArrayList<Producto> listPro = new ArrayList<>(); 
		
		try {
			String query = "SELECT  p.codigoProducto, "
					+ "m.m_nombreMarca, "
					+ "c.cate_categoria, "
					+ "p.p_stock, "
					+ "p.p_precio, "
					+ "p.p_talla, "
					+ "p.p_color FROM Producto AS p JOIN Marca AS m ON m.idMarca = p.idMarca "
					+ "JOIN Categoria AS c ON c.idCategoria = p.idCategoria ";
			Statement s = sql.createStatement();
			ResultSet rs = s.executeQuery(query);
			while(rs.next()){							
				String codigo = rs.getString("codigoProducto");
				String marca = rs.getString("m_nombreMarca");
				String categoria = rs.getString("cate_categoria");
				int stock = rs.getInt("p_stock");
				double precio = rs.getDouble("p_precio");
				String talla = rs.getString("p_talla");
				String color = rs.getString("p_color");
				Producto pro = new Producto(codigo, marca, categoria, stock, precio, talla, color);
				listPro.add(pro);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ConexionBD.closeConexion();
		return listPro;
	}
	public ArrayList<Producto> obtenerBDProductosJF(){
		Connection sql = ConexionBD.getConexion();
		ArrayList<Producto> listPro = new ArrayList<>(); 
		
		try {
			String query = "SELECT  p.codigoProducto, "
					+ "m.m_nombreMarca, "
					+ "c.cate_categoria, "
					+ "ee.pvd_nombre, "
					+ "p.p_stock, "
					+ "p.p_precio, "
					+ "p.p_talla, "
					+ "p.p_color FROM Producto AS p JOIN Marca AS m ON m.idMarca = p.idMarca "
					+ "JOIN Categoria AS c ON c.idCategoria = p.idCategoria "
					+ "JOIN Proveedor AS ee ON ee.idProveedor = p.idProveedor ";
			Statement s = sql.createStatement();
			ResultSet rs = s.executeQuery(query);
			while(rs.next()){							
				String codigo = rs.getString("codigoProducto");
				String marca = rs.getString("m_nombreMarca");
				String categoria = rs.getString("cate_categoria");
				String proveedor = rs.getString("pvd_nombre");
				int stock = rs.getInt("p_stock");
				double precio = rs.getDouble("p_precio");
				String talla = rs.getString("p_talla");
				String color = rs.getString("p_color");
				Producto pro = new Producto(codigo, marca, categoria, proveedor, stock, precio, talla, color);
				listPro.add(pro);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ConexionBD.closeConexion();
		return listPro;
	}
	
	/* ***************************************
	 * 
	 * Obtener un Solo Producto en base a su codigo
	 * 
	 * *************************************** */
	public Producto obtenerBDSoloProducto(String codigo){
		Connection sql = ConexionBD.getConexion();
		Producto pro = null; 
		try {
			String query = "SELECT "
					+ "codigoProducto, idMarca, idCategoria, p_stock, p_precio, p_talla, p_color "
					+ "FROM Producto "
					+ "WHERE codigoProducto = '"+codigo+"'";
			Statement s = sql.createStatement();
			ResultSet rs = s.executeQuery(query);
			while(rs.next()){							
				String codigoPro = rs.getString("codigoProducto");
				String marca = rs.getString("idMarca");
				String categoria = rs.getString("idCategoria");
				int stock = rs.getInt("p_stock");
				double precio = rs.getDouble("p_precio");
				String talla = rs.getString("p_talla");
				String color = rs.getString("p_color");
				pro = new Producto(codigoPro, marca, categoria, stock, precio, talla, color);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ConexionBD.closeConexion();
		return pro;
	}
	
	/* ***************************************
	 * 
	 * Filtrar Producto por Codigo, Talla, Marca y Categoria
	 * 
	 * *************************************** */
	
	public ArrayList<ProductoVender> obtenerTodosProdutosVentas(String venta){
		Connection sql = ConexionBD.getConexion();
		ArrayList<ProductoVender>  alpv = new  ArrayList<>(); 
		try {
			String query = "SELECT "
					+ "* FROM DTVenta"
					+ " WHERE nroVenta = '"+venta+"'";
			Statement s = sql.createStatement();
			ResultSet rs = s.executeQuery(query);
			while(rs.next()){							
				String codigo = rs.getString("codigoProducto");
				int cantidad = rs.getInt("dtv_cantidad");
				double desc = rs.getDouble("dtv_descuento");
				ProductoVender pv = new ProductoVender(obtenerBDSoloProducto(codigo), cantidad, desc);
				alpv.add(pv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ConexionBD.closeConexion();
		return alpv;
	}
	
	public ArrayList<Producto> ConsultarProductoFiltros(String codigo, String talla, String marca, String categoria){
		Connection sql = ConexionBD.getConexion();
		String query = "SELECT  p.codigoProducto, "
				+ "m.m_nombreMarca, "
				+ "c.cate_categoria, "
				+ "p.p_stock, "
				+ "p.p_precio, "
				+ "p.p_talla, "
				+ "p.p_color FROM Producto AS p JOIN Marca AS m ON m.idMarca = p.idMarca "
				+ "JOIN Categoria AS c ON c.idCategoria = p.idCategoria "
				+ "WHERE p.codigoProducto LIKE '%" + codigo + "%' "
						+ "AND p.p_talla LIKE '%"+talla+"%' "
								+ "AND m.m_nombreMarca LIKE '%"+marca+"%' "
										+ "AND c.cate_categoria LIKE '%"+categoria + "%'";
		
		ArrayList<Producto> alp = new ArrayList<>();		
		try {
			Statement s = sql.createStatement();
			ResultSet rs = s.executeQuery(query);
			while(rs.next()){							
				String codigoPro = rs.getString("codigoProducto");
				String marcaPro = rs.getString("m_nombreMarca");
				String categoriaPro = rs.getString("cate_categoria");
				int stock = rs.getInt("p_stock");
				double precio = rs.getDouble("p_precio");
				String tallaPro = rs.getString("p_talla");
				String color = rs.getString("p_color");
				Producto pro = new Producto(codigoPro, marcaPro, categoriaPro, stock, precio, tallaPro, color);
				alp.add(pro);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return alp;			
	}
	
	public ArrayList<String> obtenerMarcas(){
		Connection sql = ConexionBD.getConexion();
		String query = "SELECT * FROM Marca";
		ArrayList<String> a = new ArrayList<>();
		try{
			Statement stmt = sql.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()){
				a.add(rs.getString("m_nombreMarca"));
			}
		}catch(Exception e){
		}
		return a;
	}
	
	public ArrayList<String> obtenerCategorias(){
		Connection sql = ConexionBD.getConexion();
		String query = "SELECT * FROM Categoria";
		ArrayList<String> a = new ArrayList<>();
		try{
			Statement stmt = sql.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()){
				a.add(rs.getString("cate_categoria"));
			}
		}catch(Exception e){
		}
		ConexionBD.closeConexion();
		return a;
	}
	
	public ArrayList<String> obtenerProveedores(){
		Connection sql = ConexionBD.getConexion();
		String query = "SELECT * FROM Proveedor";
		ArrayList<String> a = new ArrayList<>();
		try{
			Statement stmt = sql.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()){
				a.add(rs.getString("pvd_nombre"));
			}
		}catch(Exception e){
		}
		ConexionBD.closeConexion();
		return a;
	}
	
	public ArrayList<Producto> ConsultarProductoFiltrosJF(String codigo, String marca, String categoria, String proveedor){
		Connection sql = ConexionBD.getConexion();
		String query = "SELECT  p.codigoProducto, "
				+ "m.m_nombreMarca, "
				+ "c.cate_categoria, "
				+ "ee.pvd_nombre, "
				+ "p.p_stock, "
				+ "p.p_precio, "
				+ "p.p_talla, "
				+ "p.p_color FROM Producto AS p JOIN Marca AS m ON m.idMarca = p.idMarca "
				+ "JOIN Categoria AS c ON c.idCategoria = p.idCategoria "
				+ "JOIN Proveedor AS ee ON ee.idProveedor = p.idProveedor "
				+ "WHERE p.codigoProducto LIKE '%" + codigo + "%' "
						+ "AND m.m_nombreMarca LIKE '%"+marca+"%' "
								+ "AND c.cate_categoria LIKE '%"+categoria+"%' "
										+ "AND ee.pvd_nombre LIKE '%"+proveedor + "%'";
		
		ArrayList<Producto> alp = new ArrayList<>();		
		try {
			Statement s = sql.createStatement();
			ResultSet rs = s.executeQuery(query);
			while(rs.next()){							
				String codigoPro = rs.getString("codigoProducto");
				String marcaPro = rs.getString("m_nombreMarca");
				String categoriaPro = rs.getString("cate_categoria");
				String proveedorPro = rs.getString("pvd_nombre");
				int stock = rs.getInt("p_stock");
				double precio = rs.getDouble("p_precio");
				String tallaPro = rs.getString("p_talla");
				String color = rs.getString("p_color");
				Producto pro = new Producto(codigoPro, marcaPro, categoriaPro, proveedorPro, stock, precio, tallaPro, color);
				alp.add(pro);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		ConexionBD.closeConexion();
		return alp;			
	}
	public int obtenerStock(String codigoProducto){
		Connection sql = ConexionBD.getConexion();
		int stock = 0;
		try {
			String query = "SELECT p_stock FROM Producto WHERE codigoProducto = '"+ codigoProducto+"'";
			Statement stmt = sql.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()){
				stock = rs.getInt("p_stock");
			}
		} catch (Exception e) {
			stock = -1;
			System.out.print(" Error ObtenerStock: " + e + "\n");
		}
		ConexionBD.closeConexion();
		return stock;
	}
	
	public void aumentarStock(int cantidad, String codigoProducto){
		Connection sql = ConexionBD.getConexion();
		int stockNuevo = cantidad + obtenerStock(codigoProducto);
		try {
			String query = "UPDATE Producto SET p_stock = " + stockNuevo + " "
					+ "WHERE codigoProducto = '" + codigoProducto+"'";
			Statement stmt = sql.createStatement();
			stmt.executeUpdate(query);
		} catch (Exception e) {
			System.out.print(" Error ObtenerStock: " + e + "\n");
		}
		
		ConexionBD.closeConexion();
	}

	public void eliminarProducto(String codigoProducto){
		Connection sql = ConexionBD.getConexion();
		try {
			String query = "DELETE FROM Producto WHERE codigoProducto = '"+ codigoProducto+"'";
			Statement stmt = sql.createStatement();
			stmt.executeUpdate(query);
		} catch (Exception e) {
			System.out.print(" Error eliminarProducto: " + e + "\n");
		}
		ConexionBD.closeConexion();
	}

	public int obtenerIDMarca(String nombre){
		Connection sql = ConexionBD.getConexion();
		String query = "SELECT idMarca FROM Marca where m_nombreMarca = '" + nombre + "'";
		int a = 0;
		try{
			Statement stmt = sql.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()){
				a = rs.getInt("idMarca");
			}
		}catch(Exception e){
		}
		return a;
	}
	
	public int obtenerIDCategoria(String nombre){
		Connection sql = ConexionBD.getConexion();
		String query = "SELECT idCategoria FROM Categoria where cate_categoria = '" + nombre + "'";
		int a = 0;
		try{
			Statement stmt = sql.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()){
				a = rs.getInt("idCategoria");
			}
		}catch(Exception e){
		}
		return a;
	}
	
	public int obtenerIDProveedor(String nombre){
		Connection sql = ConexionBD.getConexion();
		String query = "SELECT idProveedor FROM Proveedor where pvd_nombre = '" + nombre + "'";
		int a = 0;
		try{
			Statement stmt = sql.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()){
				a = rs.getInt("idProveedor");
			}
		}catch(Exception e){
		}
		return a;
	}
	
	public void modificarProducto(Producto p){
		Connection sql = ConexionBD.getConexion();
		String cod = p.getCodigoProducto();
		String marca = p.getIDMarca();
		String categoria = p.getIDCategoria();
		String proveedor = p.getIDProovedor();
		int stock = p.getStock();
		double precio = p.getPrecio();
		String talla = p.getTalla();
		String color = p.getColor();		
		String query = "UPDATE Producto SET codigoProducto = ?, idMarca=?, idCategoria=?, idProveedor=?, "
				+ "p_stock=?, p_precio=?, p_talla=?, p_color=? WHERE codigoProducto = '"+cod+"'";
		try {
			PreparedStatement stmt = sql.prepareStatement(query);
			stmt.setString(1,cod);
			stmt.setInt(2,obtenerIDMarca(marca));
			stmt.setInt(3,obtenerIDCategoria(categoria));
			stmt.setInt(4,obtenerIDProveedor(proveedor));
			stmt.setInt(5,stock);
			stmt.setDouble(6,precio);
			stmt.setString(7,talla);
			stmt.setString(8,color);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		ConexionBD.closeConexion();
	}

	public void insertarProveedor(Proveedor p){
		Connection sql = ConexionBD.getConexion();
		String nom = p.getNombreProveedor();
		String obs = p.getObservacionProveedor();
		String query = "INSERT INTO Proveedor(pvd_nombre, pvd_observacion) VALUES(?,?)";
		try {
			PreparedStatement stmt = sql.prepareStatement(query);
			stmt.setString(1,nom);
			stmt.setString(2,obs);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		ConexionBD.closeConexion();
	}
	
	public ArrayList<Proveedor> obtenerTodoProveedores(){
		Connection sql = ConexionBD.getConexion();
		String query = "SELECT * FROM Proveedor";
		ArrayList<Proveedor> alp = new ArrayList<>();
		try{
			Statement stmt = sql.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()){
				Proveedor p = new Proveedor(rs.getString("pvd_nombre"), rs.getString("pvd_observacion"));
				alp.add(p);
			}
		}catch(Exception e){
		}
		return alp;
	}
	
	public ArrayList<Proveedor> obtenerFiltroProveedores(String nom){
		Connection sql = ConexionBD.getConexion();
		String query = "SELECT * FROM Proveedor WHERE pvd_nombre LIKE '%"+nom+"%'";
		ArrayList<Proveedor> alp = new ArrayList<>();
		try{
			Statement stmt = sql.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()){
				Proveedor p = new Proveedor(rs.getString("pvd_nombre"), rs.getString("pvd_observacion"));
				alp.add(p);
			}
		}catch(Exception e){
		}
		return alp;
	}	
	public void modificarProveedor(Proveedor p, String cod){
		Connection sql = ConexionBD.getConexion();
		String nom = p.getNombreProveedor();
		String obs = p.getObservacionProveedor();
		String query = "UPDATE Proveedor SET pvd_nombre=?, pvd_observacion=? WHERE pvd_nombre = '"+cod+"'";
		try {
			PreparedStatement stmt = sql.prepareStatement(query);
			stmt.setString(1,nom);
			stmt.setString(2,obs);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		ConexionBD.closeConexion();
	}
	public void eliminarProveedor(String cod){
		Connection sql = ConexionBD.getConexion();
		String query = "DELETE FROM Proveedor WHERE pvd_nombre = '"+cod+"'";
		try {
			Statement stmt = sql.createStatement();
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		ConexionBD.closeConexion();
	}
	
	
	public void insertarMarca(Marca p){
		Connection sql = ConexionBD.getConexion();
		String nom = p.getNombreMarca();
		String obs = p.getObservacionMarca();
		String query = "INSERT INTO Marca(m_nombreMarca, m_observaciones) VALUES(?,?)";
		try {
			PreparedStatement stmt = sql.prepareStatement(query);
			stmt.setString(1,nom);
			stmt.setString(2,obs);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		ConexionBD.closeConexion();
	}
	
	public ArrayList<Marca> obtenerTodoMarca(){
		Connection sql = ConexionBD.getConexion();
		String query = "SELECT * FROM Marca";
		ArrayList<Marca> alm = new ArrayList<>();
		try{
			Statement stmt = sql.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()){
				Marca m = new Marca(rs.getString("m_nombreMarca"), rs.getString("m_observaciones"));
				alm.add(m);
			}
		}catch(Exception e){
		}
		return alm;
	}
	
	public ArrayList<Marca> obtenerFiltroMarca(String nom){
		Connection sql = ConexionBD.getConexion();
		String query = "SELECT * FROM Marca WHERE m_nombreMarca LIKE '%"+nom+"%'";
		ArrayList<Marca> alm = new ArrayList<>();
		try{
			Statement stmt = sql.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()){
				Marca m = new Marca(rs.getString("m_nombreMarca"), rs.getString("m_observacion"));
				alm.add(m);
			}
		}catch(Exception e){
		}
		return alm;
	}	
	public void modificarMarca(Marca p, String cod){
		Connection sql = ConexionBD.getConexion();
		String nom = p.getNombreMarca();
		String obs = p.getObservacionMarca();
		String query = "UPDATE Marca SET m_nombreMarca=?, m_observaciones=? WHERE m_nombreMarca = '"+cod+"'";
		try {
			PreparedStatement stmt = sql.prepareStatement(query);
			stmt.setString(1,nom);
			stmt.setString(2,obs);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		ConexionBD.closeConexion();
	}
	public void eliminarMarca(String cod){
		Connection sql = ConexionBD.getConexion();
		String query = "DELETE FROM Marca WHERE m_nombreMarca = '"+cod+"'";
		try {
			Statement stmt = sql.createStatement();
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		ConexionBD.closeConexion();
	}
	
	/*----------------------------------*/
	public void insertarCategoria(Categoria p){
		Connection sql = ConexionBD.getConexion();
		String nom = p.getNombreCategoria();
		String obs = p.getObservacionCategoria();
		String query = "INSERT INTO Categoria(cate_categoria, cate_observaciones) VALUES(?,?)";
		try {
			PreparedStatement stmt = sql.prepareStatement(query);
			stmt.setString(1,nom);
			stmt.setString(2,obs);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		ConexionBD.closeConexion();
	}
	
	public ArrayList<Categoria> obtenerTodoCategoria(){
		Connection sql = ConexionBD.getConexion();
		String query = "SELECT * FROM Categoria";
		ArrayList<Categoria> alm = new ArrayList<>();
		try{
			Statement stmt = sql.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()){
				Categoria m = new Categoria(rs.getString("cate_categoria"), rs.getString("cate_observaciones"));
				alm.add(m);
			}
		}catch(Exception e){
		}
		return alm;
	}
	
	public ArrayList<Categoria> obtenerFiltroCategoria(String nom){
		Connection sql = ConexionBD.getConexion();
		String query = "SELECT * FROM Categoria WHERE cate_categoria LIKE '%"+nom+"%'";
		ArrayList<Categoria> alm = new ArrayList<>();
		try{
			Statement stmt = sql.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()){
				Categoria m = new Categoria(rs.getString("cate_categoria"), rs.getString("cate_observaciones"));
				alm.add(m);
			}
		}catch(Exception e){
		}
		return alm;
	}	
	public void modificarCategoria(Categoria p, String cod){
		Connection sql = ConexionBD.getConexion();
		String nom = p.getNombreCategoria();
		String obs = p.getObservacionCategoria();
		String query = "UPDATE Categoria SET cate_categoria=?, cate_observaciones=? WHERE cate_categoria = '"+cod+"'";
		try {
			PreparedStatement stmt = sql.prepareStatement(query);
			stmt.setString(1,nom);
			stmt.setString(2,obs);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		ConexionBD.closeConexion();
	}
	public void eliminarCategoria(String cod){
		Connection sql = ConexionBD.getConexion();
		String query = "DELETE FROM Categoria WHERE cate_categoria = '"+cod+"'";
		try {
			Statement stmt = sql.createStatement();
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		ConexionBD.closeConexion();
	}
}
