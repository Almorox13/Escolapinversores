package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Coordinador;
import modelo.vo.ClienteVo;
import modelo.vo.CuentaVo;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Historial extends JFrame {

	private Coordinador coordinador;
	private JPanel contentPane;
	private JTextField caja_fecha;
	private JFrame frame;
	private Color fondo = new Color(214, 234, 248);

	public JFrame getFrame() {
		return frame;
	}

	public void setCoordinator(Coordinador coordinador) {
		this.coordinador = coordinador;
	}

	public Historial() {
		frame = new JFrame();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 710, 850);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(fondo);
		frame.getContentPane().add(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Historial de Movimientos");
		lblNewLabel.setBounds(106, 11, 486, 72);
		lblNewLabel.setForeground(new Color(0, 102, 153));
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 45));
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setForeground(new Color(0, 102, 153));
		lblNewLabel_1.setBounds(32, 108, 26, 25);
		lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD, 20));
		contentPane.add(lblNewLabel_1);

		JTextArea areaID = new JTextArea();
		areaID.setBounds(22, 144, 48, 512);
		areaID.setFont(new Font("Calibri", Font.BOLD, 20));
		areaID.setBackground(fondo);
		contentPane.add(areaID);

		JLabel lblNewLabel_2 = new JLabel("ID Acci\u00F3n");
		lblNewLabel_2.setForeground(new Color(0, 102, 153));
		lblNewLabel_2.setBounds(97, 110, 104, 21);
		lblNewLabel_2.setFont(new Font("Calibri", Font.BOLD, 20));
		contentPane.add(lblNewLabel_2);

		JTextArea area_numaccion = new JTextArea();
		area_numaccion.setBounds(106, 144, 48, 512);
		area_numaccion.setFont(new Font("Calibri", Font.BOLD, 20));
		area_numaccion.setBackground(fondo);
		contentPane.add(area_numaccion);

		JLabel lblNewLabel_3 = new JLabel("Compra/Venta");
		lblNewLabel_3.setForeground(new Color(0, 102, 153));
		lblNewLabel_3.setBounds(196, 109, 136, 23);
		lblNewLabel_3.setFont(new Font("Calibri", Font.BOLD, 20));
		contentPane.add(lblNewLabel_3);

		JTextArea area_compraventa = new JTextArea();
		area_compraventa.setBounds(246, 144, 36, 512);
		area_compraventa.setFont(new Font("Calibri", Font.BOLD, 20));
		area_compraventa.setBackground(fondo);
		contentPane.add(area_compraventa);

		JLabel lblNewLabel_4 = new JLabel("Cantidad");
		lblNewLabel_4.setForeground(new Color(0, 102, 153));
		lblNewLabel_4.setBounds(352, 110, 82, 21);
		lblNewLabel_4.setFont(new Font("Calibri", Font.BOLD, 20));
		contentPane.add(lblNewLabel_4);

		JTextArea area_cantidad = new JTextArea();
		area_cantidad.setBounds(348, 144, 90, 512);
		area_cantidad.setFont(new Font("Calibri", Font.BOLD, 20));
		area_cantidad.setBackground(fondo);
		contentPane.add(area_cantidad);

		JLabel lblNewLabel_5 = new JLabel("Coste");
		lblNewLabel_5.setForeground(new Color(0, 102, 153));
		lblNewLabel_5.setBounds(470, 108, 55, 25);
		lblNewLabel_5.setFont(new Font("Calibri", Font.BOLD, 20));
		contentPane.add(lblNewLabel_5);

		JTextArea area_coste = new JTextArea();
		area_coste.setBounds(455, 144, 90, 512);
		area_coste.setFont(new Font("Calibri", Font.BOLD, 20));
		area_coste.setBackground(fondo);
		contentPane.add(area_coste);

		JLabel lblNewLabel_6 = new JLabel("Fecha");
		lblNewLabel_6.setForeground(new Color(0, 102, 153));
		lblNewLabel_6.setBounds(580, 105, 65, 31);
		lblNewLabel_6.setFont(new Font("Calibri", Font.BOLD, 20));
		contentPane.add(lblNewLabel_6);

		JTextArea area_fecha = new JTextArea();
		area_fecha.setBounds(555, 144, 117, 512);
		area_fecha.setFont(new Font("Calibri", Font.BOLD, 20));
		area_fecha.setBackground(fondo);
		contentPane.add(area_fecha);

		JLabel lblNewLabel_7 = new JLabel("Fecha");
		lblNewLabel_7.setBounds(196, 703, 65, 31);
		lblNewLabel_7.setForeground(new Color(0, 102, 153));
		lblNewLabel_7.setFont(new Font("Calibri", Font.BOLD, 20));
		contentPane.add(lblNewLabel_7);

		caja_fecha = new JTextField();
		caja_fecha.setBounds(256, 699, 182, 39);
		caja_fecha.setBorder(null);
		caja_fecha.setFont(new Font("Calibri", Font.BOLD, 20));
		contentPane.add(caja_fecha);
		caja_fecha.setColumns(10);

		JButton btnNewButton = new JButton("");
		btnNewButton.setBounds(544, 705, 128, 95);
		btnNewButton.setBorder(null);
		btnNewButton.setIcon(new ImageIcon(Historial.class.getResource("/imagenes/Verificar.png")));
		btnNewButton.setBackground(fondo);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CuentaVo cuentaVo = CuentaVo.getSingletonInstance(0);

				if (caja_fecha.getText().length() == 0) {
					mostrarultimosmovimientos(areaID, area_numaccion, area_compraventa, area_cantidad, area_coste,
							area_fecha, coordinador.Consultar_Movimientos(cuentaVo));

				} else {
					mostrarultimosmovimientos(areaID, area_numaccion, area_compraventa, area_cantidad, area_coste,
							area_fecha,
							coordinador.Consultar_Movimientos_por_fecha(cuentaVo, caja_fecha.getText().toString()));
				}

			}
		});
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_8 = new JLabel("New label");
		lblNewLabel_8.setBackground(new Color(0, 0, 0));
		lblNewLabel_8.setBounds(-70, 169, 1000, 2);
		contentPane.add(lblNewLabel_8);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon(Historial.class.getResource("/imagenes/BackButton.png")));
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setBackground(fondo);
		btnNewButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				coordinador.ocultarVentanaHistorial();
				coordinador.mostrarVentanaUsuarios();
			}
		});
		btnNewButton_1.setBounds(10, 727, 89, 73);
		contentPane.add(btnNewButton_1);

	}

	private void mostrarultimosmovimientos(JTextArea areaid, JTextArea areanumaccion, JTextArea area_compraventa,
			JTextArea area_cantidad, JTextArea area_coste, JTextArea area_Fecha, String[][] datos) {
		int contfilas = 1;
		
		areaid.setText(" ");
		areanumaccion.setText(" ");
		area_compraventa.setText(" ");
		area_cantidad.setText(" ");
		area_coste.setText(" ");
		area_Fecha.setText(" ");
		
		while (contfilas <= 10) {

			areaid.append(datos[contfilas][1] + "\n\n  ");
			areanumaccion.append(datos[contfilas][2] + "\n\n  ");
			area_compraventa.append(datos[contfilas][3] + "\n\n  ");
			area_cantidad.append(datos[contfilas][4] + "\n\n  ");
			area_coste.append(datos[contfilas][5] + "\n\n  ");
			area_Fecha.append(datos[contfilas][6] + "\n\n  ");
			contfilas++;
		}

	}
}
