package ProFTP;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ButtonGroup;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import javax.swing.ScrollPaneConstants;

/**
 *
 * @author Fabio no
 */
public class VistaFTP extends JFrame {
	
	JPanel panel1,principal,panel2,panel3,panel4;
	JLabel lusuario, lcontrasena,lip;
	JTextField tusuario,tip;
	JPasswordField pcontrasena;
	JButton conectar,desconectar,subir,descargar;
	JTextArea ainfo;
	JComboBox archivos;
        JPopupMenu popmenu;
        JMenuItem menuItem;
        JRadioButton archivosrbtn,carpetasrbtn;
        JCheckBox tamannoArch;
	Funcionalidad funcionalidad = new Funcionalidad(this);
	ControladorVistaFTP1 cvf = new ControladorVistaFTP1(this, funcionalidad);
	
	public VistaFTP() {
		panelPrincipal();
		add(principal);
		pack();
		setVisible(true);
		setTitle("Cliente FTP");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);		
	}
	
	
	public void panelPrincipal() {
		
		panelPanel1();
		panelPanel2();
		panelPanel3();
		principal = new JPanel();
		principal.setLayout(new BorderLayout());
		principal.add(panel1, BorderLayout.NORTH);
		principal.add(panel2, BorderLayout.CENTER);
		principal.add(panel3, BorderLayout.SOUTH);
		
	}
	
	public void panelPanel1() {
		
		panel1 = new JPanel();
		lusuario = new JLabel("Usuario: ");
		lcontrasena = new JLabel("Contraseña: ");
		lip = new JLabel("ip: ");
		tusuario = new JTextField(10);
		pcontrasena = new JPasswordField(10);
		tip = new JTextField(10);
		conectar = new JButton("Conectar");
		conectar.addActionListener(cvf);
		desconectar = new JButton("Desconectar");
		desconectar.addActionListener(cvf);
		desconectar.setEnabled(false);
		
                popmenu = new JPopupMenu();
                menuItem = new JMenuItem("Cut");
                popmenu.add(menuItem);
                menuItem = new JMenuItem("Copy");
                popmenu.add(menuItem);
                menuItem = new JMenuItem("Paste");
                popmenu.add(menuItem);

                
                
		panel1.add(lip);
		panel1.add(tip);
		panel1.add(lusuario);
		panel1.add(tusuario);
		panel1.add(lcontrasena);
		panel1.add(pcontrasena);
		panel1.add(conectar);
		panel1.add(desconectar);
                panel1.add(popmenu);
		}
	
	public void panelPanel2() {
		
		panel2 = new JPanel();
		ainfo = new JTextArea(15,60);
		ainfo.setLineWrap(true);
		ainfo.setEditable(false);
		JScrollPane scroll = new JScrollPane ();
		scroll.setViewportView(ainfo);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panel2.add(scroll);
	}
	
	public void panelPanel3() {
		panelPanel4();
		panel3 = new JPanel();
		panel3.setLayout(new BorderLayout());
		subir = new JButton("Subir");
		subir.setEnabled(false);
		subir.addActionListener(cvf);
		
		
		panel3.add(subir, BorderLayout.NORTH);
		panel3.add(panel4, BorderLayout.SOUTH);
		
	}
	
	public void panelPanel4() {
		
		panel4 = new JPanel();
		descargar = new JButton("Descargar");
		descargar.setEnabled(false);
		descargar.addActionListener(cvf);
		archivos = new JComboBox();
		archivos.addItem("");
                ButtonGroup rbtng = new ButtonGroup();
                archivosrbtn = new JRadioButton("Archivos");
                carpetasrbtn = new JRadioButton("Carpetas");
                rbtng.add(archivosrbtn);
                rbtng.add(carpetasrbtn);
                tamannoArch = new JCheckBox("Menor a 5MB");
                
		panel4.add(descargar);
		panel4.add(archivos);
                panel4.add(archivosrbtn);
                panel4.add(carpetasrbtn);
                panel4.add(tamannoArch);
	}
/*	
private void showPopupMenuDemo(){
      final JPopupMenu editMenu = new JPopupMenu("Edit"); 

      JMenuItem cutMenuItem = new JMenuItem("Cut");
      cutMenuItem.setActionCommand("Cut");

      JMenuItem copyMenuItem = new JMenuItem("Copy");
      copyMenuItem.setActionCommand("Copy");

      JMenuItem pasteMenuItem = new JMenuItem("Paste");
      pasteMenuItem.setActionCommand("Paste");

      MenuItemListener menuItemListener = new MenuItemListener();

      cutMenuItem.addActionListener(menuItemListener);
      copyMenuItem.addActionListener(menuItemListener);
      pasteMenuItem.addActionListener(menuItemListener);

      editMenu.add(cutMenuItem);
      editMenu.add(copyMenuItem);
      editMenu.add(pasteMenuItem);   

      panel1.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
            editMenu.show(panel1, e.getX(), e.getY());
         }               
      });
      panel1.add(editMenu); 
      panel1.setVisible(true);
   }*/
    
    
        
   class MenuItemListener implements ActionListener {
      public void actionPerformed(ActionEvent e) {            
          JOptionPane.showMessageDialog (null, "El texto del portapapeles ha cambiado", "Portapapeles", JOptionPane.INFORMATION_MESSAGE);
      }    
   }

	
}
