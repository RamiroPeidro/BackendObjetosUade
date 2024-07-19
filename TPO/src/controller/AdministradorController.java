package controller;

import Dtos.*;
import model.TipoDeUsuario;
import model.Usuario;
import service.PracticaService;
import service.SucursalService;
import service.UsuarioService;
import views.FrmAdministrador;
import views.FrmLaboratorista;
import views.FrmRecepcionista;

import java.util.Date;

public class AdministradorController {

    private static AdministradorController instance = null;
    private SucursalService sucursalService;
    private UsuarioService usuarioService;
    private PracticaService practicaService;

    private AdministradorController() {
        this.sucursalService = new SucursalService();
        this.usuarioService = new UsuarioService();
        this.practicaService = new PracticaService();

        cargarUsuarioAdministrador();
    }

    public static AdministradorController getInstance() {
        if (instance == null) {
            instance = new AdministradorController();
        }
        return instance;
    }

    public void darDeAltaSucursal(SucursalDTO sucursalDTO, int dniResponsableTecnico) {
        sucursalService.createSucursal(sucursalDTO, dniResponsableTecnico);
    }

    public void darBajaSucursal(int numeroSucursalBaja, int sucursalDestinoPeticiones) {
        sucursalService.darBajaSucursal(numeroSucursalBaja, sucursalDestinoPeticiones);
    }

    public void modificarSucursal(SucursalDTO sucursalDTO, int dniResponsableTecnico) {
        sucursalService.modificarSucursal(sucursalDTO, dniResponsableTecnico);
    }

    public void darAltaUsuario(UsuarioDTO usuarioDTO) {
        usuarioService.darAltaUsuario(usuarioDTO);
    }

    public void darBajaUsuario(int dniUsuario) {
        usuarioService.darBajaUsuario(dniUsuario);
    }

    public void modificarUsuario(UsuarioDTO usuarioDTO) {
        usuarioService.modificarUsuario(usuarioDTO);
    }

    public int darAltaPractica(PracticaDTO practicaDTO) {
        return practicaService.darAltaPractica(practicaDTO);
    }

    public void darBajaPractica(int codigoPractica) {
        practicaService.darBajaPractica(codigoPractica);
    }

    public void modificarPractica(PracticaDTO practicaDTO) {
        practicaService.modificarPractica(practicaDTO);
    }

    private void cargarPracticasDePrueba() {
        PracticaDTO practica1 = new PracticaDTO(101, "Hemograma Completo", "Hematología", new RangoValorDTO(0.0f, 100.0f), 24f, true, false);
        PracticaDTO practica2 = new PracticaDTO(102, "Glucosa en Sangre", "Bioquímica", new RangoValorDTO(70.0f, 110.0f), 12f, true, false);
        PracticaDTO practica3 = new PracticaDTO(103, "Perfil Lipídico", "Bioquímica", new RangoValorDTO(100.0f, 200.0f), 24f, true, true);

        darAltaPractica(practica1);
        darAltaPractica(practica2);
        darAltaPractica(practica3);
    }

    private void cargarUsuarioAdministrador() {
        TipoDeUsuario tipoDeUsuario = TipoDeUsuario.Administrador;
        UsuarioDTO usuarioDTO = new UsuarioDTO("admin", "admin@gmail.com", "admin", "Administrador", "juan b justo 1234", 12345678, new Date(), tipoDeUsuario);
        darAltaUsuario(usuarioDTO);
    }

    public UsuarioDTO iniciarSesion(String nombreUsuario, String password, String botonSeleccionado) throws UsuarioService.InvalidPasswordException, UsuarioService.UserNotFoundException {
        Usuario usuario = usuarioService.iniciarSesion(nombreUsuario, password);
        return usuarioService.convertirUsuarioADTO(usuario);
    }



    private void mostrarVistasSegunTipoDeUsuarioYBoton(Usuario usuario, String botonSeleccionado) {
        TipoDeUsuario tipoDeUsuario = usuario.getTipoDeUsuario();

        switch (botonSeleccionado) {
            case "Recepcionista":
                if (tipoDeUsuario == TipoDeUsuario.Recepcionista || tipoDeUsuario == TipoDeUsuario.Administrador) {
                    FrmRecepcionista frmRecepcionista = new FrmRecepcionista(null, "Recepcionista");
                    frmRecepcionista.setVisible(true);
                } else {
                    throw new IllegalArgumentException("El usuario no tiene el rol adecuado para acceder como Recepcionista.");
                }
                break;

            case "Laboratorista":
                if (tipoDeUsuario == TipoDeUsuario.Laboratorista || tipoDeUsuario == TipoDeUsuario.Administrador) {
                    FrmLaboratorista frmLaboratorista = new FrmLaboratorista(null, "Laboratorista");
                    frmLaboratorista.setVisible(true);
                } else {
                    throw new IllegalArgumentException("El usuario no tiene el rol adecuado para acceder como Laboratorista.");
                }
                break;

            case "Administrador":
                if (tipoDeUsuario == TipoDeUsuario.Administrador) {
                    FrmAdministrador frmAdministrador = new FrmAdministrador(null, "Administrador");
                    frmAdministrador.setVisible(true);
                } else {
                    throw new IllegalArgumentException("El usuario no tiene el rol adecuado para acceder como Administrador.");
                }
                break;

            default:
                throw new IllegalArgumentException("El rol especificado no es válido.");
        }
    }
}
