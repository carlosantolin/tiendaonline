package daos;

import java.util.HashMap;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Component;

import constantes.ConstantesSQL;
import modelo.Usuario;

@Component
public class UsuariosDAOImpl implements UsuariosDAO {
	
	private DataSource elDataSource;
	private SimpleJdbcInsert simpleInsert;
	private JdbcTemplate jdbcTemplate;

	
	public DataSource getElDataSource() {
		return elDataSource;
	}

	// Para que este DAO funcione tiene que recibir un data source, cuando llegue preparo el simpleInsert
	public void setElDataSource(DataSource elDataSource) {
		this.elDataSource = elDataSource;
		simpleInsert = new SimpleJdbcInsert(elDataSource);
		simpleInsert.setTableName("tabla_usuarios");
		simpleInsert.usingGeneratedKeyColumns("id");
		jdbcTemplate = new JdbcTemplate(elDataSource);
		
	}

	@Override
	public int registrarUsuario(Usuario u) {
		HashMap<String, Object> valores = new HashMap<String, Object>();
		valores.put("nombre", u.getNombre());
		valores.put("email", u.getEmail());
		valores.put("pass", u.getPass());
		//simpleInsert.execute(valores);
		return simpleInsert.executeAndReturnKey(valores).intValue();
	}

	@Override
	public List<Usuario> obtenerUsuarios() {
		String sql = ConstantesSQL.SQL_SELECCION_USUARIOS;
		List<Usuario> usuarios = (List<Usuario>) jdbcTemplate.query(sql, new BeanPropertyRowMapper(Usuario.class));
		return usuarios;
	}

	@Override
	public int obtenerIdUsuarioPorEmailYPass(String email, String pass) {
		int id = -1;
		String sql = ConstantesSQL.SQL_SELECCION_ID_POR_EMAIL_PASS;
		try {
			id = jdbcTemplate.queryForInt(sql, new Object[] {email, pass});
		} catch (Exception e) {
			System.out.println("Error al obtener id de usuario");
			System.out.println(e.getMessage());
		}
		
		return id;
	}
	
	public void borrarUsuario(int id){
		String sql = ConstantesSQL.SQL_BORRADO_USUARIOS;
		try {
			jdbcTemplate.update(sql, new Object[] {id});
			System.out.println("Borrado el usuario con id: " + Integer.toString(id));
		} catch (Exception e) {
			System.out.println("Error al obtener id de usuario");
			System.out.println(e.getMessage());
		}
	}

	@Override
	public List<Usuario> obtenerUsuarios(int comienzo, int cuantos) {
		String sql = ConstantesSQL.SQL_SELECCION_USUARIOS_INICIO_CUANTOS;
		
		List<Usuario> valores = jdbcTemplate.query(sql, new Object[] {comienzo, cuantos}, new BeanPropertyRowMapper(Usuario.class));
		
		return valores;
	}

	@Override
	public int obtenerTotalUsuario() {
		int total = jdbcTemplate.queryForInt(ConstantesSQL.SQL_TOTAL_USUARIOS);
		
		return total;
	}

	@Override
	public int obtenerIdUsuarioPorEmail(String email) {
		int id = -1;
		String sql = ConstantesSQL.SQL_SELECCION_ID_POR_EMAIL;
		try {
			id = jdbcTemplate.queryForInt(sql, new Object[] {email});
		} catch (Exception e) {
			System.out.println("El email no exixste:	" + e.getMessage());
		}
		
		return id;
	}

	@Override
	public List<Usuario> obtenerUsuarios(String busqueda, int comienzo, int cuantos) {
		String sql = ConstantesSQL.SQL_BUSQUEDA_USUARIOS_INICIO_CUANTOS;
		
		List<Usuario> valores = jdbcTemplate.query(sql, new Object[] {"%"+busqueda+"%", comienzo, cuantos}, new BeanPropertyRowMapper(Usuario.class));
		
		return valores;
	}

	@Override
	public int obtenerTotalUsuario(String busqueda) {
		return jdbcTemplate.queryForInt(ConstantesSQL.SQL_BUSQUEDA_TOTAL_USUARIOS, new Object[] {"%"+busqueda+"%"});

	}
	

}
