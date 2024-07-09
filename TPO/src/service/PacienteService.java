package service;

import Daos.PacienteDAO;
import model.Paciente;
import model.Peticion;
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

    public void darAltaPaciente(String nombre, int dni, String domicilio, Object mail, String sexo, int edad, List<Peticion> peticionesDelPaciente) {
        Paciente paciente = new Paciente(nombre, dni, domicilio, mail, sexo, edad, peticionesDelPaciente);
        pacienteDAO.create(paciente);
    }

    public List<Paciente> getPacientes() {
        return pacienteDAO.findAll();
    }

    public void darBajaPaciente(int dniPaciente) {
        List<Paciente> pacientes = pacienteDAO.findAll();
        Iterator<Paciente> iterator = pacientes.iterator();
        while (iterator.hasNext()) {
            Paciente paciente = iterator.next();
            if (paciente.getDNIPaciente() == dniPaciente) {
                boolean sePuedeDarDeBaja = paciente.chequearSiSePuedeDarDeBaja();
                if (sePuedeDarDeBaja) {
                    iterator.remove();
                    pacienteDAO.delete(paciente);
                }
            }
        }
    }

    public void modificarPaciente(Paciente paciente) {
        Paciente pacienteExistente = pacienteDAO.findById(paciente.getDNIPaciente());
        if (pacienteExistente != null) {
            pacienteDAO.update(paciente);
        }
    }

    public void solicitarResultados(int idPeticion) {
        // Implementar lógica de solicitar resultados
    }

    public void listarPeticionesCriticas() {
        // Implementar lógica de listar peticiones críticas
    }
}
