package Vistas.Almacen;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Clases.Marca;
import Clases.Producto;
import Clases.Proveedor;
import Controladores.ProductosBD;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Almacen_Mant_Proveedor extends JDialog implements KeyListener, ActionListener, MouseListener {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblAgregarProvedor;
	private JLabel lblNombre;
	private JTextField txt_NomProve;
	private JLabel lblObservacion;
	private JTextArea txt_Observacion;
	private JScrollPane scrollPane;
	private JTable tbProveedor;
	private DefaultTableModel tbTable;
	private JLabel lblBuscar;
	private JTextField txtFiltroNom;
	private JButton btnAgregar;
	private JButton btnNewButton;
	private JButton btnAgregar_1;
	
	public Almacen_Mant_Proveedor() {
		setTitle("Mantenimiento Proveedor");
		setBounds(100, 100, 730, 602);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			lblAgregarProvedor = new JLabel("Mantenimiento Proveedor");
			lblAgregarProvedor.setHorizontalAlignment(SwingConstants.CENTER);
			lblAgregarProvedor.setFont(new Font("Tahoma", Font.BOLD, 18));
			lblAgregarProvedor.setBounds(196, 24, 322, 35);
			contentPanel.add(lblAgregarProvedor);
		}
		{
			lblNombre = new JLabel("Nombre:");
			lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNombre.setBounds(10, 93, 91, 25);
			contentPanel.add(lblNombre);
		}
		{
			txt_NomProve = new JTextField();
			txt_NomProve.setBounds(111, 95, 360, 25);
			contentPanel.add(txt_NomProve);
			txt_NomProve.setColumns(10);
		}
		{
			lblObservacion = new JLabel("Observaci\u00F3n:");
			lblObservacion.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblObservacion.setBounds(10, 148, 91, 25);
			contentPanel.add(lblObservacion);
		}
		{
			txt_Observacion = new JTextArea();
			txt_Observacion.setBounds(111, 150, 360, 90);
			contentPanel.add(txt_Observacion);
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.addMouseListener(this);
			scrollPane.setBounds(20, 318, 678, 229);
			contentPanel.add(scrollPane);
			{
				tbTable = new DefaultTableModel(
						new Object[][] {
						},
						new String[] {
							"Nombre Proveedor", "Observación"
						}
					);
				tbProveedor = new JTable();
				tbProveedor.addMouseListener(this);
				tbProveedor.setModel(tbTable);
				scrollPane.setViewportView(tbProveedor);
			}
		}
		{
			lblBuscar = new JLabel("Buscar nombre:");
			lblBuscar.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblBuscar.setBounds(20, 282, 124, 25);
			contentPanel.add(lblBuscar);
		}
		{
			txtFiltroNom = new JTextField();
			txtFiltroNom.addKeyListener(this);
			txtFiltroNom.setColumns(10);
			txtFiltroNom.setBounds(121, 284, 543, 25);
			contentPanel.add(txtFiltroNom);
		}
		{
			btnAgregar = new JButton("     Modificar");
			btnAgregar.setIcon(new ImageIcon(Almacen_Mant_Marca.class.getResource("/Imagenes/edit-solid-24.png")));
			btnAgregar.setHorizontalAlignment(SwingConstants.LEFT);
			btnAgregar.addActionListener(this);
			btnAgregar.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnAgregar.setBounds(500, 150, 164, 35);
			contentPanel.add(btnAgregar);
		}
		{
			btnNewButton = new JButton("     Eliminar");
			btnNewButton.setIcon(new ImageIcon(Almacen_Mant_Marca.class.getResource("/Imagenes/trash-alt-solid-24.png")));
			btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
			btnNewButton.addActionListener(this);
			btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnNewButton.setBounds(500, 205, 164, 35);
			contentPanel.add(btnNewButton);
		}
		{
			btnAgregar_1 = new JButton("     Agregar");
			btnAgregar_1.addActionListener(this);
			btnAgregar_1.setIcon(new ImageIcon(Almacen_Mant_Marca.class.getResource("/Imagenes/plus-circle-regular-24.png")));
			btnAgregar_1.setHorizontalAlignment(SwingConstants.LEFT);
			btnAgregar_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnAgregar_1.setBounds(500, 93, 164, 35);
			contentPanel.add(btnAgregar_1);
		}
		{
			button = new JButton("     Limpiar");
			button.addActionListener(this);
			button.setIcon(new ImageIcon(Almacen_Mant_Proveedor.class.getResource("/Imagenes/mop.png")));
			button.setHorizontalAlignment(SwingConstants.LEFT);
			button.setFont(new Font("Tahoma", Font.PLAIN, 14));
			button.setBounds(500, 48, 164, 36);
			contentPanel.add(button);
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
					mntmSalir.setIcon(new ImageIcon(Almacen_Mant_Proveedor.class.getResource("/Imagenes/cerrar-simbolo-de-boton-circular.png")));
					mnSalir.add(mntmSalir);
				}
			}
		}
		Listar("");
	}
	//---------------------------------------------------------------------
	ProductosBD pbd = new ProductosBD();
	private JMenuBar menuBar;
	private JMenu mnSalir;
	private JMenuItem mntmSalir;
	private JButton button;
	//---------------------------------------------------------------------
	
	void Listar(String nom){
		ArrayList<Proveedor> alp = new ArrayList<>();		
		tbTable.setRowCount(0);
		if(nom.length()==0){
			alp = pbd.obtenerTodoProveedores();
		}else{
			alp = pbd.obtenerFiltroProveedores(nom);		
		}
        if (alp != null) {
            for (Proveedor p : alp) {
            	tbTable.addRow(new Object[] {
                    p.getNombreProveedor(),
                    p.getObservacionProveedor(),
                });
            }
        }
	}
	void Limpiar(){
		txt_NomProve.setText("");
		txt_Observacion.setText("");
		txtFiltroNom.setText("");
	}
	
	/*
	 * Funciones para el Filtro
	 * */
	public void keyReleased(KeyEvent arg0) {
		if (arg0.getSource() == txtFiltroNom) {
			do_txtFiltroNom_keyReleased(arg0);
		}
	}
	public void keyPressed(KeyEvent arg0) {
	}
	public void keyTyped(KeyEvent arg0) {
	}
	protected void do_txtFiltroNom_keyReleased(KeyEvent arg0) {
		Listar(txtFiltroNom.getText());
	}
	/*
	 * Funciones para los Botones
	 * */
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == button) {
			do_button_actionPerformed(arg0);
		}
		if (arg0.getSource() == mntmSalir) {
			do_mntmSalir_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnAgregar_1) {
			do_btnAgregar_1_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnNewButton) {
			do_btnNewButton_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnAgregar) {
			do_btnAgregar_actionPerformed(arg0);
		}
	}	
	protected void do_btnAgregar_actionPerformed(ActionEvent arg0) {
		Proveedor p =new Proveedor(txt_NomProve.getText(), txt_Observacion.getText());
		int row = tbProveedor.getSelectedRow();
		pbd.modificarProveedor(p, tbProveedor.getValueAt(row, 0).toString());
		Limpiar();
		Listar("");
	}
	protected void do_btnNewButton_actionPerformed(ActionEvent arg0) {
		int row = tbProveedor.getSelectedRow();
		pbd.eliminarProveedor(tbProveedor.getValueAt(row, 0).toString());
		Limpiar();
		Listar("");
	}
	protected void do_btnAgregar_1_actionPerformed(ActionEvent arg0) {
		Proveedor p =new Proveedor(txt_NomProve.getText(), txt_Observacion.getText());
		pbd.insertarProveedor(p);
		Limpiar();
		Listar("");
	}
	
	/*
	 * Funciones para los Clics en la tabla
	 * */
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tbProveedor) {
			do_tbProveedor_mouseClicked(e);
		}
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	protected void do_scrollPane_mouseClicked(MouseEvent e) {
		int row = tbProveedor.getSelectedRow();
		txt_NomProve.setText(tbProveedor.getValueAt(row, 0).toString());
		txt_Observacion.setText(tbProveedor.getValueAt(row, 1).toString());		
	}
	protected void do_tbProveedor_mouseClicked(MouseEvent e) {
		int row = tbProveedor.getSelectedRow();
		txt_NomProve.setText(tbProveedor.getValueAt(row, 0).toString());
		txt_Observacion.setText(tbProveedor.getValueAt(row, 1).toString());
	}
	protected void do_mntmSalir_actionPerformed(ActionEvent arg0) {
		dispose();
	}
	protected void do_button_actionPerformed(ActionEvent arg0) {
		Limpiar();
	}
}
