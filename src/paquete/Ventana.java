/**
 * RaulClase2022_2023 - ventanaCentrada - Ventana.java
 * 3 oct 2022 - 9:36:35
 * @author Raúl Herrerías Corral
 */
package paquete;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.UIManager;

public class Ventana extends JFrame{

	private JMenuBar menuBar;
	private JMenu archivo, edicion, opciones, girar, acercaDe;
	private JMenuItem nuevo, abrir, guardar, salir, copiar, pegar, vertical,
					  horizontal, aplicacion, emergente1, emergente2;
	private JCheckBox cb1, cb2;
	private JRadioButton rb1, rb2;	
	private ButtonGroup bg;
	private JLabel labelMenu, labelArchivo, labelEdicion, labelOpciones, 
				   labelArchivo2, labelEdicion2, labelOpcionesCB, labelOpcionesRB;
	private JPopupMenu menuEmergente;
	private JPanel panel;
	
	public Ventana() {
	
		iniciarVentana();
		iniciarComponentes();
		setListeners();
		
		this.setVisible(true);
	}
	
	private void setListeners() {
		
		nuevo.addActionListener(e -> archivoNuevo());
		abrir.addActionListener(e -> archivoAbrir());
		guardar.addActionListener(e -> archivoGuardar());
		salir.addActionListener(e -> archivoSalir());
		
		copiar.addActionListener(e -> edicionCopiar());
		pegar.addActionListener(e -> edicionPegar());
		vertical.addActionListener(e -> edicionVertical());
		horizontal.addActionListener(e -> edicionHorizontal());
		
		cb1.addItemListener(e -> edicionOpcionesCB());
		cb2.addItemListener(e -> edicionOpcionesCB());
		
		rb1.addItemListener(e -> edicionOpcionesRB(e));
		rb2.addItemListener(e -> edicionOpcionesRB(e));
		
		aplicacion.addActionListener(e -> acercaDe());
		
		emergente1.addActionListener(e -> emergente1());
		emergente2.addActionListener(e -> emergente2());
		
	}
	
	private void iniciarVentana() {
		
		this.setTitle("Menus y Menus Emergentes");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Toolkit miPantalla = Toolkit.getDefaultToolkit();
		Dimension tamañoPantalla = miPantalla.getScreenSize();
		int altoPantalla = tamañoPantalla.height;
		int anchoPantalla = tamañoPantalla.width;
		
		this.setSize(anchoPantalla/3, altoPantalla/2);
		this.setLocation(anchoPantalla/3, altoPantalla/4);
		
		this.setResizable(false);
	}

