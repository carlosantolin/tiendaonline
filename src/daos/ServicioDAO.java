package daos;

import java.util.List;

import modelo.Juego;
import modelo.Servicio;

public interface ServicioDAO {

	void registrarServicio(Servicio s);
	List<Servicio> obtenerServicios();
	
}
