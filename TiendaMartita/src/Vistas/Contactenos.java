package Vistas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

public class Contactenos extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Contactenos dialog = new Contactenos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Contactenos() {
		setTitle("Contactenos");
		setBounds(100, 100, 1099, 779);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Desarrolladores");
		lblTitulo.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 35));
		lblTitulo.setBounds(92, 18, 284, 33);
		contentPanel.add(lblTitulo);
		
		JLabel lblLocalTitulo = new JLabel("Tienda de ropa");
		lblLocalTitulo.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 35));
		lblLocalTitulo.setBounds(667, 18, 239, 33);
		contentPanel.add(lblLocalTitulo);
		
		JLabel lblLocalImagen = new JLabel("");
		//lblLocalImagen.setIcon(new ImageIcon(contactenos.class.getResource("/Imagenes/martitaTienda.jpg")));
		
		lblLocalImagen.setBounds(533, 329, 516, 387);
		ajustarImagen(lblLocalImagen,"/Imagenes/Contactenos/martitaTienda.jpg");
		contentPanel.add(lblLocalImagen);
		
		JLabel lblD_1 = new JLabel("d1");
		
		//lblD_1.setIcon(new ImageIcon(contactenos.class.getResource("/Imagenes/kevinAnthony.jpg")));
		lblD_1.setBounds(32, 79, 152, 152);
		ajustarImagen(lblD_1,"/Imagenes/Contactenos/tadeo_contactenos.jpg");
		contentPanel.add(lblD_1);
		
		JLabel lblKevinAnthony = new JLabel("Carlos Tadeo Cruzado Diaz");
		lblKevinAnthony.setHorizontalAlignment(SwingConstants.CENTER);
		lblKevinAnthony.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
		lblKevinAnthony.setBounds(10, 228, 213, 33);
		contentPanel.add(lblKevinAnthony);
		
		JLabel lblNupnpe = new JLabel("n00317146@upn.pe");
		lblNupnpe.setForeground(Color.BLUE);
		lblNupnpe.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 16));
		lblNupnpe.setBounds(32, 249, 154, 33);
		contentPanel.add(lblNupnpe);
		
		JLabel lblD_3 = new JLabel("d3");
		lblD_3.setBounds(37, 304, 152, 152);
		ajustarImagen(lblD_3,"/Imagenes/Contactenos/mauro_contactenos.jpg");
		contentPanel.add(lblD_3);
		
		JLabel lblMauroContrerasSan = new JLabel("Mauro Contreras San Miguel");
		lblMauroContrerasSan.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
		lblMauroContrerasSan.setBounds(20, 452, 194, 33);
		contentPanel.add(lblMauroContrerasSan);
		
		JLabel lblNupnpe_1 = new JLabel("n00317146@upn.pe");
		lblNupnpe_1.setForeground(Color.BLUE);
		lblNupnpe_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 16));
		lblNupnpe_1.setBounds(37, 476, 154, 33);
		contentPanel.add(lblNupnpe_1);
		
		JLabel lblD_2 = new JLabel("d2");
		//lblD_2.setIcon(new ImageIcon(contactenos.class.getResource("/Imagenes/Angel.jpg")));
		lblD_2.setBounds(261, 79, 152, 152);
		ajustarImagen(lblD_2,"/Imagenes/Contactenos/angel_contactenos.jpg");
		contentPanel.add(lblD_2);
		
		JLabel lblAngel = new JLabel("Angel Valentino Castillo Davila");
		lblAngel.setHorizontalAlignment(SwingConstants.CENTER);
		lblAngel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
		lblAngel.setBounds(239, 228, 213, 33);
		contentPanel.add(lblAngel);
		
		JLabel lblNupnpe_3 = new JLabel("n00111111@upn.pe");
		lblNupnpe_3.setForeground(Color.BLUE);
		lblNupnpe_3.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 16));
		lblNupnpe_3.setBounds(261, 249, 154, 33);
		contentPanel.add(lblNupnpe_3);
		
		JLabel lblD_4 = new JLabel("d4");
		//lblD_4.setIcon(new ImageIcon(contactenos.class.getResource("/Imagenes/Kevin.jpg")));
		lblD_4.setBounds(266, 304, 152, 152);
		ajustarImagen(lblD_4,"/Imagenes/Contactenos/kevin_contactenos.jpg");
		contentPanel.add(lblD_4);
		
		JLabel lblKevinAnthonyChocca = new JLabel("Kevin Anthony Chocca Casapino");
		lblKevinAnthonyChocca.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
		lblKevinAnthonyChocca.setBounds(244, 452, 213, 33);
		contentPanel.add(lblKevinAnthonyChocca);
		
		JLabel lblNupnpe_2 = new JLabel("n00228710@upn.pe");
		lblNupnpe_2.setForeground(Color.BLUE);
		lblNupnpe_2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 16));
		lblNupnpe_2.setBounds(266, 476, 154, 33);
		contentPanel.add(lblNupnpe_2);
		
		JLabel lblMartita = new JLabel("martita");
		//lblMartita.setIcon(new ImageIcon(contactenos.class.getResource("/Imagenes/martita1.jpg")));
		lblMartita.setBounds(533, 79, 205, 251);
		ajustarImagen(lblMartita,"/Imagenes/Contactenos/martita1.jpg");
		contentPanel.add(lblMartita);
		
		JLabel lblD_5 = new JLabel("d5");
		//label.setIcon(new ImageIcon(contactenos.class.getResource("/Imagenes/Alex.jpg")));
		//label.setIcon(new ImageIcon(contactenos.class.getResource("/Imagenes/Mauro.jpg")));
		lblD_5.setBounds(148, 524, 152, 152);
		ajustarImagen(lblD_5,"/Imagenes/Contactenos/alex_contactenos.jpg");
		contentPanel.add(lblD_5);
		
		JLabel lblAlex = new JLabel("Victor Alexander Cuya Huanca");
		lblAlex.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
		lblAlex.setBounds(131, 672, 194, 33);
		contentPanel.add(lblAlex);
		
		JLabel lblNupnpe_4 = new JLabel("n00323266@upn.pe");
		lblNupnpe_4.setForeground(Color.BLUE);
		lblNupnpe_4.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 16));
		lblNupnpe_4.setBounds(148, 696, 154, 33);
		contentPanel.add(lblNupnpe_4);
		
		JLabel lblTiendaMartita = new JLabel("Tienda de ropa Martita\"", SwingConstants.CENTER);
		lblTiendaMartita.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblTiendaMartita.setBounds(746, 127, 303, 54);
		contentPanel.add(lblTiendaMartita);
		
		JLabel lblFundadoraYGerente = new JLabel("Fundadora y CEO de Martita", SwingConstants.RIGHT);
		lblFundadoraYGerente.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFundadoraYGerente.setBounds(746, 206, 303, 54);
		contentPanel.add(lblFundadoraYGerente);
		
		JLabel lblIg = new JLabel("ig: jhoanyvegas", SwingConstants.RIGHT);
		lblIg.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblIg.setBounds(748, 228, 303, 54);
		contentPanel.add(lblIg);
		
		JLabel lblA = new JLabel("\"Bienvenidos a la", SwingConstants.CENTER);
		lblA.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblA.setBounds(746, 79, 303, 54);
		contentPanel.add(lblA);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Contactenos.class.getResource("/Imagenes/Contactenos/edificio3.jpg")));
		lblNewLabel.setBounds(10, 11, 1063, 718);
		contentPanel.add(lblNewLabel);
	}
	
	//SCALE_AREA_AVERAGING
		private void ajustarImagen(JLabel label, String ruta) {
		    ImageIcon image = new ImageIcon(Contactenos.class.getResource(ruta));
		    Icon icon = new ImageIcon(image.getImage().getScaledInstance(
		            label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
		    label.setIcon(icon);
		    this.repaint();
		}
}
