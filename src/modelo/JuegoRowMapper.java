package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class JuegoRowMapper implements RowMapper{

	@Override
	public Object mapRow(ResultSet rs, int arg1) throws SQLException {
		Juego juego = new Juego();
		
		juego.setId(rs.getInt(1));
		juego.setNombre(rs.getString(2));
		juego.setDesarollador(rs.getString(3));
		juego.setDuracion(rs.getString(4));
		juego.setId_genero(rs.getInt(5));
		juego.setPrecio(rs.getDouble(6));
		juego.setStock(rs.getInt(7));
		juego.setFecha(rs.getString(8));
		// el 9 repite el id genero
		juego.setGenero(rs.getString(10));
	
		return juego;
	}

}
