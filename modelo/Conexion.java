package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	
	private Connection conexion;
	
	public Conexion() {
		conexion = conectarBD();
	}
	
	//Crear conexión con la base de datos
	private Connection conectarBD(){
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/escolapinversores", "root", "");
				return conexion;
	
			} catch (SQLException e) {
				System.out.println("Error en la base de datos");
			} catch (ClassNotFoundException e) {
				System.out.println("Error en el driver");
			}
			return null;
	}
	//Getter
	public Connection getConexion() {
		return conexion;
	}
	//Setter
	public void setConexion(Connection conexion) {
		this.conexion = conexion;
	}
}
