package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Coordinador;
import modelo.vo.CuentaVo;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JSpinner;

public class Cartera_accionesOperador extends JFrame {
	
	private JPanel contentPane;
	private JFrame frame;
	private Coordinador coordinador;
	private JTextArea caja_idaccion;
	private JTextArea caja_numeroacciones;
	private Color fondo = new Color(214, 234, 248);
	
	public JFrame getFrame() {
		
	//	CuentaVo cuentaVo =CuentaVo.getSingletonInstance(0);
		//rellenarAreas(caja_idaccion, caja_numeroacciones, coordinador.Acciones_Propiedad(cuentaVo));
		
		return frame;
	}

	public void setCoordinador(Coordinador coordinador) {
		this.coordinador = coordinador;

	}
	
	public Cartera_accionesOperador() {
		frame = new JFrame();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 574, 700);
		contentPane = new JPanel();
		contentPane.setBackground(fondo);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		contentPane.setLayout(null);
		frame.getContentPane().add(contentPane);
		JLabel lblNewLabel = new JLabel("Cartera de acciones");
		lblNewLabel.setForeground(new Color(0, 102, 153));
		lblNewLabel.setBounds(151, 24, 271, 36);
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 30));
		contentPane.add(lblNewLabel);

		JButton atras = new JButton("");
		atras.setBorder(null);
		atras.setIcon(new ImageIcon(CarteraAcciones.class.getResource("/imagenes/BackButton.png")));
		atras.setBounds(10, 570, 76, 80);
		atras.setBackground(fondo);
		atras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				coordinador.Ocultarcarteraaccionesoperador();
				coordinador.mostrarVentanaOperarios();
			}
		});
		contentPane.add(atras);
		// Aqui añadiriamos un metodo para mostrar todass las acciones
		frame.getContentPane().add(contentPane);

		JLabel lblNewLabel_1 = new JLabel("ID Acci\u00F3n");
		lblNewLabel_1.setForeground(new Color(0, 102, 153));
		lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD, 20));
		lblNewLabel_1.setBounds(145, 86, 116, 30);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("N\u00BA acciones");
		lblNewLabel_2.setForeground(new Color(0, 102, 153));
		lblNewLabel_2.setFont(new Font("Calibri", Font.BOLD, 20));
		lblNewLabel_2.setBounds(315, 90, 173, 22);
		contentPane.add(lblNewLabel_2);

		caja_idaccion = new JTextArea();
		caja_idaccion.setFont(new Font("Calibri", Font.BOLD, 20));
		caja_idaccion.setBounds(133, 115, 107, 428);
		contentPane.add(caja_idaccion);

		caja_numeroacciones = new JTextArea();
		caja_numeroacciones.setFont(new Font("Calibri", Font.BOLD, 20));
		caja_numeroacciones.setBounds(311, 115, 107, 428);
		contentPane.add(caja_numeroacciones);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(20, 216, 0, 0);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("ID de la cuenta");
		lblNewLabel_3.setForeground(new Color(0, 102, 153));
		lblNewLabel_3.setFont(new Font("Calibri", Font.BOLD, 20));
		lblNewLabel_3.setBounds(132, 582, 129, 27);
		contentPane.add(lblNewLabel_3);
		
		JSpinner caja_idcuenta = new JSpinner();
		caja_idcuenta.setFont(new Font("Calibri", Font.BOLD, 18));
		caja_idcuenta.setBorder(null);
		caja_idcuenta.setBounds(272, 581, 81, 30);
		contentPane.add(caja_idcuenta);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon(Cartera_accionesOperador.class.getResource("/imagenes/Verificar.png")));
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setBackground(fondo);
		btnNewButton_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				int idCliente=(int) caja_idcuenta.getValue();
                CuentaVo cuentaVo =CuentaVo.getSingletonInstance(0);
                cuentaVo.setId(idCliente);
                rellenarAreas(caja_idaccion, caja_numeroacciones, coordinador.Acciones_Propiedad(cuentaVo));
                CuentaVo.destroy();
			}
		});
		btnNewButton_1.setBounds(441, 551, 107, 99);
		contentPane.add(btnNewButton_1);
		
	}

	private void rellenarAreas(JTextArea areaidaccion, JTextArea areanumacciones, String[][] datos) {
		int contfilas = 1;
		areaidaccion.setText("\n    ");
		areanumacciones.setText("\n    ");
		while (contfilas < 50) {
			areaidaccion.append(datos[contfilas][1] + "\n    ");
			areanumacciones.append(datos[contfilas][2] + "\n    ");
			contfilas++;

		}
	}
}
