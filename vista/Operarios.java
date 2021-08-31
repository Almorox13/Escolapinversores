package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Coordinador;
import modelo.vo.ClienteVo;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;

public class Operarios extends JFrame {

	private JPanel contentPane;
	private Color fondo= new Color(214, 234, 248);
	private JFrame frame;
	private Coordinador coordinador;
	
	public JFrame getFrame() {
		return frame;
	}

	public void setCoordinador(Coordinador coordinador) {
		this.coordinador = coordinador;
	}
	public Operarios() {
		frame = new JFrame();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 716, 630);
		contentPane = new JPanel();
		contentPane.setBackground(fondo);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(Operarios.class.getResource("/imagenes/cotizaciones.png")));
		btnNewButton.setBounds(new Rectangle(0, 0, 150, 150));
		btnNewButton.setBounds(60, 93, 150, 150);
		btnNewButton.setBorder(null);
		btnNewButton.setBackground(fondo);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				coordinador.mostrarVentanaCotizaciones();
			}
		});
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setIcon(new ImageIcon(Operarios.class.getResource("/imagenes/carteraAcciones.png")));
		btnNewButton_2.setBounds(new Rectangle(0, 0, 150, 150));
		btnNewButton_2.setBounds(274, 93, 150, 150);
		btnNewButton_2.setBorder(null);
		btnNewButton_2.setBackground(fondo);
		btnNewButton_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				coordinador.ocultarVentanaOperarios();
				coordinador.Mostrarcarteraaccionesoperador();
			}
		});
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_4 = new JButton("");
		btnNewButton_4.setIcon(new ImageIcon(Operarios.class.getResource("/imagenes/cancelarCV.png")));
		btnNewButton_4.setBounds(new Rectangle(0, 0, 150, 150));
		btnNewButton_4.setBounds(488, 93, 150, 150);
		btnNewButton_4.setBorder(null);
		btnNewButton_4.addActionListener(new  ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				coordinador.Mostrarcancelarordenesoperario();
				coordinador.ocultarVentanaOperarios();
			}
		});
		btnNewButton_4.setBackground(fondo);
		
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon(Operarios.class.getResource("/imagenes/datosPersonales.png")));
		btnNewButton_1.setBounds(new Rectangle(0, 0, 150, 150));
		btnNewButton_1.setBounds(274, 302, 150, 150);
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setBackground(fondo);
		btnNewButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				coordinador.ocultarVentanaOperarios();
				coordinador.mostrarVentanaDatos();
			}
		});
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_5 = new JButton("");
		btnNewButton_5.setIcon(new ImageIcon(Operarios.class.getResource("/imagenes/historial.png")));
		btnNewButton_5.setBounds(new Rectangle(0, 0, 150, 150));
		btnNewButton_5.setBounds(488, 302, 150, 150);
		btnNewButton_5.setBorder(null);
		btnNewButton_5.setBackground(fondo);
		btnNewButton_5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				coordinador.ocultarVentanaOperarios();
				coordinador.Mostrarhistorialoperador();
			}
		});
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.setIcon(new ImageIcon(Operarios.class.getResource("/imagenes/darse de baja.png")));
		btnNewButton_3.setBounds(new Rectangle(0, 0, 150, 150));
		btnNewButton_3.setBounds(60, 302, 150, 150);
		btnNewButton_3.setBorder(null);
		btnNewButton_3.setBackground(fondo);
		btnNewButton_3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				coordinador.ocultarVentanaOperarios();
				coordinador.MostrarDarseDeBajaOperadoro();
			}
		});
		contentPane.add(btnNewButton_3);
		
		JButton atras = new JButton("");
		atras.setIcon(new ImageIcon(Operarios.class.getResource("/imagenes/BackButton.png")));
		atras.setBounds(new Rectangle(0, 0, 150, 150));
		atras.setBounds(10, 504, 76, 79);
		atras.setBorder(null);
		atras.setBackground(fondo);
		atras.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				coordinador.ocultarVentanaOperarios();				
				ClienteVo.destroy();
				coordinador.mostrarVentanaIncio();
			}
		});
		contentPane.add(atras);
		
		JLabel lblNewLabel = new JLabel("Escolapinversores");
		lblNewLabel.setForeground(new Color(0, 102, 153));
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 35));
		lblNewLabel.setBounds(212, 10, 344, 52);
		contentPane.add(lblNewLabel);
		
		JLabel lblCotizacionesEnTiempo = new JLabel("Cotizaciones en");
		lblCotizacionesEnTiempo.setForeground(new Color(0, 102, 153));
		lblCotizacionesEnTiempo.setFont(new Font("Calibri", Font.BOLD, 20));
		lblCotizacionesEnTiempo.setBounds(66, 245, 174, 30);
		contentPane.add(lblCotizacionesEnTiempo);
		
		JLabel lblTiempoReal = new JLabel("Tiempo Real");
		lblTiempoReal.setForeground(new Color(0, 102, 153));
		lblTiempoReal.setFont(new Font("Calibri", Font.BOLD, 20));
		lblTiempoReal.setBounds(77, 267, 174, 30);
		contentPane.add(lblTiempoReal);
		
		JLabel lblCarterasDeAcciones = new JLabel("Carteras de Acciones");
		lblCarterasDeAcciones.setForeground(new Color(0, 102, 153));
		lblCarterasDeAcciones.setFont(new Font("Calibri", Font.BOLD, 20));
		lblCarterasDeAcciones.setBounds(261, 245, 174, 30);
		contentPane.add(lblCarterasDeAcciones);
		
		JLabel lblrdenes = new JLabel("\u00D3rdenes");
		lblrdenes.setForeground(new Color(0, 102, 153));
		lblrdenes.setFont(new Font("Calibri", Font.BOLD, 20));
		lblrdenes.setBounds(526, 245, 83, 30);
		contentPane.add(lblrdenes);
		
		JLabel lblGestionarBajas = new JLabel("Gestionar Bajas");
		lblGestionarBajas.setForeground(new Color(0, 102, 153));
		lblGestionarBajas.setFont(new Font("Calibri", Font.BOLD, 20));
		lblGestionarBajas.setBounds(67, 454, 174, 30);
		contentPane.add(lblGestionarBajas);
		
		JLabel lblModificarDatos = new JLabel("Modificar Datos");
		lblModificarDatos.setForeground(new Color(0, 102, 153));
		lblModificarDatos.setFont(new Font("Calibri", Font.BOLD, 20));
		lblModificarDatos.setBounds(278, 454, 174, 30);
		contentPane.add(lblModificarDatos);
		
		JLabel lblHistoriales = new JLabel("Historiales");
		lblHistoriales.setForeground(new Color(0, 102, 153));
		lblHistoriales.setFont(new Font("Calibri", Font.BOLD, 20));
		lblHistoriales.setBounds(518, 454, 174, 30);
		contentPane.add(lblHistoriales);
		frame.getContentPane().add(contentPane);
	}
}
