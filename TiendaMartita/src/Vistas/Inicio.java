package Vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Clases.JFAlmacen;
import Clases.Trabajador;
import Clases.Vendedor;
import Controladores.TrabajadorBD;
import Vistas.Almacen.Almacen_Mant_Categoria;
import Vistas.Almacen.Almacen_Mant_Marca;
import Vistas.Almacen.Almacen_Mant_Producto;
import Vistas.Almacen.Almacen_Mant_Proveedor;
import Vistas.Gerente.Gerente_Almacen;
import Vistas.Gerente.Gerente_Gerente;
import Vistas.Gerente.Gerente_Reporte;
import Vistas.Gerente.Gerente_Vendedor;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.UIManager;
import java.awt.Font;
import java.awt.Image;

import javax.swing.Box;
import javax.swing.JDialog;

import java.awt.Component;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import java.awt.Dimension;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class Inicio extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblBienvenida;
	private JLabel lblCodigoTrabajador;
	private static JFAlmacen jfe;
	private JLabel lblNewLabel;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblNombresYApellidos;
	private JLabel label_1;
	private JPanel panel_2;
	private JLabel lblDni;
	private JLabel label_3;
	private JPanel panel_3;
	private JLabel lblCelular;
	private JLabel label_5;
	private JPanel panel_4;
	private JLabel lblCorreo;
	private JLabel label_7;
	private JPanel panel_5;
	private JLabel lblEdad;
	private JLabel label_9;
	private JMenu mnMatenimiento;
	private JMenuItem mntmProducto;
	private JMenuItem mntmProveedor;
	private JMenuItem mntmCategoria;
	private JMenuItem mntmMarca;
	private JMenu mnNewMenu_2;
	private JMenuItem mntmVendedores;
	private JMenuItem mntmGerente;
	private JMenuItem mntmJefeDeAlmacen;
	private JMenuItem mntmReporte;
	private ImageIcon image;
	public static Trabajador v;
	
	/*public static void main(String[] args) {
		try {
			Almacen_Inicio dialog = new Almacen_Inicio(jfe);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
	
	
	/**
	 * Create the frame.
	 */
	public Inicio(Trabajador vendedor) {
		v = vendedor;
		setTitle("Inicio");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 898, 422);
		{
			menuBar = new JMenuBar();
			setJMenuBar(menuBar);
			{
				mnSalir = new JMenu("   Salir   |");
				mnSalir.setFont(new Font("Segoe UI", Font.BOLD, 13));
				menuBar.add(mnSalir);
				{
					mntmCerrar = new JMenuItem("Cerrar");
					mntmCerrar.addActionListener(this);
					mntmCerrar.setIcon(new ImageIcon(Inicio.class.getResource("/Imagenes/cerrar-simbolo-de-boton-circular.png")));
					mnSalir.add(mntmCerrar);
				}
				{
					mntmCerrarSesion = new JMenuItem("Cerrar Sesion");
					mntmCerrarSesion.addActionListener(this);
					mntmCerrarSesion.setIcon(new ImageIcon(Inicio.class.getResource("/Imagenes/cerrar-sesion-24.png")));
					mnSalir.add(mntmCerrarSesion);
				}
			}
			{
				mnVenta = new JMenu("   Venta   |");
				mnVenta.setFont(new Font("Segoe UI", Font.BOLD, 13));
				menuBar.add(mnVenta);
				{
					mntmRealizarVenta = new JMenuItem("Realizar Venta");
					mntmRealizarVenta.setIcon(new ImageIcon(Inicio.class.getResource("/Imagenes/purchase-tag-solid-24.png")));
					mntmRealizarVenta.addActionListener(this);
					mnVenta.add(mntmRealizarVenta);
				}
				{
					mntmReporte = new JMenuItem("Reporte");
					mntmReporte.addActionListener(this);
					mntmReporte.setIcon(new ImageIcon(Inicio.class.getResource("/Imagenes/negocio.png")));
					mnVenta.add(mntmReporte);
				}
			}
			{
				mnProductos = new JMenu("   Productos   |");
				mnProductos.setFont(new Font("Segoe UI", Font.BOLD, 13));
				menuBar.add(mnProductos);
				{
					mntmVerproductos = new JMenuItem("Ver Stock");
					mntmVerproductos.setIcon(new ImageIcon(Inicio.class.getResource("/Imagenes/registro.png")));
					mntmVerproductos.addActionListener(this);
					mnProductos.add(mntmVerproductos);
				}
			}
			{
				mnMatenimiento = new JMenu("   Matenimiento   |");
				mnMatenimiento.setFont(new Font("Segoe UI", Font.BOLD, 13));
				menuBar.add(mnMatenimiento);
				{
					mntmProducto = new JMenuItem("Producto");
					mntmProducto.addActionListener(this);
					mntmProducto.setIcon(new ImageIcon(Inicio.class.getResource("/Imagenes/agregar-producto.png")));
					mnMatenimiento.add(mntmProducto);
				}
				{
					mntmProveedor = new JMenuItem("Proveedor");
					mntmProveedor.addActionListener(this);
					mntmProveedor.setIcon(new ImageIcon(Inicio.class.getResource("/Imagenes/proveedor.png")));
					mnMatenimiento.add(mntmProveedor);
				}
				{
					mntmCategoria = new JMenuItem("Categoria");
					mntmCategoria.addActionListener(this);
					mntmCategoria.setIcon(new ImageIcon(Inicio.class.getResource("/Imagenes/categoria.png")));
					mnMatenimiento.add(mntmCategoria);
				}
				{
					mntmMarca = new JMenuItem("Marca");
					mntmMarca.addActionListener(this);
					mntmMarca.setIcon(new ImageIcon(Inicio.class.getResource("/Imagenes/desarrollo-de-marca.png")));
					mnMatenimiento.add(mntmMarca);
				}
			}
			{
				mnNewMenu_2 = new JMenu("   Usuarios   ");
				mnNewMenu_2.setFont(new Font("Segoe UI", Font.BOLD, 13));
				mnNewMenu_2.addActionListener(this);
				menuBar.add(mnNewMenu_2);
				{
					mntmVendedores = new JMenuItem("Vendedores");
					mntmVendedores.addActionListener(this);
					mntmVendedores.setIcon(new ImageIcon(Inicio.class.getResource("/Imagenes/vendedor -24.png")));
					mnNewMenu_2.add(mntmVendedores);
				}
				{
					{
						mntmGerente = new JMenuItem("Gerente");
						mntmGerente.addActionListener(this);
						mntmGerente.setIcon(new ImageIcon(Inicio.class.getResource("/Imagenes/gerente-24.png")));
						mnNewMenu_2.add(mntmGerente);
					}
					{
						mntmJefeDeAlmacen = new JMenuItem("Jefe de Almacen");
						mntmJefeDeAlmacen.addActionListener(this);
						mntmJefeDeAlmacen.setIcon(new ImageIcon(Inicio.class.getResource("/Imagenes/almacen -24.png")));
						mnNewMenu_2.add(mntmJefeDeAlmacen);
					}
					{
						mntmClientes = new JMenuItem("Clientes");
						mnNewMenu_2.add(mntmClientes);
						mntmClientes.addActionListener(this);
						mntmClientes.setIcon(new ImageIcon(Inicio.class.getResource("/Imagenes/users-avatar.png")));
					}
				}
			}
			{
				mnContactenos = new JMenu("|   Contactenos   ");
				mnContactenos.setFont(new Font("Segoe UI", Font.BOLD, 13));
				menuBar.add(mnContactenos);
				{
					mntmProgramadores = new JMenuItem("Programadores");
					mntmProgramadores.addActionListener(this);
					mntmProgramadores.setIcon(new ImageIcon(Inicio.class.getResource("/Imagenes/coding.png")));
					mnContactenos.add(mntmProgramadores);
				}
			}
		}
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblBienvenida = new JLabel("Bienvenido " + v.getNombreCompleto());
			lblBienvenida.setHorizontalAlignment(SwingConstants.CENTER);
			lblBienvenida.setFont(new Font("Tahoma", Font.BOLD, 24));
			lblBienvenida.setBounds(292, 17, 367, 41);
			contentPane.add(lblBienvenida);
		}
		{
			panel = new JPanel();
			panel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
			panel.setBounds(405, 69, 206, 75);
			contentPane.add(panel);
			{
				lblCodigoTrabajador = new JLabel("C\u00F3digo Trabajador");
				lblCodigoTrabajador.setBounds(10, 11, 136, 21);
				lblCodigoTrabajador.setFont(new Font("Tahoma", Font.PLAIN, 17));
			}
			panel.setLayout(null);
			panel.add(lblCodigoTrabajador);
			{
				lblNewLabel = new JLabel(vendedor.getCodigoTrabajador());
				lblNewLabel.setBounds(10, 44, 186, 17);
				panel.add(lblNewLabel);
				lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			}
		}
		{
			panel_1 = new JPanel();
			panel_1.setLayout(null);
			panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
			panel_1.setBounds(405, 162, 206, 75);
			contentPane.add(panel_1);
			{
				lblNombresYApellidos = new JLabel("Nombres y Apellidos");
				lblNombresYApellidos.setFont(new Font("Tahoma", Font.PLAIN, 17));
				lblNombresYApellidos.setBounds(10, 11, 186, 21);
				panel_1.add(lblNombresYApellidos);
			}
			{
				label_1 = new JLabel(vendedor.getNombreCompleto());
				label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
				label_1.setBounds(10, 44, 186, 17);
				panel_1.add(label_1);
			}
		}
		{
			panel_2 = new JPanel();
			panel_2.setLayout(null);
			panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
			panel_2.setBounds(628, 72, 206, 75);
			contentPane.add(panel_2);
			{
				lblDni = new JLabel("DNI");
				lblDni.setFont(new Font("Tahoma", Font.PLAIN, 17));
				lblDni.setBounds(10, 11, 136, 21);
				panel_2.add(lblDni);
			}
			{
				label_3 = new JLabel(vendedor.getDniTrabajador());
				label_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
				label_3.setBounds(10, 44, 186, 17);
				panel_2.add(label_3);
			}
		}
		{
			panel_3 = new JPanel();
			panel_3.setLayout(null);
			panel_3.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
			panel_3.setBounds(405, 267, 206, 75);
			contentPane.add(panel_3);
			{
				lblCelular = new JLabel("Celular");
				lblCelular.setFont(new Font("Tahoma", Font.PLAIN, 17));
				lblCelular.setBounds(10, 11, 136, 21);
				panel_3.add(lblCelular);
			}
			{
				label_5 = new JLabel(vendedor.getCelularTrabajador());
				label_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
				label_5.setBounds(10, 44, 186, 17);
				panel_3.add(label_5);
			}
		}
		{
			panel_4 = new JPanel();
			panel_4.setLayout(null);
			panel_4.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
			panel_4.setBounds(626, 164, 206, 75);
			contentPane.add(panel_4);
			{
				lblCorreo = new JLabel("Correo");
				lblCorreo.setFont(new Font("Tahoma", Font.PLAIN, 17));
				lblCorreo.setBounds(10, 11, 136, 21);
				panel_4.add(lblCorreo);
			}
			{
				label_7 = new JLabel(vendedor.getCorreoTrabajador());
				label_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
				label_7.setBounds(10, 44, 186, 17);
				panel_4.add(label_7);
			}
		}
		lblNewLabel = new JLabel();
		lblNewLabel.setBounds(53, 45, 277, 278);
		image = new ImageIcon(Inicio.class.getResource("/Imagenes/vendedor.png"));
		Icon icono = new ImageIcon(image.getImage().getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_DEFAULT));
		contentPane.add(lblNewLabel);
		lblNewLabel.setIcon(icono);
		{
			panel_5 = new JPanel();
			panel_5.setLayout(null);
			panel_5.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
			panel_5.setBounds(627, 265, 206, 75);
			contentPane.add(panel_5);
			{
				lblEdad = new JLabel("Edad");
				lblEdad.setFont(new Font("Tahoma", Font.PLAIN, 17));
				lblEdad.setBounds(10, 11, 136, 21);
				panel_5.add(lblEdad);
			}
			{
				label_9 = new JLabel(""+vendedor.getEdadTrabajador());
				label_9.setFont(new Font("Tahoma", Font.PLAIN, 14));
				label_9.setBounds(10, 44, 186, 17);
				panel_5.add(label_9);
			}
		}
		modificarVentana();
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == mntmMarca) {
			do_mntmMarca_actionPerformed(arg0);
		}
		if (arg0.getSource() == mntmCategoria) {
			do_mntmCategoria_actionPerformed(arg0);
		}
		if (arg0.getSource() == mntmProveedor) {
			do_mntmProveedor_actionPerformed(arg0);
		}
		if (arg0.getSource() == mntmProducto) {
			do_mntmProducto_actionPerformed(arg0);
		}
		if (arg0.getSource() == mntmJefeDeAlmacen) {
			do_mntmJefeDeAlmacen_actionPerformed(arg0);
		}
		if (arg0.getSource() == mntmGerente) {
			do_mntmGerente_actionPerformed(arg0);
		}
		if (arg0.getSource() == mntmVendedores) {
			do_mntmVendedores_actionPerformed(arg0);
		}
		if (arg0.getSource() == mntmProgramadores) {
			do_mntmProgramadores_actionPerformed(arg0);
		}
		if (arg0.getSource() == mntmReporte) {
			do_mntmReporte_actionPerformed(arg0);
		}
		if (arg0.getSource() == mntmClientes) {
			do_mntmClientes_actionPerformed(arg0);
		}
		if (arg0.getSource() == mntmCerrarSesion) {
			do_mntmCerrarSesion_actionPerformed(arg0);
		}
		if (arg0.getSource() == mntmCerrar) {
			do_mntmCerrar_actionPerformed(arg0);
		}
		if (arg0.getSource() == mntmVerproductos) {
			do_mntmVerproductos_actionPerformed(arg0);
		}
		if (arg0.getSource() == mntmRealizarVenta) {
			do_mntmRealizarVenta_actionPerformed(arg0);
		}
	}	
	TrabajadorBD tbd = new TrabajadorBD();
	private JMenuBar menuBar;
	private JMenu mnVenta;
	private JMenuItem mntmRealizarVenta;
	private JMenu mnProductos;
	private JMenuItem mntmVerproductos;
	private JMenu mnSalir;
	private JMenuItem mntmCerrarSesion;
	private JMenuItem mntmCerrar;
	private JMenuItem menuItem;
	private JMenu mnContactenos;
	private JMenuItem mntmProgramadores;
	private JMenuItem mntmClientes;
	protected void do_mntmRealizarVenta_actionPerformed(ActionEvent arg0) {
		Clientes vv = new Clientes(null, v.getTipoTrabajador());
		vv.setVisible(true);
	}
	protected void do_mntmVerproductos_actionPerformed(ActionEvent arg0) {
		VerStock vs = new VerStock();
		vs.setVisible(true);
	}
	protected void do_mntmCerrar_actionPerformed(ActionEvent arg0) {
		System.exit(0);
	}
	protected void do_mntmCerrarSesion_actionPerformed(ActionEvent arg0) {
		Login l = new Login();
		l.setVisible(true);
		this.dispose();
	}
	protected void do_mntmProducto_actionPerformed(ActionEvent arg0) {
		Almacen_Mant_Producto ap = new Almacen_Mant_Producto();
		ap.setVisible(true);
	}
	
	protected void do_mntmProveedor_actionPerformed(ActionEvent arg0) {
		Almacen_Mant_Proveedor ap = new Almacen_Mant_Proveedor();
		ap.setVisible(true);
	}
	protected void do_mntmCategoria_actionPerformed(ActionEvent arg0) {
		Almacen_Mant_Categoria ap = new Almacen_Mant_Categoria();
		ap.setVisible(true);
	}
	protected void do_mntmMarca_actionPerformed(ActionEvent arg0) {
		Almacen_Mant_Marca ap = new Almacen_Mant_Marca();
		ap.setVisible(true);
	}
	protected void do_mntmVendedores_actionPerformed(ActionEvent arg0) {
		Gerente_Vendedor v=new Gerente_Vendedor();
		v.setVisible(true);
	}

	protected void do_mntmGerente_actionPerformed(ActionEvent arg0) {
		Gerente_Gerente gg = new Gerente_Gerente();
		gg.setVisible(true);
	}
	protected void do_mntmJefeDeAlmacen_actionPerformed(ActionEvent arg0) {
		Gerente_Almacen ga = new Gerente_Almacen();
		ga.setVisible(true);
	}
	void modificarVentana(){
		switch(v.getTipoTrabajador()){
			case 1:
				ventanaVendedor();
				break;
			case 2:
				ventantaGerente();
				break;
			case 3:
				ventantaAlmacen();
				break;
		}
	}
	void ventanaVendedor(){
		mntmReporte.setEnabled(false);
		mnMatenimiento.setEnabled(false);
		mnNewMenu_2.setEnabled(false);
	}
	void ventantaGerente(){
		image = new ImageIcon(Inicio.class.getResource("/Imagenes/gerente.png"));
		Icon icono = new ImageIcon(image.getImage().getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_DEFAULT));
		mntmRealizarVenta.setEnabled(false);
		mnMatenimiento.setEnabled(false);
		lblNewLabel.setIcon(icono);
	}
	void ventantaAlmacen(){
		image = new ImageIcon(Inicio.class.getResource("/Imagenes/almacen.png"));
		Icon icono = new ImageIcon(image.getImage().getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_DEFAULT));
		mnVenta.setEnabled(false);
		mnProductos.setEnabled(false);
		mnNewMenu_2.setEnabled(false);
		lblNewLabel.setIcon(icono);
		mntmClientes.setEnabled(false);
	}
	protected void do_mntmClientes_actionPerformed(ActionEvent arg0) {
		Clientes c = new Clientes(null, v.getTipoTrabajador());
		c.setVisible(true);
	}
	protected void do_mntmReporte_actionPerformed(ActionEvent arg0) {
		Gerente_Reporte gr = new Gerente_Reporte();
		gr.setVisible(true);
	}
	protected void do_mntmProgramadores_actionPerformed(ActionEvent arg0) {
		Contactenos c = new Contactenos();
		c.setVisible(true);
	}
}
