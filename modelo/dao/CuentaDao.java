package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import modelo.Conexion;
import modelo.vo.ClienteVo;
import modelo.vo.CuentaVo;

public class CuentaDao {

	private Conexion conexion = new Conexion();

	// -------------------------Crear Cuentas-------------------------//

	public int crearCuenta(CuentaVo cuentaVo) {

		Connection conn = conexion.getConexion();

		try {

			PreparedStatement miSentencia = conn
					.prepareStatement("INSERT INTO cuenta (ID_Cliente, Saldo, Perdidas_Beneficios) VALUES " + "("
							+ cuentaVo.getIdCliente() + ", " + cuentaVo.getSaldo() + ", "
							+ cuentaVo.getPerdidasBeneficios() + ");");
			miSentencia.execute();

			PreparedStatement id = conn
					.prepareStatement("SELECT ID FROM cuenta WHERE ID_Cliente = " + cuentaVo.getIdCliente() + ";");
			ResultSet rs = id.executeQuery();

			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println("Error SQL");
		}
		return 0;
	}

	// -------------------------Consultar Movimiento-------------------------//

	public String[][] ConsultarMovimientos(CuentaVo cuentavo) {
		Connection conn = conexion.getConexion();
		int contfilas = 1;

		String[][] datosMovimientos = new String[50][7];

		for (int y = 0; y < 50; y++) { // rellenar el array de string vacios (quitar null)
			for (int x = 0; x < 7; x++) {
				datosMovimientos[y][x] = "";
			}
		}
		try {
			PreparedStatement miSentencia = conn.prepareStatement("SELECT * FROM movimientos WHERE ID_Cuenta="
					+ cuentavo.getId() + " AND Validacion=1 ORDER BY Fecha_validacion DESC");
			ResultSet miResultSet = miSentencia.executeQuery();
			while (miResultSet.next()) {

				datosMovimientos[contfilas][1] = miResultSet.getInt("ID") + "";
				datosMovimientos[contfilas][2] = miResultSet.getInt("ID_Accion") + "";
				datosMovimientos[contfilas][3] = miResultSet.getString("Compra_venta") + "";
				datosMovimientos[contfilas][4] = miResultSet.getInt("Cantidad") + "";
				datosMovimientos[contfilas][5] = miResultSet.getInt("Precio") + "";
				datosMovimientos[contfilas][6] = miResultSet.getDate("Fecha_validacion") + "";
				contfilas++;
			}
			conn.close();
			return datosMovimientos;
		} catch (SQLException e) {
			return datosMovimientos;
		}
	}

	// -------------------------Consultar Movimientos Por
	// Fecha-------------------------//

	public String[][] ConsultarMovimientos_por_fecha(CuentaVo cuentavo, String fecha) {

		Connection conn = conexion.getConexion();
		int contfilas = 1;
		String[][] datosMovimientos = new String[50][7];

		try {
			for (int y = 0; y < 50; y++) { // rellenar el array de string vacios (quitar null)
				for (int x = 0; x < 7; x++) {
					datosMovimientos[y][x] = "";
				}
			}
			PreparedStatement miSentencia = conn.prepareStatement("SELECT * FROM movimientos WHERE ID_Cuenta="
					+ cuentavo.getId() + " AND Validacion=1 AND fecha_validacion = '" + fecha
					+ "' ORDER BY Fecha_validacion DESC");

			ResultSet miResultSet = miSentencia.executeQuery();
			while (miResultSet.next()) {

				datosMovimientos[contfilas][1] = miResultSet.getInt("ID") + "";
				datosMovimientos[contfilas][2] = miResultSet.getInt("ID_Accion") + "";
				datosMovimientos[contfilas][3] = miResultSet.getString("Compra_venta") + "";
				datosMovimientos[contfilas][4] = miResultSet.getInt("Cantidad") + "";
				datosMovimientos[contfilas][5] = miResultSet.getInt("Precio") + "€";
				datosMovimientos[contfilas][6] = miResultSet.getDate("Fecha_validacion") + "";
				contfilas++;
			}
			conn.close();
			return datosMovimientos;
		} catch (SQLException e) {
			return datosMovimientos;
		}
	}

	// -------------------------Calcular Beneficios
	// Cuentas-------------------------//

