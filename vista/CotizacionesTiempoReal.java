package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Coordinador;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;

public class CotizacionesTiempoReal extends JFrame {
	
	private JPanel contentPane;
	private JFrame frame;
	private Color fondo= new Color(214, 234, 248);
	private Coordinador coordinador;
	private JTextArea textArea_2;
	private JTextArea textArea_3;
	private JTextArea textArea_3_1;
	private Thread hilo;
	private boolean fin = true;

	
	public JFrame getFrame() {
		
		hilo = new Thread(new Hilo());
		hilo.start();
		return frame;
	}

	public void setCoordinador(Coordinador coordinador) {
		this.coordinador = coordinador;
	}

	public CotizacionesTiempoReal() {
		
		frame = new JFrame();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 952, 920);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(fondo);
		frame.getContentPane().add(contentPane);

		
		JButton atras = new JButton("");
		atras.setIcon(new ImageIcon(CotizacionesTiempoReal.class.getResource("/imagenes/BackButton.png")));
		atras.setBounds(22, 793, 76, 80);
		atras.setBorder(null);
		atras.setBackground(fondo);
		atras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fin = false;
				coordinador.ocultarVentanaCotizaciones();
				coordinador.mostrarVentanaUsuarios();
			}
		});

		JLabel lblNewLabel = new JLabel("Cotizaciones a Tiempo Real");
		lblNewLabel.setBounds(198, 25, 564, 56);
		lblNewLabel.setForeground(new Color(0, 102, 153));
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 45));
		
		
		JTextArea textArea = new JTextArea();
		textArea.setForeground(new Color(0, 0, 0));
		textArea.setFont(new Font("Calibri", Font.BOLD, 20));
		textArea.setBounds(137, 151, 249, 621);
		contentPane.setLayout(null);
		textArea.setText("\n  Acciona\n\n  Acerinox\n\n  ACS\n\n  Aena\n\n  Almirall\n\n  Amadeus\n\n  Arcelomit\n\n  B.Santander\n\n  B.Sabadell\n\n  Bankia\n\n  Bankinter\n\n  BBVA\n\n");
		
		JTextArea txtrDfd = new JTextArea();
		txtrDfd.setFont(new Font("Calibri", Font.BOLD, 20));
		txtrDfd.setForeground(new Color(0, 0, 0));
		txtrDfd.setBounds(62, 151, 49, 621);
		txtrDfd.setText("\n    1\n\n    2\n\n    3\n\n    4\n\n    5\n\n    6\n\n    7\n\n    8\n\n    9\n\n   10\n\n   11\n\n   12");

		contentPane.add(txtrDfd);
		contentPane.add(atras);
		contentPane.add(lblNewLabel);
		contentPane.add(textArea);
		
		textArea_2 = new JTextArea();
		textArea_2.setFont(new Font("Calibri", Font.BOLD, 20));
		textArea_2.setBounds(413, 151, 204, 621);
		contentPane.add(textArea_2);
		
		textArea_3 = new JTextArea();
		textArea_3.setFont(new Font("Calibri", Font.BOLD, 20));
		textArea_3.setBounds(644, 151, 98, 621);
		contentPane.add(textArea_3);
		
		textArea_3_1 = new JTextArea();
		textArea_3_1.setFont(new Font("Calibri", Font.BOLD, 20));
		textArea_3_1.setBounds(770, 151, 98, 621);
		contentPane.add(textArea_3_1);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setForeground(new Color(0, 102, 153));
		lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD, 20));
		lblNewLabel_1.setBounds(75, 113, 63, 32);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nombre de la Empresa");
		lblNewLabel_1_1.setForeground(new Color(0, 102, 153));
		lblNewLabel_1_1.setFont(new Font("Calibri", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(160, 113, 220, 32);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("N\u00FAmero de Acciones");
		lblNewLabel_1_1_1.setForeground(new Color(0, 102, 153));
		lblNewLabel_1_1_1.setFont(new Font("Calibri", Font.BOLD, 20));
		lblNewLabel_1_1_1.setBounds(423, 113, 220, 32);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("P. Venta");
		lblNewLabel_1_1_1_1.setForeground(new Color(0, 102, 153));
		lblNewLabel_1_1_1_1.setFont(new Font("Calibri", Font.BOLD, 20));
		lblNewLabel_1_1_1_1.setBounds(655, 113, 76, 32);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("P. Compra");
		lblNewLabel_1_1_1_1_1.setForeground(new Color(0, 102, 153));
		lblNewLabel_1_1_1_1_1.setFont(new Font("Calibri", Font.BOLD, 20));
		lblNewLabel_1_1_1_1_1.setBounds(774, 113, 98, 32);
		contentPane.add(lblNewLabel_1_1_1_1_1);
		
		JButton sacar = new JButton("");
		sacar.setIcon(new ImageIcon(CotizacionesTiempoReal.class.getResource("/imagenes/SacarVentana.png")));
		sacar.setBorder(null);
		sacar.setBackground(new Color(214, 234, 248));
		sacar.setBounds(812, 793, 76, 80);
		sacar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				fin = false;
				coordinador.mostrarVentanaUsuarios();
			}
		});
		contentPane.add(sacar);
	}
	
	public void escribir() {
		
		actualizar();
		consultar();
	}
	
	public void actualizar() {
		coordinador.actualizarAcciones();
	}
	
	public void consultar() {
		
		String numeroAcciones;
		numeroAcciones = coordinador.consultarNumAcciones();
		textArea_2.setText(numeroAcciones);
		
		String compraAcciones;
		compraAcciones = coordinador.consultarCompraAcciones();
		textArea_3.setText(compraAcciones);

		String ventaAcciones;
		ventaAcciones = coordinador.consultarVentaAcciones();
		textArea_3_1.setText(ventaAcciones);
	}
	
	private class Hilo implements Runnable{

		@Override
		public void run() {
			
			while(fin) {
				escribir();
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
