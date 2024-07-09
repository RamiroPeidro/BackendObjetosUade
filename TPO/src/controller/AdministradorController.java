package controller;

import Dtos.SucursalDTO;
import service.SucursalService;

import java.util.Date;

public class AdministradorController {

    private static AdministradorController instance = null;
    private SucursalService sucursalService;

    // Constructor privado para singleton
    private AdministradorController() {
        this.sucursalService = new SucursalService();
    }

    public static AdministradorController getInstance() {
        if (instance == null) {
            instance = new AdministradorController();
        }
        return instance;
    }

    public void darDeAltaSucursal(SucursalDTO sucursalDTO, String email, String password, String nombre, String domicilio, int dni, Date fechaNacimiento) {
        sucursalService.createSucursal(sucursalDTO, email, password, nombre, domicilio, dni, fechaNacimiento);
    }

    public void darBajaSucursal(int numeroSucursalBaja, int sucursalDestinoPeticiones) {
        sucursalService.darBajaSucursal(numeroSucursalBaja, sucursalDestinoPeticiones);
    }

    public void modificarSucursal() { //TODO: Agregar numero de sucursal como parametro.
    }

    public void darAltaUsuario() {
    }

    public void darBajaUsuario() { //TODO: Agregar numero usuario como parametro.
    }

    public void modificarUsuario() { //TODO: Agregar numero usuario como parametro.
    }

    public void darAltaPractica() {
    }

    public void darBajaPractica(int codigoPractica) {
    }

    public void modificarPractica() { //TODO: Agregar codigo practica como parametro.
    }

}
