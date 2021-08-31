package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.Conexion;
import modelo.vo.ClienteVo;
import modelo.vo.CuentaVo;

public class ClienteDao {

	private Conexion conexion = new Conexion();

	//--------------- comprobar login ----------------//

	public int queryLogin(ClienteVo clienteVo) {

		Connection conn = conexion.getConexion();

		try {

			PreparedStatement miSentencia = conn.prepareStatement("SELECT * FROM clientes WHERE DNI='"
					+ clienteVo.getDni() + "' AND Contraseña='" + clienteVo.getContraseña() + "' ");

			ResultSet miResultSet = miSentencia.executeQuery();

			if (miResultSet.next()) {
				return miResultSet.getInt("Tipo_usuario");
			}
		} catch (SQLException e) {
			System.out.println("Error SQL");
		}
		// No existe
		return 0;
	}

	//--------------- registrar usuario ----------------//

	public int insertCliente(ClienteVo clienteVo) {

		Connection conn = conexion.getConexion();

		try {
			PreparedStatement miSentencia = conn.prepareStatement(
					"INSERT INTO clientes (Nombre,Apellido,DNI,Cuenta_real,Fecha_nacimiento,Domicilio,Telefono,Contraseña) VALUES ('"
							+ clienteVo.getNombre() + "', '" + clienteVo.getApellido() + "', '" + clienteVo.getDni()
							+ "', " + "'" + clienteVo.getCuentaReal() + "', '" + clienteVo.getFechaNacimiento() + "', '"
							+ clienteVo.getDomicilio() + "', '" + clienteVo.getTelefono() + "', '"
							+ clienteVo.getContraseña() + "');");
			
			miSentencia.execute();

			PreparedStatement idUser = conn
					.prepareStatement("SELECT ID FROM clientes WHERE DNI = '" + clienteVo.getDni() + "';");
			ResultSet rs = idUser.executeQuery();
			int id = 0;
			if (rs.next()) {
				id = rs.getInt(1);
			}
			return id;
		} catch (SQLException e) {
			System.out.println("Error SQL");
		}
		return 0;
	}

	//--------------- cargar usuario y cuenta----------------//

	public void cargar(ClienteVo clienteVo, CuentaVo cuentaVo) {

		Connection conn = conexion.getConexion();

		try {
			PreparedStatement consulta = conn
					.prepareStatement("SELECT * FROM clientes WHERE DNI = '" + clienteVo.getDni() + "';");
			ResultSet rs = consulta.executeQuery();

			if (rs.next()) {

				clienteVo.setId(rs.getInt(1));
				clienteVo.setNombre(rs.getString(2));
				clienteVo.setApellido(rs.getString(3));
				clienteVo.setCuentaReal(rs.getString(5));
				clienteVo.setFechaNacimiento(rs.getString(6));
				clienteVo.setDomicilio(rs.getString(7));
				clienteVo.setTelefono(rs.getString(8));
				clienteVo.setContraseña(rs.getString(9));
			}
			PreparedStatement consultaCuenta = conn
					.prepareStatement("SELECT * FROM cuenta WHERE ID_Cliente = '" + clienteVo.getId() + "';");
			ResultSet res = consultaCuenta.executeQuery();

			if (res.next()) {

				cuentaVo.setId(res.getInt(1));
				cuentaVo.setIdCliente(clienteVo.getId());
				cuentaVo.setSaldo(res.getDouble(3));
				cuentaVo.setPerdidasBeneficios(res.getDouble(4));
			}
		} catch (SQLException e) {
		}
	}
	
	//--------------- Dar baja usuarios ----------------//

	public void DarseDebajaNoValidado(int ID_Cliente) {
		Connection conn = conexion.getConexion();
		try {
			PreparedStatement consulta = conn
					.prepareStatement("UPDATE clientes SET Baja=1 WHERE ID = '" + ID_Cliente + "';");
			consulta.executeUpdate();
			conn.close();
		} catch (Exception e) {
		}
	}
	
	//---------------Solicitar baja usuarios ----------------//

