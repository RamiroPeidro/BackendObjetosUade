package controller;

import Dtos.PacienteDTO;
import Dtos.ResultadoDTO;
import Dtos.PeticionDTO;
import service.PacienteService;
import service.PeticionService;

import java.util.List;

public class RecepcionController {
    private static RecepcionController instance = null;
    private PacienteService pacienteService;
    private PeticionService peticionService;

    private RecepcionController() {
        this.pacienteService = new PacienteService();
        this.peticionService = new PeticionService();

        cargarPeticionesDePrueba();
    }

    public static RecepcionController getInstance() {
        if (instance == null) {
            instance = new RecepcionController();
        }
        return instance;
    }

    public void cargarPeticion(int Dni, String obraSocial, int sucursalId) {
        peticionService.cargarPeticion(Dni, obraSocial, sucursalId);
    }

    public void asociarPracticaAPeticion(int idPeticion, int practicaId) {
        peticionService.asociarPracticaAPeticion(idPeticion, practicaId);
    }

    public void darBajaPeticion(int numeroPeticion) {
        peticionService.darBajaPeticion(numeroPeticion);
    }

    public void modificarPeticion(int numeroPeticion) {
        peticionService.modificarPeticion(numeroPeticion);
    }

    public void darAltaPaciente(PacienteDTO pacienteDTO) {
        pacienteService.darAltaPaciente(pacienteDTO);
    }

    public List<PacienteDTO> getPacientes() {
        return pacienteService.getPacientes();
    }

    public void darBajaPaciente(int dniPaciente) {
        pacienteService.darBajaPaciente(dniPaciente);
    }

    public void modificarPaciente(PacienteDTO paciente) {
        pacienteService.modificarPaciente(paciente);
    }

    public List<ResultadoDTO> solicitarResultados(int idPeticion) {
        return peticionService.solicitarResultado(idPeticion);
    }

    public List<PeticionDTO> listarPeticionesCriticas() {
        return peticionService.listarPeticionesCriticas();
    }

    private void cargarPeticionesDePrueba() {
        // Crear pacientes de prueba
        PacienteDTO paciente1 = new PacienteDTO("Juan Perez", 12345678, "Calle Falsa 123", "juan.perez@example.com", "M", 30, null);
        PacienteDTO paciente2 = new PacienteDTO("Maria Gomez", 87654321, "Avenida Siempreviva 456", "maria.gomez@example.com", "F", 25, null);

        darAltaPaciente(paciente1);
        darAltaPaciente(paciente2);

        // Crear peticiones de prueba
        cargarPeticion(12345678, "Obra Social 1", 1);
        cargarPeticion(87654321, "Obra Social 2", 1);

        // Asociar prácticas a las peticiones
        asociarPracticaAPeticion(1, 101); // Petición 1, Práctica 101
        asociarPracticaAPeticion(1, 102); // Petición 1, Práctica 102
        asociarPracticaAPeticion(2, 103); // Petición 2, Práctica 103
    }
}
