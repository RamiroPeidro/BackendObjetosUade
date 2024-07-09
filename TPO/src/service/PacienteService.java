package service;

import Daos.PacienteDAO;
import Dtos.PacienteDTO;
import model.Paciente;
import model.Peticion;
import model.Email;
import model.Practica;
import model.Sucursal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PacienteService {

    private final PacienteDAO pacienteDAO;

    public PacienteService() {
        this.pacienteDAO = new PacienteDAO();
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

    public void consultarResultado(int idPeticion) {
        // Implementar lógica de consultar resultado
    }

    public void darAltaPaciente(PacienteDTO pacienteDTO) {
        List<Peticion> peticiones = new ArrayList<>(); // Convertir IDs de peticiones a objetos Peticion si es necesario
        Email email = new Email(pacienteDTO.getMail()); // Crear el Value Object Email
        Paciente paciente = new Paciente(
                pacienteDTO.getNombre(),
                pacienteDTO.getDni(),
                pacienteDTO.getDomicilio(),
                email,
                pacienteDTO.getSexo(),
                pacienteDTO.getEdad(),
                peticiones
        );
        pacienteDAO.create(paciente);
    }

    public List<Paciente> getPacientes() {
        return pacienteDAO.findAll();
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

}
