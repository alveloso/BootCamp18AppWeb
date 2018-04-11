package modelo;

import javax.servlet.http.Part;

public class Cliente {
	private int id;//Para el tema de borrar o editar
	private String nombre;
	private String calle;
	private String numeracion;
	private String codigoPostal;
	private String poblacion;
	private String telefono;
	private String email;
	private String particularEmpresa;


	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	public Cliente(String nombre, String calle, String numeracion,
			String codigoPostal, String poblacion, String telefono,
			String email, String particularEmpresa) {
		super();
		this.nombre = nombre;
		this.calle = calle;
		this.numeracion = numeracion;
		this.codigoPostal = codigoPostal;
		this.poblacion = poblacion;
		this.telefono = telefono;
		this.email = email;
		this.particularEmpresa = particularEmpresa;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getNumeracion() {
		return numeracion;
	}

	public void setNumeracion(String numeracion) {
		this.numeracion = numeracion;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getParticularEmpresa() {
		return particularEmpresa;
	}

	public void setParticularEmpresa(String particularEmpresa) {
		this.particularEmpresa = particularEmpresa;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", calle=" + calle
				+ ", numeracion=" + numeracion + ", codigoPostal="
				+ codigoPostal + ", poblacion=" + poblacion + ", telefono="
				+ telefono + ", email=" + email + ", particularEmpresa="
				+ particularEmpresa + "]";
	}
	
	
	
}
