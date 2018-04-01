package daos;

public class ConstantesSQL {
	
	//SQL admin
	public final static String IDENTIFICAR_ADMIN = "select * from tabla_administrador where usuario = ? and contrasenia = ?";

	//SQL clientes
	public final static String SELECCIONAR_CLIENTES = "select * from tabla_clientes";
	public final static String REGISTRAR_CLIENTE = "insert into tabla_clientes (nombre_cliente,calle_cliente,numeracion_cliente,codigo_postal_cliente,poblacion_cliente,telefono_cliente,email_cliente,particular_empresa) values (?,?,?,?,?,?,?,?)";
	public final static String BORRAR_CLIENTE = "delete from tabla_clientes where id_cliente = ?";
	public final static String OBTENER_CLIENTE_POR_ID = "select * from tabla_clientes where id_cliente = ?";
	public static final String GUARDAR_CAMBIOS_CLIENTE = "update tabla_clientes set nombre_cliente = ?, calle_cliente = ?, numeracion_cliente = ?,codigo_postal_cliente = ?, poblacion_cliente = ?, telefono_cliente = ?, email_cliente = ?, particular_empresa = ? where id_cliente = ?";
	
	//SQL productos
	public final static String SELECCIONAR_PRODUCTOS = "select * from tabla_productos";
	public final static String REGISTRAR_PRODUCTO = "insert into tabla_productos(nombre,dispositivos,genero,fecha_salida, precio,formato,numero_jugadores,compania,idioma,editor) values (?,?,?,?,?,?,?,?,?,?)";
	public final static String BORRAR_PRODUCTO = "delete from tabla_productos where id_producto = ?";
	public final static String OBTENER_PRODUCTO_POR_ID = "select * from tabla_productos where id_producto = ?";
	public static final String GUARDAR_CAMBIOS_PRODUCTO = "update tabla_productos set nombre = ?, dispositivos = ?, genero = ?, fecha_salida = ?, precio = ?, formato = ?, numero_jugadores = ?, compania = ?, idioma = ?, editor = ? where id_producto = ?";
}
