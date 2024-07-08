package controller;

import model.Paciente;
import model.Peticion;
import model.Practica;
import model.Sucursal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RecepcionController {

    private final List<Paciente> listaPacientes = new ArrayList<>();

    public void recibirPaciente() {
    }

    public void cargarPeticion(Paciente paciente, String obraSocial,
                               Practica practica, Sucursal sucursal) {
    }

    public void darBajaPeticion() { //TODO: Agregar numero peticion como parametro.
    }

    public void modificarPeticion() { //TODO: Agregar numero peticion como parametro.
    }

    public void consultarResultado() { //TODO: Agregar id peticion como parametro.
    }

    //Dar de alta paciente - agregar paciente al sistema.
    public void darAltaPaciente(String nombre, int dni, String domicilio, Object mail, String sexo, int edad, List<Peticion> peticionesDelPaciente) {
        Paciente paciente = new Paciente(nombre, dni, domicilio, mail, sexo, edad, peticionesDelPaciente);
        listaPacientes.add(paciente);
    }

    //Devuelve la lista de pacientes.
    public List<Paciente> getPacientes() {
        return listaPacientes;
    }

    /** Diagrama de secuencia 1: **/
    public void darBajaPaciente(int dniPaciente) {
        List<Paciente> pacientes = getPacientes();
        Iterator<Paciente> iterator = pacientes.iterator();
        while (iterator.hasNext()) {
            Paciente paciente = iterator.next();
            if (paciente.getDNIPaciente() == dniPaciente) {
                boolean sePuedeDarDeBaja = paciente.chequearSiSePuedeDarDeBaja();
                if (sePuedeDarDeBaja) {
                    iterator.remove();
                }
            }
        }
    }

    public void modificarPaciente(int dniPaciente) {
    }

    public void solicitarResultados(int idPeticion) {
    }

    public void listarPeticionesCriticas() {
    }
}
