package modelo.vo;

public class AccionVo {
	
	private String nombreEmpresa;
	private int id;
	private int numAcciones;
	private double precioVenta;
	private double precioCompra;
	
//-------------- id ---------------//
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
//-------------- nombre ---------------//

	public String getNombreEmpresa() {
		return nombreEmpresa;
	}
	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}
	
//-------------- numero ---------------//

	public int getNumAcciones() {
		return numAcciones;
	}
	public void setNumAcciones(int numAcciones) {
		this.numAcciones = numAcciones;
	}
	
//-------------- venta ---------------//
	
	public double getPrecioVenta() {
		return precioVenta;
	}
	public void setPrecioVenta(double precioVenta) {
		this.precioVenta = precioVenta;
	}
	
//-------------- compra ---------------//

	public double getPrecioCompra() {
		return precioCompra;
	}
	public void setPrecioCompra(double precioCompra) {
		this.precioCompra = precioCompra;
	}
}
