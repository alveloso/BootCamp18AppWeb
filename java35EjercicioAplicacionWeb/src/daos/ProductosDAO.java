package daos;

import java.util.List;

import modelo.Producto;

public interface ProductosDAO {

	public void registrarProducto(Producto producto);
	List<Producto> obtenerProductos();
	public void borrarProducto(int id);
	public Producto obtenerProductoPorId(int id);
	public void guardarCambiosProducto(Producto producto);
	
	
}
