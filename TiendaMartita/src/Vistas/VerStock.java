package Vistas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Clases.Producto;
import Controladores.ProductosBD;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class VerStock extends JDialog implements MouseListener, ActionListener, KeyListener {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblCodigo;
	private JTextField txt_Cod;
	private JLabel lblMarca;
	private JLabel lblCategoria;
	private JLabel lblProveedor;
	private JLabel lblStock;
	private JTextField txt_Stock;
	private JLabel lblPrecio;
	private JTextField txt_pre;
	private JLabel lblTalla;
	private JTextField txt_talla;
	private JLabel lblColor;
	private JTextField txt_color;
	private JComboBox cb_Marca;
	private JComboBox cb_Categoria;
	private JComboBox cb_Proveedor;
	private JScrollPane scrollPane;
	private JTable tProductos;
	private JLabel lblBuscar;
	private JTextField txtFCod;
	private JComboBox cbFiltroMarca;
	private JComboBox cbFiltroCategoria;
	private JComboBox cbFiltroProveedor;
	private JLabel lblMarca_1;
	private JLabel lblCategoria_1;
	private JLabel lblProovedor;
	private JButton btnFiltrar;
	private DefaultTableModel tableModel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VerStock dialog = new VerStock();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VerStock() {
		setTitle("Gerente Ver Stock");
		setBounds(100, 100, 860, 718);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			lblCodigo = new JLabel("C\u00F3digo:");
			lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblCodigo.setBounds(23, 25, 108, 20);
			contentPanel.add(lblCodigo);
		}
		{
			txt_Cod = new JTextField();
			txt_Cod.setEditable(false);
			txt_Cod.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txt_Cod.setBounds(107, 25, 210, 22);
			contentPanel.add(txt_Cod);
			txt_Cod.setColumns(10);
		}
		{
			lblMarca = new JLabel("Marca:");
			lblMarca.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblMarca.setBounds(23, 68, 108, 20);
			contentPanel.add(lblMarca);
		}
		{
			cb_Marca = new JComboBox();
			cb_Marca.setEnabled(false);
			cb_Marca.setFont(new Font("Tahoma", Font.PLAIN, 14));
			cb_Marca.setBounds(107, 68, 210, 25);
			contentPanel.add(cb_Marca);
		}
		{
			lblCategoria = new JLabel("Categoria:");
			lblCategoria.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblCategoria.setBounds(23, 113, 108, 20);
			contentPanel.add(lblCategoria);
		}
		{
			cb_Categoria = new JComboBox();
			cb_Categoria.setEnabled(false);
			cb_Categoria.setBounds(107, 113, 210, 25);
			contentPanel.add(cb_Categoria);
		}
		{
			lblProveedor = new JLabel("Proveedor:");
			lblProveedor.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblProveedor.setBounds(23, 161, 108, 20);
			contentPanel.add(lblProveedor);
		}
		{
			cb_Proveedor = new JComboBox();
			cb_Proveedor.setEnabled(false);
			cb_Proveedor.setBounds(107, 161, 210, 25);
			contentPanel.add(cb_Proveedor);
		}
		{
			lblStock = new JLabel("Stock:");
			lblStock.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblStock.setBounds(495, 25, 108, 20);
			contentPanel.add(lblStock);
		}
		{
			txt_Stock = new JTextField();
			txt_Stock.setEditable(false);
			txt_Stock.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txt_Stock.setColumns(10);
			txt_Stock.setBounds(579, 25, 210, 22);
			contentPanel.add(txt_Stock);
		}
		{
			lblPrecio = new JLabel("Precio:");
			lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblPrecio.setBounds(495, 71, 108, 20);
			contentPanel.add(lblPrecio);
		}
		{
			txt_pre = new JTextField();
			txt_pre.setEditable(false);
			txt_pre.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txt_pre.setColumns(10);
			txt_pre.setBounds(579, 71, 210, 22);
			contentPanel.add(txt_pre);
		}
		{
			lblTalla = new JLabel("Talla:");
			lblTalla.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblTalla.setBounds(495, 120, 108, 20);
			contentPanel.add(lblTalla);
		}
		{
			txt_talla = new JTextField();
			txt_talla.setEditable(false);
			txt_talla.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txt_talla.setColumns(10);
			txt_talla.setBounds(579, 120, 210, 22);
			contentPanel.add(txt_talla);
		}
		{
			lblColor = new JLabel("Color:");
			lblColor.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblColor.setBounds(495, 169, 108, 20);
			contentPanel.add(lblColor);
		}
		{
			txt_color = new JTextField();
			txt_color.setEditable(false);
			txt_color.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txt_color.setColumns(10);
			txt_color.setBounds(579, 169, 210, 22);
			contentPanel.add(txt_color);
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(23, 247, 791, 362);
			contentPanel.add(scrollPane);
			{
				tableModel = new DefaultTableModel(
						new Object[][] {
						},
						new String[] {
			                    "Código", "Marca", "Categoria", "Proveedor", 
			                    "Stock", "Precio", "Talla", "Color"
			                }
					);
				tProductos = new JTable(tableModel);
				tProductos.addMouseListener(this);
				scrollPane.setViewportView(tProductos);
			}
		}
		{
			lblBuscar = new JLabel("Buscar C\u00F3digo:");
			lblBuscar.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblBuscar.setBounds(23, 211, 108, 20);
			contentPanel.add(lblBuscar);
		}
		{
			txtFCod = new JTextField();
			txtFCod.addKeyListener(this);
			txtFCod.setBounds(148, 211, 256, 25);
			contentPanel.add(txtFCod);
			txtFCod.setColumns(10);
		}
		{
			cbFiltroMarca = new JComboBox();
			cbFiltroMarca.setBounds(69, 620, 160, 25);
			contentPanel.add(cbFiltroMarca);
		}
		{
			cbFiltroCategoria = new JComboBox();
			cbFiltroCategoria.setBounds(303, 622, 160, 25);
			contentPanel.add(cbFiltroCategoria);
		}
		{
			cbFiltroProveedor = new JComboBox();
			cbFiltroProveedor.setBounds(537, 622, 160, 25);
			contentPanel.add(cbFiltroProveedor);
		}
		{
			lblMarca_1 = new JLabel("Marca");
			lblMarca_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblMarca_1.setBounds(10, 622, 66, 20);
			contentPanel.add(lblMarca_1);
		}
		{
			lblCategoria_1 = new JLabel("Categoria");
			lblCategoria_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblCategoria_1.setBounds(239, 622, 66, 20);
			contentPanel.add(lblCategoria_1);
		}
		{
			lblProovedor = new JLabel("Proveedor");
			lblProovedor.setHorizontalAlignment(SwingConstants.CENTER);
			lblProovedor.setBounds(473, 622, 66, 20);
			contentPanel.add(lblProovedor);
		}
		{
			btnFiltrar = new JButton("Filtrar");
			btnFiltrar.addActionListener(this);
			btnFiltrar.setIcon(new ImageIcon(VerStock.class.getResource("/Imagenes/search-regular-24.png")));
			btnFiltrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnFiltrar.setBounds(706, 618, 104, 29);
			contentPanel.add(btnFiltrar);
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
					mntmSalir.setIcon(new ImageIcon(VerStock.class.getResource("/Imagenes/cerrar-simbolo-de-boton-circular.png")));
					mnSalir.add(mntmSalir);
				}
			}
		}
		organizarMarca();
		organizarCategoria();
		organizarProveedor();
		Listar("", "", "", "");
	}
	ProductosBD pbd = new ProductosBD();
	private JMenuBar menuBar;
	private JMenu mnSalir;
	private JMenuItem mntmSalir;
	void organizarMarca(){
		ArrayList<String> marcas = pbd.obtenerMarcas();
		cbFiltroMarca.addItem("");
		for (String s : marcas) {
			cb_Marca.addItem(s);
			cbFiltroMarca.addItem(s);
		}
	}
	void organizarCategoria(){		
		ArrayList<String> cate = pbd.obtenerCategorias();
		cbFiltroCategoria.addItem("");
		for (String s : cate) {
			cb_Categoria.addItem(s);
			cbFiltroCategoria.addItem(s);
		}
	}
	void organizarProveedor(){
		ArrayList<String> proveedores = pbd.obtenerProveedores();
		cbFiltroProveedor.addItem("");
		for (String s : proveedores) {
			cb_Proveedor.addItem(s);
			cbFiltroProveedor.addItem(s);
		}
	}
	
	void Listar(String codigo, String marca, String categoria, String provee){
		ArrayList<Producto> alp = new ArrayList<>();		
		tableModel.setRowCount(0);
		if(codigo.length()==0&&marca.length()==0&&categoria.length()==0&&provee.length()==0){
			alp = pbd.obtenerBDProductosJF();
		}else{
			alp = pbd.ConsultarProductoFiltrosJF(codigo, marca, categoria, provee);			
		}	
		
        if (alp != null) {
            for (Producto p : alp) {
            	tableModel.addRow(new Object[] {
                    p.getCodigoProducto(),
                    p.getIDMarca(),
                    p.getIDCategoria(),
                    p.getIDProovedor(),
                    p.getStock(),
                    p.getPrecio(),
                    p.getTalla(),
                    p.getColor()
                });
            }
        }
		
	}
	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == tProductos) {
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
		int row = tProductos.getSelectedRow();
		txt_Cod.setText(tProductos.getValueAt(row, 0).toString());
		cb_Marca.setSelectedItem(tProductos.getValueAt(row, 1).toString());
		cb_Categoria.setSelectedItem(tProductos.getValueAt(row, 2).toString());
		cb_Proveedor.setSelectedItem(tProductos.getValueAt(row, 3).toString());
		txt_pre.setText(tProductos.getValueAt(row, 5).toString());
		txt_talla.setText(tProductos.getValueAt(row, 6).toString());
		txt_color.setText(tProductos.getValueAt(row, 7).toString());
		txt_Stock.setText(tProductos.getValueAt(row, 4).toString());
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnFiltrar) {
			do_btnFiltrar_actionPerformed(arg0);
		}
		if (arg0.getSource() == mntmSalir) {
			do_mntmSalir_actionPerformed(arg0);
		}
	}
	protected void do_mntmSalir_actionPerformed(ActionEvent arg0) {
		dispose();
	}
	public void keyPressed(KeyEvent arg0) {
	}
	public void keyReleased(KeyEvent arg0) {
	}
	public void keyTyped(KeyEvent arg0) {
		if (arg0.getSource() == txtFCod) {
			do_textField_1_keyTyped(arg0);
		}
	}
	protected void do_textField_1_keyTyped(KeyEvent arg0) {
		String cod = txtFCod.getText();
		Listar(cod, "", "", "");
	}
	protected void do_btnFiltrar_actionPerformed(ActionEvent arg0) {
		Listar(txtFCod.getText(), cbFiltroMarca.getSelectedItem().toString(), 
				cbFiltroCategoria.getSelectedItem().toString(), 
				cbFiltroProveedor.getSelectedItem().toString());
	}
}
