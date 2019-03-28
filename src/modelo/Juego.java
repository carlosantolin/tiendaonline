package modelo;

public class Juego {
	
	private String nombre;
	private String desarollador;
	private String fecha;
	private int id_genero;
	private String genero;
	private String duracion;
	private double precio;
	private int stock;
	private int id;
	
	public Juego() {
		
	}
	
	

	public Juego(String nombre, String desarollador, String fecha,
			int genero, String duracion, double precio, int stock) {
		super();
		this.nombre = nombre;
		this.desarollador = desarollador;
		this.fecha = fecha;
		this.id_genero = genero;
		this.duracion = duracion;
		this.precio = precio;
		this.stock = stock;
	}



	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDesarollador() {
		return desarollador;
	}

	public void setDesarollador(String desarollador) {
		this.desarollador = desarollador;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	

	public String getDuracion() {
		return duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



	public int getId_genero() {
		return id_genero;
	}



	public void setId_genero(int id_genero) {
		this.id_genero = id_genero;
	}



	public String getGenero() {
		return genero;
	}



	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	
	
	
	
	
	

}
