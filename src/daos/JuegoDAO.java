package daos;

import java.util.List;

import modelo.Juego;

public interface JuegoDAO {
	
	int registrarJuego(Juego u);
	List<Juego> obtenerJuegos();
	void borrarJuego(int id);
	void editarJuego(Juego u);
	int obtenerTotalJuego();
	List<Juego> obtenerJuegos(int comienzo, int cuantos);

}
