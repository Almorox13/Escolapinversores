package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Coordinador;
import modelo.vo.ClienteVo;
import modelo.vo.CuentaVo;
import modelo.vo.MovimientoVo;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Usuarios extends JFrame {

	private JFrame frame;
	private JPanel contentPane;
	private Coordinador coordinador;
	private Color fondo = new Color(214, 234, 248);

	public JFrame getFrame() {
		return frame;
	}

	public void setCoordinador(Coordinador coordinador) {
		this.coordinador = coordinador;
	}

	public Usuarios() {
		frame = new JFrame();
		frame.setBounds(700, 100, 1018, 870);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		contentPane.setBackground(fondo);

		JButton cartera_acciones = new JButton("");
		cartera_acciones.setIcon(new ImageIcon(Usuarios.class.getResource("/imagenes/carteraAcciones.png")));
		cartera_acciones.setBounds(300, 117, 150, 150);
		cartera_acciones.setBackground(fondo);
		cartera_acciones.setBorder(null);
		cartera_acciones.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				coordinador.ocultarVentanaUsuarios();
				coordinador.MostrarVentanaCarteraAcciones();
			}
		});
		contentPane.add(cartera_acciones);

		JLabel label_6 = new JLabel("");
		label_6.setBounds(177, 21, 0, 0);
		contentPane.add(label_6);

		JLabel label_7 = new JLabel("");
		label_7.setBounds(182, 21, 0, 0);
		contentPane.add(label_7);

		JButton boton_Comprar_acciones = new JButton("");
		boton_Comprar_acciones.setIcon(new ImageIcon(Usuarios.class.getResource("/imagenes/comprarAccciones.png")));
		boton_Comprar_acciones.setBounds(550, 117, 150, 150);
		boton_Comprar_acciones.setBackground(fondo);
		boton_Comprar_acciones.setBorder(null);
		boton_Comprar_acciones.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				coordinador.ocultarVentanaUsuarios();
				coordinador.mostrarVentanaComprarAcciones();
			}
		});
		contentPane.add(boton_Comprar_acciones);

		JLabel label_8 = new JLabel("");
		label_8.setBounds(311, 21, 0, 0);
		contentPane.add(label_8);

		JLabel label_9 = new JLabel("");
		label_9.setBounds(316, 21, 0, 0);
		contentPane.add(label_9);

		JLabel label = new JLabel("");
		label.setBounds(321, 21, 0, 0);
		contentPane.add(label);

		JLabel label_2 = new JLabel("");
		label_2.setBounds(326, 21, 0, 0);
		contentPane.add(label_2);

		JButton Botob_vender = new JButton("");
		Botob_vender.setIcon(new ImageIcon(Usuarios.class.getResource("/imagenes/venderAcciones.png")));
		Botob_vender.setBounds(300, 349, 150, 150);
		Botob_vender.setBackground(fondo);
		Botob_vender.setBorder(null);
		Botob_vender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				coordinador.ocultarVentanaUsuarios();
				coordinador.mostrarVentanaVentaAcciones();

			}
		});
		contentPane.add(Botob_vender);

		JLabel label_3 = new JLabel("");
		label_3.setBounds(447, 21, 0, 0);
		contentPane.add(label_3);

		JLabel label_10 = new JLabel("");
		label_10.setBounds(452, 21, 0, 0);
		contentPane.add(label_10);

		JLabel label_11 = new JLabel("");
		label_11.setBounds(457, 21, 0, 0);
		contentPane.add(label_11);

		JLabel label_12 = new JLabel("");
		label_12.setBounds(462, 21, 0, 0);
		contentPane.add(label_12);

		JButton Cotizaciones = new JButton("");
		Cotizaciones.setIcon(new ImageIcon(Usuarios.class.getResource("/imagenes/cotizaciones.png")));
		Cotizaciones.setBounds(50, 117, 150, 150);
		Cotizaciones.setBackground(fondo);
		Cotizaciones.setBorder(null);
		Cotizaciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				coordinador.ocultarVentanaUsuarios();
				coordinador.mostrarVentanaCotizaciones();
			}
		});
		contentPane.add(Cotizaciones);

		JLabel label_13 = new JLabel("");
		label_13.setBounds(625, 21, 0, 0);
		contentPane.add(label_13);

		JLabel label_14 = new JLabel("");
		label_14.setBounds(630, 21, 0, 0);
		contentPane.add(label_14);

		JLabel label_15 = new JLabel("");
		label_15.setBounds(635, 21, 0, 0);
		contentPane.add(label_15);

		JLabel label_16 = new JLabel("");
		label_16.setBounds(640, 21, 0, 0);
		contentPane.add(label_16);

		JLabel label_17 = new JLabel("");
		label_17.setBounds(645, 21, 0, 0);
		contentPane.add(label_17);

		JLabel label_18 = new JLabel("");
		label_18.setBounds(650, 21, 0, 0);
		contentPane.add(label_18);

		JLabel label_19 = new JLabel("");
		label_19.setBounds(655, 21, 0, 0);
		contentPane.add(label_19);

		JLabel label_20 = new JLabel("");
		label_20.setBounds(660, 21, 0, 0);
		contentPane.add(label_20);

		JButton Historial = new JButton("");
		Historial.setIcon(new ImageIcon(Usuarios.class.getResource("/imagenes/historial.png")));
		Historial.setBounds(550, 349, 150, 150);
		Historial.setBackground(fondo);
		Historial.setBorder(null);
		Historial.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				coordinador.ocultarVentanaUsuarios();
				coordinador.mostrarVentanaHistorial();
			}
		});
		contentPane.add(Historial);

		JLabel label_21 = new JLabel("");
		label_21.setBounds(240, 49, 0, 0);
		contentPane.add(label_21);

		JLabel label_22 = new JLabel("");
		label_22.setBounds(245, 49, 0, 0);
		contentPane.add(label_22);

		JLabel label_23 = new JLabel("");
		label_23.setBounds(250, 49, 0, 0);
		contentPane.add(label_23);

		JLabel label_24 = new JLabel("");
		label_24.setBounds(255, 49, 0, 0);
		contentPane.add(label_24);

		JButton Datos_personales = new JButton("");
		Datos_personales.setIcon(new ImageIcon(Usuarios.class.getResource("/imagenes/datosPersonales.png")));
		Datos_personales.setBounds(50, 349, 150, 150);
		Datos_personales.setBackground(fondo);
		Datos_personales.setBorder(null);
		Datos_personales.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				coordinador.ocultarVentanaUsuarios();
				coordinador.mostrarVentanaDatosPesonales();
			}
		});
		contentPane.add(Datos_personales);

		JButton ordenes_compra_venta = new JButton("");
		ordenes_compra_venta.setIcon(new ImageIcon(Usuarios.class.getResource("/imagenes/cancelarCV.png")));
		ordenes_compra_venta.setBounds(800, 117, 150, 150);
		ordenes_compra_venta.setBackground(fondo);
		ordenes_compra_venta.setBorder(null);
		ordenes_compra_venta.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				coordinador.ocultarVentanaUsuarios();
				coordinador.MostrarVentanaCompra_venta();
			}
		});
		contentPane.add(ordenes_compra_venta);

		JLabel label_25 = new JLabel("");
		label_25.setBounds(486, 49, 0, 0);
		contentPane.add(label_25);

		JLabel label_26 = new JLabel("");
		label_26.setBounds(491, 49, 0, 0);
		contentPane.add(label_26);

		JLabel label_27 = new JLabel("");
		label_27.setBounds(496, 49, 0, 0);
		contentPane.add(label_27);

		JLabel label_28 = new JLabel("");
		label_28.setBounds(501, 49, 0, 0);
		contentPane.add(label_28);

		JButton darsedeBaja = new JButton("");
		darsedeBaja.setIcon(new ImageIcon(Usuarios.class.getResource("/imagenes/darse de baja.png")));
		darsedeBaja.setBounds(800, 349, 150, 150);
		darsedeBaja.setBackground(fondo);
		darsedeBaja.setBorder(null);
		darsedeBaja.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                int confirmacion = JOptionPane.showConfirmDialog(null, "¿Confirmar Baja?", "Confirmación",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (confirmacion == 0) {

                    CuentaVo cuentaVo = CuentaVo.getSingletonInstance(0);
                    coordinador.darseDebajaSinConfirmacion(cuentaVo.getId());
        			JOptionPane.showMessageDialog(null, "Órden emitida", "Información", JOptionPane.INFORMATION_MESSAGE);

                }
            }

        });
		contentPane.add(darsedeBaja);

		JLabel label_29 = new JLabel("");
		label_29.setBounds(610, 49, 0, 0);
		contentPane.add(label_29);

		JLabel label_30 = new JLabel("");
		label_30.setBounds(615, 49, 0, 0);
		contentPane.add(label_30);

		frame.getContentPane().add(contentPane);

		JLabel lblNewLabel = new JLabel("Cartera de Acciones");
		lblNewLabel.setForeground(new Color(0, 102, 153));
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 20));
		lblNewLabel.setBounds(292, 275, 178, 30);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Escolapinversores");
		lblNewLabel_1.setForeground(new Color(0, 102, 153));
		lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD, 45));
		lblNewLabel_1.setBounds(321, 33, 489, 59);
		contentPane.add(lblNewLabel_1);

		JLabel lblCotizacionesEnTiempo = new JLabel("Cotizaciones en");
		lblCotizacionesEnTiempo.setForeground(new Color(0, 102, 153));
		lblCotizacionesEnTiempo.setFont(new Font("Calibri", Font.BOLD, 20));
		lblCotizacionesEnTiempo.setBounds(60, 275, 174, 30);
		contentPane.add(lblCotizacionesEnTiempo);

		JLabel lblTiempoReal = new JLabel("Tiempo Real");
		lblTiempoReal.setForeground(new Color(0, 102, 153));
		lblTiempoReal.setFont(new Font("Calibri", Font.BOLD, 20));
		lblTiempoReal.setBounds(73, 298, 174, 30);
		contentPane.add(lblTiempoReal);

		JLabel lblComprarAcciones = new JLabel("Comprar Acciones");
		lblComprarAcciones.setForeground(new Color(0, 102, 153));
		lblComprarAcciones.setFont(new Font("Calibri", Font.BOLD, 20));
		lblComprarAcciones.setBounds(548, 275, 178, 30);
		contentPane.add(lblComprarAcciones);

		JLabel lblCompraVenta = new JLabel("Cancelar \u00D3rdenes");
		lblCompraVenta.setForeground(new Color(0, 102, 153));
		lblCompraVenta.setFont(new Font("Calibri", Font.BOLD, 20));
		lblCompraVenta.setBounds(800, 275, 178, 30);
		contentPane.add(lblCompraVenta);

		JLabel lblComprarAcciones_1 = new JLabel("Informaci\u00F3n Personal");
		lblComprarAcciones_1.setForeground(new Color(0, 102, 153));
		lblComprarAcciones_1.setFont(new Font("Calibri", Font.BOLD, 20));
		lblComprarAcciones_1.setBounds(39, 507, 192, 30);
		contentPane.add(lblComprarAcciones_1);

		JLabel lblComprarAcciones_1_1 = new JLabel("Vender Acciones");
		lblComprarAcciones_1_1.setForeground(new Color(0, 102, 153));
		lblComprarAcciones_1_1.setFont(new Font("Calibri", Font.BOLD, 20));
		lblComprarAcciones_1_1.setBounds(305, 507, 178, 30);
		contentPane.add(lblComprarAcciones_1_1);

		JLabel lblComprarAcciones_1_2 = new JLabel("Historial");
		lblComprarAcciones_1_2.setForeground(new Color(0, 102, 153));
		lblComprarAcciones_1_2.setFont(new Font("Calibri", Font.BOLD, 20));
		lblComprarAcciones_1_2.setBounds(587, 507, 178, 30);
		contentPane.add(lblComprarAcciones_1_2);

		JLabel lblComprarAcciones_1_3 = new JLabel("Darse de Baja");
		lblComprarAcciones_1_3.setForeground(new Color(0, 102, 153));
		lblComprarAcciones_1_3.setFont(new Font("Calibri", Font.BOLD, 20));
		lblComprarAcciones_1_3.setBounds(820, 507, 178, 30);
		contentPane.add(lblComprarAcciones_1_3);

		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(25, 26, 0, 0);
		contentPane.add(btnNewButton);

		JButton saldoActual = new JButton("");
		saldoActual.setIcon(new ImageIcon(Usuarios.class.getResource("/imagenes/cuentas.png")));
		saldoActual.setBorder(null);
		saldoActual.setBackground(new Color(214, 234, 248));
		saldoActual.setBounds(300, 581, 150, 150);
		saldoActual.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				coordinador.MostrarVentanaSaldo_cuenta();
				coordinador.ocultarVentanaUsuarios();
			}
		});
		contentPane.add(saldoActual);

		JButton retirarDinero = new JButton("");
		retirarDinero.setIcon(new ImageIcon(Usuarios.class.getResource("/imagenes/retirar.png")));
		retirarDinero.setBorder(null);
		retirarDinero.setBackground(new Color(214, 234, 248));
		retirarDinero.setBounds(550, 581, 150, 150);
		retirarDinero.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				coordinador.ocultarVentanaUsuarios();
				coordinador.MostrarVentanaRetirarDinero();
			}
		});
		contentPane.add(retirarDinero);

		JLabel lblComprarAcciones_1_1_1 = new JLabel("Saldo de mis");
		lblComprarAcciones_1_1_1.setForeground(new Color(0, 102, 153));
		lblComprarAcciones_1_1_1.setFont(new Font("Calibri", Font.BOLD, 20));
		lblComprarAcciones_1_1_1.setBounds(320, 739, 178, 30);
		contentPane.add(lblComprarAcciones_1_1_1);

		JLabel lblComprarAcciones_1_1_2 = new JLabel("Retirar Dinero");
		lblComprarAcciones_1_1_2.setForeground(new Color(0, 102, 153));
		lblComprarAcciones_1_1_2.setFont(new Font("Calibri", Font.BOLD, 20));
		lblComprarAcciones_1_1_2.setBounds(565, 739, 178, 30);
		contentPane.add(lblComprarAcciones_1_1_2);

		JLabel lblComprarAcciones_1_1_3 = new JLabel("Cuentas");
		lblComprarAcciones_1_1_3.setForeground(new Color(0, 102, 153));
		lblComprarAcciones_1_1_3.setFont(new Font("Calibri", Font.BOLD, 20));
		lblComprarAcciones_1_1_3.setBounds(335, 762, 178, 30);
		contentPane.add(lblComprarAcciones_1_1_3);

		JButton back = new JButton("");
		back.setIcon(new ImageIcon(Usuarios.class.getResource("/imagenes/BackButton.png")));
		back.setBorder(null);
		back.setBackground(new Color(214, 234, 248));
		back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				ClienteVo.destroy();
				CuentaVo.destroy();
				coordinador.ocultarVentanaUsuarios();
				coordinador.mostrarVentanaIncio();
			}
		});
		back.setBounds(10, 655, 150, 114);
		contentPane.add(back);
	}
}
