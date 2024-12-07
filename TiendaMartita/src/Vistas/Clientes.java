package Vistas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Label;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.awt.event.KeyEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Clases.Cliente;
import Clases.Producto;
import Controladores.ClienteBD;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class Clientes extends JDialog implements KeyListener, ActionListener, MouseListener{

	private final JPanel contentPanel = new JPanel();
	private JLabel label;
	private JTextField txtIDC;
	private JLabel label_2;
	private JLabel label_3;
	private JTextField txtDni;
	private JTextField txtNombre;
	private JLabel label_4;
	private JLabel label_5;
	private JTextField txtApellido;
	private JLabel lblGnero;
	private JLabel label_7;
	private JTextField txtCorreo;
	private JTextField txtCel;
	private JLabel label_8;
	private JLabel label_9;
	private JTextField txtEdad;
	private JLabel label_10;
	private JComboBox cbCorreo;
	private JComboBox cbGenero;
	private JLabel lbl_dniNum;
	private JLabel lbl_celNum;
	private JLabel lbl_EdadNum;
	private JButton button;
	private JScrollPane scrollPane;
	private JTable table;
	private DefaultTableModel dtable;
	private JButton btnAgregar;
	private JLabel lblBuscarCdigo;
	private JTextField txtFCod;
	private JLabel lblBuscarDni;
	private JTextField txtFDni;
	private JLabel lblBuscarNombre;
	private JButton btnContinuarVenta;
	public static String codigo = "";
	
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		try {
			Clientes dialog = new Clientes(c);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * Create the dialog.
	 */
	public Clientes(Cliente c, int tipo) {
		setTitle("Cliente");
		setBounds(100, 100, 856, 778);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			label = new JLabel("Cliente");
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setFont(new Font("Tahoma", Font.BOLD, 20));
			label.setBounds(163, 30, 87, 25);
			contentPanel.add(label);
		}
		{
			txtIDC = new JTextField();
			txtIDC.setFont(new Font("Tahoma", Font.PLAIN, 13));
			txtIDC.setColumns(10);
			txtIDC.setBounds(125, 66, 155, 25);
			contentPanel.add(txtIDC);
		}
		{
			label_2 = new JLabel("ID cliente");
			label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
			label_2.setBounds(24, 70, 87, 25);
			contentPanel.add(label_2);
		}
		{
			label_3 = new JLabel("DNI");
			label_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
			label_3.setBounds(24, 102, 82, 25);
			contentPanel.add(label_3);
		}
		{
			txtDni = new JTextField();
			txtDni.setFont(new Font("Tahoma", Font.PLAIN, 13));
			txtDni.addKeyListener(this);
			txtDni.setColumns(10);
			txtDni.setBounds(125, 102, 95, 25);
			contentPanel.add(txtDni);
		}
		{
			txtNombre = new JTextField();
			txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 13));
			txtNombre.setColumns(10);
			txtNombre.setBounds(125, 137, 155, 25);
			contentPanel.add(txtNombre);
		}
		{
			label_4 = new JLabel("Nombre");
			label_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
			label_4.setBounds(24, 138, 80, 25);
			contentPanel.add(label_4);
		}
		{
			label_5 = new JLabel("Apellido");
			label_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
			label_5.setBounds(24, 174, 80, 25);
			contentPanel.add(label_5);
		}
		{
			txtApellido = new JTextField();
			txtApellido.setFont(new Font("Tahoma", Font.PLAIN, 13));
			txtApellido.setColumns(10);
			txtApellido.setBounds(125, 173, 155, 25);
			contentPanel.add(txtApellido);
		}
		{
			lblGnero = new JLabel("G\u00E9nero");
			lblGnero.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblGnero.setBounds(377, 68, 80, 25);
			contentPanel.add(lblGnero);
		}
		{
			label_7 = new JLabel("Correo");
			label_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
			label_7.setBounds(377, 104, 80, 25);
			contentPanel.add(label_7);
		}
		{
			txtCorreo = new JTextField();
			txtCorreo.setFont(new Font("Tahoma", Font.PLAIN, 13));
			txtCorreo.setColumns(10);
			txtCorreo.setBounds(478, 103, 95, 25);
			contentPanel.add(txtCorreo);
		}
		{
			txtCel = new JTextField();
			txtCel.setFont(new Font("Tahoma", Font.PLAIN, 13));
			txtCel.addKeyListener(this);
			txtCel.setColumns(10);
			txtCel.setBounds(478, 135, 95, 25);
			contentPanel.add(txtCel);
		}
		{
			label_8 = new JLabel("Celular");
			label_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
			label_8.setBounds(377, 136, 80, 25);
			contentPanel.add(label_8);
		}
		{
			label_9 = new JLabel("Edad");
			label_9.setFont(new Font("Tahoma", Font.PLAIN, 14));
			label_9.setBounds(377, 172, 64, 25);
			contentPanel.add(label_9);
		}
		{
			txtEdad = new JTextField();
			txtEdad.setFont(new Font("Tahoma", Font.PLAIN, 13));
			txtEdad.addKeyListener(this);
			txtEdad.setText("");
			txtEdad.setColumns(10);
			txtEdad.setBounds(478, 171, 95, 25);
			contentPanel.add(txtEdad);
		}
		{
			label_10 = new JLabel("@");
			label_10.setFont(new Font("Tahoma", Font.PLAIN, 15));
			label_10.setBounds(575, 104, 24, 25);
			contentPanel.add(label_10);
		}
		{
			cbCorreo = new JComboBox();
			cbCorreo.setFont(new Font("Tahoma", Font.PLAIN, 13));
			cbCorreo.setModel(new DefaultComboBoxModel(new String[] {"gmail.com", "hotmail.com"}));
			cbCorreo.setBounds(595, 104, 95, 25);
			contentPanel.add(cbCorreo);
		}
		{
			cbGenero = new JComboBox();
			cbGenero.setFont(new Font("Tahoma", Font.PLAIN, 13));
			cbGenero.setModel(new DefaultComboBoxModel(new String[] {"Masculino", "Femenino"}));
			cbGenero.setBounds(478, 72, 155, 25);
			contentPanel.add(cbGenero);
		}
		{
			lbl_dniNum = new JLabel("SOLO N\u00DAMEROS");
			lbl_dniNum.setFont(new Font("Tahoma", Font.BOLD, 11));
			lbl_dniNum.setForeground(Color.RED);
			lbl_dniNum.setBounds(230, 109, 107, 14);
			lbl_dniNum.setVisible(false);
			contentPanel.add(lbl_dniNum);
		}
		{
			lbl_celNum = new JLabel("SOLO N\u00DAMEROS");
			lbl_celNum.setForeground(Color.RED);
			lbl_celNum.setFont(new Font("Tahoma", Font.BOLD, 11));
			lbl_celNum.setBounds(585, 141, 107, 14);
			lbl_celNum.setVisible(false);
			contentPanel.add(lbl_celNum);
		}
		{
			lbl_EdadNum = new JLabel("SOLO N\u00DAMEROS");
			lbl_EdadNum.setForeground(Color.RED);
			lbl_EdadNum.setFont(new Font("Tahoma", Font.BOLD, 11));
			lbl_EdadNum.setBounds(583, 179, 107, 14);
			lbl_EdadNum.setVisible(false);
			contentPanel.add(lbl_EdadNum);
		}
		{
			button = new JButton("");
			button.addActionListener(this);
			button.setIcon(new ImageIcon(Clientes.class.getResource("/Imagenes/aleatorio.png")));
			button.setBounds(293, 68, 44, 25);
			contentPanel.add(button);
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(24, 379, 799, 293);
			contentPanel.add(scrollPane);
			{
				dtable = new DefaultTableModel(
						new Object[][] {
						},
						new String[] {
							"Código", "Nombres","Apellido", "Dni", "Género", "Correo", "Celular", "Edad"
						}
					);
				table = new JTable();
				table.addMouseListener(this);
				table.setModel(dtable);
				scrollPane.setViewportView(table);
			}
		}
		{
			btnAgregar = new JButton("     Agregar Cliente");
			btnAgregar.setHorizontalAlignment(SwingConstants.LEFT);
			btnAgregar.setIcon(new ImageIcon(Clientes.class.getResource("/Imagenes/agregar-usuario.png")));
			btnAgregar.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnAgregar.addActionListener(this);
			btnAgregar.setBounds(24, 255, 211, 39);
			contentPanel.add(btnAgregar);
		}
		{
			lblBuscarCdigo = new JLabel("Buscar c\u00F3digo:");
			lblBuscarCdigo.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblBuscarCdigo.setBounds(24, 346, 107, 25);
			contentPanel.add(lblBuscarCdigo);
		}
		{
			txtFCod = new JTextField();
			txtFCod.addKeyListener(this);
			txtFCod.setFont(new Font("Tahoma", Font.PLAIN, 13));
			txtFCod.setColumns(10);
			txtFCod.setBounds(125, 347, 155, 25);
			contentPanel.add(txtFCod);
		}
		{
			lblBuscarDni = new JLabel("Buscar DNI:");
			lblBuscarDni.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblBuscarDni.setBounds(301, 346, 107, 25);
			contentPanel.add(lblBuscarDni);
		}
		{
			txtFDni = new JTextField();
			txtFDni.addKeyListener(this);
			txtFDni.setFont(new Font("Tahoma", Font.PLAIN, 13));
			txtFDni.setColumns(10);
			txtFDni.setBounds(390, 347, 155, 25);
			contentPanel.add(txtFDni);
		}
		{
			lblBuscarNombre = new JLabel("Buscar Apellido:");
			lblBuscarNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblBuscarNombre.setBounds(567, 342, 107, 25);
			contentPanel.add(lblBuscarNombre);
		}
		{
			txtFApe = new JTextField();
			txtFApe.addKeyListener(this);
			txtFApe.setFont(new Font("Tahoma", Font.PLAIN, 13));
			txtFApe.setColumns(10);
			txtFApe.setBounds(668, 343, 155, 25);
			contentPanel.add(txtFApe);
		}
		{
			btnContinuarVenta = new JButton("Continuar Venta");
			btnContinuarVenta.addActionListener(this);
			btnContinuarVenta.setFont(new Font("Tahoma", Font.BOLD, 18));
			btnContinuarVenta.setBounds(24, 689, 801, 39);
			contentPanel.add(btnContinuarVenta);
		}
		{
			btnModificarCliente = new JButton("       Modificar Cliente");
			btnModificarCliente.addActionListener(this);
			btnModificarCliente.setIcon(new ImageIcon(Clientes.class.getResource("/Imagenes/edit-solid-24.png")));
			btnModificarCliente.setHorizontalAlignment(SwingConstants.LEFT);
			btnModificarCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnModificarCliente.setBounds(297, 255, 217, 39);
			contentPanel.add(btnModificarCliente);
		}
		{
			btnEliminaCliente = new JButton("       Eliminar Cliente");
			btnEliminaCliente.addActionListener(this);
			btnEliminaCliente.setIcon(new ImageIcon(Clientes.class.getResource("/Imagenes/trash-alt-solid-24.png")));
			btnEliminaCliente.setHorizontalAlignment(SwingConstants.LEFT);
			btnEliminaCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnEliminaCliente.setBounds(584, 255, 217, 39);
			contentPanel.add(btnEliminaCliente);
		}
		{
			button_1 = new JButton("   Limpiar");
			button_1.addActionListener(this);
			button_1.setIcon(new ImageIcon(Clientes.class.getResource("/Imagenes/mop.png")));
			button_1.setHorizontalAlignment(SwingConstants.LEFT);
			button_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			button_1.setBounds(690, 19, 133, 36);
			contentPanel.add(button_1);
		}
		cargarCliente(c);
		tipoVentana(tipo);
		Listar("", "","");
	}
	
	void cargarCliente(Cliente c){
		if(c != null){
			txtIDC.setText(c.getCodigoCliente());
			txtDni.setText(c.getDniCliente());
			txtNombre.setText(c.getNombreCliente());
			txtApellido.setText(c.getApellidoCliente());
			if(c.getGeneroCliente().equals("M")) cbGenero.setSelectedItem("Masculino");
			else cbGenero.setSelectedItem("Femenino");			
			txtCorreo.setText(c.getCorreoCliente().split("@")[0]);
			cbCorreo.setSelectedItem(c.getCorreoCliente().split("@")[1]);
			txtEdad.setText(c.getEdadCliente()+"");
			txtCel.setText(c.getCelularCliente());
		}
	}
	void limpiar(){
		txtIDC.setText("");
		txtDni.setText("");
		txtNombre.setText("");
		txtApellido.setText("");
		cbGenero.setSelectedItem("Masculino");		
		txtCorreo.setText("");
		cbCorreo.setSelectedItem("gmail.com");
		txtEdad.setText("");
		txtCel.setText("");
		txtFApe.setText("");
		txtFCod.setText("");
		txtFDni.setText("");
	}
	void Listar(String codigo, String dni, String apellido){
		ArrayList<Cliente> alc = new ArrayList<>();		
		dtable.setRowCount(0);
		if(codigo.length()==0&&dni.length()==0&&apellido.length()==0){
			alc = cbd.obtenerBDClientes();
		}else{
			alc = cbd.ConsultarClientesFiltros(codigo, apellido,dni);			
		}	
		
        if (alc != null) {
            for (Cliente c : alc) {
            	dtable.addRow(new Object[] {
                    c.getCodigoCliente(),
                    c.getNombreCliente(),
                    c.getApellidoCliente(),
                    c.getDniCliente(),
                    c.getGeneroCliente(),
                    c.getCorreoCliente(),
                    c.getCelularCliente(),
                    c.getEdadCliente()
                });
            }
        }
		
	}
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
	}
	public void keyTyped(KeyEvent e) {
		if (e.getSource() == txtFApe) {
			do_txtFApe_keyTyped(e);
		}
		if (e.getSource() == txtFDni) {
			do_txtFDni_keyTyped(e);
		}
		if (e.getSource() == txtFCod) {
			do_textField_keyTyped(e);
		}
		if (e.getSource() == txtEdad) {
			do_txtEdad_keyTyped(e);
		}
		if (e.getSource() == txtCel) {
			do_txtCel_keyTyped(e);
		}
		if (e.getSource() == txtDni) {
			do_txtDni_keyTyped(e);
		}
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
	protected void do_txtDni_keyTyped(KeyEvent e) {
		validarNumero(e, lbl_dniNum, txtDni, 8);
	}
	protected void do_txtCel_keyTyped(KeyEvent e) {
		validarNumero(e, lbl_celNum, txtCel, 9);
	}
	protected void do_txtEdad_keyTyped(KeyEvent e) {
		validarNumero(e, lbl_EdadNum, txtEdad,3);
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == button_1) {
			do_button_1_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnEliminaCliente) {
			do_btnEliminaCliente_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnModificarCliente) {
			do_btnModificarCliente_actionPerformed(arg0);
		}
		if (arg0.getSource() == button) {
			do_button_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnContinuarVenta) {
			do_btnContinuarVenta_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnAgregar) {
			do_btnAgregar_actionPerformed(arg0);
		}
	}
	protected void do_btnAgregar_actionPerformed(ActionEvent arg0) {		
		if(obtenerDatos().getNombreCliente().equals("") || obtenerDatos().getApellidoCliente().equals("")){
			JOptionPane.showMessageDialog(this, "Ingrese un cliente");
		}else{
			if(cbd.obtenerBDSoloClienteCod(obtenerDatos().getCodigoCliente()) == null){
				cbd.insertarBDCLiente(obtenerDatos());	
				limpiar();
				Listar(txtFCod.getText(), txtFApe.getText(), txtFDni.getText());
			}else{
				JOptionPane.showMessageDialog(this, "No se pudo agregar el Cliente");
			}
			
		}
	}
	Cliente obtenerDatos(){
		String generoCliente = "";
		if(cbGenero.getSelectedItem().toString().equals("Masculino"))generoCliente = "M";
		else generoCliente = "F";
		String correoCliente ="";
		if(!txtCorreo.getText().equals("")){
			correoCliente = txtCorreo.getText() + "@"+cbCorreo.getSelectedItem().toString();
		}
		Cliente c = new Cliente(txtIDC.getText(), txtNombre.getText(), txtApellido.getText(), 
				txtDni.getText(), generoCliente, correoCliente, 
				txtCel.getText(), Integer.parseInt(txtEdad.getText()));
		return c;
	}
	protected void do_btnContinuarVenta_actionPerformed(ActionEvent arg0) {
		int row = table.getSelectedRow();
		if(row == -1){
			JOptionPane.showMessageDialog(this, "Seleccione un cliente");
		}else{
			codigo = table.getValueAt(row, 0).toString();
			Vendedor_Ventas vv = new Vendedor_Ventas();
			vv.setVisible(true);
			dispose();
		}
	}
	String generaCodCliente(){
		int numeroAleatorio = (int)(Math.random() * 9000) + 1000;
		String cod = "CL-"+numeroAleatorio;
		return cod;
	}
	ClienteBD cbd = new ClienteBD();
	private JButton btnModificarCliente;
	private JButton btnEliminaCliente;
	private JTextField txtFApe;
	private JButton button_1;
	protected void do_button_actionPerformed(ActionEvent arg0) {
		if(cbd.verificarCliente(generaCodCliente())) txtIDC.setText(generaCodCliente());
	}
	void tipoVentana(int tipo){
		switch (tipo) {
		case 1:
			ventanaVendedor();
			break;
		case 2:
			ventanaGerente();
			break;
		}
	}
	void ventanaVendedor(){
		btnModificarCliente.setEnabled(false);
		btnEliminaCliente.setEnabled(false);
	}
	void ventanaGerente(){
		btnContinuarVenta.setEnabled(false);
	}
	protected void do_btnModificarCliente_actionPerformed(ActionEvent arg0) {
		if(obtenerDatos().getNombreCliente().equals("") || obtenerDatos().getApellidoCliente().equals("")){
			JOptionPane.showMessageDialog(this, "Ingrese nombres y apellidos");
		}else{
			cbd.actualizarBDCliente(obtenerDatos());
			limpiar();
			Listar(txtFCod.getText(), txtFApe.getText(), txtFDni.getText());
		}
	}
	protected void do_textField_keyTyped(KeyEvent e) {
		Listar(txtFCod.getText(), txtFApe.getText(), txtFDni.getText());
	}
	protected void do_txtFDni_keyTyped(KeyEvent e) {
		Listar(txtFCod.getText(), txtFApe.getText(), txtFDni.getText());
	}
	protected void do_txtFApe_keyTyped(KeyEvent e) {
		Listar(txtFCod.getText(), txtFApe.getText(), txtFDni.getText());
	}
	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == table) {
			do_table_mouseClicked(arg0);
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
	protected void do_table_mouseClicked(MouseEvent arg0) {
		int row = table.getSelectedRow();
		Cliente c = new Cliente(table.getValueAt(row, 0).toString(), 
				table.getValueAt(row, 1).toString(), table.getValueAt(row, 2).toString(), 
				table.getValueAt(row, 3).toString(), table.getValueAt(row, 4).toString(), 
				table.getValueAt(row, 5).toString(), table.getValueAt(row, 6).toString(), 
				Integer.parseInt(table.getValueAt(row, 7).toString()));
		cargarCliente(c);
	}
	protected void do_btnEliminaCliente_actionPerformed(ActionEvent arg0) {
		int row = table.getSelectedRow();
		if(row == -1){
			JOptionPane.showMessageDialog(this, "Seleccione un cliente a eliminar");
		}else{
			int opcion = JOptionPane.showConfirmDialog(null, "¿Desea eliminar al cliente?", "Eliminar", JOptionPane.YES_NO_OPTION);
			if (opcion == 0) {
			   cbd.eliminarCliente(table.getValueAt(row, 0).toString());
			   limpiar();
			   Listar(txtFCod.getText(), txtFApe.getText(), txtFDni.getText());
			}
		}		
	}
	protected void do_button_1_actionPerformed(ActionEvent arg0) {
		limpiar();
	}
}
