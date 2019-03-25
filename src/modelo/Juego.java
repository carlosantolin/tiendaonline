package modelo;

public class Juego {
	
	private String nombre;
	private String desarollador;
	private String fecha;
	private String genero;
	private String duracion;
	private Double precio;
	private int stock;
	private int id;
	
	public Juego() {
		
	}
	
	

	public Juego(String nombre, String desarollador, String fecha,
			String genero, String duracion, Double precio, int stock) {
		super();
		this.nombre = nombre;
		this.desarollador = desarollador;
		this.fecha = fecha;
		this.genero = genero;
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

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getDuracion() {
		return duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
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
	
	
	
	
	
	
	

}
