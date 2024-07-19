package controller;

import Dtos.PacienteDTO;
import Dtos.PracticaDTO;
import Dtos.ResultadoDTO;
import Dtos.PeticionDTO;
import service.PacienteService;
import service.PeticionService;
import service.PracticaService;

import java.util.List;

public class RecepcionController {
    private static RecepcionController instance = null;
    private PacienteService pacienteService;
    private PeticionService peticionService;
    private PracticaService practicaService;

    private RecepcionController() {
        this.pacienteService = new PacienteService();
        this.peticionService = new PeticionService();
        this.practicaService = new PracticaService();
    }

    public static RecepcionController getInstance() {
        if (instance == null) {
            instance = new RecepcionController();
        }
        return instance;
    }

    public int cargarPeticion(int dni, String obraSocial, int sucursalId) {
        return peticionService.cargarPeticion(dni, obraSocial, sucursalId);
    }


    public void asociarPracticaAPeticion(int idPeticion, int practicaId) {
        try {
            peticionService.asociarPracticaAPeticion(idPeticion, practicaId);
        } catch (IllegalArgumentException e) {
            // Propagar la excepción para que pueda ser manejada en la vista
            throw e;
        }
    }


    public void darBajaPeticion(int numeroPeticion) {
        peticionService.darBajaPeticion(numeroPeticion);
    }

    public void modificarPeticion(int numeroPeticion) {
        peticionService.modificarPeticion(numeroPeticion);
    }

    public void darAltaPaciente(PacienteDTO pacienteDTO) {
        try {
            pacienteService.darAltaPaciente(pacienteDTO);
        } catch (IllegalArgumentException e) {
            // Propagar la excepción para que pueda ser manejada en la vista
            throw e;
        }
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



    public List<PeticionDTO> listarPeticionesCriticas() {
        return peticionService.listarPeticionesCriticas();
    }


    public List<ResultadoDTO> solicitarResultados(int idPeticion) {
            return peticionService.solicitarResultado(idPeticion);
        }

}
