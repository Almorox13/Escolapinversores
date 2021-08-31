package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Coordinador;
import modelo.vo.ClienteVo;
import modelo.vo.CuentaVo;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;

public class Registro extends JFrame {
	/*
	 * caja_nombre
	 * caja_apellido
	 * caja_dni
	 * caja_cuentareal
	 * caja_fechanacimiento
	 * caja_domicilio
	 * caja_telefono
	 * caja_contraseña*/

	private JPanel contentPane;
	private JTextField caja_nombre;
	private JTextField caja_apellido;
	private JTextField caja_dni;
	private JTextField caja_cuentareal;
	private JTextField caja_fechanacimiento;
	private JTextField caja_domicilio;
	private JTextField caja_telefono;
	private JTextField caja_contraseña;
	private JButton Boton_registrar;
	private JFrame frame;
	private Coordinador coordinador;
	private Color fondo= new Color(214, 234, 248);
	
	public JFrame getFrame() {
		return frame;
	}
	
	public void setCoordinator(Coordinador coordinador) {
		this.coordinador = coordinador;
	}

	public Registro() {
		frame = new JFrame();
		frame.setBounds(800, 100, 877, 750);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		contentPane.setBackground(fondo);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 25));
		lblNewLabel.setForeground(new Color(0, 102, 153));
		lblNewLabel.setBounds(43, 38, 105, 36);
		contentPane.add(lblNewLabel);
		
		caja_nombre = new JTextField();
		caja_nombre.setBorder(null);
		caja_nombre.setFont(new Font("Calibri", Font.BOLD, 25));
		caja_nombre.setBounds(247, 38, 224, 34);
		contentPane.add(caja_nombre);
		caja_nombre.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Apellido");
		lblNewLabel_1.setForeground(new Color(0, 102, 153));
		lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD, 25));
		lblNewLabel_1.setBounds(43, 108, 135, 42);
		contentPane.add(lblNewLabel_1);
		
		caja_apellido = new JTextField();
		caja_apellido.setFont(new Font("Calibri", Font.BOLD, 25));
		caja_apellido.setBorder(null);
		caja_apellido.setBounds(247, 108, 224, 34);
		contentPane.add(caja_apellido);
		caja_apellido.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("DNI");
		lblNewLabel_2.setFont(new Font("Calibri", Font.BOLD, 25));
		lblNewLabel_2.setForeground(new Color(0, 102, 153));
		lblNewLabel_2.setBounds(43, 169, 105, 50);
		contentPane.add(lblNewLabel_2);
		
		caja_dni = new JTextField();
		caja_dni.setBorder(null);
		caja_dni.setFont(new Font("Calibri", Font.BOLD, 25));
		caja_dni.setBounds(247, 176, 224, 36);
		contentPane.add(caja_dni);
		caja_dni.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("IBAN");
		lblNewLabel_3.setFont(new Font("Calibri", Font.BOLD, 25));
		lblNewLabel_3.setForeground(new Color(0, 102, 153));
		lblNewLabel_3.setBounds(43, 451, 135, 50);
		contentPane.add(lblNewLabel_3);
		
		caja_cuentareal = new JTextField();
		caja_cuentareal.setFont(new Font("Calibri", Font.BOLD, 25));
		caja_cuentareal.setBorder(null);
		caja_cuentareal.setBounds(247, 456, 224, 36);
		contentPane.add(caja_cuentareal);
		caja_cuentareal.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Nacimiento");
		lblNewLabel_4.setForeground(new Color(0, 102, 153));
		lblNewLabel_4.setFont(new Font("Calibri", Font.BOLD, 25));
		lblNewLabel_4.setBounds(43, 315, 252, 42);
		contentPane.add(lblNewLabel_4);
		
		caja_fechanacimiento = new JTextField();
		caja_fechanacimiento.setText("aaaa-mm-dd");
		caja_fechanacimiento.setBorder(null);
		caja_fechanacimiento.setFont(new Font("Calibri", Font.BOLD, 25));
		caja_fechanacimiento.setBounds(247, 315, 224, 37);
		contentPane.add(caja_fechanacimiento);
		caja_fechanacimiento.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Domicilio");
		lblNewLabel_5.setForeground(new Color(0, 102, 153));
		lblNewLabel_5.setFont(new Font("Calibri", Font.BOLD, 25));
		lblNewLabel_5.setBounds(43, 530, 105, 32);
		contentPane.add(lblNewLabel_5);
		
		caja_domicilio = new JTextField();
		caja_domicilio.setBorder(null);
		caja_domicilio.setFont(new Font("Calibri", Font.BOLD, 25));
		caja_domicilio.setBounds(247, 526, 224, 36);
		contentPane.add(caja_domicilio);
		caja_domicilio.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Telefono");
		lblNewLabel_6.setForeground(new Color(0, 102, 153));
		lblNewLabel_6.setFont(new Font("Calibri", Font.BOLD, 25));
		lblNewLabel_6.setBounds(43, 388, 135, 36);
		contentPane.add(lblNewLabel_6);
		
		caja_telefono = new JTextField();
		caja_telefono.setBorder(null);
		caja_telefono.setFont(new Font("Calibri", Font.BOLD, 25));
		caja_telefono.setBounds(247, 391, 224, 32);
		contentPane.add(caja_telefono);
		caja_telefono.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Contrase\u00F1a");
		lblNewLabel_7.setForeground(new Color(0, 102, 153));
		lblNewLabel_7.setFont(new Font("Calibri", Font.BOLD, 25));
		lblNewLabel_7.setBounds(43, 248, 151, 36);
		contentPane.add(lblNewLabel_7);
		
		caja_contraseña = new JTextField();
		caja_contraseña.setBorder(null);
		caja_contraseña.setFont(new Font("Calibri", Font.BOLD, 25));
		caja_contraseña.setBounds(247, 250, 224, 34);
		contentPane.add(caja_contraseña);
		caja_contraseña.setColumns(10);
		
		Boton_registrar = new JButton("");
		Boton_registrar.setIcon(new ImageIcon(Registro.class.getResource("/imagenes/BackButton.png")));
		Boton_registrar.setBounds(10, 619, 92, 81);
		Boton_registrar.setBorder(null);
		Boton_registrar.setBackground(fondo);
		Boton_registrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				coordinador.ocultarVentanaRegistro();
				coordinador.mostrarVentanaIncio();
			}
		});
		contentPane.add(Boton_registrar);
		frame.getContentPane().add(contentPane);
		
		JLabel lblNewLabel_8 = new JLabel("Registrar Usuario");
		lblNewLabel_8.setFont(new Font("Calibri", Font.BOLD, 25));
		lblNewLabel_8.setForeground(new Color(0, 102, 153));
		lblNewLabel_8.setBounds(584, 392, 215, 56);
		contentPane.add(lblNewLabel_8);
		
		JButton back = new JButton("");
		back.setIcon(new ImageIcon(Registro.class.getResource("/imagenes/Registrar.png")));
		back.setBorder(null);
		back.setBackground(new Color(214, 234, 248));
		back.setBounds(588, 280, 167, 112);
		back.addActionListener(new registro());
		contentPane.add(back);
	}
	
	private class registro implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {

			String nombre = caja_nombre.getText().toString();
			String apellido = caja_apellido.getText().toString();
			String dni = caja_dni.getText().toString();
			String contraseña = caja_contraseña.getText().toString();
			String nacimiento = caja_fechanacimiento.getText().toString();
			String telefono = caja_telefono.getText().toString();
			String cuentareal = caja_cuentareal.getText().toString();
			String domicilio = caja_domicilio.getText().toString();
			
			ClienteVo clienteVo = ClienteVo.getSingletonInstance(dni, contraseña);
			clienteVo.setApellido(apellido);
			clienteVo.setNombre(nombre);
			clienteVo.setFechaNacimiento(nacimiento);
			clienteVo.setTelefono(telefono);
			clienteVo.setCuentaReal(cuentareal);
			clienteVo.setDomicilio(domicilio);
			
			int id = coordinador.registro(clienteVo);
			
			if(!(id == 0)) {
				
				clienteVo.setId(id);
				
				coordinador.mostrarVentanaIncio();
				coordinador.ocultarVentanaRegistro();
				CuentaVo.destroy();
				CuentaVo cuentaVo = CuentaVo.getSingletonInstance(id);
				System.out.println(cuentaVo.getIdCliente());
				
				cuentaVo.setId(coordinador.crearCuenta(cuentaVo));
				
			}else {
				ClienteVo.destroy();
				CuentaVo.destroy();
			}
		}
	}
}
