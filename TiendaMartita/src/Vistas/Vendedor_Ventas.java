package Vistas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JPasswordField;
import javax.swing.JMenu;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Clases.Producto;
import Clases.Trabajador;
import Clases.Vendedor;
import Controladores.ProductosBD;
import Controladores.TrabajadorBD;
import Clases.Cliente;
import Controladores.ClienteBD;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
//añadidos
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
//venta
import Clases.Venta;
import Clases.ProductoVender;
import Controladores.VentaBD;
//para que se pueda usar bien la fecha de la venta 
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import Controladores.TrabajadorBD;
import Vistas.Login;
import java.awt.Font;
import javax.swing.table.TableModel;
import java.awt.SystemColor;
import java.awt.Component;
import java.awt.Color;
import java.awt.Canvas;


public class Vendedor_Ventas extends JDialog implements ActionListener, KeyListener, ItemListener, MouseListener {

	private final JPanel contentPanel = new JPanel();
	private JMenuBar menuBar;
	private JLabel lblCodigoDelProducto;
	private JComboBox cb_Cod;
	private JLabel lblNombreDelProducto;
	private JLabel lblMarca;
	private JLabel lblTalla;
	private JTextField txt_talla;
	private JLabel lblNewLabel_1;
	private JMenu mnSalir;
	private JMenuItem mntmSalir;
	private JTextField txt_dni;
	private JLabel lblCliente;
	private JLabel lblPrecioFinal;
	private JLabel lblNewLabel_3;
	private JLabel lblComprobanteDePago;
	private JTextField txt_Precio_final;
	private JLabel lblCantidad;
	private JTextField txt_cant;
	private JButton btnVender;
	private JTextField txtFCodigo;
	private JTextField txtFTalla;
	private JTextField txtFMarca;
	private JTextField txtFCate;
	private JScrollPane scrollPane_1;
	private JTable tbTable;
	private DefaultTableModel tableModel;
	private DefaultTableModel tableModelPro;
	//se tiene que crear un arry global
	 private ArrayList<Producto> productos;
	 private JLabel lblDni;
	 //para los clientes 
	 private ArrayList<Cliente> clientes;
	 private JLabel lblGenero;
	 private JLabel lblCorrreo;
	 private JLabel lblCelular;
	 private JLabel lblEdad;
	 private JTextField txt_genero;
	 private JTextField txt_celula;
	 private JTextField txt_edad;
	 private JLabel lblNombre;
	 private JTextField txt_nom;
	 private JLabel lblApellido;
	 private JTextField txt_Apellido;
	 private JLabel lblPrecio;
	 private JTextField txt_pre;
	 private JComboBox cb_Marca;
	 private JComboBox cb_Categoria;
	 private JLabel lblStock;
	 private JTextField txt_Stock;
	 private JButton btnNewButton;
	 private Canvas canvas;
	 private Canvas canvas_1;
	 private JLabel lblProducto;
	 private JLabel lblRealizarVenta;
	 private JLabel lblDetalleDeLa;
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Vendedor_Ventas dialog = new Vendedor_Ventas();
			dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Vendedor_Ventas() {
		setTitle("Realizar Venta");
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 1295, 903);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			lblCodigoDelProducto = new JLabel("C\u00F3digo del producto");
			lblCodigoDelProducto.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblCodigoDelProducto.setBounds(410, 96, 130, 25);
			contentPanel.add(lblCodigoDelProducto);
		}
		{
			cb_Cod = new JComboBox();
			cb_Cod.addItemListener(this);
			cb_Cod.setBounds(551, 94, 146, 25);
			contentPanel.add(cb_Cod);
			
		}

		{
			lblNombreDelProducto = new JLabel("Categoria");
			lblNombreDelProducto.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNombreDelProducto.setBounds(410, 166, 130, 24);
			contentPanel.add(lblNombreDelProducto);
		}
		{
			lblMarca = new JLabel("Marca");
			lblMarca.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblMarca.setBounds(410, 130, 70, 25);
			contentPanel.add(lblMarca);
		}
		{
			lblTalla = new JLabel("Talla");
			lblTalla.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblTalla.setBounds(410, 275, 70, 25);
			contentPanel.add(lblTalla);
		}
		{
			txt_talla = new JTextField();
			txt_talla.setEditable(false);
			txt_talla.setBounds(551, 275, 146, 25);
			contentPanel.add(txt_talla);
			txt_talla.setColumns(10);
		}
		{
			lblNewLabel_1 = new JLabel("Lista de Productos: ");
			lblNewLabel_1.setBounds(10, 468, 124, 16);
			contentPanel.add(lblNewLabel_1);
		}
		{
			txt_dni = new JTextField();
			txt_dni.setEditable(false);
			txt_dni.setBounds(125, 96, 155, 25);
			contentPanel.add(txt_dni);
			txt_dni.setColumns(10);
		}
		{
			lblCliente = new JLabel("Cliente");
			lblCliente.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblCliente.setBounds(133, 59, 56, 25);
			contentPanel.add(lblCliente);
		}
		{
			lblPrecioFinal = new JLabel("Precio final: ");
			lblPrecioFinal.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblPrecioFinal.setBounds(763, 495, 88, 25);
			contentPanel.add(lblPrecioFinal);
		}
		{
			lblNewLabel_3 = new JLabel("Metodo de pago");
			lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel_3.setBounds(763, 430, 119, 25);
			contentPanel.add(lblNewLabel_3);
		}
		{
			lblComprobanteDePago = new JLabel("Comprobante de pago");
			lblComprobanteDePago.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblComprobanteDePago.setBounds(763, 460, 155, 25);
			contentPanel.add(lblComprobanteDePago);
		}
		{
			txt_Precio_final = new JTextField();
			txt_Precio_final.setEditable(false);
			txt_Precio_final.setBounds(925, 497, 180, 25);
			contentPanel.add(txt_Precio_final);
			txt_Precio_final.setColumns(10);
		}
		{
			lblCantidad = new JLabel("Cantidad");
			lblCantidad.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblCantidad.setBounds(410, 325, 97, 25);
			contentPanel.add(lblCantidad);
		}
		{
			txt_cant = new JTextField();
			txt_cant.setColumns(10);
			txt_cant.setBounds(551, 325, 146, 25);
			contentPanel.add(txt_cant);
		}
		{
			btnVender = new JButton("           Realizar Venta");
			btnVender.setIcon(new ImageIcon(Vendedor_Ventas.class.getResource("/Imagenes/purchase-tag-solid-24.png")));
			btnVender.setHorizontalAlignment(SwingConstants.LEFT);
			btnVender.setBackground(SystemColor.control);
			btnVender.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnVender.addActionListener(this);
			btnVender.setBounds(763, 539, 248, 37);
			contentPanel.add(btnVender);
		}
		{
			txtFCodigo = new JTextField();
			txtFCodigo.addKeyListener(this);
			txtFCodigo.addActionListener(this);
			txtFCodigo.setColumns(10);
			txtFCodigo.setBounds(152, 465, 116, 22);
			contentPanel.add(txtFCodigo);
		}
		{
			txtFTalla = new JTextField();
			txtFTalla.addKeyListener(this);
			txtFTalla.addActionListener(this);
			txtFTalla.setColumns(10);
			txtFTalla.setBounds(301, 465, 116, 22);
			contentPanel.add(txtFTalla);
		}
		{
			txtFMarca = new JTextField();
			txtFMarca.addKeyListener(this);
			txtFMarca.addActionListener(this);
			txtFMarca.setColumns(10);
			txtFMarca.setBounds(441, 465, 116, 22);
			contentPanel.add(txtFMarca);
		}
		{
			txtFCate = new JTextField();
			txtFCate.addKeyListener(this);
			txtFCate.addActionListener(this);
			txtFCate.setColumns(10);
			txtFCate.setBounds(590, 465, 116, 22);
			contentPanel.add(txtFCate);
		}
		{
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(22, 497, 684, 274);
			contentPanel.add(scrollPane_1);
			{
				tableModel = new DefaultTableModel(new Object[][] {},
			            new String[] {
			                    "Código", "Marca", "Categoria", "Stock",
			                    "Precio", "Talla", "Color"
			                }
						);
				tbTable = new JTable(tableModel);
				tbTable.addMouseListener(this);
				scrollPane_1.setViewportView(tbTable);
				tbTable.setFillsViewportHeight(true);
				{
					lblDni = new JLabel("DNI");
					lblDni.setFont(new Font("Tahoma", Font.PLAIN, 14));
					lblDni.setBounds(24, 96, 82, 25);
					contentPanel.add(lblDni);
				}
				{
					lblGenero = new JLabel("G\u00E9nero");
					lblGenero.setFont(new Font("Tahoma", Font.PLAIN, 14));
					lblGenero.setBounds(24, 198, 80, 25);
					contentPanel.add(lblGenero);
				}
				{
					lblCorrreo = new JLabel("Correo");
					lblCorrreo.setFont(new Font("Tahoma", Font.PLAIN, 14));
					lblCorrreo.setBounds(24, 234, 80, 25);
					contentPanel.add(lblCorrreo);
				}
				{
					lblCelular = new JLabel("Celular");
					lblCelular.setFont(new Font("Tahoma", Font.PLAIN, 14));
					lblCelular.setBounds(24, 266, 80, 25);
					contentPanel.add(lblCelular);
				}
				{
					lblEdad = new JLabel("Edad");
					lblEdad.setFont(new Font("Tahoma", Font.PLAIN, 14));
					lblEdad.setBounds(24, 302, 64, 25);
					contentPanel.add(lblEdad);
				}
				{
					txt_genero = new JTextField();
					txt_genero.setEditable(false);
					txt_genero.setBounds(125, 198, 155, 25);
					contentPanel.add(txt_genero);
					txt_genero.setColumns(10);
				}
				{
					txt_celula = new JTextField();
					txt_celula.setEditable(false);
					txt_celula.setBounds(125, 265, 155, 25);
					contentPanel.add(txt_celula);
					txt_celula.setColumns(10);
				}
				{
					txt_edad = new JTextField();
					txt_edad.setEditable(false);
					txt_edad.setText("");
					txt_edad.setBounds(125, 301, 155, 25);
					contentPanel.add(txt_edad);
					txt_edad.setColumns(10);
				}
				{
					lblNombre = new JLabel("Nombre");
					lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
					lblNombre.setBounds(24, 132, 80, 25);
					contentPanel.add(lblNombre);
				}
				{
					txt_nom = new JTextField();
					txt_nom.setEditable(false);
					txt_nom.setBounds(125, 131, 155, 25);
					contentPanel.add(txt_nom);
					txt_nom.setColumns(10);
				}
				{
					lblApellido = new JLabel("Apellido");
					lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 14));
					lblApellido.setBounds(24, 167, 80, 25);
					contentPanel.add(lblApellido);
				}
				{
					txt_Apellido = new JTextField();
					txt_Apellido.setEditable(false);
					txt_Apellido.setBounds(125, 166, 155, 25);
					contentPanel.add(txt_Apellido);
					txt_Apellido.setColumns(10);
				}
				{
					lblPrecio = new JLabel("Precio");
					lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 14));
					lblPrecio.setBounds(410, 239, 70, 25);
					contentPanel.add(lblPrecio);
				}
				{
					txt_pre = new JTextField();
					txt_pre.setEditable(false);
					txt_pre.setBounds(551, 239, 146, 25);
					contentPanel.add(txt_pre);
					txt_pre.setColumns(10);
				}
				
			}
		}
		{
			cb_Marca = new JComboBox();
			cb_Marca.setBounds(551, 132, 146, 25);
			contentPanel.add(cb_Marca);
		}
		{
			cb_Categoria = new JComboBox();
			cb_Categoria.setBounds(551, 168, 146, 25);
			contentPanel.add(cb_Categoria);
		}
		{
			lblStock = new JLabel("Stock");
			lblStock.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblStock.setBounds(410, 203, 70, 25);
			contentPanel.add(lblStock);
		}
		{
			txt_Stock = new JTextField();
			txt_Stock.setEditable(false);
			txt_Stock.setColumns(10);
			txt_Stock.setBounds(551, 203, 146, 25);
			contentPanel.add(txt_Stock);
		}
		{
			btnAgregarproducto = new JButton("            Agregar Producto");
			btnAgregarproducto.setHorizontalAlignment(SwingConstants.LEFT);
			btnAgregarproducto.setIcon(new ImageIcon(Vendedor_Ventas.class.getResource("/Imagenes/cart-add-solid-24.png")));
			btnAgregarproducto.setBackground(SystemColor.control);
			btnAgregarproducto.addActionListener(this);
			btnAgregarproducto.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnAgregarproducto.setBounds(410, 366, 276, 37);
			contentPanel.add(btnAgregarproducto);
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(763, 96, 477, 274);
			contentPanel.add(scrollPane);
			{
				tableModelPro = new DefaultTableModel(new Object[][] {},
			            new String[] {
			                    "Código",
			                    "Precio", "Cantidad", "Precio Total"
			                }
						);
				tbVentaPro = new JTable(tableModelPro);
				tbVentaPro.setFillsViewportHeight(true);
				scrollPane.setViewportView(tbVentaPro);
			}
		}
		{
			btnNewButton = new JButton("    Eliminar");
			btnNewButton.setIcon(new ImageIcon(Vendedor_Ventas.class.getResource("/Imagenes/trash-alt-solid-24.png")));
			btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
			btnNewButton.setBackground(SystemColor.control);
			btnNewButton.addActionListener(this);
			btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnNewButton.setBounds(1101, 372, 139, 37);
			contentPanel.add(btnNewButton);
		}
		{
			canvas = new Canvas();
			canvas.setBackground(Color.DARK_GRAY);
			canvas.setBounds(724, 59, 2, 760);
			contentPanel.add(canvas);
		}
		{
			canvas_1 = new Canvas();
			canvas_1.setBackground(Color.DARK_GRAY);
			canvas_1.setBounds(348, 59, 2, 350);
			contentPanel.add(canvas_1);
		}
		{
			lblProducto = new JLabel("Producto");
			lblProducto.setHorizontalAlignment(SwingConstants.CENTER);
			lblProducto.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblProducto.setBounds(475, 56, 103, 25);
			contentPanel.add(lblProducto);
		}
		{
			lblRealizarVenta = new JLabel("Realizar Venta");
			lblRealizarVenta.setHorizontalAlignment(SwingConstants.CENTER);
			lblRealizarVenta.setFont(new Font("Tahoma", Font.BOLD, 20));
			lblRealizarVenta.setBounds(315, 11, 663, 25);
			contentPanel.add(lblRealizarVenta);
		}
		{
			lblDetalleDeLa = new JLabel("Detalle de la Venta");
			lblDetalleDeLa.setHorizontalAlignment(SwingConstants.CENTER);
			lblDetalleDeLa.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblDetalleDeLa.setBounds(921, 56, 182, 25);
			contentPanel.add(lblDetalleDeLa);
		}
		{
			rd_Boleta = new JRadioButton("Boleta");
			rd_Boleta.addActionListener(this);
			rd_Boleta.setFont(new Font("Tahoma", Font.PLAIN, 13));
			rd_Boleta.setBounds(935, 463, 109, 23);
			contentPanel.add(rd_Boleta);
		}
		{
			rd_Factura = new JRadioButton("Factura");
			rd_Factura.addActionListener(this);
			rd_Factura.setFont(new Font("Tahoma", Font.PLAIN, 13));
			rd_Factura.setBounds(1046, 462, 109, 23);
			contentPanel.add(rd_Factura);
		}
		{
			lblCodigo = new JLabel("Buscar C\u00F3digo");
			lblCodigo.setHorizontalAlignment(SwingConstants.CENTER);
			lblCodigo.setBounds(152, 440, 116, 15);
			contentPanel.add(lblCodigo);
		}
		{
			lblTalla_1 = new JLabel("Buscar Talla");
			lblTalla_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblTalla_1.setBounds(301, 440, 116, 15);
			contentPanel.add(lblTalla_1);
		}
		{
			lblMarca_1 = new JLabel("Buscar Marca");
			lblMarca_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblMarca_1.setBounds(441, 440, 116, 15);
			contentPanel.add(lblMarca_1);
		}
		{
			lblCategoria = new JLabel("Buscar Categoria");
			lblCategoria.setHorizontalAlignment(SwingConstants.CENTER);
			lblCategoria.setBounds(590, 440, 116, 15);
			contentPanel.add(lblCategoria);
		}
		{
			cbMetodo = new JComboBox();
			cbMetodo.setModel(new DefaultComboBoxModel(new String[] {"Tarjeta", "Efectivo", "Plin", "Yape"}));
			cbMetodo.setBounds(929, 432, 139, 25);
			contentPanel.add(cbMetodo);
		}
		{
			label = new JLabel("@");
			label.setFont(new Font("Tahoma", Font.PLAIN, 15));
			label.setBounds(207, 234, 24, 25);
			contentPanel.add(label);
		}
		{
			cbCorreo = new JComboBox();
			cbCorreo.setFont(new Font("Tahoma", Font.PLAIN, 13));
			cbCorreo.setEnabled(false);
			cbCorreo.setBounds(227, 234, 95, 25);
			contentPanel.add(cbCorreo);
		}
		{
			txt_correo = new JTextField();
			txt_correo.setText("<dynamic>");
			txt_correo.setFont(new Font("Tahoma", Font.PLAIN, 13));
			txt_correo.setEditable(false);
			txt_correo.setColumns(10);
			txt_correo.setBounds(125, 233, 80, 25);
			contentPanel.add(txt_correo);
		}
		{
			menuBar = new JMenuBar();
			setJMenuBar(menuBar);
			{
				mnSalir = new JMenu("Salir");
				mnSalir.addActionListener(this);
				menuBar.add(mnSalir);
				{
					mntmSalir = new JMenuItem("Salir");
					mntmSalir.setIcon(new ImageIcon(Vendedor_Ventas.class.getResource("/Imagenes/cerrar-simbolo-de-boton-circular.png")));
					mntmSalir.addActionListener(this);
					mnSalir.add(mntmSalir);
				}
			}
			{
				mnCliente = new JMenu("Cliente");
				menuBar.add(mnCliente);
				{
					mntmCambiarCliente = new JMenuItem("Cambiar Cliente");
					mntmCambiarCliente.addActionListener(this);
					mntmCambiarCliente.setIcon(new ImageIcon(Vendedor_Ventas.class.getResource("/Imagenes/users-avatar.png")));
					mnCliente.add(mntmCambiarCliente);
				}
			}
		}
		
		llenarComboBox();
		organizarCategoria();
		organizarMarca();
		Listar("","","","");
		String cod = Clientes.codigo;
		llenarCamposCliente(cbd.obtenerBDSoloClienteCod(cod));
	}
	ProductosBD pbd = new ProductosBD();
	private JButton btnAgregarproducto;
	private JScrollPane scrollPane;
	private JTable tbVentaPro;
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == rd_Factura) {
			do_rd_Factura_actionPerformed(e);
		}
		if (e.getSource() == rd_Boleta) {
			do_rd_Boleta_actionPerformed(e);
		}
		if (e.getSource() == mntmCambiarCliente) {
			do_mntmCambiarCliente_actionPerformed(e);
		}
		if (e.getSource() == btnNewButton) {
			do_btnNewButton_actionPerformed(e);
		}
		if (e.getSource() == btnAgregarproducto) {
			do_btnAgregarproducto_actionPerformed(e);
		}
		if (e.getSource() == txtFCodigo) {
			do_textField_4_actionPerformed(e);
		}
		if (e.getSource() == btnVender) {
			do_btnVender_actionPerformed(e);
		}
		if (e.getSource() == mntmSalir) {
			do_mntmSalir_actionPerformed(e);
		}
		if (e.getSource() == mnSalir) {
			do_mnSalir_actionPerformed(e);
		}
	}
	protected void do_mnSalir_actionPerformed(ActionEvent e) {
	}
	protected void do_mntmSalir_actionPerformed(ActionEvent e) {
		dispose();
	}
	void limpiar(){
		txt_cant.setText("");
		txt_dni.setText("");
		txt_nom.setText("");
		txt_Apellido.setText("");
		txt_genero.setText("");
		txt_correo.setText("");
		txt_celula.setText("");
		txt_edad.setText("");
		rd_Boleta.setSelected(false);
		rd_Factura.setSelected(false);
		alpv.clear();
		txtFCate.setText("");
		txtFCodigo.setText("");
		txtFMarca.setText("");
		txtFTalla.setText("");		
		ListarTablaV();
	}
	public void Listar(String codigo, String talla, String marca, String categoria){
		ArrayList<Producto> alp = new ArrayList<>();		
		tableModel.setRowCount(0);
		if(codigo.length()==0&&talla.length()==0&&marca.length()==0&&categoria.length()==0){
			alp = pbd.obtenerBDProductos();
		}else{
			alp = pbd.ConsultarProductoFiltros(codigo, talla, marca, categoria);			
		}	
		
        if (alp != null) {
            for (Producto p : alp) {
            	tableModel.addRow(new Object[] {
                    p.getCodigoProducto(),
                    p.getIDMarca(),
                    p.getIDCategoria(),
                    p.getStock(),
                    p.getPrecio(),
                    p.getTalla(),
                    p.getColor()
                });
            }
        }
		
	}	

	 public void llenarComboBox() {	        
	        productos = pbd.obtenerBDProductos();	        
	        if (productos != null && !productos.isEmpty()) {
	            System.out.println("Productos obtenidos: " + productos.size());
	            for (Producto producto : productos) {
	                cb_Cod.addItem(producto.getCodigoProducto());
	                System.out.println("Producto añadido al comboBox: " + producto.getCodigoProducto());
	            }
	        } else {
	            JOptionPane.showMessageDialog(this, "No se encontraron productos en la base de datos.");
	        }
	    } 	
		void organizarMarca(){
			ArrayList<String> marcas = pbd.obtenerMarcas();
			for (String s : marcas) {
				cb_Marca.addItem(s);
			}
		}
		void organizarCategoria(){		
			ArrayList<String> cate = pbd.obtenerCategorias();
			for (String s : cate) {
				cb_Categoria.addItem(s);
			}
		}
	 private Producto buscarProductoPorCodigo(String codigo) {
		  if (productos != null) {
	            for (Producto producto : productos) {
	                if (producto.getCodigoProducto().equals(codigo)) {
	                    return producto;
	                }
	            }
	        }
		  System.out.println("no funca buscar");
	        return null;
	 }	
	 public void llenarCamposProducto(Producto producto) {
		 if(producto != null){
			 cb_Categoria.setSelectedItem(producto.getIDCategoria());
			 txt_talla.setText(producto.getTalla());
			 txt_Stock.setText(""+producto.getStock());
			 cb_Categoria.setSelectedItem(producto.getIDMarca());
			 txt_pre.setText(String.valueOf(producto.getPrecio()));
		 }else{
			 
             JOptionPane.showMessageDialog(this, "Producto no encontrado.");
		 }
    }

	 
	 //----------------------------------
	 //PARA EL CLIENTE
	 //--------------------------------- 
	 ClienteBD cbd = new ClienteBD();

	 public void llenarCamposCliente(Cliente cliente) {
		 try{
			 txt_dni.setText(cliente.getDniCliente());
			 txt_nom.setText(cliente.getNombreCliente());
			 txt_Apellido.setText(cliente.getApellidoCliente());
			 txt_genero.setText(cliente.getGeneroCliente());
			 txt_celula.setText(cliente.getCelularCliente());
			 txt_correo.setText(cliente.getCorreoCliente().split("@")[0]);
			 cbCorreo.setSelectedItem(cliente.getCorreoCliente().split("@")[0].toString());
			 txt_edad.setText(String.valueOf(cliente.getEdadCliente()));
		 }catch(Exception e){}
		 
    }
	 //----------------------------------------
	 //INSERTAR UNA VENTA
	 //--------------------------------------
	ArrayList<ProductoVender> alpv = new ArrayList<>();
	private JRadioButton rd_Boleta;
	private JRadioButton rd_Factura;
	VentaBD vbd = new VentaBD();
	private JLabel lblCodigo;
	private JLabel lblTalla_1;
	private JLabel lblMarca_1;
	private JLabel lblCategoria;
	private JMenu mnCliente;
	private JMenuItem mntmCambiarCliente;
	private JComboBox cbMetodo;
	private JLabel label;
	private JComboBox cbCorreo;
	private JTextField txt_correo;
	protected void do_btnVender_actionPerformed(ActionEvent e) {			
		if(alpv.size()!=0){
			boolean exito = vbd.RealizarVenta(alpv, obtenerDatosVentas());
			if(exito) JOptionPane.showMessageDialog(this, "Venta Realizada con exito");
			else JOptionPane.showMessageDialog(this, "Error: No hay productos suficientes");
			Listar("","","","");	
			this.dispose();
		}else{
			JOptionPane.showMessageDialog(this, "No hay productos para vender");
		}
		limpiar();
	}	
	
	double montoFinal(){
		double monto= 0.0;
		if(alpv.size()!=0){
			for (ProductoVender p : alpv) {
				monto += p.totalProducto();				
			}
		}
		return monto;
	}
	String generaNroVenta(){
		int numeroAleatorio = (int)(Math.random() * 9000) + 1000;
		String venta = "NV-"+numeroAleatorio;
		return venta;
	}
	Venta obtenerDatosVentas(){
		String codvendedor= Inicio.v.getCodigoTrabajador();
		String nroventa = "";
		while(nroventa.equals("")){
			if(vbd.verificarNroVenta(generaNroVenta())) nroventa = generaNroVenta();
		}
		String codigoCliente =  Clientes.codigo;
		Double descuento=0.0;
		String metododepago = cbMetodo.getSelectedItem().toString();
		String comprobante= "";
		if(rd_Boleta.isSelected()) {
			comprobante = "Boleta";
			rd_Factura.setSelected(false);
		}
		if(rd_Factura.isSelected()) {
			comprobante = "Factura";
			rd_Boleta.setSelected(false);
		}
		if(comprobante.equals("")) JOptionPane.showMessageDialog(this, "Seleccione un comprobante de pago");
		LocalDate fechaActual = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        Date fechaVenta = java.sql.Date.valueOf(fechaActual);
		Venta v= new Venta(nroventa,codigoCliente,codvendedor,montoFinal(),descuento,metododepago,comprobante,fechaVenta);
		return v;
	}

	protected void do_textField_4_actionPerformed(ActionEvent e) {		
	}
	public void keyPressed(KeyEvent arg0) {
	}
	public void keyReleased(KeyEvent arg0) {
	}
	public void keyTyped(KeyEvent arg0) {
		if (arg0.getSource() == txtFCate) {
			do_txtFCate_keyTyped(arg0);
		}
		if (arg0.getSource() == txtFMarca) {
			do_txtFMarca_keyTyped(arg0);
		}
		if (arg0.getSource() == txtFTalla) {
			do_txtFTalla_keyTyped(arg0);
		}
		if (arg0.getSource() == txtFCodigo) {
			do_txtFCodigo_keyTyped(arg0);
		}
	}
	protected void do_txtFCodigo_keyTyped(KeyEvent arg0) {
		Listar(txtFCodigo.getText(),txtFTalla.getText(),txtFMarca.getText(),txtFCate.getText());
	}
	protected void do_txtFTalla_keyTyped(KeyEvent arg0) {
		Listar(txtFCodigo.getText(),txtFTalla.getText(),txtFMarca.getText(),txtFCate.getText());
	}
	protected void do_txtFMarca_keyTyped(KeyEvent arg0) {
		Listar(txtFCodigo.getText(),txtFTalla.getText(),txtFMarca.getText(),txtFCate.getText());
	}
	protected void do_txtFCate_keyTyped(KeyEvent arg0) {
		Listar(txtFCodigo.getText(),txtFTalla.getText(),txtFMarca.getText(),txtFCate.getText());
	}
	
	//mostar los txt cuando se lecione un text box

	protected void do_comboBox_itemStateChanged(ItemEvent arg0) {			
	}
	
	protected void do_cbm2_itemStateChanged(ItemEvent arg0) {		
	}
	
	//Registrar cliente
	
	
	
	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == tbTable) {
			do_tbTable_mouseClicked(arg0);
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
	protected void do_tbTable_mouseClicked(MouseEvent arg0) {
		int row = tbTable.getSelectedRow();
		cb_Cod.setSelectedItem(tbTable.getValueAt(row, 0).toString());
		cb_Marca.setSelectedItem(tbTable.getValueAt(row, 1).toString());
		cb_Categoria.setSelectedItem(tbTable.getValueAt(row, 2).toString());
		txt_Stock.setText(tbTable.getValueAt(row, 3).toString());
		txt_pre.setText(tbTable.getValueAt(row, 4).toString());
		txt_talla.setText(tbTable.getValueAt(row, 5).toString());
	}

	protected void do_btnAgregarproducto_actionPerformed(ActionEvent e) {
		if(txt_cant.getText().equals("")){
			JOptionPane.showMessageDialog(this, "Ingrese la cantidad del producto");
		}else{
			boolean key = true;
			String codPro = cb_Cod.getSelectedItem().toString();
			if(alpv.size() != 0){
				for (ProductoVender p : alpv) {
					if(p.getProducto().getCodigoProducto().equals(codPro)){ 
						key = false;
						p.setCantidad(p.getCantidad() + Integer.parseInt(txt_cant.getText()));
					}
				}
			}			
			if(key){
				Producto p = pbd.obtenerBDSoloProducto(codPro);
				ProductoVender pv = new ProductoVender(p,Integer.parseInt(txt_cant.getText()), 0);
				alpv.add(pv);
			}
			ListarTablaV();
			txt_cant.setText("");
		}
	}	
	void ListarTablaV(){
		tableModelPro.setRowCount(0);
        for (ProductoVender p : alpv) {
        	tableModelPro.addRow(new Object[] {
        			p.getProducto().getCodigoProducto(),
        			p.getProducto().getPrecio(),
        			p.getCantidad(),
        			p.totalProducto()
            });		
        }
        txt_Precio_final.setText(""+montoFinal());
    }
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		alpv.remove(tbVentaPro.getSelectedRow());
		ListarTablaV();
		Listar("", "", "", "");
	}
	String generaCodCliente(){
		int numeroAleatorio = (int)(Math.random() * 9000) + 1000;
		String cod = "CL-"+numeroAleatorio;
		return cod;
	}
	
	protected void do_mntmCambiarCliente_actionPerformed(ActionEvent e) {
		String cod = Clientes.codigo;
		Clientes c = new Clientes(cbd.obtenerBDSoloClienteCod(cod), 1);
		c.setVisible(true);
		dispose();
	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	protected void do_rd_Boleta_actionPerformed(ActionEvent e) {
		rd_Factura.setSelected(false);
	}
	protected void do_rd_Factura_actionPerformed(ActionEvent e) {
		rd_Boleta.setSelected(false);
	}
}
