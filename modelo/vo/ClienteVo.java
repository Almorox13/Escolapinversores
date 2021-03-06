package modelo.vo;

public class ClienteVo {
	
	private static ClienteVo clienteVo;
	
	private int id;
	private String nombre;
	private String apellido;
	private String dni;
	private String cuentaReal;
	private String fechaNacimiento;
	private String domicilio;
	private String telefono;
	private String contraseņa;
	
// El constructor es privado, no permite que se genere un constructor por defecto.
    private ClienteVo(String dni, String contraseņa) {
        this.dni = dni;
        this.contraseņa = contraseņa;
    }

    public static ClienteVo getSingletonInstance(String dni, String contraseņa) {
        if (clienteVo == null){
        	clienteVo = new ClienteVo(dni, contraseņa);
        }
        return clienteVo;
    }
    
    public static void destroy() {
    
    	clienteVo = null;
    }
	
//------------ID Cliente----------------//
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

//------------Nombre Cliente----------------//
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

//------------Apellido Cliente----------------//

	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
//------------DNI Cliente----------------//
	
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	
//------------Cuenta Real Cliente----------------//

	public String getCuentaReal() {
		return cuentaReal;
	}
	
	public void setCuentaReal(String cuentaReal) {
		this.cuentaReal = cuentaReal;
	}
	
//------------Fecha Cliente----------------//

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
//------------Domicilio Cliente----------------//
	
	public String getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

//------------Telefono Cliente----------------//
	
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

//------------Contraseņa Cliente----------------//

	public String getContraseņa() {
		return contraseņa;
	}
	public void setContraseņa(String contraseņa) {
		this.contraseņa = contraseņa;
	}
}
