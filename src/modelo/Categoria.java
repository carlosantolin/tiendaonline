package modelo;

public class Categoria {
	
	private int id;
	private String nombre;
	private String descripcion;
	
	public Categoria() {} //necesita constructor vacio
	
	public Categoria(String nombre, String descricpcion) {
		this.nombre = nombre;
		this.descripcion = descricpcion;
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
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descricpcion) {
		this.descripcion = descricpcion;
	}
	
	

}
