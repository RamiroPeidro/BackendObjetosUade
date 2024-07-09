package model;

import java.util.List;

public class Paciente {

    private int dni;
    private String nombre;
    private String domicilio;
    private Email mail;
    private String sexo;
    private int edad;
    List<Peticion> peticionesDelPaciente;

    public Paciente(String nombre, int dni, String domicilio, Email mail, String sexo, int edad, List<Peticion> peticionesDelPaciente) {
        this.nombre = nombre;
        this.dni = dni;
        this.domicilio = domicilio;
        this.mail = mail;
        this.sexo = sexo;
        this.edad = edad;
        this.peticionesDelPaciente = peticionesDelPaciente;
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDNIPaciente() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public Object getMail() {
        return mail;
    }

    public void setMail(Email mail) {
        this.mail = mail;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public List<Peticion> getPeticiones() {
        return peticionesDelPaciente;
    }

    public void setPeticiones(List<Peticion> peticiones) {
        this.peticionesDelPaciente = peticiones;
    }


    public Boolean chequearSiSePuedeDarDeBaja() {
        for (Peticion peticion : peticionesDelPaciente) {
            return peticion.chequearSiLaPeticionEstaFinalizada();
        }
        return false;
        // TODO: Renombrar, pasarle parametros, devolver boolean.
    }
}
