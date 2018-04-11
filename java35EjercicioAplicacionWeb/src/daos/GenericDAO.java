package daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GenericDAO {

	protected Connection miConexion = null;
	
	static{
		//Bloque especial que se ejecuta una unica vez
		//a lo largo de la aplicacion la primera vez
		//que esta clase es usada
		
		//Preparo driver y conexion
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				System.out.println("Error al cargar driver-libreria de mysql");
				
			} //catch (SQLException e) {
//				System.out.println("Error en la conexion o la SQL esta mal");
//			}
		
	}//end static
	
	protected void conectar(){
		try {
			miConexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/practica_web","root","yupicat1");
		} catch (SQLException e) {
			System.out.println("No pude conectarme a la bbdd");
			System.out.println("Comprobar ruta de bbdd");
			System.out.println("Comprobar nombre de usuario y contraseña");
		}
	}//end conectar
	
	
	protected void desconectar(){
		try {
			miConexion.close();
		} catch (SQLException e) {
			System.out.println("No pude realizar la desconexion");
		}
	}//end desconectar
}
