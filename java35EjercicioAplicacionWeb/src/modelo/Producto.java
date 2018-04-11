package modelo;

import javax.servlet.http.Part;

public class Producto {
	
	private int id;//Para borrar y editar
	private String nombre;
	private String dispositivos;
	private String genero;
	private String fechaSalida;
	private double precio;
	private String formato;
	private String numeroJugadores;
	private String compania;
	private String idioma;
	private String editor;
	private Part imagenSubida;
	private String rutaImagen;
	
	public Producto() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Producto(String nombre, String dispositivos, String genero, String fechaSalida, double precio,
			String formato, String numeroJugadores, String compania, String idioma, String editor) {
		super();
		this.nombre = nombre;
		this.dispositivos = dispositivos;
		this.genero = genero;
		this.fechaSalida = fechaSalida;
		this.precio = precio;
		this.formato = formato;
		this.numeroJugadores = numeroJugadores;
		this.compania = compania;
		this.idioma = idioma;
		this.editor = editor;
	}



	public Producto(String nombre, String dispositivos, String genero, String fechaSalida, double precio, String formato, String numeroJugadores, String compania, String idioma, String editor, Part imagenSubida) {
		super();
		this.nombre = nombre;
		this.dispositivos = dispositivos;
		this.genero = genero;
		this.fechaSalida = fechaSalida;
		this.precio = precio;
		this.formato = formato;
		this.numeroJugadores = numeroJugadores;
		this.compania = compania;
		this.idioma = idioma;
		this.editor = editor;
		this.imagenSubida = imagenSubida;
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

	public String getDispositivos() {
		return dispositivos;
	}

	public void setDispositivos(String dispositivos) {
		this.dispositivos = dispositivos;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(String fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getFormato() {
		return formato;
	}

	public void setFormato(String formato) {
		this.formato = formato;
	}

	public String getNumeroJugadores() {
		return numeroJugadores;
	}

	public void setNumeroJugadores(String numeroJugadores) {
		this.numeroJugadores = numeroJugadores;
	}

	public String getCompania() {
		return compania;
	}

	public void setCompania(String compania) {
		this.compania = compania;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public String getEditor() {
		return editor;
	}

	public void setEditor(String editor) {
		this.editor = editor;
	}

	public Part getImagenSubida() {
		return imagenSubida;
	}

	public void setImagenSubida(Part imagenSubida) {
		this.imagenSubida = imagenSubida;
	}

	public String getRutaImagen() {
		return rutaImagen;
	}

	public void setRutaImagen(String rutaImagen) {
		this.rutaImagen = rutaImagen;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", dispositivos=" + dispositivos + ", genero=" + genero
				+ ", fechaSalida=" + fechaSalida + ", precio=" + precio + ", formato=" + formato + ", numeroJugadores="
				+ numeroJugadores + ", compania=" + compania + ", idioma=" + idioma + ", editor=" + editor
				+ ", imagenSubida=" + imagenSubida + ", rutaImagen=" + rutaImagen + "]";
	}
	

}
