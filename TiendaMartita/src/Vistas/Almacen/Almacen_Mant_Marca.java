package Vistas.Almacen;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

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
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Almacen_Mant_Marca extends JDialog implements KeyListener, ActionListener, MouseListener {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblAgregarProvedor;
	private JLabel lblNombre;
	private JTextField txt_NomMarca;
	private JLabel lblObservacion;
	private JTextArea txt_Observacion;
	private JScrollPane scrollPane;
	private JTable tbMarca;
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
			Almacen_Mant_Marca dialog = new Almacen_Mant_Marca();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Almacen_Mant_Marca() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTitle("Mantenimiento Marca");
		setBounds(100, 100, 730, 602);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			lblAgregarProvedor = new JLabel("Mantenimiento Marca");
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
			txt_NomMarca = new JTextField();
			txt_NomMarca.setBounds(111, 95, 360, 25);
			contentPanel.add(txt_NomMarca);
			txt_NomMarca.setColumns(10);
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
							"Nombre Marca", "Observación"
						}
					);
				tbMarca = new JTable();
				tbMarca.addMouseListener(this);
				tbMarca.setModel(tbTable);
				scrollPane.setViewportView(tbMarca);
			}
		}
		{
			lblBuscar = new JLabel("Buscar nombre:");
			lblBuscar.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblBuscar.setBounds(20, 282, 123, 25);
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
			button.setIcon(new ImageIcon(Almacen_Mant_Marca.class.getResource("/Imagenes/mop.png")));
			button.setHorizontalAlignment(SwingConstants.LEFT);
			button.setFont(new Font("Tahoma", Font.PLAIN, 14));
			button.setBounds(500, 46, 164, 36);
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
					mntmSalir.setIcon(new ImageIcon(Almacen_Mant_Marca.class.getResource("/Imagenes/cerrar-simbolo-de-boton-circular.png")));
					mnSalir.add(mntmSalir);
				}
			}
		}
		Listar("");
	}
	ProductosBD pbd = new ProductosBD();
	private JMenuBar menuBar;
	private JMenu mnSalir;
	private JMenuItem mntmSalir;
	private JButton button;

	void Listar(String nom){
		ArrayList<Marca> alp = new ArrayList<>();		
		tbTable.setRowCount(0);
		if(nom.length()==0){
			alp = pbd.obtenerTodoMarca();
		}else{
			alp = pbd.obtenerFiltroMarca(nom);		
		}
        if (alp != null) {
            for (Marca p : alp) {
            	tbTable.addRow(new Object[] {
                    p.getNombreMarca(),
                    p.getObservacionMarca()
                });
            }
        }
	}
	void Limpiar(){
		txt_NomMarca.setText("");
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
		Marca p =new Marca(txt_NomMarca.getText(), txt_Observacion.getText());
		int row = tbMarca.getSelectedRow();
		pbd.modificarMarca(p, tbMarca.getValueAt(row, 0).toString());
		Limpiar();
		Listar("");
	}
	protected void do_btnNewButton_actionPerformed(ActionEvent arg0) {
		int row = tbMarca.getSelectedRow();
		pbd.eliminarMarca(tbMarca.getValueAt(row, 0).toString());
		Limpiar();
		Listar("");
	}
	protected void do_btnAgregar_1_actionPerformed(ActionEvent arg0) {
		Marca p =new Marca(txt_NomMarca.getText(), txt_Observacion.getText());
		pbd.insertarMarca(p);
		Limpiar();
		Listar("");
	}
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tbMarca) {
			do_tbMarca_mouseClicked(e);
		}
		if (e.getSource() == scrollPane) {
			do_scrollPane_mouseClicked(e);
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
		int row = tbMarca.getSelectedRow();
		txt_NomMarca.setText(tbMarca.getValueAt(row, 0).toString());
		txt_Observacion.setText(tbMarca.getValueAt(row, 1).toString());
	}
	protected void do_tbMarca_mouseClicked(MouseEvent e) {
		int row = tbMarca.getSelectedRow();
		txt_NomMarca.setText(tbMarca.getValueAt(row, 0).toString());
		txt_Observacion.setText(tbMarca.getValueAt(row, 1).toString());
	}
	protected void do_mntmSalir_actionPerformed(ActionEvent arg0) {
		dispose();
	}
	protected void do_button_actionPerformed(ActionEvent arg0) {
		Limpiar();
	}
}
