package service;

import Daos.UsuarioDAO;
import Dtos.UsuarioDTO;
import model.ResultadoInicioSesion;
import model.TipoDeUsuario;
import model.Usuario;
import model.Email;
import views.FrmAdministrador;
import views.FrmLaboratorista;
import views.FrmRecepcionista;

import java.util.List;
import java.util.stream.Collectors;

public class UsuarioService {

    private UsuarioDAO usuarioDAO;

    public UsuarioService() {
        this.usuarioDAO = UsuarioDAO.getInstance();
    }

    public void darAltaUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = convertirDTOaUsuario(usuarioDTO);
        usuarioDAO.create(usuario);
    }

    public void darBajaUsuario(int dniUsuario) {
        Usuario usuario = usuarioDAO.findById(dniUsuario);
        if (usuario != null) {
            usuarioDAO.delete(usuario);
        } else {
            throw new IllegalArgumentException("Usuario no encontrado");
        }
    }

    public void modificarUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuarioExistente = usuarioDAO.findById(usuarioDTO.getDni());
        if (usuarioExistente != null) {
            Usuario usuarioModificado = convertirDTOaUsuario(usuarioDTO);
            usuarioDAO.update(usuarioModificado);
        } else {
            throw new IllegalArgumentException("Usuario no encontrado");
        }
    }

    private Usuario convertirDTOaUsuario(UsuarioDTO usuarioDTO) {
        Email email = new Email(usuarioDTO.getMail());
        return new Usuario(
                usuarioDTO.getNombreUsuario(),
                email,
                usuarioDTO.getPassword(),
                usuarioDTO.getNombre(),
                usuarioDTO.getDomicilio(),
                usuarioDTO.getDni(),
                usuarioDTO.getFechaNacimiento(),usuarioDTO.getTipoDeUsuario()
        );
    }

    public UsuarioDTO convertirUsuarioADTO(Usuario usuario) {
        return new UsuarioDTO(
                usuario.getNombreUsuario(),
                usuario.getMail().getValue(),
                usuario.getPassword(),
                usuario.getNombre(),
                usuario.getDomicilio(),
                usuario.getDni(),
                usuario.getFechaNacimiento(), usuario.getTipoDeUsuario()
        );
    }

    public List<UsuarioDTO> obtenerTodosLosUsuarios() {
        List<Usuario> usuarios = usuarioDAO.findAll();
        return usuarios.stream()
                .map(this::convertirUsuarioADTO)
                .collect(Collectors.toList());
    }




    public void iniciarSesion(String nombreUsuario, String password,String botonSeleccionado) throws InvalidPasswordException, UserNotFoundException {
        Object resultado = usuarioDAO.encontrarUsuarioPorNombreUsuario(nombreUsuario, password);

        if (resultado instanceof Usuario) {
            Usuario usuario = (Usuario) resultado;
            mostrarVistasSegunTipoDeUsuarioYBoton(usuario,botonSeleccionado);
        } else if (resultado == ResultadoInicioSesion.INVALID_PASSWORD) {
            throw new InvalidPasswordException("La contraseña no es correcta.");
        } else if (resultado == ResultadoInicioSesion.USER_NOT_FOUND) {
            throw new UserNotFoundException("El nombre de usuario no existe.");
        }
    }

    private void mostrarVistasSegunTipoDeUsuarioYBoton(Usuario usuario, String botonSeleccionado) {
        // Siempre mostrar la vista de Recepcionista si el usuario es Recepcionista o Administrador
        if (usuario.getTipoDeUsuario() == TipoDeUsuario.Recepcionista || usuario.getTipoDeUsuario() == TipoDeUsuario.Administrador && botonSeleccionado == "Recepcionista") {
            FrmRecepcionista frmRecepcionista = new FrmRecepcionista(null, "Recepcionista");
            frmRecepcionista.setVisible(true);
        }

        // Siempre mostrar la vista de Laboratorista si el usuario es Laboratorista o Administrador
        if (usuario.getTipoDeUsuario() == TipoDeUsuario.Laboratorista || usuario.getTipoDeUsuario() == TipoDeUsuario.Administrador && botonSeleccionado == "Laboratorista") {
            FrmLaboratorista frmLaboratorista = new FrmLaboratorista(null, "Laboratorista");
            frmLaboratorista.setVisible(true);
        }

        if (usuario.getTipoDeUsuario() == TipoDeUsuario.Administrador && botonSeleccionado == "Administrador") {
            FrmAdministrador frmAdministrador = new FrmAdministrador(null, "Administrador");
            frmAdministrador.setVisible(true);
        }
    }

    public class InvalidPasswordException extends Exception {
        public InvalidPasswordException(String message) {
            super(message);
        }
    }
    public class UserNotFoundException extends Exception {
        public UserNotFoundException(String message) {
            super(message);
        }
    }

}
