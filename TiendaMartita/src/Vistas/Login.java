package Vistas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Clases.JFAlmacen;
import Clases.Trabajador;
import Clases.Vendedor;
import Controladores.TrabajadorBD;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Canvas;

public class Login extends JDialog implements ActionListener, KeyListener, MouseListener {

	private final JPanel contentPanel = new JPanel();
	private JTextField txt_usua;
	private JPasswordField txt_password;
	private JButton btnCerrar;
	private JButton btnEntrar;
	public static Trabajador v;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Login dialog = new Login();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Login() {
		setTitle("Login");
		setBounds(100, 100, 810, 491);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblIdDelTrabajador = new JLabel("Usuario");
			lblIdDelTrabajador.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblIdDelTrabajador.setBounds(453, 256, 73, 16);
			contentPanel.add(lblIdDelTrabajador);
		}
		{
			txt_usua = new JTextField();
			txt_usua.setFont(new Font("Tahoma", Font.PLAIN, 13));
			txt_usua.addKeyListener(this);
			txt_usua.setBounds(536, 253, 229, 25);
			contentPanel.add(txt_usua);
			txt_usua.setColumns(10);
		}
		{
			JLabel lblContrasea = new JLabel("Contrase\u00F1a: ");
			lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblContrasea.setBounds(453, 303, 92, 16);
			contentPanel.add(lblContrasea);
		}
		{
			txt_password = new JPasswordField();
			txt_password.setFont(new Font("Tahoma", Font.PLAIN, 13));
			txt_password.setBounds(536, 300, 229, 25);
			contentPanel.add(txt_password);
		}
		{
			btnEntrar = new JButton("   Entrar");
			btnEntrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnEntrar.setHorizontalAlignment(SwingConstants.LEFT);
			btnEntrar.setIcon(new ImageIcon(Login.class.getResource("/Imagenes/enter.png")));
			btnEntrar.addActionListener(this);
			btnEntrar.setBounds(453, 375, 120, 41);
			contentPanel.add(btnEntrar);
		}
		{
			btnCerrar = new JButton("   Cerrar");
			btnCerrar.setIcon(new ImageIcon(Login.class.getResource("/Imagenes/cerrar-simbolo-de-boton-circular.png")));
			btnCerrar.setHorizontalAlignment(SwingConstants.LEFT);
			btnCerrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnCerrar.addActionListener(this);
			btnCerrar.setBounds(603, 375, 120, 41);
			contentPanel.add(btnCerrar);
		}
		{
			lblDesarroladores = new JLabel("Desarrolladores");
			lblDesarroladores.setForeground(Color.BLUE);
			lblDesarroladores.setHorizontalAlignment(SwingConstants.CENTER);
			lblDesarroladores.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblDesarroladores.addMouseListener(this);
			lblDesarroladores.setBounds(686, 427, 98, 14);
			contentPanel.add(lblDesarroladores);
		}
		{
			lblUsuarioYContrasea = new JLabel("Usuario y contrase\u00F1a incorrectas");
			lblUsuarioYContrasea.setForeground(Color.RED);
			lblUsuarioYContrasea.setHorizontalAlignment(SwingConstants.CENTER);
			lblUsuarioYContrasea.setBounds(491, 336, 215, 14);
			lblUsuarioYContrasea.setVisible(false);
			contentPanel.add(lblUsuarioYContrasea);
		}
		{
			lblLeQuedan = new JLabel("Le quedan - intentos");
			lblLeQuedan.setForeground(Color.RED);
			lblLeQuedan.setHorizontalAlignment(SwingConstants.CENTER);
			lblLeQuedan.setBounds(501, 350, 215, 14);
			lblLeQuedan.setVisible(false);
			contentPanel.add(lblLeQuedan);
		}
		{
			label = new JLabel("");
			label.setBounds(533, 27, 190, 190);
			ajustarImagen(label,"/Imagenes/profile.png");
			contentPanel.add(label);
		}
		{
			panel = new JPanel();
			panel.setBackground(new Color(153, 204, 204));
			panel.setBounds(0, 0, 419, 452);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lblLoginDeTienda = new JLabel("Tienda de Ropa ");
				lblLoginDeTienda.setBounds(34, 171, 344, 58);
				panel.add(lblLoginDeTienda);
				lblLoginDeTienda.setHorizontalAlignment(SwingConstants.CENTER);
				lblLoginDeTienda.setBackground(new Color(153, 204, 255));
				lblLoginDeTienda.setFont(new Font("Javanese Text", Font.BOLD, 42));
			}
			{
				lblMartita = new JLabel("Martita");
				lblMartita.setBounds(57, 240, 298, 56);
				panel.add(lblMartita);
				lblMartita.setHorizontalAlignment(SwingConstants.CENTER);
				lblMartita.setFont(new Font("Javanese Text", Font.BOLD, 42));
				lblMartita.setBackground(new Color(153, 204, 255));
			}
		}
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnEntrar) {
			do_btnEntrar_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnCerrar) {
			do_btnCerrar_actionPerformed(arg0);
		}
	}
	protected void do_btnCerrar_actionPerformed(ActionEvent arg0) {
		System.exit(0);
	}
	//para el error se crea un int global 
	int error;
	private JLabel lblDesarroladores;
	private JLabel lblUsuarioYContrasea;
	private JLabel lblLeQuedan;
	private JLabel label;
	private JLabel lblMartita;
	private JPanel panel;
	protected void do_btnEntrar_actionPerformed(ActionEvent arg0) {
		String user = txt_usua.getText();
		String pass=txt_password.getText();
		
		TrabajadorBD tbd = new TrabajadorBD();
		int tipoCuenta = tbd.verificarCuenta(user, pass);
		
		switch (tipoCuenta) {
		case 1:
			v = tbd.verSoloVendedor(tbd.verificarCuentaCodigo(user, pass));
			Inicio  p = new Inicio(v);
			lblUsuarioYContrasea.setVisible(false);
			lblLeQuedan.setVisible(false);
			p.setVisible(true);
			setVisible(false);
			break;
		case 2:
			v = tbd.verSoloGerente(tbd.verificarCuentaCodigo(user, pass));
			Inicio  g = new Inicio(v);	
			lblUsuarioYContrasea.setVisible(false);
			lblLeQuedan.setVisible(false);	
			g.setVisible(true);
			setVisible(false);
			break;
		case 3:
			v =tbd.verSoloJFAlmacen(tbd.verificarCuentaCodigo(user, pass));
			Inicio  a = new Inicio(v);
			lblUsuarioYContrasea.setVisible(false);
			lblLeQuedan.setVisible(false);
			a.setVisible(true);
			setVisible(false);
			
			break;
		default:
			error++;
			lblUsuarioYContrasea.setVisible(true);
			if(error==3){
				lblLeQuedan.setText("Se excedio los 3 intentos");
				lblLeQuedan.setVisible(true);
				System.exit(0);
			}
			else{
				lblLeQuedan.setText("Le queda "+(3-error)+" intentos");
				lblLeQuedan.setVisible(true);
			}
			break;
		}
		
	}
	public void keyPressed(KeyEvent arg0) {
		if (arg0.getSource() == txt_usua) {
			do_txt_usua_keyPressed(arg0);
		}
	}
	public void keyReleased(KeyEvent arg0) {
	}
	public void keyTyped(KeyEvent arg0) {
		
	}
	protected void do_txt_usua_keyPressed(KeyEvent arg0) {
	}
	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == lblDesarroladores) {
			do_lblDesarroladores_mouseClicked(arg0);
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
	protected void do_lblDesarroladores_mouseClicked(MouseEvent arg0) {
		Contactenos c = new Contactenos();
		c.setVisible(true);
	}
	private void ajustarImagen(JLabel label, String ruta) {
	    ImageIcon image = new ImageIcon(Contactenos.class.getResource(ruta));
	    Icon icon = new ImageIcon(image.getImage().getScaledInstance(
	            label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
	    label.setIcon(icon);
	    this.repaint();
	}
}
