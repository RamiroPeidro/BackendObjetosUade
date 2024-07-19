package controller;

import Dtos.RangoValorDTO;
import Dtos.SucursalDTO;
import Dtos.UsuarioDTO;
import Dtos.PracticaDTO;
import model.Practica;
import service.PracticaService;
import service.SucursalService;
import service.UsuarioService;

import java.util.ArrayList;
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
        // Crear prácticas de prueba
        PracticaDTO practica1 = new PracticaDTO(101, "Hemograma Completo", "Hematología", new RangoValorDTO(0.0f, 100.0f), 24f, true, false);
        PracticaDTO practica2 = new PracticaDTO(102, "Glucosa en Sangre", "Bioquímica", new RangoValorDTO(70.0f, 110.0f), 12f, true, false);
        PracticaDTO practica3 = new PracticaDTO(103, "Perfil Lipídico", "Bioquímica", new RangoValorDTO(100.0f, 200.0f), 24f, true, true);

        darAltaPractica(practica1);
        darAltaPractica(practica2);
        darAltaPractica(practica3);
    }

}