	public double Calcular_Beneficios_Perdidas(CuentaVo cuentavo) {
		double gastos = 0;

		double ingresos = 0;
		Connection conn = conexion.getConexion();
		try {
			PreparedStatement miSentencia = conn.prepareStatement("SELECT * FROM movimientos WHERE ID_Cuenta="
					+ cuentavo.getId() + " AND Validacion=1 AND Compra_venta='c'");
			ResultSet miResultSet = miSentencia.executeQuery();
			while (miResultSet.next()) {
				gastos = gastos - miResultSet.getInt("Precio");
			}
			miSentencia = conn.prepareStatement("SELECT * FROM movimientos WHERE ID_Cuenta=" + cuentavo.getId()
					+ " AND Validacion=1 AND Compra_venta='v'");
			miResultSet = miSentencia.executeQuery();
			while (miResultSet.next()) {
				ingresos = ingresos + miResultSet.getInt("Precio");
			}
			conn.close();
			return ingresos - gastos;

		} catch (SQLException e) {
			System.out.println("error Calcular_Beneficios_Perdidas");
			return 0;
		}
	}

	// ----------------Leer acciones_en_propiedad-------------//

	public String[][] leerAccionesEnPropiedad(CuentaVo cuentavo) {
		Connection conn = conexion.getConexion();
		PreparedStatement id;

		int contfilas = 0;
		int contcolum = 0;
		String[][] datosAccionesPropiedad = new String[50][3];
		while (contfilas < 50) {
			while (contcolum < 3) {
				datosAccionesPropiedad[contfilas][contcolum] = " ";
				contcolum++;
			}
			contcolum = 0;
			contfilas++;
		}

		try {
			contfilas = 0;
			id = conn.prepareStatement(
					"SELECT * FROM acciones_en_propiedad WHERE ID_Cuenta = " + cuentavo.getId() + ";");
			ResultSet rs = id.executeQuery();

			while (rs.next()) {
				datosAccionesPropiedad[contfilas][1] = rs.getInt("ID_Accion") + "";
				datosAccionesPropiedad[contfilas][2] = rs.getInt("Num_acciones") + "";
				contfilas++;
			}
			return datosAccionesPropiedad;

		} catch (SQLException e) {
			System.out.println("Error leerAccionesEnPropiedad");
		}
		return datosAccionesPropiedad;

	}

	// ------------VentanaRetirarDinero------------//
	
	public boolean ReitrarDinero(Double dineroaretirar, Double saldodisponible, CuentaVo cuentavo) {
		Connection conn = conexion.getConexion();
		try {
			Double saldorestante = saldodisponible - dineroaretirar;
			cuentavo.setSaldo(saldorestante);
			PreparedStatement id;
			id = conn.prepareStatement(
					"UPDATE cuenta SET Saldo=" + saldorestante + " WHERE ID = " + cuentavo.getId() + ";");
			int i = id.executeUpdate();

			return true;
		} catch (SQLException e) {
			System.out.println("Error ReitrarDinero");
		}
		return false;
	}
	// Aprobar movimiento

