package daosImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Cliente;
import daos.ClientesDAO;
import daos.ConstantesSQL;
import daos.GenericDAO;

public class ClientesDAOImpl extends GenericDAO implements ClientesDAO{

	@Override
	public void registrarCliente(Cliente cliente) {
		conectar();
		
		try {
			PreparedStatement ps = miConexion.prepareStatement(ConstantesSQL.REGISTRAR_CLIENTE);
			
			ps.setString(1, cliente.getNombre());
			ps.setString(2, cliente.getCalle());
			ps.setString(3, cliente.getNumeracion());
			ps.setString(4, cliente.getCodigoPostal());
			ps.setString(5, cliente.getPoblacion());
			ps.setString(6, cliente.getTelefono());
			ps.setString(7, cliente.getEmail());
			ps.setString(8, cliente.getParticularEmpresa());
			
			ps.execute();
			ps.close();
			
		} catch (SQLException e) {
			System.out.println("Fallo al ejecutar la sql de registro de cliente");
		}
		
		
		desconectar();
		
	}

	@Override
	public List<Cliente> obtenerClientes() {
		conectar();
		
		List<Cliente> clientes = new ArrayList<Cliente>();
		
		try {
			PreparedStatement ps = miConexion.prepareStatement(ConstantesSQL.SELECCIONAR_CLIENTES);
			
			ResultSet resultado = ps.executeQuery();
			while(resultado.next()){
				Cliente cliente = new Cliente();
				
				cliente.setNombre(resultado.getString("nombre_cliente"));
				cliente.setCalle(resultado.getString("calle_cliente"));
				cliente.setNumeracion(resultado.getString("numeracion_cliente"));
				cliente.setCodigoPostal(resultado.getString("codigo_postal_cliente"));
				cliente.setPoblacion(resultado.getString("poblacion_cliente"));
				cliente.setTelefono(resultado.getString("telefono_cliente"));
				cliente.setEmail(resultado.getString("email_cliente"));
				cliente.setParticularEmpresa(resultado.getString("particular_empresa"));
				cliente.setId(resultado.getInt("id_cliente"));
				
				clientes.add(cliente);
			}//end while
		
		
		} catch (SQLException e) {
			System.out.println("Error en la SQL de seleccion de clientes");
		}//end catch
		
		desconectar();
		
		return clientes;
	}

	@Override
	public void borrarCliente(int id) {
		conectar();
		
		try {
			PreparedStatement ps = miConexion.prepareStatement(ConstantesSQL.BORRAR_CLIENTE);
			
			ps.setInt(1, id);
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			System.out.println("Error en la SQL de borrado de usuario");
			System.out.println(e.getMessage());
		}
		
		desconectar();
		
	}

	@Override
	public Cliente obtenerClientePorId(int id) {
		conectar();
		
		Cliente cliente = new Cliente();
		try{
			PreparedStatement ps = miConexion.prepareStatement(ConstantesSQL.OBTENER_CLIENTE_POR_ID);
			
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				cliente.setNombre(rs.getString("nombre_cliente"));
				cliente.setCalle(rs.getString("calle_cliente"));
				cliente.setNumeracion(rs.getString("numeracion_cliente"));
				cliente.setCodigoPostal(rs.getString("codigo_postal_cliente"));
				cliente.setPoblacion(rs.getString("poblacion_cliente"));
				cliente.setTelefono(rs.getString("telefono_cliente"));
				cliente.setEmail(rs.getString("email_cliente"));
				cliente.setParticularEmpresa(rs.getString("particular_empresa"));
				cliente.setId(id);
				
			}
			
			ps.close();
			
		} catch (SQLException e) {
			System.out.println("Error en la SQL de editar usuario");
			System.out.println(e.getMessage());
		}

		desconectar();
		return cliente;
		
	}

	@Override
	public void guardarCambiosCliente(Cliente cliente) {
		conectar();
		
		try {
			PreparedStatement ps = miConexion.prepareStatement(ConstantesSQL.GUARDAR_CAMBIOS_CLIENTE);
			
			ps.setString(1, cliente.getNombre());
			ps.setString(2, cliente.getCalle());
			ps.setString(3, cliente.getNumeracion());
			ps.setString(4, cliente.getCodigoPostal());
			ps.setString(5, cliente.getPoblacion());
			ps.setString(6, cliente.getTelefono());
			ps.setString(7, cliente.getEmail());
			ps.setString(8, cliente.getParticularEmpresa());
			ps.setInt(9, cliente.getId());
			
			ps.execute();
			
			ps.close();
		} catch (SQLException e) {
			System.out.println("Error en la SQL editar");
			System.out.println(e.getMessage());
		}
		
		desconectar();
		
	}

	

}
