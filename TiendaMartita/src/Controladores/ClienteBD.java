package Controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Clases.Cliente;
import Conexion.ConexionBD;

public class ClienteBD {
	/* ***************************************
	 * 
	 * Insertar un Cliente
	 * 
	 * *************************************** */
	public void insertarBDCLiente(Cliente c){
		Connection sql = ConexionBD.getConexion();
		String cod = c.getCodigoCliente();
		String nom = c.getNombreCliente();
		String ape = c.getApellidoCliente();
		String dni = c.getDniCliente();
		String genero = c.getGeneroCliente();
		String correo = c.getCorreoCliente();
		String cel = c.getCelularCliente();
		int edad = c.getEdadCliente();	
		String query = 
				"INSERT INTO Cliente VALUES(?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement stmt = sql.prepareStatement(query);
			stmt.setString(1, cod);
			stmt.setString(2, nom);
			stmt.setString(3, ape);
			stmt.setString(4, dni);
			stmt.setString(5, genero);
			stmt.setString(6, correo);
			stmt.setString(7, cel);
			stmt.setInt(8, edad);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		ConexionBD.closeConexion();
	}
	
	/* ***************************************
	 * 
	 * Obtener un TODOS los Clientes registrados
	 * 
	 * *************************************** */
	public ArrayList<Cliente> obtenerBDClientes(){
		Connection sql = ConexionBD.getConexion();
		ArrayList<Cliente> listCli = new ArrayList<>(); 
		try {
			Statement s = sql.createStatement();
			ResultSet rs = s.executeQuery("Select * from Cliente");
			while(rs.next()){							
				String cod = rs.getString("codigoCliente");
				String nom = rs.getString("c_nombre");
				String ape = rs.getString("c_apellido");
				String dni = rs.getString("c_dni");
				String genero = rs.getString("c_genero");
				String correo = rs.getString("c_correo");
				String cel = rs.getString("c_celular");
				int edad = rs.getInt("c_edad");
				Cliente cli = new Cliente(cod, nom, ape, dni, genero, correo, cel, edad);
				listCli.add(cli);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ConexionBD.closeConexion();
		return listCli;
	}

	public ArrayList<Cliente> ConsultarClientesFiltros(String codigo, String apellido, String dni) {
	    Connection sql = ConexionBD.getConexion();
	    String query = "SELECT "
	            + "* FROM Cliente "
	            + "WHERE codigoCliente LIKE '%" + codigo + "%' "
	            + "AND c_apellido LIKE '%" + apellido + "%' "
	            + "AND c_dni LIKE '%" + dni + "%'";
	    
	    ArrayList<Cliente> clientes = new ArrayList<>();	    
	    try {
	        Statement s = sql.createStatement();
	        ResultSet rs = s.executeQuery(query);	        
	        while (rs.next()) {
	            String codigoCliente = rs.getString("codigoCliente");
	            String nombreCliente = rs.getString("c_nombre");
	            String apellidoCliente = rs.getString("c_apellido");
	            String dniCliente = rs.getString("c_dni");
	            String generoCliente = rs.getString("c_genero");
	            String correoCliente = rs.getString("c_correo");
	            String celularCliente = rs.getString("c_celular");
	            int edadCliente = rs.getInt("c_edad");	            
	            Cliente cliente = new Cliente(codigoCliente, nombreCliente, apellidoCliente, dniCliente, generoCliente, correoCliente, celularCliente, edadCliente);
	            clientes.add(cliente);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } 
	    
	    ConexionBD.closeConexion();
	    return clientes;
	}

	public void eliminarCliente(String codigoCliente){
		Connection sql = ConexionBD.getConexion();
		try {
			String query = "DELETE FROM Cliente WHERE codigoCliente = '"+ codigoCliente+"'";
			Statement stmt = sql.createStatement();
			stmt.executeUpdate(query);
		} catch (Exception e) {
			System.out.print("\n Error eliminar Cliente: " + e + "\n");
		}
		ConexionBD.closeConexion();
	}
	/* ***************************************
	 * 
	 * Obtener un SOLO Cliente en base a su DNI
	 * 
	 * *************************************** */
	public Cliente obtenerBDSoloCliente(String dniI){
		Connection sql = ConexionBD.getConexion();
		Cliente cli = null; 
		try {
			Statement s = sql.createStatement();
			ResultSet rs = s.executeQuery("Select * from Cliente where dni = '" + dniI+"'");
			while(rs.next()){							
				String codigoCliente = rs.getString("codigoCliente");
	            String nombreCliente = rs.getString("c_nombre");
	            String apellidoCliente = rs.getString("c_apellido");
	            String dniCliente = rs.getString("c_dni");
	            String generoCliente = rs.getString("c_genero");
	            String correoCliente = rs.getString("c_correo");
	            String celularCliente = rs.getString("c_celular");
	            int edadCliente = rs.getInt("c_edad");	            
	            cli = new Cliente(codigoCliente, nombreCliente, apellidoCliente, dniCliente, generoCliente, correoCliente, celularCliente, edadCliente);
            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ConexionBD.closeConexion();
		return cli;
	}
	public Cliente obtenerBDSoloClienteCod(String codi){
		Connection sql = ConexionBD.getConexion();
		Cliente cli = null; 
		try {
			Statement s = sql.createStatement();
			ResultSet rs = s.executeQuery("Select * from Cliente where codigoCliente = '" + codi+"'");
			while(rs.next()){							
				String codigoCliente = rs.getString("codigoCliente");
	            String nombreCliente = rs.getString("c_nombre");
	            String apellidoCliente = rs.getString("c_apellido");
	            String dniCliente = rs.getString("c_dni");
	            String generoCliente = rs.getString("c_genero");
	            String correoCliente = rs.getString("c_correo");
	            String celularCliente = rs.getString("c_celular");
	            int edadCliente = rs.getInt("c_edad");	            
	            cli = new Cliente(codigoCliente, nombreCliente, apellidoCliente, dniCliente, generoCliente, correoCliente, celularCliente, edadCliente);
            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ConexionBD.closeConexion();
		return cli;
	}
	
	public void actualizarBDCliente(Cliente c) {
	    Connection sql = ConexionBD.getConexion();
	    String cod = c.getCodigoCliente();
	    String nom = c.getNombreCliente();
	    String ape = c.getApellidoCliente();
	    String dni = c.getDniCliente();
	    String genero = c.getGeneroCliente();
	    String correo = c.getCorreoCliente();
	    String cel = c.getCelularCliente();
	    int edad = c.getEdadCliente();	
	    
	    String query = 
	            "UPDATE Cliente SET c_nombre = ?, c_apellido = ?, c_dni = ?, "
	            + "c_genero = ?, c_correo = ?, c_celular = ?, c_edad = ? WHERE codigoCliente = ?";	    
	    try {
	        PreparedStatement stmt = sql.prepareStatement(query);
	        stmt.setString(1, nom);
	        stmt.setString(2, ape);
	        stmt.setString(3, dni);
	        stmt.setString(4, genero);
	        stmt.setString(5, correo);
	        stmt.setString(6, cel);
	        stmt.setInt(7, edad);
	        stmt.setString(8, cod);
	        stmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }	
	    ConexionBD.closeConexion();
	}

	public boolean verificarCliente(String nro){
		Connection sql = ConexionBD.getConexion();
		boolean status=true;
		try {			
			String queryStock = "SELECT codigoCliente FROM Cliente";
			Statement stmt = sql.createStatement();
			ResultSet rs = stmt.executeQuery(queryStock);
			while(rs.next()){
				if(rs.getString("codigoCliente").equals(nro)) status = false;
			}
		} catch (Exception e) {
			System.out.print(" Error: " + e + "\n");
		}
		return status;
	}
}
