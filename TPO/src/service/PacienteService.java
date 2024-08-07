package service;

import Daos.PacienteDAO;
import Daos.PeticionDAO;
import Dtos.PacienteDTO;
import model.Paciente;
import model.Peticion;
import model.Email;
import model.Practica;
import model.Sucursal;

import java.util.ArrayList;
import java.util.List;

public class PacienteService {

    private final PacienteDAO pacienteDAO;
    private final PeticionDAO peticionDAO;

    public PacienteService() {
        this.pacienteDAO = PacienteDAO.getInstance();
        this.peticionDAO = PeticionDAO.getInstance();
    }

    public void recibirPaciente() {
        // Implementar lógica de recibir paciente si es necesario
    }

    public void cargarPeticion(Paciente paciente, String obraSocial,
                               Practica practica, Sucursal sucursal) {
        // Implementar lógica de cargar petición si es necesario
    }

    public void darBajaPeticion(int numeroPeticion) {
        // Implementar lógica de dar de baja petición
    }

    public void modificarPeticion(int numeroPeticion) {
        // Implementar lógica de modificar petición
    }

    public void solicitarResultado(int idPeticion) {
        // Implementar lógica de consultar resultado
    }

    public void darAltaPaciente(PacienteDTO pacienteDTO) throws IllegalArgumentException {
        Paciente existente = pacienteDAO.findById(pacienteDTO.getDni());
        if (existente != null) {
            throw new IllegalArgumentException("Ya existe un paciente con el DNI ingresado.");
        }

        List<Peticion> peticiones = new ArrayList<>(); // Convertir IDs de peticiones a objetos Peticion si es necesario
        Email email = new Email(pacienteDTO.getMail()); // Crear el Value Object Email
        Paciente paciente = convertirDTOaPaciente(pacienteDTO, peticiones);
        pacienteDAO.create(paciente);
    }

    public List<PacienteDTO> getPacientes() {
        List<Paciente> pacientes = pacienteDAO.findAll();
        List<PacienteDTO> pacienteDTOs = new ArrayList<>();
        for (Paciente paciente : pacientes) {
            pacienteDTOs.add(convertirPacienteADTO(paciente));
        }
        return pacienteDTOs;
    }

    public void darBajaPaciente(int dniPaciente) {
        Paciente paciente = pacienteDAO.findById(dniPaciente);
        if (paciente != null) {
            boolean sePuedeDarDeBaja = paciente.chequearSiSePuedeDarDeBaja();
            if (sePuedeDarDeBaja) {
                pacienteDAO.delete(paciente);
            }
        }
    }

    public void modificarPaciente(PacienteDTO pacienteDTO) {
        Paciente pacienteExistente = pacienteDAO.findById(pacienteDTO.getDni());
        if (pacienteExistente != null) {
            pacienteExistente.setNombre(pacienteDTO.getNombre());
            pacienteExistente.setDomicilio(pacienteDTO.getDomicilio());
            pacienteExistente.setMail(new Email(pacienteDTO.getMail()));
            pacienteExistente.setSexo(pacienteDTO.getSexo());
            pacienteExistente.setEdad(pacienteDTO.getEdad());
            // Actualizar las peticiones si es necesario
            pacienteDAO.update(pacienteExistente);
        }
    }

    public void solicitarResultados(int idPeticion) {
        // Implementar lógica de solicitar resultados
    }

    public void listarPeticionesCriticas() {
        // Implementar lógica de listar peticiones críticas
    }

    // Método para convertir Paciente a PacienteDTO
    private PacienteDTO convertirPacienteADTO(Paciente paciente) {
        PacienteDTO pacienteDTO = new PacienteDTO();
        pacienteDTO.setDni(paciente.getDNIPaciente());
        pacienteDTO.setNombre(paciente.getNombre());
        pacienteDTO.setDomicilio(paciente.getDomicilio());
        pacienteDTO.setMail(paciente.getMail().getValue());
        pacienteDTO.setSexo(paciente.getSexo());
        pacienteDTO.setEdad(paciente.getEdad());
        // Convertir peticiones si es necesario
        return pacienteDTO;
    }

    // Método para convertir PacienteDTO a Paciente
    private Paciente convertirDTOaPaciente(PacienteDTO pacienteDTO, List<Peticion> peticiones) {
        Email email = new Email(pacienteDTO.getMail());
        Paciente paciente = new Paciente(
                pacienteDTO.getNombre(),
                pacienteDTO.getDni(),
                pacienteDTO.getDomicilio(),
                email,
                pacienteDTO.getSexo(),
                pacienteDTO.getEdad(),
                peticiones
        );
        return paciente;
    }
}
