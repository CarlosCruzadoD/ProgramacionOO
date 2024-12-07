package Controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.security.*;

import Clases.Gerente;
import Clases.JFAlmacen;
import Clases.Producto;
import Clases.Trabajador;
import Clases.Vendedor;
import Conexion.ConexionBD;

public class TrabajadorBD {
	//------------------------------------------------------
	//INSERTAR TRABAJADORES EN LA BASE DE DATOS
	//------------------------------------------------------
	private void insertarBDTrabajador(Trabajador v){
		Connection sql = ConexionBD.getConexion();
		String codigo = v.getCodigoTrabajador();
		String nombre = v.getNombreTrabajador();
		String apellido = v.getApellidoTrabajador();
		String dni = v.getDniTrabajador();
		String genero = v.getGeneroTrabajador();
		String correo = v.getCorreoTrabajador();
		String celular = v.getCelularTrabajador();
		int edad = v.getEdadTrabajador();
		String usuario = v.getUsuarioTrabajador();
		String contra = v.getContraseñaTrabajador();
		int tipoTrabajador = v.getTipoTrabajador();
		double sueldo = v.getSueldoTrabajador();				
		String queryTrabajador = 
				"INSERT INTO Trabajador "
				+ "(codigoTrabajador, t_nombre, t_apellido, t_dni, t_genero, t_correo, t_celular, t_edad,"
				+ "t_usuario, t_contraseña, t_tipoTrabajador, t_sueldo) "
				+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";		
		try {
			PreparedStatement stmtTrabajador = sql.prepareStatement(queryTrabajador);
			stmtTrabajador.setString(1, codigo);
			stmtTrabajador.setString(2, nombre);
			stmtTrabajador.setString(3, apellido);
			stmtTrabajador.setString(4, dni);
			stmtTrabajador.setString(5, genero);
			stmtTrabajador.setString(6, correo);
			stmtTrabajador.setString(7, celular);
			stmtTrabajador.setInt(8, edad);
			stmtTrabajador.setString(9, usuario);
			stmtTrabajador.setString(10, contra);
			stmtTrabajador.setInt(11, tipoTrabajador);
			stmtTrabajador.setDouble(12, sueldo);
			stmtTrabajador.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		ConexionBD.closeConexion();
	}
	public void insertarBDGerente(Gerente g){
		Connection sql = ConexionBD.getConexion();
		String codigo = g.getCodigoTrabajador();
		String area = g.getArea();				
		String queryGerente = "INSERT INTO Gerente(codigoGerente, g_area)"
				+ "VALUES(?,?)";
		try {			
			insertarBDTrabajador(g);
			PreparedStatement stmtGerente = sql.prepareStatement(queryGerente);
			stmtGerente.setString(1, codigo);
			stmtGerente.setString(2, area);
			stmtGerente.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		ConexionBD.closeConexion();
	}
	public void insertarBDVendedor(Vendedor v){
		Connection sql = ConexionBD.getConexion();
		String codigo = v.getCodigoTrabajador();
		double comision = v.getComisionVendedor();		
		
		String queryVendedor= "INSERT INTO Vendedor(codigoVendedor, v_comision)"
				+ "VALUES(?,?)";
		try {	
			insertarBDTrabajador(v);
			PreparedStatement stmtJFVendedor = sql.prepareStatement(queryVendedor);
			stmtJFVendedor.setString(1, codigo);
			stmtJFVendedor.setDouble(2, comision);
			stmtJFVendedor.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		ConexionBD.closeConexion();
	
	}
	public void insertarBDJFAlmacen(JFAlmacen g){
		Connection sql = ConexionBD.getConexion();
		String codigo = g.getCodigoTrabajador();
		String area = g.getAreaJFALmacen();		
		
		String queryJFAlmacen = "INSERT INTO JFAlmacen(codigoJFAlmacen, jfa_area)"
				+ "VALUES(?,?)";
		try {			
			insertarBDTrabajador(g);
			PreparedStatement stmtJFAlmacen = sql.prepareStatement(queryJFAlmacen);
			stmtJFAlmacen.setString(1, codigo);
			stmtJFAlmacen.setString(2, area);
			stmtJFAlmacen.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		ConexionBD.closeConexion();
	
	}
	
	
	
	//------------------------------------------------------
	//VER TRABAJADORES DE LA BASE DE DATOS
	//------------------------------------------------------
	
	//******************************************************
		//****** TODOS LOS VENDEDORES *******
	public ArrayList<Vendedor> verTodosVendedores(){
		Connection sql = ConexionBD.getConexion();
		String query= "SELECT * FROM Trabajador JOIN Vendedor ON Vendedor.codigoVendedor = Trabajador.codigoTrabajador";
		ArrayList<Vendedor> vendedores = new ArrayList<>();
		try {			
			Statement stmt = sql.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()){
				String codigoTrabajador = rs.getString(1);
				String nombreTrabajador = rs.getString(2);
				String apellidoTrabajador = rs.getString(3);
				String dniTrabajador = rs.getString(4);
				String generoTrabajador = rs.getString(5);
				String correoTrabajador = rs.getString(6);
				String celularTrabajador = rs.getString(7);
				int edadTrabajador = rs.getInt(8);
				String usuarioTrabajador = rs.getString(9);
				String contraseñaTrabajador = rs.getString(10);
				int tipoTrabajador = rs.getInt(11);
				double sueldoTrabajador = rs.getDouble(12);
				double comisionVendedor = rs.getDouble(14);				
				Vendedor v = new Vendedor
						(codigoTrabajador, nombreTrabajador, apellidoTrabajador, dniTrabajador, 
								generoTrabajador, correoTrabajador, celularTrabajador, edadTrabajador, 
								usuarioTrabajador, contraseñaTrabajador, tipoTrabajador, sueldoTrabajador, 
								comisionVendedor);
				vendedores.add(v);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		ConexionBD.closeConexion();
		return vendedores;
	}
	/* **************************************
	 * 
	 * Consultar con filtros el Vendedor
	 * 
	 * ******************************************* */
	public ArrayList<Vendedor> consultarVendedor(String nombre, String apellido, String dni){
		Connection sql = ConexionBD.getConexion();
		String query = "SELECT * FROM Vendedor JOIN Trabajador ON Trabajador.codigoTrabajador = Vendedor.codigoVendedor "
				+ "	WHERE t_nombre LIKE '%"+nombre+"%' AND "
						+ "t_apellido LIKE '%"+apellido+"%' AND "
								+ "t_dni LIKE '%"+dni+"%'";
		ArrayList<Vendedor> alv = new ArrayList<>();
		try{
			Statement s = sql.createStatement();
			ResultSet rs = s.executeQuery(query);
			while(rs.next()){							
				String codVendedor = rs.getString("codigoTrabajador");
				String nombreVen = rs.getString("t_nombre");
				String apeVen = rs.getString("t_apellido");
				String dniVen = rs.getString("t_dni");
				String genero = rs.getString("t_genero");
				String correo = rs.getString("t_correo");
				String celular = rs.getString("t_celular");
				int edad = rs.getInt("t_edad");
				double sueldo = rs.getDouble("t_sueldo");
				double comision = rs.getDouble("v_comision");
				Vendedor v = new Vendedor(codVendedor, nombreVen, apeVen, dniVen, genero, 
						correo, celular, edad, sueldo, 
						comision);
				alv.add(v);
			}
		}catch(Exception e ){			
		}
		return alv;
	}
	public ArrayList<Gerente> consultarGerente(String nombre, String apellido, String dni){
		Connection sql = ConexionBD.getConexion();
		String query = "SELECT * FROM Gerente JOIN Trabajador ON Trabajador.codigoTrabajador = Gerente.codigoGerente "
				+ "	WHERE t_nombre LIKE '%"+nombre+"%' AND "
						+ "t_apellido LIKE '%"+apellido+"%' AND "
								+ "t_dni LIKE '%"+dni+"%'";
		ArrayList<Gerente> alv = new ArrayList<>();
		try{
			Statement s = sql.createStatement();
			ResultSet rs = s.executeQuery(query);
			while(rs.next()){							
				String codVendedor = rs.getString("codigoTrabajador");
				String nombreVen = rs.getString("t_nombre");
				String apeVen = rs.getString("t_apellido");
				String dniVen = rs.getString("t_dni");
				String genero = rs.getString("t_genero");
				String correo = rs.getString("t_correo");
				String celular = rs.getString("t_celular");
				int edad = rs.getInt("t_edad");
				double sueldo = rs.getDouble("t_sueldo");
				String area = rs.getString("g_area");
				Gerente v = new Gerente(codVendedor, nombreVen, apeVen, dniVen, genero, 
						correo, celular, edad, sueldo, 
						area);
				alv.add(v);
			}
		}catch(Exception e ){			
		}
		return alv;
	}
	public ArrayList<JFAlmacen> consultarJFAlmacen(String nombre, String apellido, String dni){
		Connection sql = ConexionBD.getConexion();
		String query = "SELECT * FROM JFAlmacen JOIN Trabajador ON Trabajador.codigoTrabajador = JFAlmacen.codigoJFAlmacen "
				+ "	WHERE t_nombre LIKE '%"+nombre+"%' AND "
						+ "t_apellido LIKE '%"+apellido+"%' AND "
								+ "t_dni LIKE '%"+dni+"%'";
		ArrayList<JFAlmacen> alv = new ArrayList<>();
		try{
			Statement s = sql.createStatement();
			ResultSet rs = s.executeQuery(query);
			while(rs.next()){							
				String codVendedor = rs.getString("codigoTrabajador");
				String nombreVen = rs.getString("t_nombre");
				String apeVen = rs.getString("t_apellido");
				String dniVen = rs.getString("t_dni");
				String genero = rs.getString("t_genero");
				String correo = rs.getString("t_correo");
				String celular = rs.getString("t_celular");
				int edad = rs.getInt("t_edad");
				double sueldo = rs.getDouble("t_sueldo");
				String area = rs.getString("jfa_area");
				JFAlmacen v = new JFAlmacen(codVendedor, nombreVen, apeVen, dniVen, genero, 
						correo, celular, edad, sueldo, 
						area);
				alv.add(v);
			}
		}catch(Exception e ){			
		}
		return alv;
	}
	
	
		//****** UN SOLO VENDEDOR *******
	public Vendedor verSoloVendedor(String codigo){
		Connection sql = ConexionBD.getConexion();
		String query= "SELECT * FROM Trabajador JOIN Vendedor ON "
				+ "Vendedor.codigoVendedor = Trabajador.codigoTrabajador "
				+ "WHERE Trabajador.codigoTrabajador = '"+ codigo+"'";
		Vendedor v = null;
		try {			
			Statement stmt = sql.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()){
				String codigoTrabajador = rs.getString(1);
				String nombreTrabajador = rs.getString(2);
				String apellidoTrabajador = rs.getString(3);
				String dniTrabajador = rs.getString(4);
				String generoTrabajador = rs.getString(5);
				String correoTrabajador = rs.getString(6);
				String celularTrabajador = rs.getString(7);
				int edadTrabajador = rs.getInt(8);
				String usuarioTrabajador = rs.getString(9);
				String contraseñaTrabajador = rs.getString(10);
				int tipoTrabajador = rs.getInt(11);
				double sueldoTrabajador = rs.getDouble(12);
				double comisionVendedor = rs.getDouble(14);				
				v = new Vendedor
						(codigoTrabajador, nombreTrabajador, apellidoTrabajador, dniTrabajador, 
								generoTrabajador, correoTrabajador, celularTrabajador, edadTrabajador, 
								usuarioTrabajador, contraseñaTrabajador, tipoTrabajador, sueldoTrabajador, 
								comisionVendedor);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		ConexionBD.closeConexion();
		return v;
	}	
	//******************************************************
		//****** TODOS LOS GERENTES *******
	public ArrayList<Gerente> verTodosGerentes(){
		Connection sql = ConexionBD.getConexion();
		String query= "SELECT * FROM Trabajador JOIN Gerente ON Gerente.codigoGerente = Trabajador.codigoTrabajador";
		ArrayList<Gerente> gerentes = new ArrayList<>();
		try {			
			Statement stmt = sql.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()){
				String codigoTrabajador = rs.getString(1);
				String nombreTrabajador = rs.getString(2);
				String apellidoTrabajador = rs.getString(3);
				String dniTrabajador = rs.getString(4);
				String generoTrabajador = rs.getString(5);
				String correoTrabajador = rs.getString(6);
				String celularTrabajador = rs.getString(7);
				int edadTrabajador = rs.getInt(8);
				String usuarioTrabajador = rs.getString(9);
				String contraseñaTrabajador = rs.getString(10);
				int tipoTrabajador = rs.getInt(11);
				double sueldoTrabajador = rs.getDouble(12);
				String area = rs.getString(14);	
				Gerente v = new Gerente
						(codigoTrabajador, nombreTrabajador, apellidoTrabajador, dniTrabajador, 
								generoTrabajador, correoTrabajador, celularTrabajador, edadTrabajador, 
								usuarioTrabajador, contraseñaTrabajador, tipoTrabajador, sueldoTrabajador, 
								area);
				gerentes.add(v);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		ConexionBD.closeConexion();
		return gerentes;
	}
	
		//****** UN SOLO GERENTE *******
	public Gerente verSoloGerente(String codigo){
		Connection sql = ConexionBD.getConexion();
		String query= "SELECT * FROM Trabajador JOIN Gerente ON "
				+ "Gerente.codigoGerente = Trabajador.codigoTrabajador "
				+ "WHERE Trabajador.codigoTrabajador = '"+codigo+"'";
		Gerente g = null;
		try {			
			Statement stmt = sql.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()){
				String codigoTrabajador = rs.getString(1);
				String nombreTrabajador = rs.getString(2);
				String apellidoTrabajador = rs.getString(3);
				String dniTrabajador = rs.getString(4);
				String generoTrabajador = rs.getString(5);
				String correoTrabajador = rs.getString(6);
				String celularTrabajador = rs.getString(7);
				int edadTrabajador = rs.getInt(8);
				String usuarioTrabajador = rs.getString(9);
				String contraseñaTrabajador = rs.getString(10);
				int tipoTrabajador = rs.getInt(11);
				double sueldoTrabajador = rs.getDouble(12);
				String area = rs.getString(14);	
				g = new Gerente
						(codigoTrabajador, nombreTrabajador, apellidoTrabajador, dniTrabajador, 
								generoTrabajador, correoTrabajador, celularTrabajador, edadTrabajador, 
								usuarioTrabajador, contraseñaTrabajador, tipoTrabajador, sueldoTrabajador, 
								area);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		ConexionBD.closeConexion();
		return g;
	}
	//******************************************************
		//****** TODOS LOS JEFES DE ALMACENES *******
	public ArrayList<JFAlmacen> verTodosJFAlmacen(){
		Connection sql = ConexionBD.getConexion();
		String query= "SELECT * FROM Trabajador JOIN JFAlmacen "
				+ "ON JFAlmacen.codigoJFAlmacen = Trabajador.codigoTrabajador";
		ArrayList<JFAlmacen> jfAlmacen = new ArrayList<>();
		try {			
			Statement stmt = sql.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()){
				String codigoTrabajador = rs.getString(1);
				String nombreTrabajador = rs.getString(2);
				String apellidoTrabajador = rs.getString(3);
				String dniTrabajador = rs.getString(4);
				String generoTrabajador = rs.getString(5);
				String correoTrabajador = rs.getString(6);
				String celularTrabajador = rs.getString(7);
				int edadTrabajador = rs.getInt(8);
				String usuarioTrabajador = rs.getString(9);
				String contraseñaTrabajador = rs.getString(10);
				int tipoTrabajador = rs.getInt(11);
				double sueldoTrabajador = rs.getDouble(12);
				String area = rs.getString(14);	
				JFAlmacen v = new JFAlmacen
						(codigoTrabajador, nombreTrabajador, apellidoTrabajador, dniTrabajador, 
								generoTrabajador, correoTrabajador, celularTrabajador, edadTrabajador, 
								usuarioTrabajador, contraseñaTrabajador, tipoTrabajador, sueldoTrabajador, 
								area);
				jfAlmacen.add(v);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		ConexionBD.closeConexion();
		return jfAlmacen;
	}
		//****** SOLO UN JEFE DE ALMACEN *******
	public JFAlmacen verSoloJFAlmacen(String codigo){
		Connection sql = ConexionBD.getConexion();
		String query= "SELECT * FROM Trabajador JOIN JFAlmacen "
				+ "ON JFAlmacen.codigoJFAlmacen = Trabajador.codigoTrabajador "
				+ "WHERE Trabajador.codigoTrabajador = '"+codigo+"'";
		JFAlmacen j = null;
		try {			
			Statement stmt = sql.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()){
				String codigoTrabajador = rs.getString(1);
				String nombreTrabajador = rs.getString(2);
				String apellidoTrabajador = rs.getString(3);
				String dniTrabajador = rs.getString(4);
				String generoTrabajador = rs.getString(5);
				String correoTrabajador = rs.getString(6);
				String celularTrabajador = rs.getString(7);
				int edadTrabajador = rs.getInt(8);
				String usuarioTrabajador = rs.getString(9);
				String contraseñaTrabajador = rs.getString(10);
				int tipoTrabajador = rs.getInt(11);
				double sueldoTrabajador = rs.getDouble(12);
				String area = rs.getString(14);	
				j = new JFAlmacen
						(codigoTrabajador, nombreTrabajador, apellidoTrabajador, dniTrabajador, 
								generoTrabajador, correoTrabajador, celularTrabajador, edadTrabajador, 
								usuarioTrabajador, contraseñaTrabajador, tipoTrabajador, sueldoTrabajador, 
								area);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		ConexionBD.closeConexion();
		return j;
	}

	
	//------------------------------------------------------
	//ELIMINAR TRABAJADORES DE LA BASE DE DATOS
	//------------------------------------------------------
	
	public void eliminarTrabajador(String codigoTrabajador){
		Connection sql = ConexionBD.getConexion();
		String query = "DELETE FROM Trabajador WHERE codigoTrabajador = '" + codigoTrabajador + "'";
		try {
			Statement stmt =  sql.createStatement();
			stmt.executeUpdate(query);
		} catch (Exception e) {
			System.out.print(" Error: " + e);
		}
		ConexionBD.closeConexion();
	}		
	
	

	
	/* **************************************
	 * 
	 * Verificar Usuario y contra
	 * 
	 * ******************************************* */
	
	
	public int verificarCuenta(String user, String pass){
		Connection sql = ConexionBD.getConexion();
		String query = "select t_usuario, t_contraseña, t_tipoTrabajador from Trabajador";
		int trabajador = 0;
		try {
			Statement stmt = sql.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()){
				if(user.equals(rs.getString(1))&& pass.equals(rs.getString(2))) trabajador = rs.getInt(3);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ConexionBD.closeConexion();
		return trabajador;
	}
	
	public String verificarCuentaCodigo(String user, String pass){
		Connection sql = ConexionBD.getConexion();
		String query = "select t_usuario, t_contraseña, codigoTrabajador from Trabajador";
		String trabajador = "";
		try {
			Statement stmt = sql.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()){
				if(user.equals(rs.getString(1))&& pass.equals(rs.getString(2))) trabajador = rs.getString(3);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ConexionBD.closeConexion();
		return trabajador;		
	}
	
	public ArrayList<Trabajador> consultarFiltroTrabajadores(String codigo, String dni, String usuario){
		Connection sql = ConexionBD.getConexion();
		String query = "SELECT * FROM Trabajador"
				+ "	WHERE codigoTrabajador LIKE '%"+codigo+"%' AND "
						+ "t_dni LIKE '%"+dni+"%' AND "
								+ "t_usuario LIKE '%"+usuario+"%'";
		ArrayList<Trabajador> alv = new ArrayList<>();
		try{
			Statement s = sql.createStatement();
			ResultSet rs = s.executeQuery(query);
			while(rs.next()){							
				String codigoTrabajador = rs.getString("codigoTrabajador");
				String nombreTrabajador = rs.getString("t_nombre");
				String apellidoTrabajador = rs.getString("t_apellido");
				String dniTrabajador = rs.getString("t_dni");
				String generoTrabajador = rs.getString("t_genero");
				String correoTrabajador = rs.getString("t_correo");
				String celularTrabajador = rs.getString("t_celular");
				int edadTrabajador = rs.getInt("t_edad");
				String usuarioTrabajador = rs.getString("t_usuario");
				String contraseñaTrabajador = rs.getString("t_contraseña");
				int tipoTrabajador = rs.getInt("t_tipoTrabajador");
				double sueldoTrabajador = rs.getDouble("t_sueldo");
				
				Trabajador v = new Trabajador(codigoTrabajador, nombreTrabajador, apellidoTrabajador, dniTrabajador, 
						generoTrabajador, correoTrabajador, celularTrabajador, edadTrabajador, usuarioTrabajador, 
						contraseñaTrabajador, tipoTrabajador, sueldoTrabajador);
				alv.add(v);
			}
		}catch(Exception e ){			
		}
		return alv;
	}
	public void modificarTrabajador(Trabajador v, String codigo) {
	    Connection sql = ConexionBD.getConexion();
	     
	    String query = "UPDATE Trabajador SET "
	            + "t_nombre = ?, "
	            + "t_apellido = ?, "
	            + "t_dni = ?, "
	            + "t_genero = ?, "
	            + "t_correo = ?, "
	            + "t_celular = ?, "
	            + "t_edad = ?, "
	            + "t_usuario = ?, "
	            + "t_contraseña = ? "
	            + "WHERE codigoTrabajador = ?";	    
	    try {
	        PreparedStatement pstmt = sql.prepareStatement(query); 
	        pstmt.setString(1, v.getNombreTrabajador());
	        pstmt.setString(2, v.getApellidoTrabajador());
	        pstmt.setString(3, v.getDniTrabajador());
	        pstmt.setString(4, v.getGeneroTrabajador());
	        pstmt.setString(5, v.getCorreoTrabajador());
	        pstmt.setString(6, v.getCelularTrabajador());
	        pstmt.setInt(7, v.getEdadTrabajador());
	        pstmt.setString(8, v.getUsuarioTrabajador());
	        pstmt.setString(9, v.getContraseñaTrabajador());
	        pstmt.setString(10, codigo);
	        
	        int affectedRows = pstmt.executeUpdate();        
	        if (affectedRows > 0) {
	            System.out.println("El trabajador ha sido modificado correctamente.");
	        } else {
	            System.out.println("No se encontró el trabajador con el código proporcionado.");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }  
	    ConexionBD.closeConexion();
	}
	public void modificarVendedor(Vendedor v, String codigo) {
	    Connection sql = ConexionBD.getConexion();
	     
	    String query = "UPDATE Vendedor SET "
	            + "v_comision = ? "
	            + "WHERE codigoVendedor = ?";
	    
	    try {
	        PreparedStatement pstmt = sql.prepareStatement(query); 
	        pstmt.setDouble(1, v.getComisionVendedor());
	        pstmt.setString(2, codigo);	        
	        int affectedRows = pstmt.executeUpdate();    
	        modificarTrabajador(v, codigo);
	        if (affectedRows > 0) {
	            System.out.println("El Vendedor ha sido modificado correctamente.");
	        } else {
	            System.out.println("No se encontró el Vendedor con el código proporcionado.");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }  
	    ConexionBD.closeConexion();
	}
	public void modificarGerente(Gerente v, String codigo) {
	    Connection sql = ConexionBD.getConexion();
	     
	    String query = "UPDATE Gerente SET "
	            + "g_area = ? "
	            + "WHERE codigoGerente = ?";
	    
	    try {
	        PreparedStatement pstmt = sql.prepareStatement(query); 
	        pstmt.setString(1, v.getArea());
	        pstmt.setString(2, codigo);	        
	        int affectedRows = pstmt.executeUpdate();    
	        modificarTrabajador(v, codigo);
	        if (affectedRows > 0) {
	            System.out.println("El Gerente ha sido modificado correctamente.");
	        } else {
	            System.out.println("No se encontró el Gerente con el código proporcionado.");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }  
	    ConexionBD.closeConexion();
	}
	public void modificarAlmacen(JFAlmacen v, String codigo) {
	    Connection sql = ConexionBD.getConexion();
	     
	    String query = "UPDATE JFAlmacen SET "
	            + "jfa_area = ? "
	            + "WHERE codigoJFAlmacen = ?";
	    
	    try {
	        PreparedStatement pstmt = sql.prepareStatement(query); 
	        pstmt.setString(1, v.getAreaJFALmacen());
	        pstmt.setString(2, codigo);	        
	        int affectedRows = pstmt.executeUpdate();    
	        modificarTrabajador(v, codigo);
	        if (affectedRows > 0) {
	            System.out.println("El Jefe de almacen ha sido modificado correctamente.");
	        } else {
	            System.out.println("No se encontró el Jefe de almacen con el código proporcionado.");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }  
	    ConexionBD.closeConexion();
	}
	
	
	
	public void modificarTipoTrabajador(String tipo, String codigoTrabajador) {
	    Connection sql = ConexionBD.getConexion();	    
	    String query = "UPDATE Trabajador SET t_tipoTrabajador = ? WHERE codigoTrabajador = ?";	    
	    try {
	        PreparedStatement pstmt = sql.prepareStatement(query);
	        pstmt.setString(1, tipo);
	        pstmt.setString(2, codigoTrabajador);
	        int affectedRows = pstmt.executeUpdate();	        
	        if (affectedRows > 0) {
	            System.out.println("El tipo de trabajador ha sido modificado.");
	        } else {
	            System.out.println("No se encontró el trabajador con el código proporcionado.");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } 
	    ConexionBD.closeConexion();	    
	}	
	
	public ArrayList<Trabajador> verTodosTrabajadores(){
		Connection sql = ConexionBD.getConexion();
		String query= "SELECT * FROM Trabajador";
		ArrayList<Trabajador> trabajadores = new ArrayList<>();
		try {			
			Statement stmt = sql.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()){
				String codigoTrabajador = rs.getString(1);
				String nombreTrabajador = rs.getString(2);
				String apellidoTrabajador = rs.getString(3);
				String dniTrabajador = rs.getString(4);
				String generoTrabajador = rs.getString(5);
				String correoTrabajador = rs.getString(6);
				String celularTrabajador = rs.getString(7);
				int edadTrabajador = rs.getInt(8);
				String usuarioTrabajador = rs.getString(9);
				String contraseñaTrabajador = rs.getString(10);
				int tipoTrabajador = rs.getInt(11);
				double sueldoTrabajador = rs.getDouble(12);				
				Trabajador v = new Trabajador(codigoTrabajador, nombreTrabajador, apellidoTrabajador, 
						dniTrabajador, generoTrabajador, correoTrabajador, celularTrabajador, edadTrabajador,
						usuarioTrabajador, contraseñaTrabajador, tipoTrabajador, sueldoTrabajador);
				trabajadores.add(v);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		ConexionBD.closeConexion();
		return trabajadores;
	}
	public boolean verificarTrabajador(String nro){
		Connection sql = ConexionBD.getConexion();
		boolean status=true;
		try {			
			String queryStock = "SELECT codigoTrabajador FROM Trabajador";
			Statement stmt = sql.createStatement();
			ResultSet rs = stmt.executeQuery(queryStock);
			while(rs.next()){
				if(rs.getString("codigoTrabajador").equals(nro)) status = false;
			}
		} catch (Exception e) {
			System.out.print(" Error: " + e + "\n");
		}
		return status;
	}
}
