package modelo;

import java.util.Arrays;

import javax.swing.JOptionPane;

import controlador.Coordinador;
import modelo.dao.AccionDao;
import modelo.dao.ClienteDao;
import modelo.dao.CuentaDao;
import modelo.dao.MovimientoDao;
import modelo.vo.ClienteVo;
import modelo.vo.CuentaVo;
import modelo.vo.MovimientoVo;

public class Logica {

	private Coordinador coordinador;

	public void setCoordinador(Coordinador coordinador) { // set coordinador
		this.coordinador = coordinador;
	}

	public Coordinador getCoordinador() { // get coordinador
		return coordinador;
	}

	//------------- Logica Login ---------------//

	public int validarLogin(ClienteVo clienteVo) {

		ClienteDao clienteDao = new ClienteDao();

		if (clienteVo.getDni().length() == 9) {
			int rango = clienteDao.queryLogin(clienteVo);
			if (rango != 0) {

				return rango;
			} else {

				JOptionPane.showMessageDialog(null, "Usuario o Contraseña incorrecto", "Información",
						JOptionPane.INFORMATION_MESSAGE);
				ClienteVo.destroy(); // dado que el cliente no existe eliminamos el objeto singleton
				CuentaVo.destroy();
				return 0;
			}
		} else {
			JOptionPane.showMessageDialog(null, "DNI no válido", "Información", JOptionPane.INFORMATION_MESSAGE);
			ClienteVo.destroy(); // dado que el cliente no existe eliminamos el objeto singleton
			CuentaVo.destroy();
			return 0;
		}
	}

	public void cargar(String dni) {

		ClienteVo clienteVo = ClienteVo.getSingletonInstance("", "");
		CuentaVo cuentaVo = CuentaVo.getSingletonInstance(0);

		ClienteDao clienteDao = new ClienteDao();
		clienteDao.cargar(clienteVo, cuentaVo);
	}

	//------------- Logica Registro ---------------//

	public int validarRegistro(ClienteVo clienteVo) {

		ClienteDao clienteDao = new ClienteDao();

		if (clienteVo.getDni().length() == 9) {

			if (clienteVo.getDni().length() == 9) {

				int id = clienteDao.insertCliente(clienteVo);
				
				if (!((id) == 0)) {

					JOptionPane.showMessageDialog(null, "Cliente Registrado", "Información",
							JOptionPane.INFORMATION_MESSAGE);
					return id;
				} else {
					JOptionPane.showMessageDialog(null, "No se ha registrado, error en la inserción", "Información",
							JOptionPane.INFORMATION_MESSAGE);
					ClienteVo.destroy(); // dado que el cliente no existe eliminamos el objeto singleton
					return 0;
				}
			} else {
				JOptionPane.showMessageDialog(null, "Teléfono no válido", "Información",
						JOptionPane.INFORMATION_MESSAGE);
				ClienteVo.destroy(); // dado que el cliente no existe eliminamos el objeto singleton
				return 0;
			}
		} else {
			JOptionPane.showMessageDialog(null, "DNI no válido", "Información", JOptionPane.INFORMATION_MESSAGE);
			ClienteVo.destroy(); // dado que el cliente no existe eliminamos el objeto singleton
			return 0;
		}
	}

	//------------- Logica Cotizaciones ---------------//

	public String numAcciones() {

		AccionDao accionDao = new AccionDao();
		return accionDao.queryNumeroAcciones();
	}

	public String precioCompraAcciones() {

		AccionDao accionDao = new AccionDao();
		String resultado = "";
		double[] precios = accionDao.queryCompraAcciones();

		for (int i = 0; i <= 12; i++) {

			resultado = resultado + "\n  " + precios[i] + "\n  ";
		}
		return resultado;
	}

	public String precioVentaAcciones() {

		AccionDao accionDao = new AccionDao();
		String resultado = "";
		double[] precios = accionDao.queryVentaAcciones();

		for (int i = 0; i <= 12; i++) {

			resultado = resultado + "\n  " + precios[i] + "\n  ";
		}
		return resultado;
	}

	public void actualizarAcciones() {

		AccionDao accionDao = new AccionDao();
		accionDao.updateAcciones();
	}

	//------------- Logica Comprar ---------------//

	public int consultarComprar() {

		AccionDao accionDao = new AccionDao();
		
		double[] precios = accionDao.queryCompraAcciones();
		Arrays.sort(precios);
		System.out.println(precios[1]);

		return accionDao.queryId(precios[1], "Precio_compra");
	}

	//------------- Logica Vender ---------------//

	public int consultarVender() {

		AccionDao accionDao = new AccionDao();
		double[] precios = accionDao.queryVentaAcciones();
		Arrays.sort(precios);

		int a = accionDao.queryId(precios[12], "Precio_venta");

		return a;
	}

	//------------- Logica Actualizar precio ---------------//

	public double actualizarValor(int id, int valor) {

		AccionDao accionDao = new AccionDao();
		double precio = accionDao.queryPrecio(id, "Precio_compra");

		return precio * valor;
	}

	//------------- Logica Crear Cuenta ---------------//

