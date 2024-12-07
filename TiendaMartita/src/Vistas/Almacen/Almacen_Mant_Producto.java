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
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class Almacen_Mant_Producto extends JDialog implements MouseListener, ActionListener, KeyListener {

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
	private JLabel lblAgregarYModificar;
	private JScrollPane scrollPane;
	private JTable tProductos;
	private JButton btnAgregar;
	private JButton btnModificar;
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
			Almacen_Mant_Producto dialog = new Almacen_Mant_Producto();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Almacen_Mant_Producto() {
		setTitle("Mantenimiento Productos");
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 897, 718);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			lblCodigo = new JLabel("C\u00F3digo:");
			lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblCodigo.setBounds(10, 68, 108, 20);
			contentPanel.add(lblCodigo);
		}
		{
			txt_Cod = new JTextField();
			txt_Cod.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txt_Cod.setBounds(94, 68, 210, 22);
			contentPanel.add(txt_Cod);
			txt_Cod.setColumns(10);
		}
		{
			lblMarca = new JLabel("Marca:");
			lblMarca.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblMarca.setBounds(10, 111, 108, 20);
			contentPanel.add(lblMarca);
		}
		{
			cb_Marca = new JComboBox();
			cb_Marca.setFont(new Font("Tahoma", Font.PLAIN, 14));
			cb_Marca.setBounds(94, 111, 210, 25);
			contentPanel.add(cb_Marca);
		}
		{
			lblCategoria = new JLabel("Categoria:");
			lblCategoria.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblCategoria.setBounds(10, 156, 108, 20);
			contentPanel.add(lblCategoria);
		}
		{
			cb_Categoria = new JComboBox();
			cb_Categoria.setBounds(94, 156, 210, 25);
			contentPanel.add(cb_Categoria);
		}
		{
			lblProveedor = new JLabel("Proveedor:");
			lblProveedor.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblProveedor.setBounds(10, 204, 108, 20);
			contentPanel.add(lblProveedor);
		}
		{
			cb_Proveedor = new JComboBox();
			cb_Proveedor.setBounds(94, 204, 210, 25);
			contentPanel.add(cb_Proveedor);
		}
		{
			lblStock = new JLabel("Stock:");
			lblStock.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblStock.setBounds(389, 68, 108, 20);
			contentPanel.add(lblStock);
		}
		{
			txt_Stock = new JTextField();
			txt_Stock.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txt_Stock.setColumns(10);
			txt_Stock.setBounds(473, 68, 210, 22);
			contentPanel.add(txt_Stock);
		}
		{
			lblPrecio = new JLabel("Precio:");
			lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblPrecio.setBounds(389, 114, 108, 20);
			contentPanel.add(lblPrecio);
		}
		{
			txt_pre = new JTextField();
			txt_pre.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txt_pre.setColumns(10);
			txt_pre.setBounds(473, 114, 210, 22);
			contentPanel.add(txt_pre);
		}
		{
			lblTalla = new JLabel("Talla:");
			lblTalla.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblTalla.setBounds(389, 163, 108, 20);
			contentPanel.add(lblTalla);
		}
		{
			txt_talla = new JTextField();
			txt_talla.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txt_talla.setColumns(10);
			txt_talla.setBounds(473, 163, 210, 22);
			contentPanel.add(txt_talla);
		}
		{
			lblColor = new JLabel("Color:");
			lblColor.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblColor.setBounds(389, 212, 108, 20);
			contentPanel.add(lblColor);
		}
		{
			txt_color = new JTextField();
			txt_color.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txt_color.setColumns(10);
			txt_color.setBounds(473, 212, 210, 22);
			contentPanel.add(txt_color);
		}
		{
			lblAgregarYModificar = new JLabel("Mantenimiento Productos");
			lblAgregarYModificar.setHorizontalAlignment(SwingConstants.CENTER);
			lblAgregarYModificar.setFont(new Font("Tahoma", Font.BOLD, 18));
			lblAgregarYModificar.setBounds(218, 11, 387, 34);
			contentPanel.add(lblAgregarYModificar);
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(23, 351, 833, 260);
			contentPanel.add(scrollPane);
			{
				tableModel = new DefaultTableModel(
						new Object[][] {
						},
						new String[] {
			                    "Código", "Marca", "Categoría", "Proveedor", 
			                    "Stock", "Precio", "Talla", "Color"
			                }
					);
				tProductos = new JTable(tableModel);
				tProductos.addMouseListener(this);
				scrollPane.setViewportView(tProductos);
			}
		}
		{
			btnAgregar = new JButton("     Agregar");
			btnAgregar.setBackground(SystemColor.menu);
			btnAgregar.setHorizontalAlignment(SwingConstants.LEFT);
			btnAgregar.setIcon(new ImageIcon(Almacen_Mant_Producto.class.getResource("/Imagenes/plus-circle-regular-24.png")));
			btnAgregar.addActionListener(this);
			btnAgregar.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnAgregar.setBounds(706, 79, 150, 38);
			contentPanel.add(btnAgregar);
		}
		{
			btnModificar = new JButton("    Eliminar");
			btnModificar.setBackground(SystemColor.menu);
			btnModificar.setHorizontalAlignment(SwingConstants.LEFT);
			btnModificar.setIcon(new ImageIcon(Almacen_Mant_Producto.class.getResource("/Imagenes/trash-alt-solid-24.png")));
			btnModificar.addActionListener(this);
			btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnModificar.setBounds(706, 195, 150, 38);
			contentPanel.add(btnModificar);
		}
		{
			lblBuscar = new JLabel("Buscar C\u00F3digo:");
			lblBuscar.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblBuscar.setBounds(20, 311, 113, 20);
			contentPanel.add(lblBuscar);
		}
		{
			txtFCod = new JTextField();
			txtFCod.addKeyListener(this);
			txtFCod.setBounds(156, 311, 256, 25);
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
			btnFiltrar = new JButton("    Filtrar");
			btnFiltrar.setBackground(SystemColor.control);
			btnFiltrar.setHorizontalAlignment(SwingConstants.LEFT);
			btnFiltrar.setIcon(new ImageIcon(Almacen_Mant_Producto.class.getResource("/Imagenes/search-regular-24.png")));
			btnFiltrar.addActionListener(this);
			btnFiltrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnFiltrar.setBounds(737, 616, 119, 38);
			contentPanel.add(btnFiltrar);
		}
		{
			btnModificar_1 = new JButton("     Modificar");
			btnModificar_1.setBackground(SystemColor.menu);
			btnModificar_1.addActionListener(this);
			btnModificar_1.setHorizontalAlignment(SwingConstants.LEFT);
			btnModificar_1.setIcon(new ImageIcon(Almacen_Mant_Producto.class.getResource("/Imagenes/edit-solid-24.png")));
			btnModificar_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnModificar_1.setBounds(706, 138, 150, 38);
			contentPanel.add(btnModificar_1);
		}
		{
			btnAgregarCantidad = new JButton("Agregar Stock");
			btnAgregarCantidad.setBackground(SystemColor.control);
			btnAgregarCantidad.addActionListener(this);
			btnAgregarCantidad.setIcon(new ImageIcon(Almacen_Mant_Producto.class.getResource("/Imagenes/plus-circle-regular-24.png")));
			btnAgregarCantidad.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnAgregarCantidad.setBounds(681, 302, 175, 38);
			contentPanel.add(btnAgregarCantidad);
		}
		{
			txtAgregarCantidad = new JTextField();
			txtAgregarCantidad.setColumns(10);
			txtAgregarCantidad.setBounds(473, 311, 198, 25);
			contentPanel.add(txtAgregarCantidad);
		}
		{
			lblCantidad = new JLabel("Cantidad:");
			lblCantidad.setHorizontalAlignment(SwingConstants.CENTER);
			lblCantidad.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblCantidad.setBounds(526, 285, 113, 20);
			contentPanel.add(lblCantidad);
		}
		{
			btnLimpiar = new JButton("     Limpiar");
			btnLimpiar.addActionListener(this);
			btnLimpiar.setIcon(new ImageIcon(Almacen_Mant_Producto.class.getResource("/Imagenes/mop.png")));
			btnLimpiar.setHorizontalAlignment(SwingConstants.LEFT);
			btnLimpiar.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnLimpiar.setBounds(706, 20, 150, 36);
			contentPanel.add(btnLimpiar);
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
					mntmSalir.setIcon(new ImageIcon(Almacen_Mant_Producto.class.getResource("/Imagenes/cerrar-simbolo-de-boton-circular.png")));
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
	private JButton btnModificar_1;
	private JButton btnAgregarCantidad;
	private JTextField txtAgregarCantidad;
	private JMenuBar menuBar;
	private JMenu mnSalir;
	private JMenuItem mntmSalir;
	private JLabel lblCantidad;
	private JButton btnLimpiar;
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
		txt_Stock.setText(tProductos.getValueAt(row, 4).toString());
		txt_pre.setText(tProductos.getValueAt(row, 5).toString());
		txt_talla.setText(tProductos.getValueAt(row, 6).toString());
		txt_color.setText(tProductos.getValueAt(row, 7).toString());
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnLimpiar) {
			do_btnLimpiar_actionPerformed(arg0);
		}
		if (arg0.getSource() == mntmSalir) {
			do_mntmSalir_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnModificar_1) {
			do_btnModificar_1_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnAgregarCantidad) {
			do_btnAgregarCantidad_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnFiltrar) {
			do_btnFiltrar_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnModificar) {
			do_btnModificar_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnAgregar) {
			do_btnAgregar_actionPerformed(arg0);
		}
	}
	Producto obtenerProductos(){
		String codigoProducto = txt_Cod.getText();
		String iDMarca = cb_Marca.getSelectedItem().toString();
		String iDCategoria = cb_Categoria.getSelectedItem().toString();
		String idProveedor = cb_Proveedor.getSelectedItem().toString();
		int stock = Integer.parseInt(txt_Stock.getText());
		double precio = Double.parseDouble(txt_pre.getText());
		String talla = txt_talla.getText();
		String color = txt_color.getText();		
		Producto p = new Producto(codigoProducto, iDMarca, iDCategoria,idProveedor, stock, precio, talla, color);
		return p;
	}
	protected void do_btnAgregar_actionPerformed(ActionEvent arg0) {
		if(pbd.obtenerBDSoloProducto(obtenerProductos().getCodigoProducto()) == null){
			pbd.insertarBDProducto(obtenerProductos());
			Listar("", "", "", "");
			txt_Stock.setText("");
			Limpiar();
		}else{
			JOptionPane.showMessageDialog(this,"No pudo ingresar producto");
		}
	}
	protected void do_btnModificar_actionPerformed(ActionEvent arg0) {
		String cod = txt_Cod.getText();
		pbd.eliminarProducto(cod);
		Listar("", "", "", "");
		Limpiar();
	}
	public void keyPressed(KeyEvent arg0) {
	}
	public void keyReleased(KeyEvent arg0) {
		if (arg0.getSource() == txtFCod) {
			do_textField_1_keyReleased(arg0);
		}
	}
	public void keyTyped(KeyEvent arg0) {
	}
	protected void do_textField_1_keyReleased(KeyEvent arg0) {
		String cod = txtFCod.getText();
		Listar(cod, "", "", "");
	}
	protected void do_btnFiltrar_actionPerformed(ActionEvent arg0) {
		Listar(txtFCod.getText(), cbFiltroMarca.getSelectedItem().toString(), 
				cbFiltroCategoria.getSelectedItem().toString(), 
				cbFiltroProveedor.getSelectedItem().toString());
	}
	protected void do_btnAgregarCantidad_actionPerformed(ActionEvent arg0) {
		int aumentar = Integer.parseInt(txtAgregarCantidad.getText());
		String cod = txt_Cod.getText();		
		pbd.aumentarStock(aumentar, cod);
		Listar("", "", "", "");
		Limpiar();
		txt_Stock.setText("");
	}
	protected void do_btnModificar_1_actionPerformed(ActionEvent arg0) {
		pbd.modificarProducto(obtenerProductos());
		Listar("", "", "", "");
		Limpiar();
		txt_Stock.setText("");
	}
	protected void do_mntmSalir_actionPerformed(ActionEvent arg0) {
		dispose();
	}
	void Limpiar(){
		txt_Cod.setText("");
		cb_Marca.setSelectedItem("");
		cb_Categoria.setSelectedItem("");
		cb_Proveedor.setSelectedItem("");
		txt_Stock.setText("");
		txt_pre.setText("");
		txt_talla.setText("");
		txt_color.setText("");
	}
	protected void do_btnLimpiar_actionPerformed(ActionEvent arg0) {
		Limpiar();
	}
}
