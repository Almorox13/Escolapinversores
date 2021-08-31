package modelo.dao;

import java.sql.Connection;

import java.util.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import modelo.Conexion;
import modelo.vo.MovimientoVo;

public class MovimientoDao {

	private Conexion conexion = new Conexion();

	public boolean insertMovimiento(MovimientoVo movimientoVo) {

		Connection conn = conexion.getConexion();
		Date fecha = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
				
			PreparedStatement miSentencia = conn.prepareStatement("INSERT INTO movimientos (ID_Cuenta, ID_Accion, Compra_venta, Fecha_orden, Cantidad, Precio)"
					+ " VALUES ("+ movimientoVo.getIdCuenta() +", "+ movimientoVo.getIdAccion() +", '" + movimientoVo.getCompraVenta() + "', '" + formatoFecha.format(fecha) +
					"', "+ movimientoVo.getCantidad() +", " + movimientoVo.getPrecio() + ");");
			
			miSentencia.execute();
			
			return true;
			
		} catch (SQLException e) {
			System.out.println("Error SQL");
		}
		return false;
	}
	
	//----------------Consultar movimientos no validados------------------//
	
	public String[][] ConsultarMovimientosNovalidados(int ID_Cuenta) {
		Connection conn = conexion.getConexion();
		int contfilas = 1;
		PreparedStatement miSentencia;
		String[][] datosMovimientos = new String[50][7];

		for (int y = 0; y < 50; y++) { // rellenar el array de string vacios (quitar null)
			for (int x = 0; x < 7; x++) {
				datosMovimientos[y][x] = "";
			}
		}
		System.out.println(ID_Cuenta);

		try {
			if (ID_Cuenta != 0) {
								
				miSentencia = conn.prepareStatement("SELECT * FROM movimientos WHERE ID_Cuenta = " + ID_Cuenta
						+ " AND Validacion=0 ORDER BY Fecha_orden DESC");
			} else {
				miSentencia = conn
						.prepareStatement("SELECT * FROM movimientos WHERE Validacion=0 ORDER BY Fecha_orden DESC");
			}
			ResultSet miResultSet = miSentencia.executeQuery();
			while (miResultSet.next()) {

				datosMovimientos[contfilas][1] = miResultSet.getInt("ID") + "";
				datosMovimientos[contfilas][2] = miResultSet.getInt("ID_Accion") + "";
				datosMovimientos[contfilas][3] = miResultSet.getString("Compra_venta") + "";
				datosMovimientos[contfilas][4] = miResultSet.getInt("Cantidad") + "";
				datosMovimientos[contfilas][5] = miResultSet.getInt("Precio") + "";
				datosMovimientos[contfilas][6] = miResultSet.getDate("Fecha_orden") + "";
				contfilas++;
			}

			conn.close();
			return datosMovimientos;

		} catch (SQLException e) {
			System.out.println("error ConsultarMovimientosNovalidados");
			return datosMovimientos;
		}

	}

	public void borrarMovimientos(int ID) {
		Connection conn = conexion.getConexion();
		try {
			PreparedStatement miSentencia = conn
					.prepareStatement("delete from movimientos where ID=" + ID);
			miSentencia.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Error borrarMovimientos");
		}
	}

	public boolean ExisteMovimiento(int ID) {
		Connection conn = conexion.getConexion();
		PreparedStatement miSentencia;
		try {
			miSentencia = conn.prepareStatement("SELECT * FROM movimientos WHERE ID=" + ID);
			ResultSet miResultSet = miSentencia.executeQuery();
			while (miResultSet.next()) {

				return true;
			}
		} catch (SQLException e) {
			System.out.println("Error existeMovimiento");
			return false;
		}
		return false;

	}

}
