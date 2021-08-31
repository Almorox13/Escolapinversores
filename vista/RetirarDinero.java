package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Coordinador;
import modelo.vo.CuentaVo;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class RetirarDinero extends JFrame {

	private Coordinador coordinador;
	private JPanel contentPane;
	private JTextField caja_fecha;
	private JFrame frame;
	private Color fondo = new Color(214, 234, 248);

	/**
	 * Launch the application.
	 */
	public JFrame getFrame() {
		return frame;
	}

	public void setCoordinator(Coordinador coordinador) {
		this.coordinador = coordinador;
	}
	/**
	 * Create the frame.
	 */
	public RetirarDinero() {
		frame = new JFrame();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(500, 500, 664, 223);
		contentPane = new JPanel();
		contentPane.setBackground(fondo);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Saldo a retirar");
		lblNewLabel.setForeground(new Color(0, 102, 153));
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 30));
		lblNewLabel.setBounds(133, 34, 193, 48);
		contentPane.add(lblNewLabel);
		
		JSpinner saldo_retirar = new JSpinner();
		saldo_retirar.setBorder(null);
		saldo_retirar.setFont(new Font("Calibri", Font.BOLD, 25));
		saldo_retirar.setBounds(336, 38, 144, 35);
		contentPane.add(saldo_retirar);
		
		JButton Retirar = new JButton("");
		Retirar.setIcon(new ImageIcon(RetirarDinero.class.getResource("/imagenes/Verificar.png")));
		Retirar.setBorder(null);
		Retirar.setBackground(fondo);
		Retirar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int s = (int)saldo_retirar.getValue();
				
				if(s > 0) {
					double saldoRetirar=s;
					CuentaVo cuentavo=CuentaVo.getSingletonInstance(0);
					coordinador.retirarDinero(cuentavo, saldoRetirar);
				}else {
					System.out.println("El saldo no puede ser nagativo");
				}
			}
		});
		Retirar.setBounds(523, 85, 115, 88);
		contentPane.add(Retirar);
		
		JButton atras = new JButton("");
		atras.setBorder(null);
		atras.setBackground(fondo);
		atras.setIcon(new ImageIcon(RetirarDinero.class.getResource("/imagenes/BackButton.png")));
		atras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				coordinador.OcultarVentanaRetirarDinero();
				coordinador.mostrarVentanaUsuarios();
			}
		});
		atras.setBounds(10, 98, 74, 73);
		contentPane.add(atras);
		frame.getContentPane().add(contentPane);
	}
}
