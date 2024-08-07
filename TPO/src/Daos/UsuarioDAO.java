package Daos;

import model.ResultadoInicioSesion;
import model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO extends GenericDAOImpl<Usuario, Integer> {
    private static UsuarioDAO instance;
    private static List<Usuario> usuarios; //lo cambie a static no se si me influye en algo mas

    private UsuarioDAO() {
        this.usuarios = new ArrayList<>();
    }

    public static UsuarioDAO getInstance() {
        if (instance == null) {
            instance = new UsuarioDAO();
        }
        return instance;
    }

    @Override
    public Usuario findById(Integer dni) {
        for (Usuario usuario : usuarios) {
            if (usuario.getDni() == dni) {
                return usuario;
            }
        }
        return null;
    }


    public static Object encontrarUsuarioPorNombreUsuario(String nombreUsuario, String password) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNombreUsuario().equals(nombreUsuario)) {
                if (usuario.getPassword().equals(password)) {
                    return usuario;
                } else {
                    return ResultadoInicioSesion.INVALID_PASSWORD;
                }
            }
        }
        return ResultadoInicioSesion.USER_NOT_FOUND;
    }

    @Override
    public List<Usuario> findAll() {
        return new ArrayList<>(usuarios);
    }

    @Override
    public void create(Usuario usuario) {
        usuarios.add(usuario);
    }

    @Override
    public void update(Usuario usuario) {
        Usuario existingUsuario = findById(usuario.getDni());
        if (existingUsuario != null) {
            int index = usuarios.indexOf(existingUsuario);
            usuarios.set(index, usuario);
        }
    }

    @Override
    public void delete(Usuario usuario) {
        usuarios.remove(usuario);
    }
}
