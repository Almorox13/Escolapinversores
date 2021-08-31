package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Coordinador;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.ImageIcon;

public class DarseDeBajaOperador extends JFrame {
	private Coordinador coordinador;
	private JPanel contentPane;
	private JFrame frame;
	private Color fondo = new Color(214, 234, 248);

	public JFrame getFrame() {
		
		return frame;
	}
	public void setCoordinator(Coordinador coordinador) {
		this.coordinador = coordinador;
	}

	public DarseDeBajaOperador() {
		frame = new JFrame();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 618, 600);
		contentPane = new JPanel();
		contentPane.setBackground(fondo);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Solicitudes de bajas");
		lblNewLabel.setForeground(new Color(0, 102, 153));
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 35));
		lblNewLabel.setBounds(142, 11, 326, 55);
		contentPane.add(lblNewLabel);
		
		JSpinner caja_idcliente = new JSpinner();
		caja_idcliente.setFont(new Font("Calibri", Font.BOLD, 20));
		caja_idcliente.setBorder(null);
		caja_idcliente.setBounds(150, 495, 108, 29);
		contentPane.add(caja_idcliente);
		
		JLabel lblNewLabel_1 = new JLabel("Id cliente");
		lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD, 20));
		lblNewLabel_1.setForeground(new Color(0, 102, 153));
		lblNewLabel_1.setBounds(161, 468, 137, 29);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("ID");
		lblNewLabel_2.setForeground(new Color(0, 102, 153));
		lblNewLabel_2.setFont(new Font("Calibri", Font.BOLD, 18));
		lblNewLabel_2.setBounds(39, 61, 62, 31);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Nombre");
		lblNewLabel_3.setForeground(new Color(0, 102, 153));
		lblNewLabel_3.setFont(new Font("Calibri", Font.BOLD, 18));
		lblNewLabel_3.setBounds(95, 60, 62, 32);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Apellido");
		lblNewLabel_4.setForeground(new Color(0, 102, 153));
		lblNewLabel_4.setFont(new Font("Calibri", Font.BOLD, 18));
		lblNewLabel_4.setBounds(198, 60, 77, 32);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("DNI");
		lblNewLabel_5.setFont(new Font("Calibri", Font.BOLD, 18));
		lblNewLabel_5.setForeground(new Color(0, 102, 153));
		lblNewLabel_5.setBounds(307, 60, 62, 32);
		contentPane.add(lblNewLabel_5);
		
		JTextArea area_id = new JTextArea();
		area_id.setFont(new Font("Calibri", Font.BOLD, 20));
		area_id.setBounds(29, 89, 46, 323);
		contentPane.add(area_id);
		
		JTextArea area_nombre = new JTextArea();
		area_nombre.setBounds(85, 90, 77, 323);
		contentPane.add(area_nombre);
		
		JTextArea area_apellido = new JTextArea();
		area_apellido.setBounds(172, 90, 109, 323);
		contentPane.add(area_apellido);
		
		JTextArea area_dni = new JTextArea();
		area_dni.setBounds(291, 90, 78, 322);
		contentPane.add(area_dni);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon(DarseDeBajaOperador.class.getResource("/imagenes/BackButton.png")));
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setBounds(10, 479, 73, 71);
		btnNewButton_1.setBackground(fondo);
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				coordinador.OcultarDarseDeBajaOperador();
				coordinador.mostrarVentanaOperarios();
			}
		});
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_6 = new JLabel("Cuenta real");
		lblNewLabel_6.setForeground(new Color(0, 102, 153));
		lblNewLabel_6.setFont(new Font("Calibri", Font.BOLD, 18));
		lblNewLabel_6.setBounds(379, 60, 89, 32);
		contentPane.add(lblNewLabel_6);
		
		JTextArea caja_cuentareal = new JTextArea();
		caja_cuentareal.setBounds(379, 90, 89, 322);
		contentPane.add(caja_cuentareal);
		
		JLabel lblNewLabel_7 = new JLabel("Telefono");
		lblNewLabel_7.setFont(new Font("Calibri", Font.BOLD, 18));
		lblNewLabel_7.setForeground(new Color(0, 102, 153));
		lblNewLabel_7.setBounds(490, 65, 77, 23);
		contentPane.add(lblNewLabel_7);
		
		JTextArea caja_telefono = new JTextArea();
		caja_telefono.setBounds(478, 90, 89, 322);
		contentPane.add(caja_telefono);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(DarseDeBajaOperador.class.getResource("/imagenes/Verificar.png")));
		btnNewButton.setBorder(null);
		btnNewButton.setBackground(fondo);
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				JTextField dni = new JTextField(5);
				JTextField contraseña = new JTextField(5);
				
				JPanel myPanel = new JPanel();
			      myPanel.add(new JLabel("DNI: "));
			      myPanel.add(dni);
			      myPanel.add(new JLabel("Contraseña:"));
			      myPanel.add(contraseña);

			      int result = JOptionPane.showConfirmDialog(null, myPanel, 
			               "Esta acción requiere de un supervisor", JOptionPane.OK_CANCEL_OPTION);
				if((result == JOptionPane.OK_OPTION) && (coordinador.comprobarSupervidor(dni.getText().toString(), contraseña.getText().toString()))) {
				
					int idcliente=(int)caja_idcliente.getValue();
					coordinador.darsedebaja(idcliente);
			
				}else {
					JOptionPane.showMessageDialog(null, "Usuario o Contraseña incorrecto", "Información",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnNewButton.setBounds(503, 455, 89, 95);
		contentPane.add(btnNewButton);
		frame.getContentPane().add(contentPane);
		
		JButton a = new JButton("");
		a.setIcon(new ImageIcon(DarseDeBajaOperador.class.getResource("/imagenes/recargar.png")));
		a.setBorder(null);
		a.setBounds(331, 444, 137, 106);
		a.setBackground(fondo);
		a.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				mostrarsolicitudesbaja(area_id, area_nombre, area_apellido, area_dni, caja_cuentareal, caja_telefono, coordinador.mostrarClientesBaja());
			}
		});
		contentPane.add(a);
	}
	
	private void mostrarsolicitudesbaja(JTextArea areaid,JTextArea areanombre,JTextArea areaapellido,JTextArea areadni,JTextArea areacuentareal,JTextArea areatelefono,String [][] datos) {
		areaid.setText(" ");
		areanombre.setText(" ");
		areaapellido.setText(" ");
		areadni.setText(" ");
		areacuentareal.setText(" ");
		areatelefono.setText(" ");
		int cont=1;
		
		while(cont<16) {
			areaid.append(datos[cont][1]+"\n");
			areanombre.append(datos[cont][2]+"\n");
			areaapellido.append(datos[cont][3]+"\n");
			areadni.append(datos[cont][4]+"\n");
			areacuentareal.append(datos[cont][5]+"\n");
			areatelefono.append(datos[cont][6]+"\n");
			cont++;	
		}
	}
}