	public int crearCuenta(CuentaVo cuentaVo) {

		CuentaDao cuentaDao = new CuentaDao();
		return cuentaDao.crearCuenta(cuentaVo);
	}

	//------------- Logica Insertar Movimiento ---------------//

	public void insertarMovimiento(MovimientoVo movimientoVo) {

		MovimientoDao movimientoDao = new MovimientoDao();
		if (movimientoDao.insertMovimiento(movimientoVo)) {

			JOptionPane.showMessageDialog(null, "Órden emitida", "Información", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	//-----------------Lógica Historial--------------//

	public String[][] MostrarHistorial(CuentaVo cuentavo) {

		CuentaDao cuentadao = new CuentaDao();
		return cuentadao.ConsultarMovimientos(cuentavo);
	}

	public String[][] MostrarHistorial_por_fecha(CuentaVo cuentavo, String fecha) {

		CuentaDao cuentadao = new CuentaDao();
		return cuentadao.ConsultarMovimientos_por_fecha(cuentavo, fecha);
	}

	//----------------RetirarSaldo------------//

	public void RetirarSaldo(Double dinero_retirado, CuentaVo cuentavo) {
		
		CuentaDao cuentadao = new CuentaDao();
		
		if (cuentavo.getSaldo() >= dinero_retirado) {
			
			if (cuentadao.ReitrarDinero(dinero_retirado, cuentavo.getSaldo(), cuentavo)) {
				
				JOptionPane.showMessageDialog(null, "Dinero Retirado", "Información", JOptionPane.INFORMATION_MESSAGE);
			}
		} else {
			System.out.println("No puedes retirar esa cantidad de dinero");
		}
	}

	//------------------MostrarMovimientoNoValidados------------//

	public String[][] movimientosNoValidados(int ID_cuenta) {
		MovimientoDao movimientosdao = new MovimientoDao();
		return movimientosdao.ConsultarMovimientosNovalidados(ID_cuenta);
	}

	//-----------------borrarmovimiento-------------//
	
	public void borrarMovimiento(int idMovimiento, int idcuenta) {
		
		MovimientoDao movimientosdao = new MovimientoDao();
		
		if (movimientosdao.ExisteMovimiento(idMovimiento)) {
			movimientosdao.borrarMovimientos(idMovimiento);
		} else {
			System.out.println("No existe el ID del movimiento");
		}
	}

	//----------------darseBAja--------------//
	
	public void darseDebajaSinConfirmacion(int ID_Cliente) {
		ClienteDao clienteDao = new ClienteDao();
		clienteDao.DarseDebajaNoValidado(ID_Cliente);
	}

	// -------------AprobarMovimientos------------//
	
	public void AprobarMovimiento(int idMovimiento, int idCuenta) {
		
		CuentaDao cuentadao = new CuentaDao();
		MovimientoDao movimientosdao = new MovimientoDao();
		
		if (movimientosdao.ExisteMovimiento(idMovimiento)) {
			
			cuentadao.aprobarMovimiento(idMovimiento, idCuenta, cuentadao.obtenerSaldo(idCuenta));
		} else {
			System.out.println("No existe el ID del movimiento");
		}
	}

	// ----------------MostrarClientes--------------//
	
	public String[][] mostrarClientesSolicitudesdebaja() {
		ClienteDao clientedao = new ClienteDao();
		return clientedao.solicitudesdebaja();
	}

	// -------------BorrarCLientes-----------//
	
	public void BorrarClientes(int idcliente) {
		
		CuentaDao cuentadao = new CuentaDao();
		MovimientoDao movimientosdao = new MovimientoDao();
		ClienteDao clientedao = new ClienteDao();
		
		if (clientedao.quiereDarsedebaja(idcliente)) {
			
			cuentadao.borrarAccionesEnPropiedad(clientedao.darIDcuenta(idcliente));
			movimientosdao.borrarMovimientos(clientedao.darIDcuenta(idcliente));
			cuentadao.borrarCuenta(clientedao.darIDcuenta(idcliente));
			clientedao.borrarClietne(idcliente);
		} else {
			System.out.println("El cliente no se quiere dar de baja");
		}
	}
	
	// ------------------Logica leer acciones en propiedad----------------------//

	public String[][] datosAcciones_propiedad(CuentaVo cuentavo) {

		CuentaDao cuentadao = new CuentaDao();
		
		if (cuentadao.ExisteCuenta(cuentavo.getId())) {
			return cuentadao.leerAccionesEnPropiedad(cuentavo);
		} else {
			return null;
		}
	}
	
	// ------------------Logica obtener Datos Cliente----------------------//

	public String[] getDatos(String id) {
		ClienteDao clienteDao = new ClienteDao();
		return clienteDao.queryDatos(id);
	}

	public boolean modificarDatos(String[] datos, String id) {
		ClienteDao clienteDao = new ClienteDao();
		return clienteDao.updateDatos(datos, id);
	}

	public boolean comprobarSupervidor(String string, String string2) {
		ClienteDao clienteDao = new ClienteDao();
		return clienteDao.comprobarSupervisor(string, string2);
	}
}
