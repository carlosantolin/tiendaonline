package daos;

import java.util.List;

import modelo.Juego;

public interface JuegoDAO {
	
	void registrarJuego(Juego u);
	List<Juego> obtenerJuegos();

}
