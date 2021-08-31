package modelo.vo;

public class CuentaVo {
	
	private static CuentaVo cuentaVo;
	private int id;
	private int idCliente;
	private double saldo;
	private double perdidasBeneficios;
	
	// El constructor es privado, no permite que se genere un constructor por defecto.
    private CuentaVo(int idCliente) {
        this.idCliente = idCliente;
    }

    public static CuentaVo getSingletonInstance(int idCliente) {
        if (cuentaVo == null){
        	cuentaVo = new CuentaVo(idCliente);
        }
        return cuentaVo;
    }
    
    public static void destroy() {
    
    	cuentaVo = null;
    }
//------------ID Cuenta----------------//

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
//------------ID Cliente----------------//

	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	
//------------Balance----------------//

	public double getPerdidasBeneficios() {
		return perdidasBeneficios;
	}
	public void setPerdidasBeneficios(double perdidasBeneficios) {
		this.perdidasBeneficios = perdidasBeneficios;
	}
	
//------------Saldo----------------//

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public double getSaldo() {
		return saldo;
	}
}
