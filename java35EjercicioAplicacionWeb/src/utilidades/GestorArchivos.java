package utilidades;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.Part;

public class GestorArchivos {
	
	private static final String CARPETA_SUBIDAS="D:\\eclipseWS\\java35EjercicioAplicacionWeb\\WebContent\\imagenes\\subidas";
	
	public static String rutaArchivo(int id){
		
		String ruta = CARPETA_SUBIDAS + File.separator + id + ".jpg";
		//Como estamos trabajando en local para ver los resultados
		//debo dar una ruta absoluta
		File f = new File(ruta);
		
		return f.getAbsolutePath();
	}
	
	public static void guardarArchivo(Part archivo, String ruta){
		
		System.out.println("Lo que contiene la ruta es: " + ruta);
		File carpetaSubidas = new File(CARPETA_SUBIDAS);
		
		if(!carpetaSubidas.exists()){
			System.out.println("La carpeta no existia asi que al creo");
			carpetaSubidas.mkdir();
		}
		try {
			InputStream is = archivo.getInputStream();
			
			System.out.println("He pasado el inputStream");
			FileOutputStream fos = new FileOutputStream(CARPETA_SUBIDAS + File.separator + ruta);
			
			byte[] leidos = new byte[1024];
			
			while(is.read(leidos) != -1){
				fos.write(leidos);
			}
			
			//Es mejor cerrar el de escritura antes
			fos.close();
			is.close();
			
		} catch (IOException e) {
			System.out.println("error en el is");
			System.out.println(e.getMessage());
		}
	}
}
