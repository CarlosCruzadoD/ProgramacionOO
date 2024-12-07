package Vistas.Gerente;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Clases.Gerente;
import Clases.JFAlmacen;
import Clases.Producto;
import Clases.ProductoVender;
import Clases.Vendedor;
import Clases.Venta;
import Controladores.ProductosBD;
import Controladores.TrabajadorBD;
import Controladores.VentaBD;

import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.sql.Date;
import java.awt.event.KeyEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JPasswordField;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Color;

public class Gerente_Almacen extends JDialog implements ActionListener, KeyListener, MouseListener {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblDatosDeV;
	private JLabel lblNombre;
	private JLabel lblApellidos;
	private JLabel lblDni;
	private JLabel lblGenero;
	private JLabel lblCorreo;
	private JLabel lblCelular;
	private JLabel lblEdad;
	private JLabel lblUsuario;
	private JLabel lblSueldo;
	private JLabel lblContrasea;
	private JLabel lblCodigoTrabajador;
	private JTextField txt_Cod;
	private JTextField txt_nombre;
	private JTextField txt_apellido;
	private JTextField txt_dni;
	private JComboBox cb_genero;
	private JTextField txt_celular;
	private JTextField txt_edad;
	private JTextField txt_user;
	private JTextField txt_sueldo;
	private JButton btnNewButton;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JScrollPane scrollPane;
	private JTable JTable;
	private DefaultTableModel tableModel;
	private JTextField txtFnombre;
	private JTextField txtFapellido;
	private JTextField txtFdni;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Gerente_Almacen dialog = new Gerente_Almacen();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Gerente_Almacen() {
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setTitle("Jefe de Almacen");
		setBounds(100, 100, 899, 713);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			lblDatosDeV = new JLabel("Jefe de almacen");
			lblDatosDeV.setHorizontalAlignment(SwingConstants.CENTER);
			lblDatosDeV.setFont(new Font("Tahoma", Font.BOLD, 20));
			lblDatosDeV.setBounds(289, 1, 165, 40);
			contentPanel.add(lblDatosDeV);
		}
		{
			lblNombre = new JLabel("Nombre");
			lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNombre.setBounds(30, 80, 93, 25);
			contentPanel.add(lblNombre);
		}
		{
			lblApellidos = new JLabel("Apellidos");
			lblApellidos.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblApellidos.setBounds(30, 116, 69, 25);
			contentPanel.add(lblApellidos);
		}
		{
			lblDni = new JLabel("DNI");
			lblDni.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblDni.setBounds(30, 156, 46, 25);
			contentPanel.add(lblDni);
		}
		{
			lblGenero = new JLabel("G\u00E9nero");
			lblGenero.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblGenero.setBounds(30, 200, 46, 25);
			contentPanel.add(lblGenero);
		}
		{
			lblCorreo = new JLabel("Correo");
			lblCorreo.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblCorreo.setBounds(390, 50, 46, 25);
			contentPanel.add(lblCorreo);
		}
		{
			lblCelular = new JLabel("Celular");
			lblCelular.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblCelular.setBounds(390, 86, 46, 25);
			contentPanel.add(lblCelular);
		}
		{
			lblEdad = new JLabel("Edad");
			lblEdad.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblEdad.setBounds(390, 120, 46, 25);
			contentPanel.add(lblEdad);
		}
		{
			lblUsuario = new JLabel("Usuario");
			lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblUsuario.setBounds(390, 161, 46, 25);
			contentPanel.add(lblUsuario);
		}
		{
			lblSueldo = new JLabel("Sueldo");
			lblSueldo.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblSueldo.setBounds(390, 243, 46, 25);
			contentPanel.add(lblSueldo);
		}
		{
			lblContrasea = new JLabel("Contrase\u00F1a");
			lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblContrasea.setBounds(390, 200, 101, 25);
			contentPanel.add(lblContrasea);
		}
		{
			lblCodigoTrabajador = new JLabel("C\u00F3digo Trabajador");
			lblCodigoTrabajador.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblCodigoTrabajador.setBounds(30, 47, 119, 25);
			contentPanel.add(lblCodigoTrabajador);
		}
		{
			txt_Cod = new JTextField();
			txt_Cod.setBounds(155, 49, 120, 25);
			contentPanel.add(txt_Cod);
			txt_Cod.setColumns(10);
		}
		{
			txt_nombre = new JTextField();
			txt_nombre.setBounds(155, 82, 134, 25);
			contentPanel.add(txt_nombre);
			txt_nombre.setColumns(10);
		}
		{
			txt_apellido = new JTextField();
			txt_apellido.setBounds(155, 119, 134, 25);
			contentPanel.add(txt_apellido);
			txt_apellido.setColumns(10);
		}
		{
			txt_dni = new JTextField();
			txt_dni.addKeyListener(this);
			txt_dni.setBounds(155, 158, 74, 25);
			contentPanel.add(txt_dni);
			txt_dni.setColumns(10);
		}
		{
			cb_genero = new JComboBox();
			cb_genero.setModel(new DefaultComboBoxModel(new String[] {"Masculino", "Femenino"}));
			cb_genero.setBounds(155, 200, 120, 25);
			contentPanel.add(cb_genero);
		}
		{
			txt_celular = new JTextField();
			txt_celular.addKeyListener(this);
			txt_celular.setBounds(464, 86, 74, 25);
			contentPanel.add(txt_celular);
			txt_celular.setColumns(10);
		}
		{
			txt_edad = new JTextField();
			txt_edad.addKeyListener(this);
			txt_edad.setBounds(464, 122, 69, 25);
			contentPanel.add(txt_edad);
			txt_edad.setColumns(10);
		}
		{
			txt_user = new JTextField();
			txt_user.setBounds(464, 161, 150, 25);
			contentPanel.add(txt_user);
			txt_user.setColumns(10);
		}
		{
			txt_sueldo = new JTextField();
			txt_sueldo.addKeyListener(this);
			txt_sueldo.setBounds(464, 245, 74, 25);
			contentPanel.add(txt_sueldo);
			txt_sueldo.setColumns(10);
		}
		{
			btnNewButton = new JButton("   Agregar");
			btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
			btnNewButton.setIcon(new ImageIcon(Gerente_Almacen.class.getResource("/Imagenes/plus-circle-regular-24.png")));
			btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnNewButton.addActionListener(this);
			btnNewButton.setBounds(709, 50, 133, 36);
			contentPanel.add(btnNewButton);
		}
		{
			btnModificar = new JButton("   Modificar");
			btnModificar.setIcon(new ImageIcon(Gerente_Almacen.class.getResource("/Imagenes/edit-solid-24.png")));
			btnModificar.setHorizontalAlignment(SwingConstants.LEFT);
			btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnModificar.addActionListener(this);
			btnModificar.setBounds(709, 102, 133, 36);
			contentPanel.add(btnModificar);
		}
		{
			btnEliminar = new JButton("   Eliminar");
			btnEliminar.setIcon(new ImageIcon(Gerente_Almacen.class.getResource("/Imagenes/trash-alt-solid-24.png")));
			btnEliminar.setHorizontalAlignment(SwingConstants.LEFT);
			btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnEliminar.addActionListener(this);
			btnEliminar.setBounds(709, 155, 133, 36);
			contentPanel.add(btnEliminar);
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(30, 358, 812, 290);
			contentPanel.add(scrollPane);
			{
				tableModel = new DefaultTableModel(
			            new Object[][] {},
			            new String[] {
			                "Código Jefe de Almacen", "Nombres", "Apellidos", "DNI",
			                "Genero", "Correo", "Celular", "Edad", "Sueldo",
			                "Area"
			            }
			        );

				JTable = new JTable(tableModel);
				JTable.addMouseListener(this);
				scrollPane.setViewportView(JTable);
				{
					txtFnombre = new JTextField();
					txtFnombre.addKeyListener(this);
					txtFnombre.setBounds(30, 327, 139, 25);
					contentPanel.add(txtFnombre);
					txtFnombre.setColumns(10);
				}
				{
					txtFapellido = new JTextField();
					txtFapellido.addKeyListener(this);
					txtFapellido.setColumns(10);
					txtFapellido.setBounds(179, 327, 139, 25);
					contentPanel.add(txtFapellido);
				}
				{
					txtFdni = new JTextField();
					txtFdni.addKeyListener(this);
					txtFdni.setColumns(10);
					txtFdni.setBounds(328, 327, 139, 25);
					contentPanel.add(txtFdni);
				}
				{
					button = new JButton("");
					button.addActionListener(this);
					button.setIcon(new ImageIcon(Gerente_Almacen.class.getResource("/Imagenes/aleatorio.png")));
					button.setBounds(285, 47, 44, 25);
					contentPanel.add(button);
				}
				{
					lblNombre_1 = new JLabel("Buscar Nombre");
					lblNombre_1.setHorizontalAlignment(SwingConstants.CENTER);
					lblNombre_1.setBounds(30, 308, 139, 14);
					contentPanel.add(lblNombre_1);
				}
				{
					lblApellido = new JLabel("Buscar Apellido:");
					lblApellido.setHorizontalAlignment(SwingConstants.CENTER);
					lblApellido.setBounds(179, 308, 139, 14);
					contentPanel.add(lblApellido);
				}
				{
					lblDni_1 = new JLabel("Buscar DNI:");
					lblDni_1.setHorizontalAlignment(SwingConstants.CENTER);
					lblDni_1.setBounds(328, 308, 139, 14);
					contentPanel.add(lblDni_1);
				}
				{
					lblPorcentajeDeComision = new JLabel("\u00C1rea");
					lblPorcentajeDeComision.setFont(new Font("Tahoma", Font.PLAIN, 14));
					lblPorcentajeDeComision.setHorizontalAlignment(SwingConstants.LEFT);
					lblPorcentajeDeComision.setBounds(30, 243, 69, 25);
					contentPanel.add(lblPorcentajeDeComision);
				}
				{
					txt_pass = new JPasswordField();
					txt_pass.setBounds(464, 204, 150, 25);
					contentPanel.add(txt_pass);
				}
				{
					txt_area = new JTextField();
					txt_area.setColumns(10);
					txt_area.setBounds(155, 247, 120, 25);
					contentPanel.add(txt_area);
				}
				{
					txt_correo = new JTextField();
					txt_correo.setColumns(10);
					txt_correo.setBounds(464, 49, 74, 25);
					contentPanel.add(txt_correo);
				}
				{
					label = new JLabel("@");
					label.setHorizontalAlignment(SwingConstants.CENTER);
					label.setFont(new Font("Tahoma", Font.PLAIN, 14));
					label.setBounds(534, 50, 28, 25);
					contentPanel.add(label);
				}
				{
					comboBox = new JComboBox();
					comboBox.setModel(new DefaultComboBoxModel(new String[] {"gmail.com", "hotmail.com"}));
					comboBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
					comboBox.setBounds(560, 50, 93, 25);
					contentPanel.add(comboBox);
				}
				{
					lbldniNum = new JLabel("SOLO N\u00DAMEROS");
					lbldniNum.setForeground(Color.RED);
					lbldniNum.setFont(new Font("Tahoma", Font.BOLD, 11));
					lbldniNum.setBounds(239, 163, 90, 14);
					lbldniNum.setVisible(false);
					contentPanel.add(lbldniNum);
				}
				{
					lblCelNum = new JLabel("SOLO N\u00DAMEROS");
					lblCelNum.setForeground(Color.RED);
					lblCelNum.setFont(new Font("Tahoma", Font.BOLD, 11));
					lblCelNum.setBounds(544, 91, 90, 14);
					contentPanel.add(lblCelNum);
					lblCelNum.setVisible(false);
				}
				{
					lblEdadNum = new JLabel("SOLO N\u00DAMEROS");
					lblEdadNum.setForeground(Color.RED);
					lblEdadNum.setFont(new Font("Tahoma", Font.BOLD, 11));
					lblEdadNum.setBounds(543, 123, 90, 14);
					contentPanel.add(lblEdadNum);
					lblEdadNum.setVisible(false);
				}
				{
					lblSueldoNum = new JLabel("SOLO N\u00DAMEROS");
					lblSueldoNum.setForeground(Color.RED);
					lblSueldoNum.setFont(new Font("Tahoma", Font.BOLD, 11));
					lblSueldoNum.setBounds(548, 250, 90, 14);
					contentPanel.add(lblSueldoNum);
					lblSueldoNum.setVisible(false);
				}
				{
					button_1 = new JButton("   Limpiar");
					button_1.addActionListener(this);
					button_1.setIcon(new ImageIcon(Gerente_Almacen.class.getResource("/Imagenes/mop.png")));
					button_1.setHorizontalAlignment(SwingConstants.LEFT);
					button_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
					button_1.setBounds(709, 205, 133, 36);
					contentPanel.add(button_1);
				}
				{
					menuBar = new JMenuBar();
					setJMenuBar(menuBar);
					{
						mnSalir = new JMenu("Salir");
						menuBar.add(mnSalir);
						{
							mntmSalir = new JMenuItem("Salir");
							mntmSalir.addActionListener(this);
							mntmSalir.setIcon(new ImageIcon(Gerente_Almacen.class.getResource("/Imagenes/cerrar-simbolo-de-boton-circular.png")));
							mnSalir.add(mntmSalir);
						}
					}
				}
				Listar("","","");
			}
		}
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == button_1) {
			do_button_1_actionPerformed(arg0);
		}
		if (arg0.getSource() == mntmSalir) {
			do_mntmSalir_actionPerformed(arg0);
		}
		if (arg0.getSource() == button) {
			do_button_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnModificar) {
			do_btnModificar_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnEliminar) {
			do_btnEliminar_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnNewButton) {
			do_btnNewButton_actionPerformed(arg0);
		}
	}
	protected void do_btnNewButton_actionPerformed(ActionEvent arg0) {
		if(tbd.verSoloJFAlmacen(obtenerDatos().getCodigoTrabajador()) == null){
			tbd.insertarBDJFAlmacen(obtenerDatos());
			Listar(txtFnombre.getText(),txtFapellido.getText(), txtFdni.getText());
			Limpiar();
		}else{
			JOptionPane.showMessageDialog(this, "No se puedo agregar el Jefe de Almacen");
		}
	}
	
	JFAlmacen obtenerDatos(){
		String generoTrabajador;
		if(txt_nombre.getText().equals("Masculino")) generoTrabajador = "M";
		else generoTrabajador = "F";		
		int tipoTrabajador = 1; 		
		String codigoTrabajador = txt_Cod.getText();
		String nombreTrabajador = txt_nombre.getText();
		String apellidoTrabajador = txt_apellido.getText();
		String dniTrabajador = txt_dni.getText();
		String correoTrabajador = txt_correo.getText() + "@"+comboBox.getSelectedItem().toString();
		String celularTrabajador = txt_celular.getText();
		int edadTrabajador = Integer.parseInt(txt_edad.getText()); 
		String usuarioTrabajador = txt_user.getText();
		String contrase = txt_pass.getText();
		Double sueldoTrabajador = Double.parseDouble(txt_sueldo.getText());
		String area = txt_area.getText();

		JFAlmacen g = new JFAlmacen(codigoTrabajador, nombreTrabajador, apellidoTrabajador, 
				dniTrabajador, generoTrabajador, correoTrabajador, celularTrabajador, 
				edadTrabajador, usuarioTrabajador, contrase, tipoTrabajador, 
				sueldoTrabajador, area);
		return g;
	}
	public void Listar(String nombre, String apellido, String dni){
		ArrayList<JFAlmacen> alg = new ArrayList<>();
		
		tableModel.setRowCount(0);

		if(nombre.length()==0 && apellido.length()==0&&dni.length()==0){
			alg = tbd.verTodosJFAlmacen();
		}else{
			alg = tbd.consultarJFAlmacen(nombre, apellido, dni);
		}	
		
        if (alg != null) {
            for (JFAlmacen v: alg) {
            	tableModel.addRow(new Object[] {
                    v.getCodigoTrabajador(),
                    v.getNombreTrabajador(),
                    v.getApellidoTrabajador(),
                    v.getDniTrabajador(),
                    v.getGeneroTrabajador(),
                    v.getCorreoTrabajador(),
                    v.getCelularTrabajador(),
                    v.getEdadTrabajador(),
                    v.getSueldoTrabajador(),
                    v.getAreaJFALmacen()
                });
            }
        }
		
	}
	public void keyPressed(KeyEvent arg0) {
	}
	public void keyReleased(KeyEvent arg0) {
	}
	public void keyTyped(KeyEvent arg0) {
		if (arg0.getSource() == txt_dni) {
			do_txt_dni_keyTyped(arg0);
		}
		if (arg0.getSource() == txt_edad) {
			do_txt_edad_keyTyped(arg0);
		}
		if (arg0.getSource() == txt_celular) {
			do_txt_celular_keyTyped(arg0);
		}
		if (arg0.getSource() == txt_sueldo) {
			do_txt_sueldo_keyTyped(arg0);
		}
		if (arg0.getSource() == txtFdni) {
			do_txtFdni_keyTyped(arg0);
		}
		if (arg0.getSource() == txtFapellido) {
			do_txtFapellido_keyTyped(arg0);
		}
		if (arg0.getSource() == txtFnombre) {
			do_txtFnombre_keyTyped(arg0);
		}
	}
	protected void do_txtFnombre_keyTyped(KeyEvent arg0) {
		Listar(txtFnombre.getText(),txtFapellido.getText(), txtFdni.getText());
	}
	protected void do_txtFapellido_keyTyped(KeyEvent arg0) {
		Listar(txtFnombre.getText(),txtFapellido.getText(), txtFdni.getText());
	}
	protected void do_txtFdni_keyTyped(KeyEvent arg0) {
		Listar(txtFnombre.getText(),txtFapellido.getText(), txtFdni.getText());
	}
	protected void do_btnEliminar_actionPerformed(ActionEvent arg0) {				
		String codigoEliminar = tableModel.getValueAt(JTable.getSelectedRow(), 0).toString();	
		tbd.eliminarTrabajador(codigoEliminar);
		txtFnombre.setText("");
		txtFapellido.setText("");
		txtFdni.setText("");
		Listar(txtFnombre.getText(),txtFapellido.getText(), txtFdni.getText());
		Limpiar();
	}
	
	ArrayList<ProductoVender> alpv = new ArrayList<>();
	private JButton button;
	private JLabel lblNombre_1;
	private JLabel lblApellido;
	private JLabel lblDni_1;
	private JLabel lblPorcentajeDeComision;
	
	protected void do_btnModificar_actionPerformed(ActionEvent arg0) {
		try{
			String generoTrabajador;
			if(cb_genero.getSelectedItem().toString().equals("Masculino")) generoTrabajador = "M";
			else generoTrabajador = "F";	
			Double sueldoTrabajador = Double.parseDouble(txt_sueldo.getText());
			String  area = txt_area.getText();
			JFAlmacen v = new JFAlmacen(txt_Cod.getText(), txt_nombre.getText(),txt_apellido.getText(),
					txt_dni.getText(), generoTrabajador, txt_correo.getText(),
					txt_celular.getText(), Integer.parseInt(txt_edad.getText()),
					txt_user.getText(), txt_pass.getText(),1, sueldoTrabajador,area);
			tbd.modificarAlmacen(v, JTable.getValueAt(JTable.getSelectedRow(), 0).toString());		
			txtFnombre.setText("");
			txtFapellido.setText("");
			txtFdni.setText("");
			Listar(txtFnombre.getText(),txtFapellido.getText(), txtFdni.getText());	
			Limpiar();
			JOptionPane.showMessageDialog(this, "El Jefe de almacen ha sido modificado exitosamente");
		}catch(Exception e){
			JOptionPane.showMessageDialog(this, "No se pudo modificar el Jefe de almacen");
		}		
	}
	
	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == JTable) {
			do_JTable_mouseClicked(arg0);
		}
	}
	public void mouseEntered(MouseEvent arg0) {
	}
	public void mouseExited(MouseEvent arg0) {
	}
	public void mousePressed(MouseEvent arg0) {
	}
	public void mouseReleased(MouseEvent arg0) {
	}
	TrabajadorBD tbd = new TrabajadorBD();
	private JPasswordField txt_pass;
	private JTextField txt_area;
	private JMenuBar menuBar;
	private JMenu mnSalir;
	private JMenuItem mntmSalir;
	private JTextField txt_correo;
	private JLabel label;
	private JComboBox comboBox;
	private JLabel lbldniNum;
	private JLabel lblCelNum;
	private JLabel lblEdadNum;
	private JLabel lblSueldoNum;
	private JButton button_1;
	protected void do_JTable_mouseClicked(MouseEvent arg0) {
		int row = JTable.getSelectedRow();
		String cod = JTable.getValueAt(row, 0).toString();
		JFAlmacen v = tbd.verSoloJFAlmacen(cod);
		txt_Cod.setText(v.getCodigoTrabajador());
		txt_nombre.setText(v.getNombreTrabajador());
		txt_apellido.setText(v.getApellidoTrabajador());
		txt_dni.setText(v.getDniTrabajador());
		txt_correo.setText(v.getCorreoTrabajador());
		txt_edad.setText(""+v.getEdadTrabajador());
		txt_celular.setText(v.getCelularTrabajador());
		txt_user.setText(v.getUsuarioTrabajador());
		txt_sueldo.setText(v.getSueldoTrabajador()+"");
		txt_area.setText(v.getAreaJFALmacen());
		txt_pass.setText(v.getContraseñaTrabajador());
	}
	void Limpiar(){
		txt_Cod.setText("");
		txt_nombre.setText("");
		txt_apellido.setText("");
		txt_dni.setText("");
		txt_correo.setText("");
		txt_edad.setText("");
		txt_celular.setText("");
		txt_user.setText("");
		txt_pass.setText("");
		txt_sueldo.setText("");
		txt_area.setText("");
	}
	String generaCodTrabajador(String conc){
		int numeroAleatorio = (int)(Math.random() * 9000) + 1000;
		String cod = conc+"-"+numeroAleatorio;
		return cod;
	}
	protected void do_button_actionPerformed(ActionEvent arg0) {
		String cod = generaCodTrabajador("JFA");
		if(tbd.verificarTrabajador(cod))txt_Cod.setText(cod);
	}
	protected void do_mntmSalir_actionPerformed(ActionEvent arg0) {
		dispose();
	}
	protected void do_button_1_actionPerformed(ActionEvent arg0) {
		Limpiar();
	}
	void validarNumero(KeyEvent e, JLabel l, JTextField j, int num){
		char validarNumeros=e.getKeyChar();
		if(j.getText().length() < num){
			if(Character.isLetter(validarNumeros)){
				e.consume();
				l.setVisible(true);						
			}else l.setVisible(false);
		}else e.consume();
	}
	protected void do_txt_sueldo_keyTyped(KeyEvent arg0) {
		validarNumero(arg0, lblSueldoNum, txt_sueldo, 4);
	}
	protected void do_txt_celular_keyTyped(KeyEvent arg0) {
		validarNumero(arg0, lblCelNum, txt_celular, 9);
	}
	protected void do_txt_edad_keyTyped(KeyEvent arg0) {
		validarNumero(arg0, lblEdadNum, txt_edad, 2);
	}
	protected void do_txt_dni_keyTyped(KeyEvent arg0) {
		validarNumero(arg0, lbldniNum, txt_dni, 8);
	}
}
