package controller;

import Dtos.PacienteDTO;
import model.Paciente;
import model.Peticion;
import model.Practica;
import model.Sucursal;
import service.PacienteService;

import java.util.List;

public class RecepcionController {

    private PacienteService pacienteService;

    public RecepcionController() {
        this.pacienteService = new PacienteService();
    }

    public void recibirPaciente() {
        // Implementar lógica de recibir paciente si es necesario
    }

    public void cargarPeticion(Paciente paciente, String obraSocial,
                               Practica practica, Sucursal sucursal) {
        // Implementar lógica de cargar petición si es necesario
    }

    public void darBajaPeticion(int numeroPeticion) {
        // Delegar al servicio
        pacienteService.darBajaPeticion(numeroPeticion);
    }

    public void modificarPeticion(int numeroPeticion) {
        // Delegar al servicio
        pacienteService.modificarPeticion(numeroPeticion);
    }

    public void consultarResultado(int idPeticion) {
        // Delegar al servicio
        pacienteService.consultarResultado(idPeticion);
    }

    public void darAltaPaciente(PacienteDTO pacienteDTO) {
        pacienteService.darAltaPaciente(pacienteDTO);
    }

    public List<Paciente> getPacientes() {
        return pacienteService.getPacientes();
    }

    public void darBajaPaciente(int dniPaciente) {
        pacienteService.darBajaPaciente(dniPaciente);
    }

    public void modificarPaciente(PacienteDTO paciente) {
        pacienteService.modificarPaciente(paciente);
    }

    public void solicitarResultados(int idPeticion) {
        pacienteService.solicitarResultados(idPeticion);
    }

    public void listarPeticionesCriticas() {
        pacienteService.listarPeticionesCriticas();
    }
}
