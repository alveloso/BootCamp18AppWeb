package daos;

import java.util.List;

import modelo.Cliente;

public interface ClientesDAO {

	public void registrarCliente(Cliente cliente);
	List<Cliente> obtenerClientes();
	public void borrarCliente(int id);
	Cliente obtenerClientePorId(int id);
	public void guardarCambiosCliente(Cliente cliente);
	
}
