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

    public void getDniPaciente() { //TODO: Cambiar a que devuelva un int, hace falta poner el get explicito?
    }

    public void getPeticionPaciente() { //TODO: Cambiar a que devuelva una peticion, hace falta poner el get explicito?
    }

    public void chequearSiSePuedeDarDeBaja() { //TODO: Renombrar, pasarle parametros, devolver boolean.
    }
}
