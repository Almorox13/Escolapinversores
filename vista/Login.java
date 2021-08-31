package vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controlador.Coordinador;
import modelo.vo.ClienteVo;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.SystemColor;

public class Login {

	private JFrame frame;
	private JTextField inDNI;
	private JTextField inContrase�a;
	private Coordinador coordinador;
	private JLabel lblDNI;
	private JLabel lblContrase�a;
	private Color fondo= new Color(214, 234, 248);
	
	public JFrame getFrame() {
		return frame;
	}
	
	public void setCoordinator(Coordinador coordinador) {
		this.coordinador = coordinador;
	}

	public Login() {
		frame = new JFrame();
		frame.setForeground(SystemColor.textInactiveText);
		frame.getContentPane().setForeground(SystemColor.desktop);
		frame.setBounds(900, 300, 581, 371);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(fondo);
		
		JButton btn = new JButton("");
		btn.setIcon(new ImageIcon(Login.class.getResource("/imagenes/Verificar.png")));
		btn.setForeground(SystemColor.inactiveCaption);
		btn.setBackground(fondo);
		btn.setFont(new Font("Arial", Font.PLAIN, 18));
		btn.setBounds(439, 224, 97, 85);
		btn.setBorder(null);
		btn.addActionListener(new IniciarSesion());
		frame.getContentPane().add(btn);
		
		lblDNI = new JLabel("DNI");
		lblDNI.setForeground(new Color(0, 102, 153));
		lblDNI.setFont(new Font("Calibri", Font.BOLD, 25));
		lblDNI.setBounds(63, 66, 117, 40);
		frame.getContentPane().add(lblDNI);
		
		lblContrase�a = new JLabel("Contrase\u00F1a");
		lblContrase�a.setForeground(new Color(0, 102, 153));
		lblContrase�a.setFont(new Font("Calibri", Font.BOLD, 25));
		lblContrase�a.setBounds(63, 135, 145, 29);
		frame.getContentPane().add(lblContrase�a);
		
		inDNI = new JTextField();
		inDNI.setBorder(null);
		inDNI.setFont(new Font("Arial", Font.PLAIN, 18));
		inDNI.setBounds(257, 70, 237, 29);
		frame.getContentPane().add(inDNI);
		inDNI.setColumns(10);
		
		inContrase�a = new JTextField();
		inContrase�a.setBorder(null);
		inContrase�a.setFont(new Font("Arial", Font.PLAIN, 18));
		inContrase�a.setBounds(257, 133, 237, 29);
		frame.getContentPane().add(inContrase�a);
		inContrase�a.setColumns(10);
		
		JButton btn_1 = new JButton("");
		btn_1.setIcon(new ImageIcon(Login.class.getResource("/imagenes/BackButton.png")));
		btn_1.setForeground(SystemColor.activeCaptionText);
		btn_1.setFont(new Font("Arial", Font.PLAIN, 18));
		btn_1.setBorder(null);
		btn_1.setBackground(fondo);
		btn_1.setBounds(10, 224, 97, 85);
		btn_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				coordinador.ocultarVentanaLogin();
				coordinador.mostrarVentanaIncio();
			}
		});
		frame.getContentPane().add(btn_1);
	}
	
	private class IniciarSesion implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			String dni = inDNI.getText().toString();
			String contrase�a = inContrase�a.getText().toString();
			
			ClienteVo clienteVo = ClienteVo.getSingletonInstance(dni, contrase�a);
			coordinador.cargar(dni);
			
			int rango = coordinador.login(clienteVo);
			
			switch (rango) {
				case 1:
					
					coordinador.ocultarVentanaLogin();
					coordinador.mostrarVentanaUsuarios();
					inDNI.setText("");
					inContrase�a.setText("");
					break;
				case 2:
					
					coordinador.ocultarVentanaLogin();
					coordinador.mostrarVentanaOperarios();
					break;
				case 3:
					
					coordinador.ocultarVentanaLogin();
					coordinador.mostrarVentanaOperarios();
					break;
				
				default:
					
					lblDNI.setForeground(Color.RED);
					lblContrase�a.setForeground(Color.RED);
				}
		}
	}
}


