package daos;

import java.util.HashMap;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import constantes.ConstantesSQL;
import modelo.Juego;
import modelo.Usuario;

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
	
	public void borrarJuego(int id){
		String sql = ConstantesSQL.SQL_BORRADO_JUEGOS;
		try {
			jdbcTemplate.update(sql, new Object[] {id});
			System.out.println("Borrado el juego con id: " + Integer.toString(id));
		} catch (Exception e) {
			System.out.println("Error al obtener id de juego");
			System.out.println(e.getMessage());
		}
	}
	
	public void editarJuego(Juego j){
		String sql = ConstantesSQL.SQL_EDICION_JUEGOS;
		try {
			jdbcTemplate.update(sql, new Object[]
					{j.getDesarollador(), j.getDuracion(), j.getFecha(), j.getGenero(), 
					j.getNombre(), j.getPrecio(), j.getStock()});
			System.out.println("Editado el juego con id: " + Integer.toString(j.getId()));
		} catch (Exception e) {
			System.out.println("Error al obtener id de juego");
			System.out.println(e.getMessage());
		}
	}

	@Override
	public int obtenerTotalJuego() {
		
		return jdbcTemplate.queryForInt(ConstantesSQL.SQL_TOTAL_JUGADORES);
	}

	@Override
	public List<Juego> obtenerJuegos(int comienzo, int cuantos) {
		String sql = ConstantesSQL.SQL_SELECCION_JUEGOS_INICIO_CUANTOS;
		
		List<Juego> valores = jdbcTemplate.query(sql, new Object[] {comienzo, cuantos}, new BeanPropertyRowMapper(Juego.class));
		
		return valores;
	}
		
	

}
