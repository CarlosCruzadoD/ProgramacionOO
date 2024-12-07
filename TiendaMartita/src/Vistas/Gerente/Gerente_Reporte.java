package Vistas.Gerente;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Controladores.ProductosBD;
import Controladores.VentaBD;
import Clases.ProductoVender;
import Clases.Venta;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import Clases.ExportarExcel;

public class Gerente_Reporte extends JDialog implements ActionListener, KeyListener, MouseListener {

    private final JPanel contentPanel = new JPanel();
    private JTextField txtCodVendedor;
    private DefaultTableModel tableModel;
    private JTable table;
    private JTextField txtNroVenta;
    private JTextField txtCodCliente;
    private JButton btnBorrarVenta;
    private JLabel lblNroDeVenta;
    private JLabel lblCodigoDeCliente;
    private JLabel lblCodigoDeVendedor_1;

    public static void main(String[] args) {
        try {
            Gerente_Reporte dialog = new Gerente_Reporte();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Gerente_Reporte() {
        setTitle("Reporte");
        setBounds(100, 100, 819, 576);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        txtCodVendedor = new JTextField();
        txtCodVendedor.addKeyListener(this);
        txtCodVendedor.setBounds(673, 93, 120, 25);
        contentPanel.add(txtCodVendedor);
        txtCodVendedor.setColumns(10);

        JLabel lblCodigoDeVendedor = new JLabel("REPORTE DE VENTAS");
        lblCodigoDeVendedor.setHorizontalAlignment(SwingConstants.CENTER);
        lblCodigoDeVendedor.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblCodigoDeVendedor.setBounds(187, 29, 424, 32);
        contentPanel.add(lblCodigoDeVendedor);

        tableModel = new DefaultTableModel(
            new Object[][] {},
            new String[] {
                "Nro Venta", "Código Cliente", "Código Vendedor", "Monto Final",
                "Descuento Total", "Método de Pago", "Comprobante de Pago", "Fecha de Venta"
            }
        );

        table = new JTable(tableModel);
        table.addMouseListener(this);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(29, 129, 761, 337);
        contentPanel.add(scrollPane);
        
        txtNroVenta = new JTextField();
        txtNroVenta.addKeyListener(this);
        txtNroVenta.setColumns(10);
        txtNroVenta.setBounds(138, 93, 120, 25);
        contentPanel.add(txtNroVenta);
        
        txtCodCliente = new JTextField();
        txtCodCliente.addKeyListener(this);
        txtCodCliente.setColumns(10);
        txtCodCliente.setBounds(392, 93, 120, 25);
        contentPanel.add(txtCodCliente);
        
        btnBorrarVenta = new JButton("   Borrar venta");
        btnBorrarVenta.setHorizontalAlignment(SwingConstants.LEFT);
        btnBorrarVenta.setIcon(new ImageIcon(Gerente_Reporte.class.getResource("/Imagenes/trash-alt-solid-24.png")));
        btnBorrarVenta.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnBorrarVenta.addActionListener(this);
        btnBorrarVenta.setBounds(635, 477, 158, 32);
        contentPanel.add(btnBorrarVenta);
        
        lblNroDeVenta = new JLabel("Nro de Venta");
        lblNroDeVenta.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNroDeVenta.setBounds(29, 91, 99, 25);
        contentPanel.add(lblNroDeVenta);
        
        lblCodigoDeCliente = new JLabel("C\u00F3digo de cliente");
        lblCodigoDeCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblCodigoDeCliente.setBounds(279, 91, 120, 25);
        contentPanel.add(lblCodigoDeCliente);
        
        lblCodigoDeVendedor_1 = new JLabel("C\u00F3digo de vendedor");
        lblCodigoDeVendedor_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblCodigoDeVendedor_1.setBounds(536, 91, 140, 25);
        contentPanel.add(lblCodigoDeVendedor_1);
        {
        	btnImportarAExcel = new JButton("Exportar a Excel");
        	btnImportarAExcel.setIcon(new ImageIcon(Gerente_Reporte.class.getResource("/Imagenes/negocio.png")));
        	btnImportarAExcel.addActionListener(this);
        	btnImportarAExcel.setFont(new Font("Tahoma", Font.BOLD, 13));
        	btnImportarAExcel.setBounds(414, 477, 197, 32);
        	contentPanel.add(btnImportarAExcel);
        }
        
        button = new JButton("   Limpiar");
        button.addActionListener(this);
        button.setIcon(new ImageIcon(Gerente_Reporte.class.getResource("/Imagenes/mop.png")));
        button.setHorizontalAlignment(SwingConstants.LEFT);
        button.setFont(new Font("Tahoma", Font.PLAIN, 14));
        button.setBounds(657, 29, 133, 36);
        contentPanel.add(button);
        
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        
        mnSalir = new JMenu("Salir");
        menuBar.add(mnSalir);
        
        mntmSalir = new JMenuItem("Salir");
        mntmSalir.addActionListener(this);
        mntmSalir.setIcon(new ImageIcon(Gerente_Reporte.class.getResource("/Imagenes/cerrar-simbolo-de-boton-circular.png")));
        mnSalir.add(mntmSalir);
        Listar(txtNroVenta.getText(), txtCodCliente.getText(), txtCodVendedor.getText());
    }

    public void actionPerformed(ActionEvent arg0) {
    	if (arg0.getSource() == button) {
    		do_button_actionPerformed(arg0);
    	}
    	if (arg0.getSource() == btnImportarAExcel) {
    		do_btnImportarAExcel_actionPerformed(arg0);
    	}
    	if (arg0.getSource() == mntmSalir) {
    		do_mntmSalir_actionPerformed(arg0);
    	}
    	if (arg0.getSource() == btnBorrarVenta) {
    		do_btnBorrarVenta_actionPerformed(arg0);
    	}
    }
    
    
    void Listar(String NroVenta, String CodCliente, String CodVendedor){
    	 VentaBD vbd = new VentaBD();    	 
    	 ArrayList<Venta> vs = new ArrayList<>();		
		tableModel.setRowCount(0);
		if(NroVenta.length()==0 && CodCliente.length()==0&&CodVendedor.length()==0){
			vs = vbd.VerTodasVentas();			
		}else{
			vs = vbd.VerFiltroVenta(NroVenta, CodCliente, CodVendedor);
		}	
		if (vs != null) {
		for (Venta venta : vs) {
            tableModel.addRow(new Object[]{
                venta.getNroVenta(),
                venta.getCodigoClienteVenta(),
                venta.getCodigoVendedorVenta(),
                venta.getMontoFinalVenta(),
                venta.getDescuentoTotalVenta(),
                venta.getMetodoPagoVenta(),
                venta.getComprobantePagoVenta(),
                venta.getFechaVenta().toString()
            	});
        	}
		}    	
    }    
	public void keyPressed(KeyEvent arg0) {
	}
	public void keyReleased(KeyEvent arg0) {
	}
	public void keyTyped(KeyEvent arg0) {
		if (arg0.getSource() == txtCodVendedor) {
			do_txtCodVendedor_keyTyped(arg0);
		}
		if (arg0.getSource() == txtCodCliente) {
			do_txtCodCliente_keyTyped(arg0);
		}
		if (arg0.getSource() == txtNroVenta) {
			do_txtNroVenta_keyTyped(arg0);
		}
	}
	protected void do_txtNroVenta_keyTyped(KeyEvent arg0) {
    	Listar(txtNroVenta.getText(), txtCodCliente.getText(), txtCodVendedor.getText());

	}
	protected void do_txtCodCliente_keyTyped(KeyEvent arg0) {
    	Listar(txtNroVenta.getText(), txtCodCliente.getText(), txtCodVendedor.getText());

	}
	protected void do_txtCodVendedor_keyTyped(KeyEvent arg0) {
    	Listar(txtNroVenta.getText(), txtCodCliente.getText(), txtCodVendedor.getText());

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
		int fila=table.getSelectedRow();
		txtNroVenta.setText(String.valueOf(table.getValueAt(fila, 0)));
		txtCodCliente.setText(String.valueOf(table.getValueAt(fila, 1)));
		txtCodVendedor.setText(String.valueOf(table.getValueAt(fila, 2)));
	}
	ProductosBD pbd = new ProductosBD();
	private JMenuBar menuBar;
	private JMenu mnSalir;
	private JMenuItem mntmSalir;
	private JButton btnImportarAExcel;
	private JButton button;
	protected void do_btnBorrarVenta_actionPerformed(ActionEvent arg0) {		
		int validar = JOptionPane.showConfirmDialog(btnBorrarVenta , "¿DESEA BORRAR LA VENTA?",
		        "confirmacion", JOptionPane.YES_NO_OPTION);		
		if(validar==JOptionPane.YES_OPTION)
	      {
			VentaBD v = new VentaBD();			
			ArrayList<ProductoVender> alpv = pbd.obtenerTodosProdutosVentas(txtNroVenta.getText());
			for (ProductoVender p : alpv) {
				pbd.aumentarStock(p.getCantidad(), p.getProducto().getCodigoProducto());
			}
			v.eliminarVenta(txtNroVenta.getText());
			Limpiar();	
			Listar(txtNroVenta.getText(), txtCodCliente.getText(), txtCodVendedor.getText());
			JOptionPane.showMessageDialog(this, "Venta eliminada Correctamente");
	      }

	}
	protected void do_mntmSalir_actionPerformed(ActionEvent arg0) {
		dispose();
	}
	protected void do_btnImportarAExcel_actionPerformed(ActionEvent arg0) {
		ExportarExcel ex = new ExportarExcel();
		try {
            
            ex.exportarExcel(table);
        } catch (Exception e) {
            System.out.println("Error: " + ex);
        }
	}
	void Limpiar(){
		txtCodCliente.setText("");
		txtCodVendedor.setText("");
		txtNroVenta.setText("");
	}
	protected void do_button_actionPerformed(ActionEvent arg0) {
		Limpiar();
	}
}