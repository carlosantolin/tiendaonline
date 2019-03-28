package daos;

import java.util.List;

import modelo.Juego;

public interface JuegoDAO {
	
	int registrarJuego(Juego u);
	List<Juego> obtenerJuegos();
	void borrarJuego(int id);
	void editarJuego(Juego u);
	int obtenerTotalJuego();
	int obtenerTotalJuego(String busqueda);
	List<Juego> obtenerJuegos(int comienzo, int cuantos);
	List<Juego> obtenerJuegos(String busqueda, int comienzo, int cuantos);


}
