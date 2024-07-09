package Daos;

import model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO extends GenericDAOImpl<Usuario, Integer> {

    private List<Usuario> usuarios = new ArrayList<>();

    @Override
    public Usuario findById(Integer dni) {
        for (Usuario usuario : usuarios) {
            if (usuario.getDni() == dni) {
                return usuario;
            }
        }
        return null;
    }

    @Override
    public List<Usuario> findAll() {
        return usuarios;
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
