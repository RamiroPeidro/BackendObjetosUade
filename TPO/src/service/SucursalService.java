package service;

import Daos.SucursalDAO;
import Daos.PeticionDAO;
import Dtos.SucursalDTO;
import model.Sucursal;
import model.Peticion;
import model.Usuario;
import model.Email;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class SucursalService {

    private SucursalDAO sucursalDAO;

    public SucursalService() {
        this.sucursalDAO = new SucursalDAO();
    }

    public void darBajaSucursal(int numeroSucursalBaja, int sucursalDestinoPeticiones) {
        Sucursal sucursalBaja = sucursalDAO.findByNumero(numeroSucursalBaja);
        Sucursal sucursalDestino = sucursalDAO.findByNumero(sucursalDestinoPeticiones);

        if (sucursalBaja == null || sucursalDestino == null) {
            System.out.println("Sucursal no encontrada");
            return;
        }

        // Chequear si se puede dar de baja la sucursal
        boolean sePuedeDarDeBaja = sucursalBaja.chequearSiSePuedeDarDeBajaSucursal();
        if (sePuedeDarDeBaja) {
            // Transferir peticiones a la sucursal destino
            for (Peticion peticion : sucursalBaja.getPeticionesDeSucursal()) {
                if (peticion.getSucursal().getNumero() == numeroSucursalBaja) {
                    peticion.setSucursal(sucursalDestino);
                }
            }

            // Eliminar la sucursal
            sucursalDAO.delete(sucursalBaja);
            System.out.println("Sucursal dada de baja");
        } else {
            System.out.println("No se puede dar de baja la sucursal. Hay peticiones con resultados finalizados.");
        }
    }

    public SucursalDTO getSucursalDTO(int numeroSucursal) {
        Sucursal sucursal = sucursalDAO.findByNumero(numeroSucursal);
        if (sucursal == null) {
            return null;
        }

        SucursalDTO sucursalDTO = new SucursalDTO();
        sucursalDTO.setNumero(sucursal.getNumero());
        sucursalDTO.setDireccion(sucursal.getDireccion());
        sucursalDTO.setResponsableTecnico(sucursal.getResponsableTecnico().getNombre());

        List<Integer> peticionesIds = new ArrayList<>();
        for (Peticion peticion : sucursal.getPeticionesDeSucursal()) {
            peticionesIds.add(peticion.getIdPeticion());
        }
        sucursalDTO.setPeticionesIds(peticionesIds);

        return sucursalDTO;
    }

    public void createSucursal(SucursalDTO sucursalDTO, String email, String password, String nombre, String domicilio, int dni, Date fechaNacimiento) {
        Sucursal sucursal = new Sucursal();
        sucursal.setNumero(sucursalDTO.getNumero());
        sucursal.setDireccion(sucursalDTO.getDireccion());

        // Crear Email y Usuario
        Email emailObj = new Email(email);
        Usuario responsableTecnico = new Usuario(sucursalDTO.getResponsableTecnico(), emailObj, password, nombre, domicilio, dni, fechaNacimiento);
        sucursal.setResponsableTecnico(responsableTecnico);

        // Convertir los IDs de peticiones a objetos Peticion si es necesario
        List<Peticion> peticiones = new ArrayList<>();
        for (Integer id : sucursalDTO.getPeticionesIds()) {
            peticiones.add(new PeticionDAO().findById(id));
        }
        sucursal.setPeticionesDeSucursal(peticiones);

        sucursalDAO.create(sucursal);
    }
}
