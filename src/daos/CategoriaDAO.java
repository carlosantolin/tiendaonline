package daos;

import java.util.List;

import modelo.Categoria;

public interface CategoriaDAO {
	
	void registrarCategoria(Categoria c);
	List<Categoria> obtenerCategorias();

}
