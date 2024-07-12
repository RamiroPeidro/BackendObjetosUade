package model;

import java.util.List;

public class Paciente {

    private int dni;
    private String nombre;
    private String domicilio;
    private Email email;
    private String sexo;
    private int edad;
    List<Peticion> peticionesDelPaciente;

    public Paciente(String nombre, int dni, String domicilio, Email email, String sexo, int edad) {
        this.nombre = nombre;
        this.dni = dni;
        this.domicilio = domicilio;
        this.email = email;
        this.sexo = sexo;
        this.edad = edad;
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

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
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
