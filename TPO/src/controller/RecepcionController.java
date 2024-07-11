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
        return peticionService.consultarResultado(idPeticion);
    }

    public List<PeticionDTO> listarPeticionesCriticas() {
        return peticionService.listarPeticionesCriticas();
    }
}
