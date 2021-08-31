package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Coordinador;
import modelo.vo.ClienteVo;
import modelo.vo.CuentaVo;
import modelo.vo.MovimientoVo;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JTextArea;
import javax.swing.JSpinner;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.ImageIcon;

public class ComprarAcciones extends JFrame {
	/*
	 * CAJA ID ACCION:"caja_id_accion" NUMERO DE ACCIONES:"caja_num_acciones"
	 * TEXTAREA:"area_acciones"
	 */
	private JPanel contentPane;
	private Coordinador coordinador;
	private JFrame frame;
	private Color fondo= new Color(214, 234, 248);
	private JButton porMejor;
	private JSpinner caja_id_accion;
	private JSpinner caja_num_acciones;
	private JLabel lblNewLabel_1_1;
	private double valor = 0;
	private boolean fin = true;

	public JFrame getFrame() {
		Thread hilo = new Thread(new Runnable() {
			@Override
			public void run() {
				actualizarValor();
			}
		});
		hilo.start();
		return frame;
	}

	public void setCoordinador(Coordinador coordinador) {
		this.coordinador = coordinador;
	}

	public ComprarAcciones() {
		frame = new JFrame();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(1000, 300, 903, 477);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(fondo);

		JLabel lblNewLabel = new JLabel("ID de la accion que desea comprar");
		lblNewLabel.setBounds(66, 127, 385, 40);
		lblNewLabel.setForeground(new Color(0, 102, 153));
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 20));

		JLabel lblNewLabel_1 = new JLabel("Numero de acciones a comprar");
		lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD, 20));
		lblNewLabel_1.setForeground(new Color(0, 102, 153));
		lblNewLabel_1.setBounds(66, 206, 314, 38);
		
		caja_id_accion = new JSpinner();
		caja_id_accion.setFont(new Font("Calibri", Font.BOLD, 20));
		caja_id_accion.setBounds(400, 132, 110, 32);
		caja_id_accion.setBorder(null);
		
		caja_num_acciones = new JSpinner();
		caja_num_acciones.setFont(new Font("Calibri", Font.BOLD, 20));
		caja_num_acciones.setBounds(400, 210, 110, 32);
		caja_num_acciones.setValue(1);
		caja_num_acciones.setBorder(null);
		
		JLabel lblNewLabel_2 = new JLabel("Compra de Acciones");
		lblNewLabel_2.setBounds(315, 22, 253, 38);
		lblNewLabel_2.setForeground(new Color(0, 102, 153));
		lblNewLabel_2.setFont(new Font("Calibri", Font.BOLD, 30));
		contentPane.setLayout(null);
		contentPane.add(lblNewLabel_2);
		contentPane.add(lblNewLabel_1);
		contentPane.add(lblNewLabel);
		contentPane.add(caja_num_acciones);
		contentPane.add(caja_id_accion);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(ComprarAcciones.class.getResource("/imagenes/BackButton.png")));
		btnNewButton.setBounds(10, 327, 100, 100);
		btnNewButton.setBackground(fondo);
		btnNewButton.setBorder(null);
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				coordinador.ocultarVentanaComprarAcciones();
				coordinador.mostrarVentanaUsuarios();
				fin = false;
			}
		});
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon(ComprarAcciones.class.getResource("/imagenes/Verificar.png")));
		btnNewButton_1.setBounds(777, 327, 100, 100);
		btnNewButton_1.setBackground(fondo);
		btnNewButton_1.setBorder(null);
		btnNewButton_1.addActionListener(new confirmar());
		contentPane.add(btnNewButton_1);
		frame.getContentPane().add(contentPane);
		
		porMejor = new JButton("");
		porMejor.setIcon(new ImageIcon(ComprarAcciones.class.getResource("/imagenes/cotizaciones.png")));
		porMejor.setBorder(null);
		porMejor.setBackground(new Color(214, 234, 248));
		porMejor.setBounds(637, 119, 125, 125);
		porMejor.addActionListener(new porLoMejor());
		contentPane.add(porMejor);
		
		JLabel lblPorLoMejor = new JLabel("Por lo Mejor");
		lblPorLoMejor.setForeground(new Color(0, 102, 153));
		lblPorLoMejor.setFont(new Font("Calibri", Font.BOLD, 20));
		lblPorLoMejor.setBounds(645, 242, 117, 40);
		contentPane.add(lblPorLoMejor);
		
		lblNewLabel_1_1 = new JLabel("Valor Actual: 0000\u20AC");
		lblNewLabel_1_1.setForeground(new Color(0, 102, 153));
		lblNewLabel_1_1.setFont(new Font("Calibri", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(297, 354, 271, 38);
		contentPane.add(lblNewLabel_1_1);
	}
	
	private void actualizarValor() {
		
		while(fin) {
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			valor = coordinador.actualizarValor((int)caja_id_accion.getValue(), (int)caja_num_acciones.getValue());
			lblNewLabel_1_1.setText("Valor Actual: " + valor + "\u20AC");
		}
	}

	private class porLoMejor implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			caja_id_accion.setValue(coordinador.consultaCompra());
		}
	}
	
	private class confirmar implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
		
			int confirmacion = JOptionPane.showConfirmDialog(null, "¿Confirmar petición de compra?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if(confirmacion == 0){
								
				MovimientoVo movimientoVo = new MovimientoVo();
				CuentaVo cuentaVo = CuentaVo.getSingletonInstance(0);
				
				movimientoVo.setIdAccion((int)caja_id_accion.getValue());
				movimientoVo.setIdCuenta(cuentaVo.getId());
				movimientoVo.setCompraVenta('c');
				movimientoVo.setFechaOrden("2000-09-09");
				movimientoVo.setPrecio(valor);
				movimientoVo.setCantidad((int)caja_num_acciones.getValue());
				
				coordinador.insertarMovimiento(movimientoVo);
			}
		}
	}
}