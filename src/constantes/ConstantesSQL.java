package constantes;

public class ConstantesSQL {
	
	public final static String SQL_SELECCION_ID_POR_EMAIL_PASS = "SELECT id FROM tabla_usuarios WHERE email=? AND pass=?;";
	public final static String SQL_SELECCION_USUARIOS = "SELECT * FROM tabla_usuarios ORDER BY id DESC;";
	public final static String SQL_SELECCION_JUEGOS = "SELECT * FROM tabla_juegos ORDER BY id DESC;";
	public final static String SQL_SELECCION_SERVICIOS = "SELECT * FROM tabla_servicios ORDER BY id DESC;";
	public final static String SQL_SELECCION_CATEGORIAS = "SELECT * FROM tabla_categorias ORDER BY id DESC;";
	public final static String SQL_BORRADO_USUARIOS = "DELETE FROM tabla_usuarios WHERE id=?;";
	public final static String SQL_BORRADO_JUEGOS = "DELETE FROM tabla_juegos WHERE id=?;";
	public final static String SQL_EDICION_JUEGOS ="UPDATE tabla_juegos SET desarollador=?, duracion=?, fecha=?, genero=?, nombre=?, precio=?, stock=? WHERE id=?;";
	public final static String SQL_SELECCION_USUARIOS_INICIO_CUANTOS = "SELECT * FROM tabla_usuarios ORDER BY id DESC limit ?,?;";
	public final static String SQL_TOTAL_USUARIOS = "SELECT COUNT(*) FROM tabla_usuarios;";
	public final static String SQL_TOTAL_JUGADORES = "SELECT COUNT(*) FROM tabla_juegos;";
	public final static String SQL_SELECCION_JUEGOS_INICIO_CUANTOS = "SELECT * FROM tabla_juegos ORDER BY id DESC limit ?,?;";
	public static final String SQL_SELECCION_ID_POR_EMAIL = "SELECT id FROM tabla_usuarios WHERE email=?;";
	public static final String SQL_BUSQUEDA_USUARIOS_INICIO_CUANTOS = "SELECT * FROM tabla_usuarios WHERE nombre LIKE ? ORDER BY id DESC limit ?,?;";
	public static final String SQL_BUSQUEDA_JUEGOS_INICIO_CUANTOS = "SELECT * FROM tabla_juegos WHERE nombre LIKE ? ORDER BY id DESC limit ?,?;";
	public static final String SQL_BUSQUEDA_TOTAL_JUGADORES = "SELECT COUNT(*) FROM tabla_juegos WHERE nombre LIKE ?;";
	public static final String SQL_BUSQUEDA_TOTAL_USUARIOS = "SELECT COUNT(*) FROM tabla_usuarios WHERE nombre LIKE ?;";

}
