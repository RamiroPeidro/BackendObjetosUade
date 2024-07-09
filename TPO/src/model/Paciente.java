package model;

import java.util.List;

public class Paciente {

    private int dni;
    private String nombre;
    private String domicilio;
    private Object mail; //TODO: Asi se declara un ObjetValue? ni ideaa
    private String sexo;
    private int edad;
    List<Peticion> peticionesDelPaciente;

    public Paciente(String nombre, int dni, String domicilio, Object mail, String sexo, int edad, List<Peticion> peticionesDelPaciente) {
        this.nombre = nombre;
        this.dni = dni;
        this.domicilio = domicilio;
        this.mail = mail;
        this.sexo = sexo;
        this.edad = edad;
        this.peticionesDelPaciente = peticionesDelPaciente;
    }

    public int getDNIPaciente() {
        return this.dni;
    }

    public Boolean chequearSiSePuedeDarDeBaja() {
        for (Peticion peticion : peticionesDelPaciente) {
            return peticion.chequearSiLaPeticionEstaFinalizada();
        }
        return false;
        // TODO: Renombrar, pasarle parametros, devolver boolean.
    }
}
