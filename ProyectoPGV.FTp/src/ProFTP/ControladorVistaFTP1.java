package ProFTP;

import java.awt.AWTException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

//import org.apache.commons.net.ftp.FTPClient;

public class ControladorVistaFTP1 implements ActionListener {

	VistaFTP vftp;
	Funcionalidad funcionalidad;

	public ControladorVistaFTP1(VistaFTP vftp, Funcionalidad funcionalidad) {

		this.vftp = vftp;
		this.funcionalidad = funcionalidad;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		switch (e.getActionCommand()) {
		case "Conectar":

			if (!funcionalidad.ObtenerDatos()[0].equals("") && !funcionalidad.ObtenerDatos()[1].equals("")
					&& !funcionalidad.ObtenerDatos()[2].equals("")) {
                            funcionalidad.Conectar(funcionalidad.ObtenerDatos()[0], funcionalidad.ObtenerDatos()[1],
						funcionalidad.ObtenerDatos()[2]);
				funcionalidad.ConectarBotones();
				funcionalidad.ListarContenido();
			}
			break;

		case "Desconectar":
			funcionalidad.Desconectar();
			funcionalidad.DesconectarBotones();
			break;
			
		case "Subir":
			funcionalidad.SubirArchivo();
			break;
			
		case "Descargar":
			funcionalidad.DescargarArchivo();
			break;

		default:
			break;
		}

		if (e.getActionCommand().equals("Conectar")) {

		}

                    vftp.menuItem.addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent e){
                        if(vftp.menuItem.equals("Cut")) {
                               SystemClipboard.copy(vftp.tip.getText());
                               vftp.tip.setText("");
                    }}});
                    vftp.tip.addMouseListener(new MouseAdapter(){
                        public void mouseReleased(MouseEvent Me){
                          if(Me.isPopupTrigger()){
                            vftp.popmenu.show(Me.getComponent(), Me.getX(), Me.getY());
                      }}});
                    vftp.tusuario.addMouseListener(new MouseAdapter(){
                        public void mouseReleased(MouseEvent Me){
                        if(Me.isPopupTrigger()){
                            vftp.popmenu.show(Me.getComponent(), Me.getX(), Me.getY());
                    }}});
	}
        public void actionPerformed1(ActionEvent e){
            switch(e.getActionCommand()){
                case "Cut":
                    SystemClipboard.copy(vftp.tip.getText());
                    vftp.tip.setText("");
                    break;
                case "Copy":
                    SystemClipboard.copy(vftp.tip.getText());
                    break;
                case "Paste":
            {
                try {
                    SystemClipboard.paste();
                } catch (AWTException ex) {
                    Logger.getLogger(ControladorVistaFTP1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                    break;
    }
}
}
