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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Saldo extends JFrame {

	private JPanel contentPane;
	private JFrame frame;
	private Coordinador coordinador;
	private JLabel texto;
	private JButton btnNewButton;
	private Color fondo = new Color(214, 234, 248);

	public JFrame getFrame() {
		return frame;
	}
	public void setCoordinador(Coordinador coordinador) {
		this.coordinador = coordinador;

	}
	
	public Saldo() {
		frame = new JFrame();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(500, 500, 653, 283);
		contentPane = new JPanel();
		contentPane.setBackground(fondo);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);

		texto = new JLabel("El saldo de tu cuenta es:");
		texto.setForeground(new Color(0, 102, 153));
		texto.setFont(new Font("Calibri", Font.BOLD, 35));
		texto.setBounds(29, 22, 598, 59);
		contentPane.add(texto);
		
		JButton atras = new JButton("");
		atras.setIcon(new ImageIcon(Saldo.class.getResource("/imagenes/BackButton.png")));
		atras.setBorder(null);
		atras.setBackground(fondo);
		atras.setBounds(10, 152, 89, 81);
		atras.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				coordinador.OcultarVentanaSaldo_cuenta();
				coordinador.mostrarVentanaUsuarios();
			}
		});
		contentPane.add(atras);
		frame.getContentPane().add(contentPane);
		
		btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(Saldo.class.getResource("/imagenes/recargar.png")));
		btnNewButton.setBorder(null);
		btnNewButton.setBackground(fondo);
		btnNewButton.setBounds(498, 120, 129, 113);
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CuentaVo cuentavo = CuentaVo.getSingletonInstance(0);
				texto.setText("Saldo disponible:  " + cuentavo.getSaldo() + "€");
			}
			
		});
		contentPane.add(btnNewButton);
	}
}
