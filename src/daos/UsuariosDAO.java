package daos;

import java.util.List;

import modelo.Usuario;

public interface UsuariosDAO {
	
	void registrarUsuario(Usuario u);
	List<Usuario> obtenerUsuarios();
	int obtenerIdUsuarioPorEmailYPass(String email, String pass);

}
