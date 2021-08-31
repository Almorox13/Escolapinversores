package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.Conexion;

public class AccionDao {

	private Conexion conexion = new Conexion();

	//--------------- consultar numero acciones ----------------//

	public String queryNumeroAcciones() {

		Connection conn = conexion.getConexion();

		try {

			PreparedStatement miSentencia = conn.prepareStatement("SELECT N_acciones FROM acciones");
			ResultSet miResultSet = miSentencia.executeQuery();
			String resultado = "";

			while (miResultSet.next()) {
				resultado = resultado + "\n  " + miResultSet.getString(1) + "\n  ";
			}
			return resultado;
		} catch (SQLException e) {
			System.out.println("Error SQL");
		}
		return null;
	}

	//--------------- consultar compra acciones ----------------//

	public double[] queryCompraAcciones() {

		Connection conn = conexion.getConexion();

		try {

			PreparedStatement miSentencia = conn.prepareStatement("SELECT Precio_compra FROM acciones");
			ResultSet miResultSet = miSentencia.executeQuery();

			double[] precios = new double[13];
			int cont = 0;

			while (miResultSet.next()) {
				precios[cont] = miResultSet.getDouble(1);
				cont++;
			}
			return precios;
		} catch (SQLException e) {
			 
			System.out.println("Error SQL");
		}
		return null;
	}

	//--------------- consultar venta acciones ----------------//

	public double[] queryVentaAcciones() {

		Connection conn = conexion.getConexion();

		try {

			PreparedStatement miSentencia = conn.prepareStatement("SELECT Precio_venta FROM acciones");
			ResultSet miResultSet = miSentencia.executeQuery();

			double[] precios = new double[13];
			int cont = 0;

			while (miResultSet.next()) {
				precios[cont] = miResultSet.getDouble(1);
				cont++;
			}
			return precios;
		} catch (SQLException e) {
			 
			System.out.println("Error SQL");
		}
		return null;
	}

	//--------------- actualizar acciones ----------------//

	public void updateAcciones() {

		Connection conn = conexion.getConexion();
		PreparedStatement miSentencia;

		try {

			for (int i = 0; i <= 12; i++) {

				double numAcciones = (double) Math.round((Math.random() * 100000 + 10000) * 100) / 100;
				double venta = (double) Math.round((Math.random() * 50 + 1) * 100) / 100;
				double compra = (double) Math.round((Math.random() * 50 + 1) * 100) / 100;

				miSentencia = conn.prepareStatement("UPDATE acciones SET N_acciones = '" + numAcciones
						+ "', Precio_compra = '" + compra + "', Precio_venta = '" + venta + "' WHERE ID = " + i);
				miSentencia.executeUpdate();
			}

		} catch (SQLException e) {
			 
			System.out.println("Error SQL");
		}
	}

	//---------------  consultar id accion ----------------//

	public int queryId(double precio, String CV) {

		Connection conn = conexion.getConexion();
		PreparedStatement miSentencia;

		try {
			System.out.println(precio);
			miSentencia = conn.prepareStatement("SELECT ID FROM acciones WHERE " + CV + " = " + precio +";");
			ResultSet rs = miSentencia.executeQuery();
			
			if(rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			 
			System.out.println("Error SQL");
		}
		return 0;
	}
	
	//---------------  consultar precio accion ----------------//
	
	public double queryPrecio(int id, String CV) {

		Connection conn = conexion.getConexion();
		PreparedStatement miSentencia;

		try {

			miSentencia = conn.prepareStatement("SELECT " + CV + " FROM acciones WHERE ID = " + id + ";");
			ResultSet rs = miSentencia.executeQuery();
			
			if(rs.next()) {
				return rs.getDouble(1);
			}
		} catch (SQLException e) {
			 
			System.out.println("Error SQL");
		}
		return 0;
	}
}
