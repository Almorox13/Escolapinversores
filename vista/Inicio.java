package vista;

import javax.swing.JFrame;
import controlador.Coordinador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;

public class Inicio {

	private JFrame frame;
	private Coordinador coordinador;
	private Color fondo= new Color(214, 234, 248);

	public JFrame getFrame() {
		return frame;
	}
	
	public void setCoordinator(Coordinador coordinador) {
		this.coordinador = coordinador;
	}
	
	public Inicio() {
		frame = new JFrame();
		frame.setBounds(900, 300, 733, 456);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(fondo);
		
		JButton iniciarSesion = new JButton("");
		iniciarSesion.setIcon(new ImageIcon(Inicio.class.getResource("/imagenes/IniciarSesionIcon.png")));
		iniciarSesion.setBounds(118, 140, 186, 157);
		iniciarSesion.addActionListener(new iniciarSesion());
		iniciarSesion.setBorder(null);
		iniciarSesion.setBackground(fondo);
		frame.getContentPane().add(iniciarSesion);
		
		
		JButton registrarse = new JButton("");
		registrarse.setIcon(new ImageIcon(Inicio.class.getResource("/imagenes/Registrar.png")));
		registrarse.setBounds(399, 140, 186, 157);
		registrarse.addActionListener(new registrarse());
		registrarse.setBorder(null);
		registrarse.setBackground(fondo);
		frame.getContentPane().add(registrarse);
		
		JLabel lblNewLabel = new JLabel("Bienvenido a Escolapinversores");
		lblNewLabel.setForeground(new Color(0, 102, 153));
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 35));
		lblNewLabel.setBounds(118, 33, 467, 79);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblIniciarSesion = new JLabel("Iniciar Sesion");
		lblIniciarSesion.setForeground(new Color(0, 102, 153));
		lblIniciarSesion.setFont(new Font("Calibri", Font.BOLD, 22));
		lblIniciarSesion.setBounds(152, 308, 129, 50);
		frame.getContentPane().add(lblIniciarSesion);
		
		JLabel lblRegistrarse = new JLabel("Registrarse");
		lblRegistrarse.setForeground(new Color(0, 102, 153));
		lblRegistrarse.setFont(new Font("Calibri", Font.BOLD, 22));
		lblRegistrarse.setBounds(441, 308, 129, 50);
		frame.getContentPane().add(lblRegistrarse);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(10, 33, 0, 0);
		frame.getContentPane().add(btnNewButton);
	}
	
	private class iniciarSesion implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {

			coordinador.ocultarVentanaIncio();
			coordinador.mostrarVentanaLogin();
		}
	}
	
	private class registrarse implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			coordinador.ocultarVentanaIncio();
			coordinador.mostrarVentanaRegistro();
		}
		
	}
}
