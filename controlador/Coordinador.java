package controlador;

import modelo.Logica;
import modelo.vo.ClienteVo;
import modelo.vo.CuentaVo;
import modelo.vo.MovimientoVo;
import vista.ComprarAcciones;
import vista.ConsultarDatosPersonales;
import vista.CotizacionesTiempoReal;
import vista.DarseDeBajaOperador;
import vista.Historial;
import vista.HistorialOperador;
import vista.Inicio;
import vista.Login;
import vista.ModificarDatos;
import vista.Operarios;
import vista.Registro;
import vista.Usuarios;
import vista.VentaAcciones;
import vista.CancelarOrdenes;
import vista.CancelarOrdenesOperario;
import vista.CarteraAcciones;
import vista.Cartera_accionesOperador;
import vista.RetirarDinero;
import vista.Saldo;

public class Coordinador {

	private Logica logica;

	private Inicio ventanaInicio;
	private Login ventanaLogin;
	private Registro ventanaRegistro;
	private Usuarios ventanaUsuarios;
	private CotizacionesTiempoReal ventanaCotizaciones;
	private ComprarAcciones ventanaComprarAcciones;
	private VentaAcciones ventanaVentaAcciones;
	private ConsultarDatosPersonales ventanaDatosPersonales;
	private Historial ventanaHistorial;
	private CarteraAcciones ventanacarteraacciones;
	private RetirarDinero ventanaretirardinero;
	private Saldo ventanasaldocuenta;
	private CancelarOrdenes cancelarOrdenes;
	private Operarios ventanaOperarios;
	private CancelarOrdenesOperario ventanaCancelarOrdenesOperario;
	private Cartera_accionesOperador accionesOperador;
	private HistorialOperador historialoperador;
	private DarseDeBajaOperador darsebajaoperador;
	private ModificarDatos datos;

	public void setLogica(Logica logica) { // set logica
		this.logica = logica;
	}

	public Logica getLogica() { // get logica
		return logica;
	}

	// ---------------------ventana Inicio---------------------//

	public void setVentanaInicio(Inicio ventanaInicio) { // set
		this.ventanaInicio = ventanaInicio;
	}

	public Inicio getVentanaInicio() { // get
		return ventanaInicio;
	}

	public void mostrarVentanaIncio() {
		ventanaInicio.getFrame().setVisible(true); // mostrar
	}

	public void ocultarVentanaIncio() {
		ventanaInicio.getFrame().setVisible(false); // ocultar
	}

	// ---------------------ventana Login---------------------//

	public void setVentanaLogin(Login ventanaLogin) { // set
		this.ventanaLogin = ventanaLogin;
	}

	public Login getVentanaLogin() { // get
		return ventanaLogin;
	}

	public void mostrarVentanaLogin() {
		ventanaLogin.getFrame().setVisible(true); // mostrar
	}

	public void ocultarVentanaLogin() {
		ventanaLogin.getFrame().setVisible(false); // ocultar
	}

	public int login(ClienteVo clienteVo) { // validar Login
		return logica.validarLogin(clienteVo);
	}

	public void cargar(String dni) {
		logica.cargar(dni);
	}

	// ---------------------ventana Registro---------------------//

	public void setVentanaRegistro(Registro ventanaRegistro) { // set
		this.ventanaRegistro = ventanaRegistro;
	}

	public Registro getVentanaRegistro() { // get
		return ventanaRegistro;
	}

	public void mostrarVentanaRegistro() {
		ventanaRegistro.getFrame().setVisible(true); // mostrar
	}

	public void ocultarVentanaRegistro() {
		ventanaRegistro.getFrame().setVisible(false); // ocultar
	}

	public int registro(ClienteVo clienteVo) {
		return logica.validarRegistro(clienteVo);
	}

	public int crearCuenta(CuentaVo cuentaVo) {
		return logica.crearCuenta(cuentaVo);
	}

	// ---------------------ventana Usuarios---------------------//

	public void setVentanaUsuarios(Usuarios ventanaUsuarios) { // set
		this.ventanaUsuarios = ventanaUsuarios;
	}

	public Usuarios getVentanaUsuarios() { // get
		return ventanaUsuarios;
	}

	public void mostrarVentanaUsuarios() {
		ventanaUsuarios.getFrame().setVisible(true);
	}

	public void ocultarVentanaUsuarios() {
		ventanaUsuarios.getFrame().setVisible(false);
	}

	// ---------------------ventana Cotizaciones---------------------//

	public void setVentanaCotizaciones(CotizacionesTiempoReal ventanaCotizaciones) {
		this.ventanaCotizaciones = ventanaCotizaciones;
	}

	public CotizacionesTiempoReal getVentanaCotizaciones() {
		return ventanaCotizaciones;
	}

	public void mostrarVentanaCotizaciones() {
		ventanaCotizaciones.getFrame().setVisible(true);
	}

	public void ocultarVentanaCotizaciones() {
		ventanaCotizaciones.getFrame().setVisible(false);
	}

	public String consultarNumAcciones() {
		return logica.numAcciones();
	}