	private void iniciarComponentes() {
		
		labelMenu = new JLabel("MENU");
		labelMenu.setBounds(6,10,60,20);
		
		labelArchivo = new JLabel("Archivo: ");
		labelArchivo.setBounds(6,50,60,20);
		
		labelEdicion = new JLabel("Edicion: ");
		labelEdicion.setBounds(6,80,60,20);
		
		labelOpciones = new JLabel("Opciones: ");
		labelOpciones.setBounds(6,110,60,20);
		
		labelArchivo2 = new JLabel();
		labelArchivo2.setBounds(80,50,100,20);
		
		labelEdicion2 = new JLabel();
		labelEdicion2.setBounds(80,80,100,20);
		
		labelOpcionesCB = new JLabel();
		labelOpcionesCB.setBounds(80,110,100,20);
		
		labelOpcionesRB = new JLabel();
		labelOpcionesRB.setBounds(80,130,300,20);
		
		menuBar = new JMenuBar();
		menuEmergente = new JPopupMenu();
		
		archivo = new JMenu("Archivo");
		edicion = new JMenu("Edición");
		opciones = new JMenu("Opciones");
		girar = new JMenu("Girar");
		acercaDe = new JMenu("Acerca de...");
		
		nuevo = new JMenuItem("Nuevo");
		abrir = new JMenuItem("Abrir");
		guardar = new JMenuItem("Guardar");
		salir = new JMenuItem("Salir");
		copiar = new JMenuItem("Copiar");
		pegar = new JMenuItem("Pegar");
		vertical = new JMenuItem("Vertical");
		horizontal = new JMenuItem("Horizontal");
		aplicacion = new JMenuItem("Aplicación");
		
		emergente1 = new JMenuItem("Opcion Emergente 1");
		emergente2 = new JMenuItem("Opcion Emergente 2");
		
		cb1 = new JCheckBox("Check 1");
		cb2 = new JCheckBox("Check 2");
		
		rb1 = new JRadioButton("Radio 1");
		rb2 = new JRadioButton("Radio 2");
		
		bg = new ButtonGroup();
		bg.add(rb1);
		bg.add(rb2);
		
		menuBar.add(archivo);
		menuBar.add(edicion);
		menuBar.add(opciones);
		menuBar.add(acercaDe);
		
		archivo.add(nuevo);
		archivo.addSeparator();
		archivo.add(abrir);
		archivo.addSeparator();
		archivo.add(guardar);
		archivo.addSeparator();
		archivo.add(salir);
		
		edicion.add(copiar);
		edicion.add(pegar);
		edicion.add(girar);
		
		girar.add(vertical);
		girar.add(horizontal);
		
		opciones.add(cb1);
		opciones.add(cb2);
		opciones.addSeparator();
		opciones.add(rb1);
		opciones.add(rb2);
		
		acercaDe.add(aplicacion);
		
		menuEmergente.add(emergente1);
		menuEmergente.add(emergente2);
		
		panel = new JPanel();
		panel.setComponentPopupMenu(menuEmergente);
		
		this.setJMenuBar(menuBar);
		
		this.add(labelArchivo);
		this.add(labelEdicion);
		this.add(labelOpciones);
		
		this.add(labelArchivo2);
		this.add(labelEdicion2);
		this.add(labelOpcionesCB);
		this.add(labelOpcionesRB);
		
		this.add(labelMenu);
		this.add(panel); //El panel debe ser lo último que se añade.
	}
	
	private void archivoNuevo() {
		labelArchivo2.setText("Nuevo");
	}
	
	private void archivoAbrir() {
		labelArchivo2.setText("Abrir");
	}

	private void archivoGuardar() {
		labelArchivo2.setText("Guardar");
	}

	private void archivoSalir() {
		labelArchivo2.setText("Salir");
	}

	private void edicionCopiar() {
		labelEdicion2.setText("Copiar");
	}

	private void edicionPegar() {
		labelEdicion2.setText("Pegar");
	}
	
	private void edicionVertical() {
		labelEdicion2.setText("Girar/Vertical");
	}
	
	private void edicionHorizontal() {
		labelEdicion2.setText("Girar/Horizontal");
	}
	
	private void edicionOpcionesCB() {
		
		if (!cb1.isSelected() && !cb2.isSelected()) {
			labelOpcionesCB.setText("");
		}
		
		if (cb1.isSelected()) {
			labelOpcionesCB.setText("CB1");
		}
		
		if (cb2.isSelected()) {
			labelOpcionesCB.setText("CB2");
		}
		
		if (cb1.isSelected() && cb2.isSelected()) {
			labelOpcionesCB.setText("CB1 & CB2");
		}
	}

	private void edicionOpcionesRB(ItemEvent e) {
		
		if (e.getSource() == rb1) {
			labelOpcionesRB.setText("Radio 1 es True, Radio 2 es False");
		}
		
		if (e.getSource() == rb2) {
			labelOpcionesRB.setText("Radio 1 es False, Radio 2 es True");
		}
	}
	
	private void acercaDe() {
		
		UIManager.put("OptionPane.okButtonText", "Aceptar");
		
		JOptionPane.showMessageDialog(this, "<html><body><p style = 'width: 230px'>"
				+ "Esta es una aplicación simple con el fin de exponer de forma sencilla el funcionamiento"
				+ " básico de los componentes de los menus" + "</p></body></html>",
				"INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);
	}
	
	private void emergente1() {
		UIManager.put("OptionPane.okButtonText", "Aceptar");
		JOptionPane.showMessageDialog(this, "Presionó la opción emergente 1", 
												"Mensaje", JOptionPane.INFORMATION_MESSAGE);
	}
	
	private void emergente2() {
		UIManager.put("OptionPane.okButtonText", "Aceptar");
		JOptionPane.showMessageDialog(this, "Presionó la opción emergente 2", 
												"Mensaje", JOptionPane.INFORMATION_MESSAGE);
	}
}