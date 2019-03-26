package daos;

import java.util.HashMap;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import constantes.ConstantesSQL;
import modelo.Juego;

public class JuegoDAOImpl implements JuegoDAO {
	
	private DataSource elDataSource;
	private SimpleJdbcInsert simpleInsert;
	private JdbcTemplate jdbcTemplate;

	public DataSource getElDataSource() {
		return elDataSource;
	}
	
	public void setElDataSource(DataSource elDataSource) {
		this.elDataSource = elDataSource;
		simpleInsert = new SimpleJdbcInsert(elDataSource);
		simpleInsert.setTableName("tabla_juegos");
		simpleInsert.usingGeneratedKeyColumns("id");
		jdbcTemplate = new JdbcTemplate(elDataSource);
		
	}
	
	@Override
	public int registrarJuego(Juego o) {
		HashMap<String, Object> valores = new HashMap<String, Object>();
		valores.put("nombre", o.getNombre());
		valores.put("desarollador", o.getDesarollador());
		valores.put("fecha", o.getFecha());
		valores.put("genero", o.getGenero());
		valores.put("duracion", o.getDuracion());
		valores.put("precio", o.getPrecio());
		valores.put("stock", o.getStock());
		//simpleInsert.execute(valores);
		return simpleInsert.executeAndReturnKey(valores).intValue();
	}

	@Override
	public List<Juego> obtenerJuegos() {
		String sql = ConstantesSQL.SQL_SELECCION_JUEGOS;
		List<Juego> ordenadores = (List<Juego>) jdbcTemplate.query(sql, new BeanPropertyRowMapper(Juego.class));
		return ordenadores;
	}

}