	public String consultarCompraAcciones() {
		return logica.precioCompraAcciones();
	}

	public String consultarVentaAcciones() {
		return logica.precioVentaAcciones();
	}

	public void actualizarAcciones() {
		logica.actualizarAcciones();
	}

	// ---------------------ventana Comprar acciones---------------------//

	public void setVentanaComprarAcciones(ComprarAcciones ventanaComprarAcciones) {
		this.ventanaComprarAcciones = ventanaComprarAcciones;
	}

	public ComprarAcciones getVentanaComprarAcciones() {
		return ventanaComprarAcciones;
	}

	public void mostrarVentanaComprarAcciones() {
		ventanaComprarAcciones.getFrame().setVisible(true);
	}

	public void ocultarVentanaComprarAcciones() {
		ventanaComprarAcciones.getFrame().setVisible(false);
	}

	public int consultaCompra() {
		return logica.consultarComprar();
	}

	public int consultaVenta() {
		return logica.consultarVender();
	}

	public double actualizarValor(int id, int valor) {
		return logica.actualizarValor(id, valor);
	}

	public void insertarMovimiento(MovimientoVo movimientoVo) {
		logica.insertarMovimiento(movimientoVo);
	}

	// ---------------------ventana Comprar acciones---------------------//

	public void setVentanaVentaAcciones(VentaAcciones ventanaVentaAcciones) {
		this.ventanaVentaAcciones = ventanaVentaAcciones;
	}

	public VentaAcciones getVentanaVentaAcciones() {
		return ventanaVentaAcciones;
	}

	public void mostrarVentanaVentaAcciones() {
		ventanaVentaAcciones.getFrame().setVisible(true);
	}

	public void ocultarVentanaVentaAcciones() {
		ventanaVentaAcciones.getFrame().setVisible(false);
	}

	// -------------------------Ventana ConsultarDatosPersonales--------------//

	public void setVentanaConsultarDatosPersonales(ConsultarDatosPersonales ventanadatospersonales) {
		this.ventanaDatosPersonales = ventanadatospersonales;
	}

	public void mostrarVentanaDatosPesonales() {
		ventanaDatosPersonales.getFrame().setVisible(true);
	}

	public ConsultarDatosPersonales getVentanadatospersonales() {
		return ventanaDatosPersonales;
	}

	public void ocultarVentanaDatosPersonales() {
		ventanaDatosPersonales.getFrame().setVisible(false);
	}

	// ----------------------------Ventana Historial----------------//

	public void setVentanaHistorial(Historial ventanahistorial) {
		this.ventanaHistorial = ventanahistorial;
	}

	public void mostrarVentanaHistorial() {
		ventanaHistorial.getFrame().setVisible(true);
	}

	public Historial getVentanaHistorial() {
		return ventanaHistorial;
	}

	public void ocultarVentanaHistorial() {
		ventanaHistorial.getFrame().setVisible(false);
	}

	public String[][] Consultar_Movimientos(CuentaVo Cuentavo) {

		return logica.MostrarHistorial(Cuentavo);
	}

	public String[][] Consultar_Movimientos_por_fecha(CuentaVo Cuentavo, String fecha) {

		return logica.MostrarHistorial_por_fecha(Cuentavo, fecha);
	}

	// ------------------------------VentanaSaldo_cuenta----------------------//

	public void setVentanaSaldo_cuenta(Saldo ventanasaldocuenta) {
		this.ventanasaldocuenta = ventanasaldocuenta;
	}

	public Saldo getVentanaSaldo_cuenta() {
		return ventanasaldocuenta;
	}

	public void MostrarVentanaSaldo_cuenta() {
		ventanasaldocuenta.getFrame().setVisible(true);
	}

	public void OcultarVentanaSaldo_cuenta() {
		ventanasaldocuenta.getFrame().setVisible(false);
	}

	// ---------------------Ventana_Cartera_acciones---------------------//

	public String[][] Acciones_Propiedad(CuentaVo cuentavo) {

		return logica.datosAcciones_propiedad(cuentavo);
	}

	public void setVentanaCarteraAcciones(CarteraAcciones ventanacarteraacciones) {
		this.ventanacarteraacciones = ventanacarteraacciones;
	}

	public CarteraAcciones getVentanaCarteraAcciones() {
		return ventanacarteraacciones;
	}

	public void MostrarVentanaCarteraAcciones() {
		ventanacarteraacciones.getFrame().setVisible(true);
	}

	public void OcultarVentanaCarteraAcciones() {
		ventanacarteraacciones.getFrame().setVisible(false);
	}

	// ------------------------------Ventana
	// Retirardinero-----------------------------//

	public void retirarDinero(CuentaVo cuentavo, Double dineroRetirar) {
		logica.RetirarSaldo(dineroRetirar, cuentavo);
	}

	public void setVentanaRetiradaDinero(RetirarDinero ventanaretirardinero) {
		this.ventanaretirardinero = ventanaretirardinero;
	}

	public RetirarDinero getVentanaRetirarDinero() {
		return ventanaretirardinero;
	}

