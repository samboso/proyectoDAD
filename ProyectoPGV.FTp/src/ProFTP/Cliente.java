package ProFTP;

import static com.oracle.jrockit.jfr.ContentType.Timestamp;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.sql.Timestamp;
import java.util.Date;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

public class Cliente {
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		VistaFTP ftp = new VistaFTP();
		
		
		FTPClient cliente_ftp = new FTPClient();
		
        	String servidor_FTP = "192.168.2.201";
				//"192.168.2.235";
		String usuario_FTP = "fabio";
		String password_FTP = "adminfabio";
		//SimpleDateFormat dateFormat = null;
                String string;
		try {
			cliente_ftp.connect(servidor_FTP,21);
			boolean login = cliente_ftp.login(usuario_FTP, password_FTP);
			
			//PARA DESCONECTAR AL CLIENTE
//			cliente_ftp.logout();
//			cliente_ftp.disconnect();
			
			
			System.out.println("Directorio actual: "+cliente_ftp.printWorkingDirectory());
			
			FTPFile ficheros[] = cliente_ftp.listFiles();

			for(int i=0; i<ficheros.length; i++){
                            if (ficheros[i].isDirectory()) {
                                System.out.println("Carpetas compartidas: "+ficheros[i].getName());
                                System.out.println("Propiedades de las carpetas: "+ficheros[i].getTimestamp().getTime().toString());
                            } else
				System.out.println("Ficheros compartidos: "+ficheros[i].getName());
			}
                        
			/*
			FileOutputStream stream = null;
			String archivo = "/Captura.PNG";
			stream = new FileOutputStream("pruebaFTP.PNG");
			cliente_ftp.retrieveFile(archivo, stream);
			stream.close();
			*/
                        //String myString = "Zas en toda la boca"; 
                        //StringSelection stringSelection = new StringSelection(myString); 
                        //Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard(); 
                        //clpbrd.setContents(stringSelection, null);
                        //SystemClipboard.copy(myString);
                        
		} catch (IOException e) {
			System.out.println(e.getMessage());
			System.out.println("HOLALALALA");
			e.printStackTrace();
		}
		
	}
}
