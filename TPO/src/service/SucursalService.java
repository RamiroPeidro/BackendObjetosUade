package service;

import Daos.SucursalDAO;
import Daos.PeticionDAO;
import Daos.UsuarioDAO;
import Dtos.SucursalDTO;
import Dtos.UsuarioDTO;
import model.Sucursal;
import model.Peticion;
import model.Usuario;
import model.Email;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class SucursalService {

    private SucursalDAO sucursalDAO;
    private PeticionDAO peticionDAO;
    private UsuarioDAO usuarioDAO;

    public SucursalService() {
        this.sucursalDAO = new SucursalDAO();
        this.peticionDAO = new PeticionDAO();
        this.usuarioDAO = new UsuarioDAO();
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

        return convertirASucursalDTO(sucursal);
    }

    public void createSucursal(SucursalDTO sucursalDTO) {
        Sucursal sucursal = convertirASucursal(sucursalDTO);
        sucursalDAO.create(sucursal);
    }

    public void modificarSucursal(SucursalDTO sucursalDTO, UsuarioDTO responsableTecnicoDTO) {
        Sucursal sucursalExistente = sucursalDAO.findByNumero(sucursalDTO.getNumero());
        if (sucursalExistente == null) {
            throw new IllegalArgumentException("Sucursal no encontrada");
        }

        sucursalExistente.setDireccion(sucursalDTO.getDireccion());

        // Actualizar el responsable técnico solo si se proporciona un DTO
        if (responsableTecnicoDTO != null) {
            Email emailObj = new Email(responsableTecnicoDTO.getMail());
            Usuario responsableTecnico = new Usuario(
                    responsableTecnicoDTO.getNombreUsuario(),
                    emailObj,
                    responsableTecnicoDTO.getPassword(),
                    responsableTecnicoDTO.getNombre(),
                    responsableTecnicoDTO.getDomicilio(),
                    responsableTecnicoDTO.getDni(),
                    responsableTecnicoDTO.getFechaNacimiento()
            );
            sucursalExistente.setResponsableTecnico(responsableTecnico);
        }

        List<Peticion> peticiones = new ArrayList<>();
        for (Integer id : sucursalDTO.getPeticionesIds()) {
            Peticion peticion = peticionDAO.findById(id);
            if (peticion != null) {
                peticiones.add(peticion);
            }
        }
        sucursalExistente.setPeticionesDeSucursal(peticiones);

        sucursalDAO.update(sucursalExistente);
    }

    public void asociarResponsableTecnico(int numeroSucursal, int dniResponsableTecnico) {
        Sucursal sucursalExistente = sucursalDAO.findByNumero(numeroSucursal);
        if (sucursalExistente == null) {
            throw new IllegalArgumentException("Sucursal no encontrada");
        }

        Usuario responsableTecnico = usuarioDAO.findById(dniResponsableTecnico);
        if (responsableTecnico == null) {
            throw new IllegalArgumentException("Usuario no encontrado");
        }

        sucursalExistente.setResponsableTecnico(responsableTecnico);
        sucursalDAO.update(sucursalExistente);
    }

    // Métodos de conversión

    private SucursalDTO convertirASucursalDTO(Sucursal sucursal) {
        List<Integer> peticionesIds = new ArrayList<>();
        for (Peticion peticion : sucursal.getPeticionesDeSucursal()) {
            peticionesIds.add(peticion.getIdPeticion());
        }

        return new SucursalDTO(
                sucursal.getNumero(),
                sucursal.getDireccion(),
                convertirAUsuarioDTO(sucursal.getResponsableTecnico()),
                peticionesIds
        );
    }


    private Sucursal convertirASucursal(SucursalDTO sucursalDTO) {
        Sucursal sucursal = new Sucursal();
        sucursal.setNumero(sucursalDTO.getNumero());
        sucursal.setDireccion(sucursalDTO.getDireccion());

        List<Peticion> peticiones = new ArrayList<>();
        for (Integer id : sucursalDTO.getPeticionesIds()) {
            Peticion peticion = peticionDAO.findById(id);
            if (peticion != null) {
                peticiones.add(peticion);
            }
        }
        sucursal.setPeticionesDeSucursal(peticiones);

        return sucursal;
    }


    private UsuarioDTO convertirAUsuarioDTO(Usuario usuario) {
        if (usuario == null) {
            return null;
        }
        return new UsuarioDTO(
                usuario.getNombreUsuario(),
                usuario.getMail().getValue(),
                usuario.getPassword(),
                usuario.getNombre(),
                usuario.getDomicilio(),
                usuario.getDni(),
                usuario.getFechaNacimiento()
        );
    }
}
