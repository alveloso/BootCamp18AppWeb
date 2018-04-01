package daosImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Producto;
import daos.ConstantesSQL;
import daos.GenericDAO;
import daos.ProductosDAO;

public class ProductosDAOImpl extends GenericDAO implements ProductosDAO{

	@Override
	public void registrarProducto(Producto producto) {
		conectar();
		
		try {
			PreparedStatement ps = miConexion.prepareStatement(ConstantesSQL.REGISTRAR_PRODUCTO);
			
			ps.setString(1, producto.getNombre());
			ps.setString(2, producto.getDispositivos());
			ps.setString(3, producto.getGenero());
			ps.setString(4, producto.getFechaSalida());
			ps.setDouble(5, producto.getPrecio());
			ps.setString(6, producto.getFormato());
			ps.setString(7, producto.getNumeroJugadores());
			ps.setString(8, producto.getCompania());
			ps.setString(9, producto.getIdioma());
			ps.setString(10, producto.getEditor());
			
			ps.execute();
			ps.close();
			
		} catch (SQLException e) {
			System.out.println("Fallo al ejecutar la sql de registro de producto");
		}
		
		desconectar();
	}
	
	@Override
	public List<Producto> obtenerProductos() {
		conectar();
		
		List<Producto> productos = new ArrayList<Producto>();
		
		try {
			PreparedStatement ps = miConexion.prepareStatement(ConstantesSQL.SELECCIONAR_PRODUCTOS);
			
			ResultSet resultado = ps.executeQuery();
			while(resultado.next()){
				Producto producto = new Producto();
				
				producto.setNombre(resultado.getString("nombre"));
				producto.setDispositivos(resultado.getString("dispositivos"));
				producto.setGenero(resultado.getString("genero"));
				producto.setFechaSalida(resultado.getString("fecha_salida"));
				producto.setPrecio(resultado.getDouble("precio"));
				producto.setFormato(resultado.getString("formato"));
				producto.setNumeroJugadores(resultado.getString("numero_jugadores"));
				producto.setCompania(resultado.getString("compania"));
				producto.setIdioma(resultado.getString("idioma"));
				producto.setEditor(resultado.getString("editor"));
				producto.setId(resultado.getInt("id_producto"));
				
				productos.add(producto);
			}//end while
		
		
		} catch (SQLException e) {
			System.out.println("Error en la SQL de seleccion de productos");
		}//end catch
		
		desconectar();
		
		return productos;
	}

	@Override
	public void borrarProducto(int id) {
		conectar();
		
		try {
			PreparedStatement ps = miConexion.prepareStatement(ConstantesSQL.BORRAR_PRODUCTO);
			
			ps.setInt(1, id);
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			System.out.println("Error en la SQL de borrado de producto");
			System.out.println(e.getMessage());
		}
		
		desconectar();
		
	}

	@Override
	public Producto obtenerProductoPorId(int id) {
		conectar();
		
		Producto producto = new Producto();
		try{
			PreparedStatement ps = miConexion.prepareStatement(ConstantesSQL.OBTENER_PRODUCTO_POR_ID);
			
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				producto.setNombre(rs.getString("nombre"));
				producto.setDispositivos(rs.getString("dispositivos"));
				producto.setGenero(rs.getString("genero"));
				producto.setFechaSalida(rs.getString("fecha_salida"));
				producto.setPrecio(rs.getDouble("precio"));
				producto.setFormato(rs.getString("formato"));
				producto.setNumeroJugadores(rs.getString("numero_jugadores"));
				producto.setCompania(rs.getString("compania"));
				producto.setIdioma(rs.getString("idioma"));
				producto.setEditor(rs.getString("editor"));
				producto.setId(id);
				
			}
			
			ps.close();
			
		} catch (SQLException e) {
			System.out.println("Error en la SQL de buscar por ID");
			System.out.println(e.getMessage());
		}

		desconectar();
		return producto;
	}

	@Override
	public void guardarCambiosProducto(Producto producto) {
		conectar();
		
		try {
			PreparedStatement ps = miConexion.prepareStatement(ConstantesSQL.GUARDAR_CAMBIOS_PRODUCTO);
			
			ps.setString(1, producto.getNombre());
			ps.setString(2, producto.getDispositivos());
			ps.setString(3, producto.getGenero());
			ps.setString(4, producto.getFechaSalida());
			ps.setDouble(5, producto.getPrecio());
			ps.setString(6, producto.getFormato());
			ps.setString(7, producto.getNumeroJugadores());
			ps.setString(8, producto.getCompania());
			ps.setString(9, producto.getIdioma());
			ps.setString(10, producto.getEditor());
			ps.setInt(11, producto.getId());
			
			ps.execute();
			
			ps.close();
		} catch (SQLException e) {
			System.out.println("Error en la SQL editar producto");
			System.out.println(e.getMessage());
		}
		
		desconectar();
	}
}