	public void aprobarMovimiento(int idmovimiento, int idCuenta, int saldo) {

		Connection conn = conexion.getConexion();
		String compra_venta = "";
		Double preciototal = 0.0;
		Double preciofinal = 0.0;
		int numAccionesenpropiedad = 0;
		int idAccion = 0;
		int numAcciones = 0;
		Date fecha = new Date();
		SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
		PreparedStatement miSentencia;
		try {

			miSentencia = conn.prepareStatement("SELECT * FROM movimientos WHERE ID=" + idmovimiento);

			ResultSet miResultSet = miSentencia.executeQuery();
			if (miResultSet.next()) {

				idAccion = miResultSet.getInt("ID_Accion");
				compra_venta = miResultSet.getString("Compra_venta") + "";
				numAcciones = miResultSet.getInt("Cantidad");
				preciototal = miResultSet.getDouble("Precio");

			} else {
				System.out.println("No existe el movimiento");
			}
			miSentencia = conn.prepareStatement(
					"SELECT * FROM acciones_en_propiedad WHERE ID_Cuenta=" + idCuenta + " AND ID_Accion=" + idAccion);

			miResultSet = miSentencia.executeQuery();
			while (miResultSet.next()) {

				numAccionesenpropiedad = numAccionesenpropiedad + miResultSet.getInt("Num_acciones");

			}

			if (compra_venta.equals("c")) {
				if (saldo >= preciototal) {
					miSentencia = conn.prepareStatement("Update movimientos SET Validacion=1 ,Fecha_Validacion='"
							+ formatoFecha.format(fecha) + "' where ID=" + idmovimiento);

					miSentencia.executeUpdate();

					preciofinal = saldo - preciototal;
					// Update al saldo de la cuenta
					miSentencia = conn
							.prepareStatement("Update cuenta SET Saldo=" + preciofinal + " where ID=" + idCuenta);
					miSentencia.executeUpdate();

					// Comprobamos si la cuenta ya tiene alguna accion con el mismo id y si las
					// tiene las añadimos
					miSentencia = conn.prepareStatement("SELECT * FROM acciones_en_propiedad where ID_Cuenta="
							+ idCuenta + " AND ID_Accion=" + idAccion);
					miResultSet = miSentencia.executeQuery();
					if (miResultSet.next()) {
						// Si ya existe hacemos un update
						miSentencia = conn.prepareStatement(
								"UPDATE acciones_en_propiedad SET Num_acciones=" + miResultSet.getInt("Num_acciones")
										+ numAcciones + " where ID_Cuenta=" + idCuenta + " AND ID_Accion=" + idAccion);
						miSentencia.executeUpdate();
					} else {
						// Si no hacemos un insert
						String sql = String.format(
								"INSERT INTO acciones_en_propiedad (ID_Cuenta,ID_Accion,Num_acciones) VALUES(%s,%s,%s)",
								idCuenta, idAccion, numAcciones);
						miSentencia = conn.prepareStatement(sql);

						int resul = miSentencia.executeUpdate();
					}
				} else {
					System.out.println("Dinero insuficiente para la compra");
				}
			}
			if (compra_venta.equals("v")) {

				// Comporbamos que tnega suficientes acciones
				if (numAccionesenpropiedad >= numAcciones) {
					miSentencia = conn.prepareStatement("Update movimientos SET Validacion=1, Fecha_Validacion='"
							+ formatoFecha.format(fecha) + "' where ID=" + idmovimiento);
					miSentencia.executeUpdate();
					preciofinal = saldo + preciototal;
					// Update al saldo de la cuenta
					miSentencia = conn
							.prepareStatement("Update cuenta SET Saldo=" + preciofinal + " where ID=" + idCuenta);
					miSentencia.executeUpdate();
					if (numAccionesenpropiedad == numAcciones) {
						miSentencia = conn.prepareStatement("Delete from FROM acciones_en_propiedad WHERE ID_Cuenta="
								+ idCuenta + " AND ID_Accion=" + idAccion);

						int resul = miSentencia.executeUpdate();

					} else {
						int l = numAccionesenpropiedad - numAcciones;
						miSentencia = conn.prepareStatement("UPDATE acciones_en_propiedad SET Num_acciones=" + l
								+ " WHERE ID_Cuenta=" + idCuenta + " AND ID_Accion=" + idAccion);
						miSentencia.executeUpdate();
					}

				} else {
					System.out.println("No tienes suficientes acciones para vender");
				}
			}
			conn.close();
		} catch (SQLException e) {
			System.out.println("Error aprobarMovimiento");
		}
	}

	public void borrarAccionesEnPropiedad(int idcuenta) {

		Connection conn = conexion.getConexion();
		try {
			PreparedStatement miSentencia = conn
					.prepareStatement("delete from acciones_en_propiedad where ID_Cuenta=" + idcuenta);
			miSentencia.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			System.out.println("Error borrarAccionesEnPropiedad");
		}

	}

	public void borrarCuenta(int idcuenta) {
		Connection conn = conexion.getConexion();
		try {
			PreparedStatement miSentencia = conn.prepareStatement("delete from cuenta where ID=" + idcuenta);
			miSentencia.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			System.out.println("Error borrarAccionesEnPropiedad");
		}
	}

	public int obtenerSaldo(int idCuenta) {
		Connection conn = conexion.getConexion();
		try {
			System.out.println(idCuenta);
			PreparedStatement misentencia = conn.prepareStatement("Select * from cuenta where ID=" + idCuenta);
			ResultSet miResultSet = misentencia.executeQuery();
			if (miResultSet.next()) {
				int a =  miResultSet.getInt("Saldo");
				System.out.println(a);
				return a;

			} else {
				System.out.println("No existe el la cuenta");
				return 0;
			}
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
	}

	public boolean ExisteCuenta(int Idcuenta) {
		Connection conn = conexion.getConexion();
		try {
			PreparedStatement misentencia = conn.prepareStatement("Select * from cuenta where ID=" + Idcuenta);
			ResultSet miResultSet = misentencia.executeQuery();
			if (miResultSet.next()) {
				return true;

			} else {
				System.out.println("No existe el la cuenta");
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
}