	public void MostrarVentanaRetirarDinero() {
		ventanaretirardinero.getFrame().setVisible(true);
	}

	public void OcultarVentanaRetirarDinero() {
		ventanaretirardinero.getFrame().setVisible(false);
	}

	// --------------------VentanaCompra_venta----------------------//

	public void setVentanaCompra_venta(CancelarOrdenes cancelarOrdenes) {
		this.cancelarOrdenes = cancelarOrdenes;
	}

	public CancelarOrdenes getVentanaCompra_venta() {
		return cancelarOrdenes;
	}

	public void MostrarVentanaCompra_venta() {
		cancelarOrdenes.getFrame().setVisible(true);
	}

	public void OcultarVentanaCompra_venta() {
		cancelarOrdenes.getFrame().setVisible(false);
	}

	public String[][] consultarmovimientosNoValidados(int ID_Cuenta) {
		return logica.movimientosNoValidados(ID_Cuenta);
	}

	public void borrarMovimiento(int idmovimiento, int idcuenta) {
		logica.borrarMovimiento(idmovimiento, idcuenta);
	}

	// ------------------Darse de baja--------------------//

	public void darseDebajaSinConfirmacion(int ID_Cliente) {
		logica.darseDebajaSinConfirmacion(ID_Cliente);
	}

	// --------------CancelarOdenesOperario--------------//

	public void setcancelarordenesoperario(CancelarOrdenesOperario ventanaCancelarOrdenesOperario) {
		this.ventanaCancelarOrdenesOperario = ventanaCancelarOrdenesOperario;
	}

	public CancelarOrdenesOperario getcancelarordenesoperario() {
		return ventanaCancelarOrdenesOperario;
	}

	public void Mostrarcancelarordenesoperario() {
		ventanaCancelarOrdenesOperario.getFrame().setVisible(true);
	}

	public void Ocultarcancelarordenesoperario() {
		ventanaCancelarOrdenesOperario.getFrame().setVisible(false);
	}

	public void aprobarMovimiento(int idMovimiento, int idcuenta) {
		logica.AprobarMovimiento(idMovimiento, idcuenta);
	}
	// --------------------------Ventana darse de baja
	// operador---------------------//

	public void setDarseDeBajaOperador(DarseDeBajaOperador darsebajaoperador) {
		this.darsebajaoperador = darsebajaoperador;
	}

	public DarseDeBajaOperador getDarseDeBajaOperador() {
		return darsebajaoperador;
	}

	public void MostrarDarseDeBajaOperadoro() {
		darsebajaoperador.getFrame().setVisible(true);
	}

	public void OcultarDarseDeBajaOperador() {
		darsebajaoperador.getFrame().setVisible(false);
	}

	public void darsedebaja(int idCliente) {
		logica.BorrarClientes(idCliente);
	}

	public String[][] mostrarClientesBaja() {
		return logica.mostrarClientesSolicitudesdebaja();
	}

	// ---------------Ventana Cartera Acciones Operador-------------------//

	public void setcarteraaccionesoperador(Cartera_accionesOperador accionesOperador) {
		this.accionesOperador = accionesOperador;
	}

	public Cartera_accionesOperador getcarteraaccionesoperador() {
		return accionesOperador;
	}

	public void Mostrarcarteraaccionesoperador() {
		accionesOperador.getFrame().setVisible(true);
	}

	public void Ocultarcarteraaccionesoperador() {
		accionesOperador.getFrame().setVisible(false);
	}

	// ------------------Ventana HistorialOperador-------------------//

	public void sethistorialoperador(HistorialOperador historialoperador) {
		this.historialoperador = historialoperador;
	}

	public HistorialOperador gethistorialoperador() {
		return historialoperador;
	}

	public void Mostrarhistorialoperador() {
		historialoperador.getFrame().setVisible(true);
	}

	public void Ocultarhistorialoperador() {
		historialoperador.getFrame().setVisible(false);
	}

	// ---------VentanaOperadores-----------//

	public void setVentanaOperarios(Operarios ventanaOperarios) {
		this.ventanaOperarios = ventanaOperarios;
	}

	public Operarios getVentanaOperarios() {
		return ventanaOperarios;
	}

	public void mostrarVentanaOperarios() {
		ventanaOperarios.getFrame().setVisible(true);
	}

	public void ocultarVentanaOperarios() {
		ventanaOperarios.getFrame().setVisible(false);
	}

	// ---------VentanaHistorial-----------//

	public String[] getDatos(String id) {
		return logica.getDatos(id);
	}

	public void setModificarDatos(ModificarDatos datos) {
		this.datos = datos;
	}
	public void mostrarVentanaDatos() {
		datos.getFrame().setVisible(true);
	}

	public void ocultarVentanaDatos() {
		datos.getFrame().setVisible(false);
	}

	public boolean modificarDatos(String[] datos2, String id) {
		return logica.modificarDatos(datos2, id);
	}

	//------------Comprobar Supervisor-------------//

	public boolean comprobarSupervidor(String string, String string2) {
		return logica.comprobarSupervidor(string, string2);
	}

}