	public String[][] solicitudesdebaja() {
		
		Connection conn = conexion.getConexion();
		int contfilas = 0;
		int contcolum = 0;
		String[][] datosMovimientos = new String[50][7];
		
		for (int y = 0; y < 50; y++) { // rellenar el array de string vacios (quitar null)
			for (int x = 0; x < 7; x++) {
				datosMovimientos[y][x] = "";
			}
		}
		try {
			PreparedStatement consulta = conn.prepareStatement("SELECT * FROM clientes WHERE Baja=1;");
			ResultSet rs = consulta.executeQuery();
			contfilas = 1;
			while (rs.next()) {
				
				datosMovimientos[contfilas][1] = rs.getInt("ID") + "";
				datosMovimientos[contfilas][2] = rs.getString("Nombre");
				datosMovimientos[contfilas][3] = rs.getString("Apellido");
				datosMovimientos[contfilas][4] = rs.getString("DNI");
				datosMovimientos[contfilas][5] = rs.getString("Cuenta_real");
				datosMovimientos[contfilas][6] = rs.getString("Telefono");
				contfilas++;
			}
			conn.close();
			return datosMovimientos;
		} catch (SQLException e) {
			System.out.println("error solicitudesdebaja");
			return datosMovimientos;
		}
	}
	
	//--------------- Consular ID cuenta ----------------//

	public int darIDcuenta(int idcliente) {
		Connection conn = conexion.getConexion();
		try {
			PreparedStatement consulta = conn.prepareStatement("SELECT * FROM cuenta WHERE ID_Cliente=" + idcliente);
			ResultSet rs = consulta.executeQuery();

			if (rs.next()) {
				return rs.getInt("ID");
			} else {
				System.out.println("NO existe el idCLiente");
				return 0;
			}
		} catch (SQLException e) {
			System.out.println("error darIDcuenta");
			return 0;
		}
	}
	
	//---------------comprobar baja usuarios----------------//

	public boolean quiereDarsedebaja(int idCLiente) {
		Connection conn = conexion.getConexion();
		try {
			PreparedStatement consulta = conn
					.prepareStatement("SELECT * FROM clientes WHERE Baja=1 AND ID=" + idCLiente);
			ResultSet rs = consulta.executeQuery();

			if (rs.next()) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			System.out.println("error quiereDarsedebaja");
			return false;
		}
	}

	//--------------Borrar usuarios----------------//

	public void borrarClietne(int ID) {
		Connection conn = conexion.getConexion();
		try {
			PreparedStatement miSentencia = conn.prepareStatement("delete from clientes where ID =" + ID);
			miSentencia.executeUpdate();
			conn.close();
		} catch (SQLException e) {
		
			System.out.println("Error borrarAccionesEnPropiedad");
		}
	}

	//--------------Datos usuarios----------------//

	public String[] queryDatos(String id) {
		
		Connection conn = conexion.getConexion();
		String[] datos = new String[8];

		try {
			PreparedStatement consulta = conn
					.prepareStatement("SELECT * FROM clientes WHERE ID = '" + id + "';");
			ResultSet rs = consulta.executeQuery();

			if (rs.next()) {

				datos[0] = rs.getString(2);
				datos[1] = rs.getString(3);
				datos[2] = rs.getString(4);
				datos[3] = rs.getString(5);
				datos[4] = rs.getString(6);
				datos[5] = rs.getString(7);
				datos[6] = rs.getString(8);
				datos[7] = rs.getString(9);
			}
			return datos;
		} catch (SQLException e) {
		}
		return null;
	}

	public boolean updateDatos(String[] datos, String id) {
		
		Connection conn = conexion.getConexion();

		try {
			PreparedStatement consulta = conn
					.prepareStatement("UPDATE clientes SET Nombre = '" + datos[0] + "', Apellido = '" + datos[1] + "', DNI = '"
							+ datos[2] + "', Cuenta_real = '" + datos[3] + "', Fecha_nacimiento = '" + datos[4] 
									+ "', Domicilio = '" + datos[5] + "', Telefono = '" + datos[6] + "', Contraseña = '" + datos[7] + "' WHERE ID = " + id);
			
			consulta.execute();

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;	
	}

	public boolean comprobarSupervisor(String string, String string2) {

		Connection conn = conexion.getConexion();

		try {
			PreparedStatement consulta = conn
					.prepareStatement("");
			
			ResultSet rs = consulta.executeQuery("SELECT * FROM clientes WHERE DNI = '" + string + "' AND Contraseña = '" + string2 + "'");
			
			if(rs.next()) {
				
				return true;
			}
			return false;
		} catch (SQLException e) {
		}
		return false;		
	}
}
