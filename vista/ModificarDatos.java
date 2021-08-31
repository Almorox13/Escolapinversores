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
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class ModificarDatos extends JFrame {

	private Coordinador coordinador;
	private JPanel contentPane;
	private JFrame frame;
	private Color fondo = new Color(214, 234, 248);
	private JTextField inname;
	private JTextField inapellido;
	private JTextField indni;
	private JTextField incuenta;
	private JTextField intelf;
	private JTextField indomicilio;
	private JTextField incontraseña;
	private JTextField infech;
	private JTextField inid;

	public JFrame getFrame() {
		return frame;
	}

	public void setCoordinator(Coordinador coordinador) {
		this.coordinador = coordinador;
	}

	public ModificarDatos() {
		frame = new JFrame();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 710, 469);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(fondo);
		frame.getContentPane().add(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Modificar Datos");
		lblNewLabel.setBounds(185, 29, 486, 72);
		lblNewLabel.setForeground(new Color(0, 102, 153));
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 45));
		contentPane.add(lblNewLabel);

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
				coordinador.Ocultarhistorialoperador();
				coordinador.mostrarVentanaOperarios();
			}
		});
		btnNewButton_1.setBounds(10, 346, 89, 73);
		contentPane.add(btnNewButton_1);
		
		
		JLabel lblNewLabel_7_2 = new JLabel("Nombre");
		lblNewLabel_7_2.setForeground(new Color(0, 102, 153));
		lblNewLabel_7_2.setFont(new Font("Calibri", Font.BOLD, 20));
		lblNewLabel_7_2.setBounds(40, 127, 95, 31);
		contentPane.add(lblNewLabel_7_2);
		
		inname = new JTextField();
		inname.setFont(new Font("Calibri", Font.BOLD, 20));
		inname.setForeground(new Color(0, 102, 153));
		inname.setBorder(null);
		inname.setBounds(133, 128, 150, 27);
		contentPane.add(inname);
		inname.setColumns(10);
		
		JLabel lblNewLabel_7_2_1 = new JLabel("Apellido");
		lblNewLabel_7_2_1.setForeground(new Color(0, 102, 153));
		lblNewLabel_7_2_1.setFont(new Font("Calibri", Font.BOLD, 20));
		lblNewLabel_7_2_1.setBounds(40, 175, 95, 31);
		contentPane.add(lblNewLabel_7_2_1);
		
		inapellido = new JTextField();
		inapellido.setForeground(new Color(0, 102, 153));
		inapellido.setFont(new Font("Calibri", Font.BOLD, 20));
		inapellido.setColumns(10);
		inapellido.setBorder(null);
		inapellido.setBounds(133, 176, 150, 27);
		contentPane.add(inapellido);
		
		JLabel lblNewLabel_7_2_2 = new JLabel("DNI");
		lblNewLabel_7_2_2.setForeground(new Color(0, 102, 153));
		lblNewLabel_7_2_2.setFont(new Font("Calibri", Font.BOLD, 20));
		lblNewLabel_7_2_2.setBounds(40, 226, 95, 31);
		contentPane.add(lblNewLabel_7_2_2);
		
		indni = new JTextField();
		indni.setForeground(new Color(0, 102, 153));
		indni.setFont(new Font("Calibri", Font.BOLD, 20));
		indni.setColumns(10);
		indni.setBorder(null);
		indni.setBounds(133, 227, 150, 27);
		contentPane.add(indni);
		
		JLabel lblNewLabel_7_2_3 = new JLabel("Cuenta");
		lblNewLabel_7_2_3.setForeground(new Color(0, 102, 153));
		lblNewLabel_7_2_3.setFont(new Font("Calibri", Font.BOLD, 20));
		lblNewLabel_7_2_3.setBounds(40, 276, 95, 31);
		contentPane.add(lblNewLabel_7_2_3);
		
		incuenta = new JTextField();
		incuenta.setForeground(new Color(0, 102, 153));
		incuenta.setFont(new Font("Calibri", Font.BOLD, 20));
		incuenta.setColumns(10);
		incuenta.setBorder(null);
		incuenta.setBounds(133, 277, 150, 27);
		contentPane.add(incuenta);
		
		JLabel lblNewLabel_7_2_4 = new JLabel("Tel\u00E9fono");
		lblNewLabel_7_2_4.setForeground(new Color(0, 102, 153));
		lblNewLabel_7_2_4.setFont(new Font("Calibri", Font.BOLD, 20));
		lblNewLabel_7_2_4.setBounds(362, 127, 95, 31);
		contentPane.add(lblNewLabel_7_2_4);
		
		intelf = new JTextField();
		intelf.setForeground(new Color(0, 102, 153));
		intelf.setFont(new Font("Calibri", Font.BOLD, 20));
		intelf.setColumns(10);
		intelf.setBorder(null);
		intelf.setBounds(478, 129, 150, 27);
		contentPane.add(intelf);
		
		JLabel lblNewLabel_7_2_5 = new JLabel("Domicilio");
		lblNewLabel_7_2_5.setForeground(new Color(0, 102, 153));
		lblNewLabel_7_2_5.setFont(new Font("Calibri", Font.BOLD, 20));
		lblNewLabel_7_2_5.setBounds(362, 175, 95, 31);
		contentPane.add(lblNewLabel_7_2_5);
		
		indomicilio = new JTextField();
		indomicilio.setForeground(new Color(0, 102, 153));
		indomicilio.setFont(new Font("Calibri", Font.BOLD, 20));
		indomicilio.setColumns(10);
		indomicilio.setBorder(null);
		indomicilio.setBounds(478, 177, 150, 27);
		contentPane.add(indomicilio);
		
		JLabel lblNewLabel_7_2_6 = new JLabel("Contrase\u00F1a");
		lblNewLabel_7_2_6.setForeground(new Color(0, 102, 153));
		lblNewLabel_7_2_6.setFont(new Font("Calibri", Font.BOLD, 20));
		lblNewLabel_7_2_6.setBounds(362, 226, 112, 31);
		contentPane.add(lblNewLabel_7_2_6);
		
		incontraseña = new JTextField();
		incontraseña.setForeground(new Color(0, 102, 153));
		incontraseña.setFont(new Font("Calibri", Font.BOLD, 20));
		incontraseña.setColumns(10);
		incontraseña.setBorder(null);
		incontraseña.setBounds(478, 228, 150, 27);
		contentPane.add(incontraseña);
		
		JLabel infecha = new JLabel("Fecha");
		infecha.setForeground(new Color(0, 102, 153));
		infecha.setFont(new Font("Calibri", Font.BOLD, 20));
		infecha.setBounds(362, 276, 95, 31);
		contentPane.add(infecha);
		
		infech = new JTextField();
		infech.setForeground(new Color(0, 102, 153));
		infech.setFont(new Font("Calibri", Font.BOLD, 20));
		infech.setColumns(10);
		infech.setBorder(null);
		infech.setBounds(478, 278, 150, 27);
		contentPane.add(infech);
		
		JLabel lblNewLabel_7_2_8 = new JLabel("ID Cliente");
		lblNewLabel_7_2_8.setForeground(new Color(0, 102, 153));
		lblNewLabel_7_2_8.setFont(new Font("Calibri", Font.BOLD, 20));
		lblNewLabel_7_2_8.setBounds(186, 361, 95, 31);
		contentPane.add(lblNewLabel_7_2_8);
		
		inid = new JTextField();
		inid.setForeground(new Color(0, 102, 153));
		inid.setFont(new Font("Calibri", Font.BOLD, 20));
		inid.setColumns(10);
		inid.setBorder(null);
		inid.setBounds(291, 363, 150, 27);
		contentPane.add(inid);
		
		JButton verificar = new JButton("");
		verificar.setIcon(new ImageIcon(ModificarDatos.class.getResource("/imagenes/Verificar.png")));
		verificar.setBorder(null);
		verificar.setBackground(new Color(214, 234, 248));
		verificar.setBounds(579, 327, 105, 103);
		verificar.addActionListener(new ActionListener() {
			
			@Override
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
				
					String id = inid.getText().toString();
	
					String[] datos = {
							inname.getText().toString(),
							inapellido.getText().toString(),
							indni.getText().toString(),
							incuenta.getText().toString(),
							infech.getText().toString(),
							indomicilio.getText().toString(),
							intelf.getText().toString(),
							incontraseña.getText().toString()};
					
					if(coordinador.modificarDatos(datos, id)) {
						
						JOptionPane.showMessageDialog(null, "Modificado Correctamente", "Información",
								JOptionPane.INFORMATION_MESSAGE);
						
					}else {
						JOptionPane.showMessageDialog(null, "No se ha modificado", "Información",
								JOptionPane.INFORMATION_MESSAGE);				
					}
				}else {
					
				}
			}
		});
		contentPane.add(verificar);
		
		JButton buscar = new JButton("");
		buscar.setIcon(new ImageIcon(ModificarDatos.class.getResource("/imagenes/Registrar.png")));
		buscar.setBorder(null);
		buscar.setBackground(new Color(214, 234, 248));
		buscar.setBounds(490, 346, 70, 70);
		buscar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				String id = inid.getText().toString();
				
				String[] datos = coordinador.getDatos(id);
				
				inname.setText(datos[0]);
				inapellido.setText(datos[1]);
				indni.setText(datos[2]);
				incuenta.setText(datos[3]);
				infech.setText(datos[4]);
				indomicilio.setText(datos[5]);
				intelf.setText(datos[6]);
				incontraseña.setText(datos[7]);
			}
		});
		contentPane.add(buscar);

	}
}