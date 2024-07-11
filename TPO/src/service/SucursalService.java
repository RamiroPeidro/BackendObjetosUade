package service;

import Daos.SucursalDAO;
import Daos.PeticionDAO;
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

    public SucursalService() {
        this.sucursalDAO = new SucursalDAO();
        this.peticionDAO = new PeticionDAO();
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

    public void createSucursal(SucursalDTO sucursalDTO, UsuarioDTO responsableTecnicoDTO) {
        Sucursal sucursal = convertirASucursal(sucursalDTO, responsableTecnicoDTO);
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

    // Métodos de conversión

    private SucursalDTO convertirASucursalDTO(Sucursal sucursal) {
        SucursalDTO sucursalDTO = new SucursalDTO();
        sucursalDTO.setNumero(sucursal.getNumero());
        sucursalDTO.setDireccion(sucursal.getDireccion());
        sucursalDTO.setResponsableTecnico(convertirAUsuarioDTO(sucursal.getResponsableTecnico()));

        List<Integer> peticionesIds = new ArrayList<>();
        for (Peticion peticion : sucursal.getPeticionesDeSucursal()) {
            peticionesIds.add(peticion.getIdPeticion());
        }
        sucursalDTO.setPeticionesIds(peticionesIds);

        return sucursalDTO;
    }

    private Sucursal convertirASucursal(SucursalDTO sucursalDTO, UsuarioDTO responsableTecnicoDTO) {
        Sucursal sucursal = new Sucursal();
        sucursal.setNumero(sucursalDTO.getNumero());
        sucursal.setDireccion(sucursalDTO.getDireccion());

        // Crear Email y Usuario
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
        sucursal.setResponsableTecnico(responsableTecnico);

        // Convertir los IDs de peticiones a objetos Peticion
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
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setNombreUsuario(usuario.getNombreUsuario());
        usuarioDTO.setMail(usuario.getMail().getValue());
        usuarioDTO.setPassword(usuario.getPassword());
        usuarioDTO.setNombre(usuario.getNombre());
        usuarioDTO.setDomicilio(usuario.getDomicilio());
        usuarioDTO.setDni(usuario.getDni());
        usuarioDTO.setFechaNacimiento(usuario.getFechaNacimiento());

        return usuarioDTO;
    }
}
