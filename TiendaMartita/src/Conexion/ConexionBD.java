package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
	
	private static final String CONTROLADOR = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/TiendaMartita";
	private static final String USUARIO = "root";
	private static final String CLAVE = "root";
	private static Connection sql;	
	public static Connection getConexion(){
		try {
			Class.forName(CONTROLADOR);			
			sql = DriverManager.getConnection(URL, USUARIO, CLAVE);
			System.out.print("Ok -");
		}catch (Exception e) {
			System.out.print("Mal -");
			e.printStackTrace();
		}
		return sql;
	}
	public static void closeConexion(){
		if(sql != null){
			try {
				sql.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
	}
	public static void main(String[] args) {
		getConexion();
	}

}
