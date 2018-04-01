package daosImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import daos.AdministradorDAO;
import daos.ConstantesSQL;
import daos.GenericDAO;

public class AdministradorDAOImpl extends GenericDAO implements AdministradorDAO{

	@Override
	public boolean identificarAdmin(String usuario, String contrasenia) {

		//De momento el usuario no esta identificado
		boolean identificado = false;
		
		//Siempre conectar
		conectar();
		
		try {
			
			//Preparamos consulta
			PreparedStatement ps = miConexion.prepareStatement(ConstantesSQL.IDENTIFICAR_ADMIN);
			ps.setString(1, usuario);
			ps.setString(2, contrasenia);
			
			//Recogemos resultado
			ResultSet rs = ps.executeQuery();
			
			//no funcionaria buscando null porque aunque no devuelva usuario
			//el resultset tiene algo igualmente
			if(rs.next()){
				/*
				 * Si este if se cumple eso es que he obtenido un resultado
				 * de base de datos
				 */
				identificado = true;
			}
			
			
			ps.close();
			
		} catch (SQLException e) {
			System.out.println("Error en la SQL de identificar admin");
			System.out.println(e.getMessage());
		}
		
		desconectar();
		
		return identificado;
	}

}
