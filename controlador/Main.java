package controlador;

import modelo.Logica;
import vista.CancelarOrdenes;
import vista.CancelarOrdenesOperario;
import vista.CarteraAcciones;
import vista.Cartera_accionesOperador;
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
import vista.RetirarDinero;
import vista.Saldo;
import vista.Usuarios;
import vista.VentaAcciones;

public class Main {
	
	private Logica logica;  //logica
	private Coordinador coordinador;  //coordinador
	
	private Inicio ventanaInicio;
	private Login ventanaLogin;
	private Registro ventanaRegistro;
	private Usuarios ventanaUsuarios;
	private CotizacionesTiempoReal ventanaCotizaciones;
	private ComprarAcciones ventanaComprarAcciones;
	private VentaAcciones ventanaVentaAcciones;
	private ConsultarDatosPersonales ventanaDatosPersonales;
	private Historial ventanaHistorial;
	private RetirarDinero ventanaRetirarDinero;
	private Saldo ventanaSaldo;
	private CarteraAcciones ventanaCartera;
	private CancelarOrdenes cancelarOrdenes;
	private Operarios ventanaOperarios;
	private CancelarOrdenesOperario ventanaCancelarOrdenesOperario;
	private Cartera_accionesOperador ventanaCartera_accionesOperador;
	private DarseDeBajaOperador bajaOperador;
	private HistorialOperador historialOperador;
	private ModificarDatos datos;
	

	public static void main(String[] args) {
		
		Main main = new Main();	
		main.iniciar();
	}
	
	public void iniciar(){
		
		logica = new Logica();
		coordinador = new Coordinador();
		
		//coordinador a lógica
		logica.setCoordinador(coordinador);
		
		//lógica a coordinador
		coordinador.setLogica(logica);
		
		//instancia ventanas
		ventanaInicio = new Inicio();
		ventanaLogin = new Login();
		ventanaRegistro = new Registro();
		ventanaUsuarios = new Usuarios();
		ventanaCotizaciones = new CotizacionesTiempoReal();
		ventanaComprarAcciones = new ComprarAcciones();
		ventanaVentaAcciones = new VentaAcciones();
		ventanaDatosPersonales = new ConsultarDatosPersonales();
		ventanaHistorial = new Historial();
		ventanaCartera = new CarteraAcciones();
		ventanaRetirarDinero = new RetirarDinero();
		ventanaSaldo = new Saldo();
		cancelarOrdenes = new CancelarOrdenes();
		ventanaOperarios = new Operarios();
		ventanaCancelarOrdenesOperario = new CancelarOrdenesOperario();
		ventanaCartera_accionesOperador = new Cartera_accionesOperador();
		bajaOperador = new DarseDeBajaOperador();
		historialOperador = new HistorialOperador();
		datos = new ModificarDatos();
		
		//ventanas a coordinador
		coordinador.setVentanaInicio(ventanaInicio);
		coordinador.setVentanaLogin(ventanaLogin);
		coordinador.setVentanaRegistro(ventanaRegistro);
		coordinador.setVentanaUsuarios(ventanaUsuarios);
		coordinador.setVentanaCotizaciones(ventanaCotizaciones);
		coordinador.setVentanaComprarAcciones(ventanaComprarAcciones);
		coordinador.setVentanaVentaAcciones(ventanaVentaAcciones);
		coordinador.setVentanaConsultarDatosPersonales(ventanaDatosPersonales);
		coordinador.setVentanaHistorial(ventanaHistorial);
		coordinador.setVentanaCarteraAcciones(ventanaCartera);
		coordinador.setVentanaRetiradaDinero(ventanaRetirarDinero);
		coordinador.setVentanaSaldo_cuenta(ventanaSaldo);
		coordinador.setVentanaCompra_venta(cancelarOrdenes);
		coordinador.setVentanaOperarios(ventanaOperarios);
		coordinador.setcancelarordenesoperario(ventanaCancelarOrdenesOperario);
		coordinador.setcarteraaccionesoperador(ventanaCartera_accionesOperador);
		coordinador.setDarseDeBajaOperador(bajaOperador);
		coordinador.sethistorialoperador(historialOperador);
		coordinador.setModificarDatos(datos);
		
		//coordinador a ventanas
		ventanaInicio.setCoordinator(coordinador);
		ventanaLogin.setCoordinator(coordinador);
		ventanaRegistro.setCoordinator(coordinador);
		ventanaUsuarios.setCoordinador(coordinador);
		ventanaCotizaciones.setCoordinador(coordinador);
		ventanaComprarAcciones.setCoordinador(coordinador);
		ventanaVentaAcciones.setCoordinador(coordinador);
		ventanaDatosPersonales.setCoordinador(coordinador);
		ventanaHistorial.setCoordinator(coordinador);
		ventanaCartera.setCoordinador(coordinador);
		ventanaSaldo.setCoordinador(coordinador);
		ventanaRetirarDinero.setCoordinator(coordinador);
		cancelarOrdenes.setCoordinator(coordinador);
		ventanaOperarios.setCoordinador(coordinador);
		ventanaCancelarOrdenesOperario.setCoordinator(coordinador);
		ventanaCartera_accionesOperador.setCoordinador(coordinador);
		bajaOperador.setCoordinator(coordinador);
		historialOperador.setCoordinator(coordinador);
		datos.setCoordinator(coordinador);
		
		ventanaInicio.getFrame().setVisible(true);
	}
}
