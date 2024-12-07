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

import Clases.Categoria;
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

public class Almacen_Mant_Categoria extends JDialog implements KeyListener, ActionListener, MouseListener {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblAgregarProvedor;
	private JLabel lblNombre;
	private JTextField txt_NomCate;
	private JLabel lblObservacion;
	private JTextArea txt_Observacion;
	private JScrollPane scrollPane;
	private JTable tbCate;
	private DefaultTableModel tbTable;
	private JLabel lblBuscar;
	private JTextField txtFiltroNom;
	private JButton btnAgregar;
	private JButton btnNewButton;
	private JButton btnAgregar_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Almacen_Mant_Categoria dialog = new Almacen_Mant_Categoria();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Almacen_Mant_Categoria() {
		setTitle("Mantenimiento Categor\u00EDa");
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 730, 602);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			lblAgregarProvedor = new JLabel("Mantenimiento Categor\u00EDa");
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
			txt_NomCate = new JTextField();
			txt_NomCate.setBounds(111, 95, 360, 25);
			contentPanel.add(txt_NomCate);
			txt_NomCate.setColumns(10);
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
							"Nombre Categoría", "Observación"
						}
					);
				tbCate = new JTable();
				tbCate.addMouseListener(this);
				tbCate.setModel(tbTable);
				scrollPane.setViewportView(tbCate);
			}
		}
		{
			lblBuscar = new JLabel("Buscar nombre:");
			lblBuscar.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblBuscar.setBounds(20, 282, 122, 25);
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
			button.setIcon(new ImageIcon(Almacen_Mant_Categoria.class.getResource("/Imagenes/mop.png")));
			button.setHorizontalAlignment(SwingConstants.LEFT);
			button.setFont(new Font("Tahoma", Font.PLAIN, 14));
			button.setBounds(500, 46, 164, 36);
			contentPanel.add(button);
		}
		{
			menuBar = new JMenuBar();
			setJMenuBar(menuBar);
			{
				mnNewMenu = new JMenu("Salir");
				menuBar.add(mnNewMenu);
				{
					mntmNewMenuItem = new JMenuItem("Salir");
					mntmNewMenuItem.addActionListener(this);
					mntmNewMenuItem.setIcon(new ImageIcon(Almacen_Mant_Categoria.class.getResource("/Imagenes/cerrar-simbolo-de-boton-circular.png")));
					mnNewMenu.add(mntmNewMenuItem);
				}
			}
		}
		Listar("");
	}
	ProductosBD pbd = new ProductosBD();
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenuItem mntmNewMenuItem;
	private JButton button;

	void Listar(String nom){
		ArrayList<Categoria> alp = new ArrayList<>();		
		tbTable.setRowCount(0);
		if(nom.length()==0){
			alp = pbd.obtenerTodoCategoria();
		}else{
			alp = pbd.obtenerFiltroCategoria(nom);		
		}
        if (alp != null) {
            for (Categoria p : alp) {
            	tbTable.addRow(new Object[] {
                    p.getNombreCategoria(),
                    p.getObservacionCategoria()
                });
            }
        }
	}
	void Limpiar(){
		txt_NomCate.setText("");
		txt_Observacion.setText("");
		txtFiltroNom.setText("");
	}
	
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
	
	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == button) {
			do_button_actionPerformed(arg0);
		}
		if (arg0.getSource() == mntmNewMenuItem) {
			do_mntmNewMenuItem_actionPerformed(arg0);
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
		Categoria p =new Categoria(txt_NomCate.getText(), txt_Observacion.getText());
		int row = tbCate.getSelectedRow();
		pbd.modificarCategoria(p, tbCate.getValueAt(row, 0).toString());
		Limpiar();
		Listar("");
	}
	protected void do_btnNewButton_actionPerformed(ActionEvent arg0) {
		int row = tbCate.getSelectedRow();
		pbd.eliminarCategoria(tbCate.getValueAt(row, 0).toString());
		Limpiar();
		Listar("");
	}
	protected void do_btnAgregar_1_actionPerformed(ActionEvent arg0) {
		Categoria p =new Categoria(txt_NomCate.getText(),txt_Observacion.getText());
		pbd.insertarCategoria(p);
		Limpiar();
		Listar("");
	}
	
	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == tbCate) {
			do_tbCate_mouseClicked(arg0);
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
		int row = tbCate.getSelectedRow();
		txt_NomCate.setText(tbCate.getValueAt(row, 0).toString());
		txt_Observacion.setText(tbCate.getValueAt(row, 1).toString());
		
	}
	protected void do_tbCate_mouseClicked(MouseEvent arg0) {
		int row = tbCate.getSelectedRow();
		txt_NomCate.setText(tbCate.getValueAt(row, 0).toString());
		txt_Observacion.setText(tbCate.getValueAt(row, 1).toString());
	}
	protected void do_mntmNewMenuItem_actionPerformed(ActionEvent arg0) {
		dispose();
	}
	protected void do_button_actionPerformed(ActionEvent arg0) {
		Limpiar();
	}
}
