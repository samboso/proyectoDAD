package ProFTP;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.JFileChooser;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

public class Funcionalidad {

	VistaFTP vf;
	FTPClient cliente_ftp = new FTPClient();
	String contenido;
	public Funcionalidad(VistaFTP vf) {

		this.vf = vf;
	}

	public void Conectar(String usuario_FTP, String contrasena_FTP, String servidor_FTP) {
		try {
			cliente_ftp.connect(servidor_FTP);

			boolean login = cliente_ftp.login(usuario_FTP, contrasena_FTP);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void Desconectar() {

		try {
			cliente_ftp.disconnect();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public String[] ObtenerDatos() {

		String usuario = vf.tusuario.getText().toString();
		String contrasena = String.valueOf(vf.pcontrasena.getPassword());
		String ip = vf.tip.getText().toString();
		String[] datos = { usuario, contrasena, ip };

		return datos;
	}

	public void ConectarBotones() {

		vf.desconectar.setEnabled(true);
		vf.conectar.setEnabled(false);
		vf.subir.setEnabled(true);
		vf.descargar.setEnabled(true);
	}

	public void DesconectarBotones() {

		vf.desconectar.setEnabled(false);
		vf.conectar.setEnabled(true);
		vf.subir.setEnabled(false);
		vf.descargar.setEnabled(false);
		vf.tusuario.setText("");
		vf.pcontrasena.setText("");
		vf.tip.setText("");
		vf.ainfo.setText("");
		vf.archivos.removeAllItems();
	}

	public void ListarContenido() {

		try {
			FTPFile ficheros[] = cliente_ftp.listFiles();
			for (int i = 0; i < ficheros.length; i++) {
				vf.ainfo.append(ficheros[i].getName().toString() + "\n");
				vf.archivos.addItem(ficheros[i].getName().toString());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void SubirArchivo() {
		JFileChooser fc = new JFileChooser();
		fc.showOpenDialog(vf);
		File archivo = fc.getSelectedFile();
		if(archivo!=null) {
		try {
			String nombre = archivo.getName();
			BufferedInputStream bfis = new BufferedInputStream(new FileInputStream(archivo));
		//	cliente_ftp.enterLocalPassiveMode();
			//cliente_ftp.enterRemotePassiveMode();
			cliente_ftp.storeFile(nombre, bfis);
			bfis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		vf.archivos.removeAllItems();
		vf.ainfo.setText("");
		ListarContenido();
	}

	public void DescargarArchivo() {
		
		FileOutputStream stream = null;
		String archivo = (String) vf.archivos.getSelectedItem();
		try {
			stream = new FileOutputStream(archivo);
			cliente_ftp.retrieveFile(archivo, stream);
			stream.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
