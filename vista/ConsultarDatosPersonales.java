package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Coordinador;
import modelo.vo.ClienteVo;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class ConsultarDatosPersonales extends JFrame {

	private JTextField cajanombre;
	private JTextField cajadni;
	private JTextField cajacuentareal;
	private JTextField cajafechanacimiento;
	private JTextField cajaapellido;
	private JTextField cajadomicilio;
	private JTextField cajatelefono;
	private JTextField cajacontraseña;
	private Color fondo = new Color(214, 234, 248);

	private JFrame frame;
	private JPanel contentPane;
	private Coordinador coordinador;

	public JFrame getFrame() {
		mostrarDatos();
		return frame;
	}

	public void setCoordinador(Coordinador coordinador) {
		this.coordinador = coordinador;
	}

	public ConsultarDatosPersonales() {
		frame = new JFrame();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 807, 491);
		contentPane = new JPanel();
		contentPane.setBackground(fondo);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		frame.getContentPane().add(contentPane);
		
		JLabel lblNewLabel = new JLabel("Datos Personales");
		lblNewLabel.setForeground(new Color(0, 102, 153));
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 35));
		lblNewLabel.setBounds(271, 22, 270, 42);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setForeground(new Color(0, 102, 153));
		lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD, 20));
		lblNewLabel_1.setBounds(38, 94, 95, 38);
		contentPane.add(lblNewLabel_1);

		cajanombre = new JTextField();
		cajanombre.setForeground(new Color(0, 0, 0));
		cajanombre.setBackground(fondo);
		cajanombre.setBorder(null);
		cajanombre.setFont(new Font("Calibri", Font.BOLD, 20));
		cajanombre.setBounds(230, 97, 170, 35);
		contentPane.add(cajanombre);
		cajanombre.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("DNI:");
		lblNewLabel_2.setForeground(new Color(0, 102, 153));
		lblNewLabel_2.setFont(new Font("Calibri", Font.BOLD, 20));
		lblNewLabel_2.setBounds(38, 161, 75, 37);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("IBAN:");
		lblNewLabel_3.setForeground(new Color(0, 102, 153));
		lblNewLabel_3.setFont(new Font("Calibri", Font.BOLD, 20));
		lblNewLabel_3.setBounds(38, 225, 141, 41);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Fecha Nacimiento:");
		lblNewLabel_4.setForeground(new Color(0, 102, 153));
		lblNewLabel_4.setFont(new Font("Calibri", Font.BOLD, 20));
		lblNewLabel_4.setBounds(38, 292, 161, 38);
		contentPane.add(lblNewLabel_4);

		cajadni = new JTextField();
		cajadni.setSelectionColor(new Color(0, 0, 0));
		cajadni.setForeground(Color.BLACK);
		cajadni.setBackground(new Color(100, 149, 237));
		cajadni.setBorder(null);
		cajadni.setFont(new Font("Calibri", Font.BOLD, 20));
		cajadni.setBounds(230, 163, 170, 35);
		cajadni.setBackground(fondo);
		contentPane.add(cajadni);
		cajadni.setColumns(10);

		cajacuentareal = new JTextField();
		cajacuentareal.setSelectionColor(new Color(0, 0, 0));
		cajacuentareal.setForeground(Color.BLACK);
		cajacuentareal.setBackground(new Color(100, 149, 237));
		cajacuentareal.setBorder(null);
		cajacuentareal.setBackground(fondo);
		cajacuentareal.setFont(new Font("Calibri", Font.BOLD, 20));
		cajacuentareal.setBounds(230, 229, 170, 35);
		contentPane.add(cajacuentareal);
		cajacuentareal.setColumns(10);

		cajafechanacimiento = new JTextField();
		cajafechanacimiento.setSelectionColor(new Color(0, 0, 0));
		cajafechanacimiento.setForeground(Color.BLACK);
		cajafechanacimiento.setBackground(new Color(100, 149, 237));
		cajafechanacimiento.setBorder(null);
		cajafechanacimiento.setBackground(fondo);
		cajafechanacimiento.setFont(new Font("Calibri", Font.BOLD, 20));
		cajafechanacimiento.setBounds(230, 295, 170, 35);
		contentPane.add(cajafechanacimiento);
		cajafechanacimiento.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Apellido:");
		lblNewLabel_5.setForeground(new Color(0, 102, 153));
		lblNewLabel_5.setFont(new Font("Calibri", Font.BOLD, 20));
		lblNewLabel_5.setBounds(445, 96, 124, 34);
		contentPane.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("Domicilio:");
		lblNewLabel_6.setForeground(new Color(0, 102, 153));
		lblNewLabel_6.setFont(new Font("Calibri", Font.BOLD, 20));
		lblNewLabel_6.setBounds(445, 162, 124, 35);
		contentPane.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("Tel\u00E9fono:");
		lblNewLabel_7.setForeground(new Color(0, 102, 153));
		lblNewLabel_7.setFont(new Font("Calibri", Font.BOLD, 20));
		lblNewLabel_7.setBounds(445, 228, 124, 35);
		contentPane.add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("Contrase\u00F1a:");
		lblNewLabel_8.setForeground(new Color(0, 102, 153));
		lblNewLabel_8.setFont(new Font("Calibri", Font.BOLD, 20));
		lblNewLabel_8.setBounds(445, 297, 124, 29);
		contentPane.add(lblNewLabel_8);

		cajaapellido = new JTextField();
		cajaapellido.setFont(new Font("Calibri", Font.BOLD, 20));
		cajaapellido.setSelectionColor(new Color(0, 0, 0));
		cajaapellido.setForeground(Color.BLACK);
		cajaapellido.setBackground(new Color(100, 149, 237));
		cajaapellido.setBorder(null);
		cajaapellido.setBounds(592, 95, 170, 35);
		contentPane.add(cajaapellido);
		cajaapellido.setColumns(10);
		cajaapellido.setBackground(fondo);


		cajadomicilio = new JTextField();
		cajadomicilio.setFont(new Font("Calibri", Font.BOLD, 20));
		cajadomicilio.setSelectionColor(new Color(0, 0, 0));
		cajadomicilio.setForeground(Color.BLACK);
		cajadomicilio.setBackground(new Color(100, 149, 237));
		cajadomicilio.setBorder(null);
		cajadomicilio.setBounds(592, 161, 170, 35);
		contentPane.add(cajadomicilio);
		cajadomicilio.setColumns(10);
		cajadomicilio.setBackground(fondo);


		cajatelefono = new JTextField();
		cajatelefono.setFont(new Font("Calibri", Font.BOLD, 20));
		cajatelefono.setSelectionColor(new Color(0, 0, 0));
		cajatelefono.setForeground(Color.BLACK);
		cajatelefono.setBackground(new Color(100, 149, 237));
		cajatelefono.setBorder(null);
		cajatelefono.setBounds(592, 227, 170, 35);
		contentPane.add(cajatelefono);
		cajatelefono.setColumns(10);
		cajatelefono.setBackground(fondo);


		cajacontraseña = new JTextField();
		cajacontraseña.setFont(new Font("Calibri", Font.BOLD, 20));
		cajacontraseña.setSelectionColor(new Color(0, 0, 0));
		cajacontraseña.setForeground(Color.BLACK);
		cajacontraseña.setBackground(new Color(100, 149, 237));
		cajacontraseña.setBorder(null);
		cajacontraseña.setBounds(592, 293, 170, 35);
		contentPane.add(cajacontraseña);
		cajacontraseña.setColumns(10);
		cajacontraseña.setBackground(fondo);

				
		JButton atras = new JButton("");
		atras.setIcon(new ImageIcon(ConsultarDatosPersonales.class.getResource("/imagenes/BackButton.png")));
		atras.setBorder(null);
		atras.setBackground(fondo);
		atras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				coordinador.ocultarVentanaDatosPersonales();
				coordinador.mostrarVentanaUsuarios();
			}
		});
		atras.setBounds(10, 368, 89, 73);
		contentPane.add(atras);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(25, 33, 0, 0);
		contentPane.add(btnNewButton);
	}

	private void mostrarDatos() {
		
		ClienteVo clienteVo = ClienteVo.getSingletonInstance("", "");
				
		cajanombre.setText(clienteVo.getNombre());
		cajaapellido.setText(clienteVo.getApellido());
		cajadni.setText(clienteVo.getDni());
		cajacuentareal.setText(clienteVo.getCuentaReal());
		cajafechanacimiento.setText(clienteVo.getFechaNacimiento());
		cajadomicilio.setText(clienteVo.getDomicilio());
		cajatelefono.setText(clienteVo.getTelefono());
		cajacontraseña.setText(clienteVo.getContraseña());
	}
}
