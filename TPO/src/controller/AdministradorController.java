package controller;

import Dtos.SucursalDTO;
import Dtos.UsuarioDTO;
import Dtos.PracticaDTO;
import model.Practica;
import service.PracticaService;
import service.SucursalService;
import service.UsuarioService;

import java.util.Date;

public class AdministradorController {

    private static AdministradorController instance = null;
    private SucursalService sucursalService;
    private UsuarioService usuarioService;
    private PracticaService practicaService;

    // Constructor privado para singleton
    private AdministradorController() {
        this.sucursalService = new SucursalService();
        this.usuarioService = new UsuarioService();
        this.practicaService = new PracticaService();
    }

    public static AdministradorController getInstance() {
        if (instance == null) {
            instance = new AdministradorController();
        }
        return instance;
    }

    public void darDeAltaSucursal(SucursalDTO sucursalDTO, UsuarioDTO responsableTecnicoDTO) {
        sucursalService.createSucursal(sucursalDTO, responsableTecnicoDTO);
    }

    public void darBajaSucursal(int numeroSucursalBaja, int sucursalDestinoPeticiones) {
        sucursalService.darBajaSucursal(numeroSucursalBaja, sucursalDestinoPeticiones);
    }

    public void modificarSucursal(SucursalDTO sucursalDTO, UsuarioDTO responsableTecnicoDTO) {
        sucursalService.modificarSucursal(sucursalDTO, responsableTecnicoDTO);
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

    public void darAltaPractica(PracticaDTO practicaDTO) {
        practicaService.darAltaPractica(practicaDTO);
    }

    public void darBajaPractica(int codigoPractica) {
        practicaService.darBajaPractica(codigoPractica);
    }

    public void modificarPractica(PracticaDTO practicaDTO) {
        practicaService.modificarPractica(practicaDTO);
    }

}
