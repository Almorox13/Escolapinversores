package modelo.vo;

public class MovimientoVo {
	
	private int id;
	private int idCuenta;
	private int idAccion;
	private char compraVenta;
	private String fechaOrden;
	private String fechaValidacion;
	private int cantidad;
	private double precio;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public int getIdCuenta() {
		return idCuenta;
	}
	public void setIdCuenta(int idCuenta) {
		this.idCuenta = idCuenta;
	}
	
	
	public int getIdAccion() {
		return idAccion;
	}
	public void setIdAccion(int idAccion) {
		this.idAccion = idAccion;
	}
	
	
	public char getCompraVenta() {
		return compraVenta;
	}
	public void setCompraVenta(char compraVenta) {
		this.compraVenta = compraVenta;
	}
	
	
	public String getFechaOrden() {
		return fechaOrden;
	}
	public void setFechaOrden(String fechaOrden) {
		this.fechaOrden = fechaOrden;
	}
	
	
	public String getFechaValidacion() {
		return fechaValidacion;
	}
	public void setFechaValidacion(String fechaValidacion) {
		this.fechaValidacion = fechaValidacion;
	}
	
	
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
}
